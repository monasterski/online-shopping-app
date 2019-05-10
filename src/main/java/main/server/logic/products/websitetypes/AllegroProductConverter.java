package main.server.logic.products.websitetypes;

import main.server.controllers.data.AdvancedSearch;
import main.server.controllers.data.product.CarProduct;
import main.server.controllers.data.product.Product;
import main.server.controllers.data.product.ProductCategory;
import main.server.logic.products.AbstractProductFactory;
import main.server.logic.products.ProductConverter;

import java.util.ArrayList;
import java.util.List;

public class AllegroProductConverter implements ProductConverter {

    private AdvancedSearch advancedSearch;

    private AbstractProductFactory productFactory;

    public AllegroProductConverter(AdvancedSearch advancedSearch){
        this.advancedSearch = advancedSearch;
        this.productFactory = advancedSearch.getProductCategory().getProductFactory();
    }

    @Override
    public List<Product> getProductsFromSite() {
        String seachTerm = advancedSearch.getSearchString();
        ProductCategory category = advancedSearch.getProductCategory();
        //TODO: empty list
        return new ArrayList<>();
    }
}
