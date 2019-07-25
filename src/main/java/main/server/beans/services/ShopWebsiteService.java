package main.server.beans.services;

import main.server.controllers.data.AdvancedSearch;
import main.server.logic.products.abstractions.Product;
import main.server.controllers.products.ProductController;

import java.io.IOException;
import java.util.List;

public interface ShopWebsiteService {

    List<ProductController.ProductResultList> getProducts(String searchCriteria) throws IOException;

    List<Product> getAdvancedProductList(AdvancedSearch advancedSearch);

    Product getProductDetails(String url) throws IOException;

    void addProductList(List<Product> productList);

    List<Product> getProductList();

    void addAdvancedSearch(AdvancedSearch advancedSearch);

    AdvancedSearch getAdvancedSearch();
}
