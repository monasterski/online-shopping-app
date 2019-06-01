package main.server.logic.products.producttypes;

import main.server.controllers.data.product.VehicleProduct;
import main.server.logic.products.AbstractProductFactory;
import main.server.logic.products.WebsiteType;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

public class VehicleProductFactory implements AbstractProductFactory {


    @Override
    public VehicleProduct createProduct(Map<String, String> data){


//        VehicleProduct(String name, WebsiteType sourceWebsite, BufferedImage image, boolean used, String price, String linkToOffer, int year, int mileage)

        try{

            BufferedImage image = ImageIO.read(new URL(data.get("image")));
            String price = data.get("price").replaceAll("[^\\d.]+", "");
            if(price.equals(""))
                price = "-1";
            int mileage = -1;
            if(data.containsKey("mileage") && !data.get("mileage").equals(""))
                mileage = Integer.parseInt(data.get("mileage").replaceAll("[^\\d.]+", ""));
            boolean used = true;
            if(data.containsKey("used")) {
                if(data.get("used").equals("no"))
                    used = false;
            }
            int year = -1;
            if(data.containsKey("year") && !data.get("year").equals(""))
                year = Integer.parseInt(data.get("year"));
            return new VehicleProduct(data.get("name"), WebsiteType.valueOf(data.get("sourceWebsite")), image,
                    used, price, data.get("link"),year , mileage);
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