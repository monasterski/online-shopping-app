package main.server.controllers.data.product;

import main.server.logic.products.WebsiteType;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;
import java.util.List;

public abstract class Product {

    private String name;
    private BufferedImage image;
    private int price;
    private int quantity;
    private boolean used;
    private int contactNumber;
    //Czy jest produkt na sprzedaż
    private boolean active;
    private WebsiteType sourceWebsite;

    public String getSourceWebsite() {
        return sourceWebsite.name();
    }

    public void setSourceWebsite(WebsiteType sourceWebsite) {
        this.sourceWebsite = sourceWebsite;
    }

    public String getImage64() {
        try{
            BufferedImage bImage = this.image;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write( bImage, "jpg", baos );
            baos.flush();
            byte[] imageInByteArray = baos.toByteArray();
            baos.close();
            String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(imageInByteArray);
            return b64;
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    private static HashMap<Class<? extends Product>,List<String>> additionalFieldsMap = new HashMap<>();
    private List<String> additionalFields;

    Product(String name, BufferedImage image, int price,int contactNumber, WebsiteType website){
        this.name = name;
        this.image = image;
        this.price = price;
        this.contactNumber = contactNumber;
        this.sourceWebsite = website;
        intiAdditionalFields();
    }

    Product(){
        intiAdditionalFields();
    }

    private void intiAdditionalFields() {
        if(!additionalFieldsMap.containsKey(this.getClass())) {
            Field[] fields = getClass().getDeclaredFields();
            List<String> fieldNames = new LinkedList<>();
            for(Field field : fields){
                if(field.isAnnotationPresent(Additional.class)){
                    fieldNames.add(field.getName());
                }
            }
            additionalFieldsMap.put(this.getClass(),fieldNames);
        }
        this.additionalFields = additionalFieldsMap.get(this.getClass());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public List<String> getAdditionalFields() {
        return additionalFields;
    }

    public String getAdditionalFieldInPolish(String additionalField) {
        Map<String, String> dict = new HashMap<>();
        dict.put("year", "Rok");
        dict.put("mileage", "Przebieg");
        return dict.get(additionalField);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
