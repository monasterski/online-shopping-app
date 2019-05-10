package main.server.logic.products;

import main.server.controllers.data.AdvancedSearch;
import main.server.controllers.data.product.CarProduct;
import main.server.controllers.data.product.Product;
import main.server.logic.products.websitetypes.AllegroProductConverter;
import main.server.logic.products.websitetypes.OLXProductConverter;
import main.server.logic.products.websitetypes.OtomotoProductConverter;

public enum WebsiteType {

    OLX,
    OTOMOTO,
    ALLEGRO;


    public static Product getProductDetails(String url) {
        for(WebsiteType type : WebsiteType.values())
            if(url.contains(type.name().toLowerCase()+".pl"))
                return type.getProduct(url);
        throw new UnsupportedOperationException("Unsupported website URL: " + url);
    }

    public Product getProduct(String url) {
        //TODO
        return new CarProduct("wymyslona nazwa rezultatu", "1000", "1234","00000000",2001,300000);
    }
}
