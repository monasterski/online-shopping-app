package main.server.logic.products;

import main.server.controllers.data.AdvancedSearch;
import main.server.controllers.data.product.Product;

import java.util.List;

public interface ProductConverter {

    List<Product> getProductsFromSite();
}
