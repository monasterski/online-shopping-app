package main.server.controllers.products;

import main.server.controllers.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class BasketController extends AbstractController {

    @RequestMapping(value = "/basket",method = RequestMethod.GET)
    public String basket(Model model){
        model.addAttribute("products",getApplicationContext().getBasket().getProducts());
        return "basket";
    }
}
