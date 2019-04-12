package main.server.controllers.authorization;

import main.server.beans.services.AuthorizationService;
import main.server.database.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthorizationController {

    @Autowired
    private AuthorizationService authorizationService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String getLogin(Model model){
        model.addAttribute("user",new User());
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegister(Model model){
        model.addAttribute("user",new User());
        return "register";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String postRegister(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        authorizationService.registerUser(user);
        return "redirect:/login";
    }
}
