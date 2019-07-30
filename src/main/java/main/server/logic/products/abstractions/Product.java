package main.server.logic.products.abstractions;

import main.server.logic.products.enums.WebsiteType;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.List;

public class Product implements Serializable {

    private String productName;
    private String image;
    private int price;
    private boolean used;
    private String linkToOffer;
    private WebsiteType sourceWebsite;


    public String getLinkToOffer() {
        return linkToOffer;
    }

    public void setLinkToOffer(String linkToOffer) {
        this.linkToOffer = linkToOffer;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public String getSourceWebsite() {
        return sourceWebsite.name();
    }

    public String getBase64String() throws IOException {
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(this);
        oos.flush();
        return Base64.getUrlEncoder().encodeToString(baos.toByteArray());
    }

    public void setSourceWebsite(WebsiteType sourceWebsite) {
        this.sourceWebsite = sourceWebsite;
    }


    private static HashMap<Class<? extends Product>,List<String>> additionalFieldsMap = new HashMap<>();
    private List<String> additionalFields;

    public Product(String productName, String image, int price, boolean used, String linkToOffer, WebsiteType website){
        this.productName = productName;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        if(price==-1)
            return "nieznana";
        return String.valueOf(price);
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public String isUsed() {

        if(used)
            return "tak";
        return "nie";
    }

    public String getUsed() {
        if(used)
            return "1";
        return "0";
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

}
