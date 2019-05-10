package main.server.logic.products.websitetypes;

import main.server.controllers.data.AdvancedSearch;
import main.server.controllers.data.product.CarProduct;
import main.server.controllers.data.product.Product;
import main.server.controllers.data.product.ProductCategory;
import main.server.logic.products.AbstractProductFactory;
import main.server.logic.products.ProductConverter;

import java.util.ArrayList;
import java.util.List;

public class OLXProductConverter implements ProductConverter {

    private AdvancedSearch advancedSearch;

    private AbstractProductFactory productFactory;

    public OLXProductConverter(AdvancedSearch advancedSearch){
        this.advancedSearch = advancedSearch;
        this.productFactory = advancedSearch.getProductCategory().getProductFactory();
    }

    @Override
    public List<Product> getProductsFromSite() {
        String seachTerm = advancedSearch.getSearchString();
        ProductCategory category = advancedSearch.getProductCategory();
        List<Product> result = new ArrayList<>();
        result.add(new CarProduct("wymyslona nazwa rezultatu", "1000", "1234","00000000",2001,300000));
        return result;
    }
}
