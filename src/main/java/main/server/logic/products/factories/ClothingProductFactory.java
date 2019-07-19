package main.server.logic.products.factories;

import main.server.logic.products.enums.WebsiteType;
import main.server.logic.products.producttypes.ClothingProduct;
import main.server.logic.products.abstractions.AbstractProductFactory;
import main.server.logic.products.producttypes.VehicleProduct;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

public class ClothingProductFactory implements AbstractProductFactory {

    @Override
    public ClothingProduct createProduct(Map<String, String> data) {

        //ClothingProduct(String name, WebsiteType sourceWebsite, BufferedImage image, boolean used, String price, String linkToOffer, String size, String type)

        try{

            BufferedImage image = ImageIO.read(new URL(data.get("image")));
            String price = data.get("price").replaceAll("[^\\d.]+", "");
            if(price.equals(""))
                price = "-1";

            boolean used = true;
            if(data.containsKey("used")) {
                if(data.get("used").equals("no"))
                    used = false;
            }
            return new ClothingProduct(data.get("name"), WebsiteType.valueOf(data.get("sourceWebsite")), image,
                    used, price, data.get("link"),data.get("size") , data.get("type"));
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
