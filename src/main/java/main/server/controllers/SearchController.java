package main.server.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user/search")
public class SearchController extends AbstractController {

    @RequestMapping(method= RequestMethod.GET)
    public String search() {
        return "search";
    }
}
