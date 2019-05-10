package main.server.controllers.search;

import main.server.beans.services.ShopWebsiteService;
import main.server.controllers.AbstractController;
import main.server.controllers.data.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
public class AdvancedSearchController extends AbstractController {

    @Autowired
    private ShopWebsiteService shopService;

    @RequestMapping(value = "/advanced_search", method = RequestMethod.GET)
    public String search(Search search, Model model) throws IOException {
        return "advanced_search";
    }

}
