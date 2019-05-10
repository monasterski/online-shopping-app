package main.server.controllers.data;

import main.server.controllers.data.product.ProductCategory;
import main.server.logic.products.WebsiteType;

import java.util.HashSet;
import java.util.Set;

public class AdvancedSearch extends Search{

    private ProductCategory productCategory;

    private Set<WebsiteType> websitesToSearchIn;

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public AdvancedSearch(){
        this.websitesToSearchIn = new HashSet<>();
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = ProductCategory.valueOf(productCategory.toUpperCase());
    }

    public Set<WebsiteType> getWebsitesToSearchIn() {
        return websitesToSearchIn;
    }

    public void setWebsitesToSearchIn(String websiteToSearchIn) {
        this.websitesToSearchIn.add(WebsiteType.valueOf(websiteToSearchIn.toUpperCase()));
    }
}
