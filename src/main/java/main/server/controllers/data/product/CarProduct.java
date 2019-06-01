package main.server.controllers.data.product;


import main.server.logic.products.WebsiteType;

import java.awt.*;
import java.awt.image.BufferedImage;

public class CarProduct extends Product {

    @Additional
    private int year;
    @Additional
    private int mileage;

    public CarProduct(){}

    public CarProduct(String name, WebsiteType sourceWebsite, BufferedImage image, boolean used, String price, String linkToOffer, int year, int mileage){
        //TODO REMOVE only for testing
        super(name, image, Integer.parseInt(price), used, linkToOffer, sourceWebsite);
        this.year = year;
        this.mileage = mileage;
    }


    public String getMileage() {

        if(mileage==-1)
            return "-";
        return String.valueOf(mileage);
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getYear() {
        if(year==-1)
            return "-";
        return String.valueOf(year);
    }

    public void setYear(int year) {
        this.year = year;
    }
}
