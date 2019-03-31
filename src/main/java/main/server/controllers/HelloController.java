package main.server.controllers;

import main.server.database.dto.Hello;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedList;
import java.util.List;

@Controller
public class HelloController {

    private List<Hello> values = new LinkedList<>();

    @RequestMapping("/hello")
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
