package main.server.controllers.search;

import main.server.beans.services.ShopWebsiteService;
import main.server.controllers.AbstractController;
import main.server.controllers.data.AdvancedSearch;
import main.server.logic.products.enums.ProductCategory;
import main.server.logic.products.enums.WebsiteType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdvancedSearchController extends AbstractController {

    @Autowired
    private ShopWebsiteService shopService;

    @RequestMapping(value = "/advanced_search_form", method = RequestMethod.GET)
    public String searchForm(AdvancedSearch advancedSearch, Model model) throws IOException {

        model.addAttribute("advancedSearch", new AdvancedSearch());

        List<String> productCategoryList = new ArrayList<>();
        for(ProductCategory productCategory : ProductCategory.values()){
            String productCategoryName = productCategory.name().toLowerCase();
            productCategoryName = productCategoryName.substring(0,1).toUpperCase() + productCategoryName.substring(1);
            productCategoryList.add(productCategoryName);
        }
        model.addAttribute("productCategoryList", productCategoryList);
        List<String> websiteTypeList = new ArrayList<>();
        for(WebsiteType websiteType : WebsiteType.values()){
            String websiteTypeName = websiteType.name().toLowerCase();
            websiteTypeName = websiteTypeName.substring(0,1).toUpperCase() + websiteTypeName.substring(1);
            websiteTypeList.add(websiteTypeName);
        }
        model.addAttribute("websiteTypeList", websiteTypeList);
        return "advanced_search";
    }

    @RequestMapping(value = "/advanced_search_results", method = RequestMethod.POST)
    public String advancedSearch(
            @RequestParam(value ="Allegro", required = false)String[] checkboxAllegroVal,
            @RequestParam(value="Olx", required = false)String[] checkboxOLXVal,
            @RequestParam(value="Gratka", required = false)String[] checkboxGratkaVal,
            AdvancedSearch advancedSearch,
            Model model){

        if(checkboxAllegroVal != null){
            advancedSearch.setWebsitesToSearchIn("Allegro");
        }
        if(checkboxOLXVal != null){
            advancedSearch.setWebsitesToSearchIn("Olx");
        }
        if(checkboxGratkaVal != null){
            advancedSearch.setWebsitesToSearchIn("Gratka");
        }
        model.addAttribute("advancedSearch", advancedSearch);
        model.addAttribute("advancedResultsList", shopService.getAdvancedProductList(advancedSearch));
        return "advanced_search_results";
    }

}
