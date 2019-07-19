package main.server.logic.products.producttypes;

import main.server.logic.products.abstractions.Additional;
import main.server.logic.products.abstractions.Product;
import main.server.logic.products.enums.WebsiteType;

import java.awt.image.BufferedImage;

public class ClothingProduct extends Product {

    @Additional
    private String size;
    @Additional
    private String type;


    public ClothingProduct(){}

    public ClothingProduct(String name, WebsiteType sourceWebsite, BufferedImage image, boolean used, String price, String linkToOffer, String size, String type){
        //TODO REMOVE only for testing
        super(name, image, Integer.parseInt(price), used, linkToOffer, sourceWebsite);
        this.size = size;
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
