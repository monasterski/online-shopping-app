package main.server.logic.products.producttypes;

import main.server.controllers.data.product.CarProduct;
import main.server.logic.products.AbstractProductFactory;
import main.server.logic.products.WebsiteType;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CarProductFactory implements AbstractProductFactory {


    @Override
    public CarProduct createProduct(Map<String, String> data){

        CarProduct carProduct;


//        CarProduct(String name, WebsiteType sourceWebsite, BufferedImage image, boolean used, String price, String linkToOffer, int year, int mileage)

        try{

            BufferedImage image = ImageIO.read(new URL(data.get("image")));
            String price = data.get("price").replaceAll("[^\\d.]+", "");
            int mileage = Integer.parseInt(data.get("mileage").replaceAll("[^\\d.]+", ""));
            boolean used = true;
            if(data.containsKey("used")) {
                if(data.get("used").equals("no"))
                    used = false;
            }
            return new CarProduct(data.get("name"), WebsiteType.valueOf(data.get("sourceWebsite")), image,
                    used, price, data.get("link"), Integer.parseInt(data.get("year")), mileage);
        }
        catch (java.net.MalformedURLException exc){
            System.out.println(data.get("image"));
        }
        catch(IOException ex) {
            System.out.println(data.get("image"));
            ex.printStackTrace();
        }

        return null;
    }
}
