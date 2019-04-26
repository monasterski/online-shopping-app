package main.server.controllers.authorization;

import main.server.controllers.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController extends AbstractController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

}

