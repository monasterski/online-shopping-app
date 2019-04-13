package main.server.controllers;


import main.server.database.dto.Search;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user/search")
public class SearchController extends AbstractController {

    @RequestMapping(method= RequestMethod.GET)
    public String search(Model model) {
        model.addAttribute("search", new Search());
        return "search";
    }
    @RequestMapping(method= RequestMethod.POST)
    public String processSearchTerm(Search search) {
        return "redirect:/user/search/" + search.getSearchString();
    }

    @RequestMapping(value = "/{searchString}", method = RequestMethod.GET)
    public String printResults(@PathVariable("searchString") String searchString, Model model){
        return "results";
    }


}
