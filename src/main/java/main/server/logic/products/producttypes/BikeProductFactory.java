package main.server.logic.products.producttypes;

import main.server.controllers.data.product.BikeProduct;
import main.server.logic.products.AbstractProductFactory;

public class BikeProductFactory implements AbstractProductFactory {

    @Override
    public BikeProduct createProduct() {
        return new BikeProduct();
    }
}
