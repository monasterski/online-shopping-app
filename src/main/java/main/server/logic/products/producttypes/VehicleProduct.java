package main.server.logic.products.producttypes;


import main.server.logic.products.abstractions.Additional;
import main.server.logic.products.abstractions.Product;
import main.server.logic.products.enums.WebsiteType;

import java.awt.image.BufferedImage;

public class VehicleProduct extends Product {

    @Additional
    private int year;
    @Additional
    private int mileage;

    public VehicleProduct(){}

    public VehicleProduct(String name, WebsiteType sourceWebsite, String image, boolean used, String price, String linkToOffer, int year, int mileage){
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
