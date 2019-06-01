package main.server.logic.products;

import main.server.controllers.data.AdvancedSearch;
import main.server.controllers.data.product.CarProduct;
import main.server.controllers.data.product.Product;
import main.server.logic.products.websitetypes.AllegroProductConverter;
import main.server.logic.products.websitetypes.OLXProductConverter;
import main.server.logic.products.websitetypes.OtomotoProductConverter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

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
        try {

            BufferedImage image = ImageIO.read(new URL("https://static.thenounproject.com/png/1427-200.png"));
            return new CarProduct("wymyslona nazwa rezultatu", OLX, image, "1000","1234",2001,300000);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
