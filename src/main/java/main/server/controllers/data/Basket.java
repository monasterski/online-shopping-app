package main.server.controllers.data;

import main.server.database.dto.ProductData;

import java.util.List;

public class Basket {

    private List<ProductData> products;

    public void addProduct(ProductData product){
        products.add(product);
    }

    public List<ProductData> getProducts() {
        return products;
    }

    public void setProducts(List<ProductData> products) {
        this.products = products;
    }
}
