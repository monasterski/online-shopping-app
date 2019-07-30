package main.server.logic.products.factories;

import main.server.logic.products.producttypes.VehicleProduct;
import main.server.logic.products.abstractions.AbstractProductFactory;
import main.server.logic.products.enums.WebsiteType;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

public class  VehicleProductFactory implements AbstractProductFactory {


    @Override
    public VehicleProduct createProduct(Map<String, String> data){


//        VehicleProduct(String name, WebsiteType sourceWebsite, BufferedImage image, boolean used, String price, String linkToOffer, int year, int mileage)

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
        return new VehicleProduct(data.get("name"), WebsiteType.valueOf(data.get("sourceWebsite")), data.get("image"),
                used, price, data.get("link"),year , mileage);

    }
}
