package gr.di.uoa.kk.databasesystems.RestControllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/")
public class ShowAuthViewsAPIs {

    @GetMapping
    ModelAndView home(HttpSession session, Authentication authentication) {
        if(authentication != null && authentication.isAuthenticated()){
            ModelAndView modelAndView = new ModelAndView("student");
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("signin");
            session.invalidate();
            return modelAndView;
        }
    }

    @GetMapping(value = "signOut")
    @ResponseStatus(value = HttpStatus.OK)
    public ModelAndView signOut(HttpSession session){
        ModelAndView modelAndView = new ModelAndView("/signin");
        session.invalidate();
        return modelAndView;
    }

    @GetMapping(value = "student", consumes = MediaType.ALL_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    ModelAndView showStudent(HttpSession session, Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView("student");
        modelAndView.addObject("userName",authentication.getName());
        return modelAndView;
    }
}
