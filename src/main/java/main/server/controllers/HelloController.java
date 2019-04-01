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
public class HelloController {

    private List<Hello> values = new LinkedList<>();

    //http://localhost:8080/tai-app/hello
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(Model model){
        values.add(new Hello("trzy",3));
        values.add(new Hello("jeden",1));
        values.add(new Hello("dwa",2));
        model.addAttribute("values",values);
        return "hello";
    }

    public List<Hello> getValues() {
        return values;
    }

    public void setValues(List<Hello> values) {
        this.values = values;
    }
}
