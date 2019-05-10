package main.server.controllers.data;

import main.server.controllers.data.product.ProductCategory;
import main.server.logic.products.WebsiteType;

import java.util.HashSet;
import java.util.Set;

public class AdvancedSearch extends Search{

    private ProductCategory productCategory;

    private Set<WebsiteType> websitesToSechIn;

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public AdvancedSearch(){
        this.websitesToSechIn = new HashSet<>();
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = ProductCategory.valueOf(productCategory.toUpperCase());
    }

    public Set<WebsiteType> getWebsitesToSechIn() {
        return websitesToSechIn;
    }

    public void setWebsitesToSechIn(String websiteToSechIn) {
        this.websitesToSechIn.add(WebsiteType.valueOf(websiteToSechIn.toUpperCase()));
    }
}
