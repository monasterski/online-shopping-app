package main.server.controllers.data.product;

import main.server.logic.products.AbstractProductFactory;
import main.server.logic.products.producttypes.BikeProductFactory;
import main.server.logic.products.producttypes.CarProductFactory;

public enum ProductCategory {
    CAR(new CarProductFactory()),
    BIKE(new BikeProductFactory());

    private AbstractProductFactory productFactory;

    ProductCategory(AbstractProductFactory productFactory){
        this.productFactory = productFactory;
    }
}
