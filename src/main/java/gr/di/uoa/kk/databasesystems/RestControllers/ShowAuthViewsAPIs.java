package gr.di.uoa.kk.databasesystems.RestControllers;


import gr.di.uoa.kk.databasesystems.entities.IncidentType;
import gr.di.uoa.kk.databasesystems.service.IncidentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.List;

@RestController
@RequestMapping("/")
public class ShowAuthViewsAPIs {

    @Autowired
    IncidentTypeService incidentTypeService;

    @GetMapping
    ModelAndView home(HttpSession session, Authentication authentication) {
        if(authentication != null && authentication.isAuthenticated()){
            ModelAndView modelAndView = new ModelAndView("find");
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

    @GetMapping(value = "find", consumes = MediaType.ALL_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    ModelAndView showFind(HttpSession session, Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView("find");
        modelAndView.addObject("userName",authentication.getName());
        return modelAndView;
    }

    @GetMapping(value = "storeProcedureOne", consumes = MediaType.ALL_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    ModelAndView showStoreProcedureOne(HttpSession session, Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView("storeProcedureOne");
        modelAndView.addObject("userName",authentication.getName());
        return modelAndView;
    }

    @GetMapping(value = "storeProcedureTwo", consumes = MediaType.ALL_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    ModelAndView showStoreProcedureTwo(HttpSession session, Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView("storeProcedureTwo");
        List<IncidentType> incidentTypeList = incidentTypeService.findAllIncidentTypeNames();
        modelAndView.addObject("types",incidentTypeList);
        modelAndView.addObject("userName",authentication.getName());
        return modelAndView;
    }

    @GetMapping(value = "storeProcedureThree", consumes = MediaType.ALL_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    ModelAndView showStoreProcedureThree(HttpSession session, Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView("storeProcedureThree");
        modelAndView.addObject("userName",authentication.getName());
        return modelAndView;
    }

    @GetMapping(value = "insert", consumes = MediaType.ALL_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    ModelAndView showInsert(HttpSession session, Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView("insert");
        List<IncidentType> incidentTypeList = incidentTypeService.findAllIncidentTypeNames();
        modelAndView.addObject("types",incidentTypeList);
        modelAndView.addObject("userName",authentication.getName());
        return modelAndView;
    }

    @GetMapping(value = "signin")
    @ResponseStatus(value = HttpStatus.OK)
    ModelAndView signIn(HttpSession session) {
        //If session does not exists come from sign out
        if(session == null){
            ModelAndView modelAndView = new ModelAndView("signin");
            return modelAndView;
        }else {
            session.invalidate();
            ModelAndView modelAndView = new ModelAndView("signin");
            modelAndView.addObject("status", "Username/Password Incorrect");
            return modelAndView;
        }
    }
}
