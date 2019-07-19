package main.server.logic.products.enums;

import main.server.logic.products.abstractions.AbstractProductFactory;
import main.server.logic.products.factories.ClothingProductFactory;
import main.server.logic.products.factories.VehicleProductFactory;

public enum ProductCategory {
    VEHICLE(new VehicleProductFactory()),
    CLOTHING(new ClothingProductFactory());

    private AbstractProductFactory productFactory;

    ProductCategory(AbstractProductFactory productFactory){
        this.productFactory = productFactory;
    }

    public AbstractProductFactory getProductFactory(){
        return this.productFactory;
    }
}
