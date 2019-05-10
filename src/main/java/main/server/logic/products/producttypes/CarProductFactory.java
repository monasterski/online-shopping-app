package main.server.logic.products.producttypes;

import main.server.controllers.data.product.CarProduct;
import main.server.logic.products.AbstractProductFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CarProductFactory implements AbstractProductFactory {


    private List<String> fieldsNeeded;

    public CarProductFactory() {
        this.fieldsNeeded = new ArrayList<String>() {
            {
                add("name");
                add("price");
                add("used");
                add("contactNumber");
                add("active");
                add("vin");
                add("year");
                add("mileage");
            }
        };
    }

    @Override
    public CarProduct createProduct(Map<String, String> data){

        return new CarProduct();
    }
}
