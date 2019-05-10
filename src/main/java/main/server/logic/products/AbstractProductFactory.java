package main.server.logic.products;

import main.server.controllers.data.product.Product;

import java.util.Map;

public interface AbstractProductFactory {

    Product createProduct(Map<String, String> data);
}
