package main.server.logic.products.abstractions;

import java.util.Map;

public interface AbstractProductFactory {

    Product createProduct(Map<String, String> data);
}
