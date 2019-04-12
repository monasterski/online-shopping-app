package main.server.controllers.authorization;

import main.server.beans.services.AuthorizationService;
import main.server.database.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthorizationController {

    @Autowired
    private AuthorizationService authorizationService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String getLogin(Model model){
        System.out.println(authorizationService.toString());
        model.addAttribute("user",new User());
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegister(Model model){
        System.out.println("GET " + authorizationService.toString());
        model.addAttribute("user",new User());
        return "register";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String postRegister(User user){
        System.out.println("POST "+authorizationService.toString());
        authorizationService.registerUser(user);
        return "redirect:/login";
    }
}