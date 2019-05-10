package main.server.logic.products.producttypes;

import main.server.controllers.data.product.BikeProduct;
import main.server.logic.products.AbstractProductFactory;

import java.util.Map;

public class BikeProductFactory implements AbstractProductFactory {

    @Override
    public BikeProduct createProduct(Map<String, String> data) {
        return new BikeProduct();
    }
}
