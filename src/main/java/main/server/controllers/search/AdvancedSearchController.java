package main.server.controllers.search;

import main.server.beans.services.ShopWebsiteService;
import main.server.controllers.AbstractController;
import main.server.controllers.data.AdvancedSearch;
import main.server.controllers.data.Sort;
import main.server.logic.products.abstractions.Product;
import main.server.logic.products.enums.ProductCategory;
import main.server.logic.products.enums.WebsiteType;
import main.server.logic.products.producttypes.ClothingProduct;
import main.server.logic.products.producttypes.VehicleProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

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
            Sort sort,
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
        List<Product> productResultList = shopService.getAdvancedProductList(advancedSearch);
        List<List<String>> additionalFieldsValues = getAdditionalValsLists(productResultList, advancedSearch);
        shopService.addAdvancedSearch(advancedSearch);
        shopService.addProductList(productResultList);
        model.addAttribute("sort", sort);
        model.addAttribute("advancedSearch", advancedSearch);
        model.addAttribute("vehicleString", "VEHICLE");
        model.addAttribute("clothingString", "CLOTHING");
        model.addAttribute("advancedResultsList", productResultList);
        model.addAttribute("additionalField1Values", additionalFieldsValues.get(0));
        model.addAttribute("additionalField2Values", additionalFieldsValues.get(1));
        return "advanced_search_results";
    }

    private List<List<String>> getAdditionalValsLists(List<Product> productList, AdvancedSearch search){
        if(search.getProductCategory().equals(ProductCategory.VEHICLE)){
            List<Integer> yearList = new ArrayList<>();
            List<Integer> mileageList = new ArrayList<>();
            for(Product product : productList){
                VehicleProduct vProduct = (VehicleProduct) product;
                yearList.add(Integer.parseInt(vProduct.getYear().replace('-','0')));
                mileageList.add(Integer.parseInt(vProduct.getMileage().replace('-','0')));
            }
            Collections.sort(yearList);
            Collections.sort(mileageList);
            List<String> yearListString = yearList.stream().map(x->Integer.toString(x)).collect(Collectors.toList());
            List<String> mileageListString = mileageList.stream().map(x->Integer.toString(x)).collect(Collectors.toList());
            List<List<String>> result = new ArrayList<>();
            result.add(yearListString);
            result.add(mileageListString);
            return result;

        }
        else {
            List<String> sizeList = new ArrayList<>();
            List<String> typeList = new ArrayList<>();
            for(Product product : productList){
                ClothingProduct cProduct = (ClothingProduct) product;
                sizeList.add(cProduct.getSize());
                typeList.add(cProduct.getType());
            }
            sizeList = new ArrayList<>(new LinkedHashSet<>(sizeList));
            typeList = new ArrayList<>(new LinkedHashSet<>(typeList));
            List<List<String>> result = new ArrayList<>();
            result.add(sizeList);
            result.add(typeList);
            return result;
        }
    }

    @RequestMapping(value = "/advanced_search_results_sorted", method = RequestMethod.POST)
    public String advancedSearchSort(
            Sort sort,
            Model model) {

        ProductCategory category = shopService.getAdvancedSearch().getProductCategory();
        List<Product> productResultList = shopService.getProductList();

        if(sort.getPriceSorting().equals("Rosnąco")){
            productResultList.sort(
                    (a,b)->{
                        String aString = a.getPrice();
                        String bString = b.getPrice();
                        if(aString.equals("nieznana")) aString="0";
                        if(bString.equals("nieznana")) bString="0";
                        if(Integer.parseInt(aString)>Integer.parseInt(bString)){
                            return 1;
                        }
                        if(Integer.parseInt(aString)<Integer.parseInt(bString)){
                            return -1;
                        }
                        else {
                            return 0;
                        }
                    });
        }
        else {
            productResultList.sort(
                    (a,b)->{
                        String aString = a.getPrice();
                        String bString = b.getPrice();
                        if(aString.equals("nieznana")) aString="0";
                        if(bString.equals("nieznana")) bString="0";
                        if(Integer.parseInt(aString)>Integer.parseInt(bString)){
                            return -1;
                        }
                        if(Integer.parseInt(aString)<Integer.parseInt(bString)){
                            return 1;
                        }
                        else {
                            return 0;
                        }
                    });
        }
        productResultList = productResultList.stream().filter(product -> product.isUsed().toUpperCase().equals(sort.getUsed().toUpperCase())).collect(Collectors.toList());

        if(category.equals(ProductCategory.VEHICLE)){
            List<VehicleProduct> vehicleProducts = productResultList.stream().map(VehicleProduct.class::cast).collect(Collectors.toList());
            vehicleProducts = vehicleProducts.stream().filter(
                    product ->
                            Integer.parseInt(product.getYear()) >= sort.getYearFrom()
                            && Integer.parseInt(product.getYear())<= sort.getYearTo()
                    ).collect(Collectors.toList());
            vehicleProducts = vehicleProducts.stream().filter(
                    product ->
                            Integer.parseInt(product.getMileage()) >= sort.getMileageFrom()
                                    && Integer.parseInt(product.getMileage())<= sort.getMileageTo()
            ).collect(Collectors.toList());
            productResultList = vehicleProducts.stream().map(Product.class::cast).collect(Collectors.toList());
        }
        else{
            List<ClothingProduct> clothingProducts = productResultList.stream().map(ClothingProduct.class::cast).collect(Collectors.toList());
            if(!sort.getType().equals(""))
                clothingProducts = clothingProducts.stream()
                        .filter(product ->
                                product.getType() != null &&
                                product.getType().equals(sort.getType())
                        )
                        .collect(Collectors.toList());
            if(!sort.getSize().equals(""))
                clothingProducts = clothingProducts.stream()
                        .filter(product ->
                                product.getSize() != null &&
                                product.getSize().equals(sort.getSize())
                        )
                        .collect(Collectors.toList());
            productResultList = clothingProducts.stream().map(Product.class::cast).collect(Collectors.toList());
        }
        List<List<String>> additionalFieldsValues = getAdditionalValsLists(productResultList, shopService.getAdvancedSearch());
        model.addAttribute("sort", sort);
        model.addAttribute("vehicleString", "VEHICLE");
        model.addAttribute("clothingString", "CLOTHING");
        model.addAttribute("advancedResultsList", productResultList);
        model.addAttribute("advancedSearch", shopService.getAdvancedSearch());
        model.addAttribute("additionalField1Values", additionalFieldsValues.get(0));
        model.addAttribute("additionalField2Values", additionalFieldsValues.get(1));
        shopService.addProductList(productResultList);
        return "advanced_search_results";
    }
}
