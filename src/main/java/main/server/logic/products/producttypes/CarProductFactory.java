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

//        attributes.put("name", el.select("a.marginright5").select("strong").html());
//        attributes.put("image", el.select("img.fleft").attr("src"));
//        attributes.put("price", oneCarDoc.select("span.offer-price__number").first().data());
//        attributes.put("used", oneCarDoc.select("span.offer-params__link").first().attr("title"));

        CarProduct carProduct;


//        CarProduct(String name, Image image, String price, String contactNumber, String vin, int year, int mileage)

        try{

            BufferedImage image = ImageIO.read(new URL(data.get("image")));
            return new CarProduct(data.get("name"), WebsiteType.valueOf(data.get("sourceWebsite")), image, "123", "1234", Integer.parseInt(data.get("year")), 1000);
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
