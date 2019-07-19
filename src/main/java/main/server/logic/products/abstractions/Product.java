package main.server.logic.products.abstractions;

import main.server.logic.products.enums.WebsiteType;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
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
    private String linkToOffer;

    public String getLinkToOffer() {
        return linkToOffer;
    }

    public void setLinkToOffer(String linkToOffer) {
        this.linkToOffer = linkToOffer;
    }

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
            ImageIO.write( bImage, "png", baos );
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

    public Product(String name, BufferedImage image, int price, boolean used, String linkToOffer, WebsiteType website){
        this.name = name;
        this.image = image;
        this.price = price;
        this.used = used;
        this.linkToOffer = linkToOffer;
        this.sourceWebsite = website;
        intiAdditionalFields();
    }

    public Product(){
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

    public String getPrice() {
        if(price==-1)
            return "nieznana";
        return String.valueOf(price);
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

    public String isUsed() {

        if(used)
            return "tak";
        return "nie";
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public List<String> getAdditionalFields() {
        return additionalFields;
    }

    public String getAdditionalFieldInPolish(String additionalField) {
        Map<String, String> dict = new HashMap<>();
        dict.put("year", "Rok");
        dict.put("mileage", "Przebieg");
        dict.put("size", "Rozmiar");
        dict.put("type", "Rodzaj");
        return dict.get(additionalField);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
