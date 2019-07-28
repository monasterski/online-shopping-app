package main.server.controllers.authorization;

import main.server.beans.services.AuthorizationService;
import main.server.controllers.AbstractController;
import main.server.controllers.data.User;
import main.server.database.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserAccountController extends AbstractController {

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping(value = "/user/account",method = RequestMethod.GET)
    public String getAccountInfo(Model model){
        model.addAttribute("user", applicationContext.getUser());
        return "account";
    }
}
