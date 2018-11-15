package gr.di.uoa.kk.databasesystems.RestControllers;


import gr.di.uoa.kk.databasesystems.dto.SignUpDto;
import gr.di.uoa.kk.databasesystems.entities.Role;
import gr.di.uoa.kk.databasesystems.entities.User;
import gr.di.uoa.kk.databasesystems.entities.enums.RoleNameEnum;
import gr.di.uoa.kk.databasesystems.repository.RoleRepository;
import gr.di.uoa.kk.databasesystems.repository.UserRepository;
import gr.di.uoa.kk.databasesystems.security.JwtProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/noAuth")
public class NoAuthAPIs {

    private static final Logger logger = LoggerFactory.getLogger(NoAuthAPIs.class);

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping(value = "/signIn", consumes = MediaType.ALL_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ModelAndView authenticateUser(@RequestParam String username,
                                         @RequestParam String password) {
        ModelAndView modelAndView = new ModelAndView("student");
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        username,
                        password
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);

        modelAndView.addObject("userName"," " + authentication.getName());
        return modelAndView;
    }

    @PostMapping(value = "/signUp", consumes = MediaType.ALL_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ModelAndView registerUser(HttpSession session,
                                     @RequestParam String username,
                                     @RequestParam String name,
                                     @RequestParam String email,
                                     @RequestParam String password) {
        session.invalidate();
        if(userRepository.existsByUsername(username)) {
            ModelAndView modelAndView = new ModelAndView("/signUp");
            modelAndView.addObject("status", "Username is already taken");
            return modelAndView;
//            return new ResponseEntity<String>("Fail -> Username is already taken!",
//                    HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(email)) {
            ModelAndView modelAndView = new ModelAndView("/signUp");
            modelAndView.addObject("status", "Email is already in use");
            return modelAndView;
//            return new ResponseEntity<String>("Fail -> Email is already in use!",
//                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        User user = new User(name, username, email, encoder.encode(password));

        //Change if can signUp with multi-roles
        Set<String> strRoles = new HashSet<>();
        strRoles.add("user");
        Set<Role> roles = new HashSet<>();

        strRoles.forEach(role -> {
            switch(role) {
                case "admin":
                    Role adminRole = roleRepository.findByName(RoleNameEnum.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(adminRole);

                    break;
                case "pm":
                    Role pmRole = roleRepository.findByName(RoleNameEnum.ROLE_PM)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(pmRole);

                    break;
                default:
                    Role userRole = roleRepository.findByName(RoleNameEnum.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(userRole);
            }
        });

        user.setRoles(roles);
        userRepository.save(user);

        ModelAndView modelAndView = new ModelAndView("/signIn");

        return modelAndView;

//        return ResponseEntity.ok().body("User registered successfully!");
    }

    @GetMapping(value = "/signUp")
    @ResponseStatus(value = HttpStatus.OK)
    ModelAndView showSignUp(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("signup");
        return modelAndView;
    }

    //This method called by JwtAuthEntryPoint
    @GetMapping(value = "signIn")
    @ResponseStatus(value = HttpStatus.OK)
    ModelAndView showLoginPage(HttpSession session) {
        //If session does not exists come from sign out
        if(session == null){
            ModelAndView modelAndView = new ModelAndView("/signin");
            return modelAndView;
        }else {
            session.invalidate();
            ModelAndView modelAndView = new ModelAndView("/signin");
            modelAndView.addObject("status", "Username/Password Incorrect");
            return modelAndView;
        }
    }

}

