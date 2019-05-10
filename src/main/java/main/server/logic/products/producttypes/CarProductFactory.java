package main.server.logic.products.producttypes;

import main.server.controllers.data.product.CarProduct;
import main.server.logic.products.AbstractProductFactory;

public class CarProductFactory implements AbstractProductFactory {

    @Override
    public CarProduct createProduct(){
        return new CarProduct();
    }
}
