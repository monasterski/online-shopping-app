package main.server.controllers;

import main.server.database.dto.Hello;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class HelloController extends AbstractController {

    private List<Hello> values = new LinkedList<>();

    //http://localhost:8080/tai-app/hello
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(Model model){
        model.addAttribute("username",getApplicationContext().getUsername());
        return "hello";
    }

    public List<Hello> getValues() {
        return values;
    }

    public void setValues(List<Hello> values) {
        this.values = values;
    }
}
