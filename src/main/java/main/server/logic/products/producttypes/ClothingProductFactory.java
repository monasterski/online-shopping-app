package main.server.logic.products.producttypes;

import main.server.controllers.data.product.ClothingProduct;
import main.server.logic.products.AbstractProductFactory;

import java.util.Map;

public class ClothingProductFactory implements AbstractProductFactory {

    @Override
    public ClothingProduct createProduct(Map<String, String> data) {
        return new ClothingProduct();
    }
}
