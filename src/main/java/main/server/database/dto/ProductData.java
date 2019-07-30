package main.server.database.dto;

import main.server.database.AbstractData;

import javax.persistence.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Base64;

@Entity
@Table(name = "PRODUCTS")
public class ProductData extends AbstractData {

    @Id
    @Column(name = "PRODUCT_ID")
    private Long id;

    @Column(name = "PRODUCTS_USER_ID")
    @JoinColumn(name = "USER_ID")
    private Long userId;

    @Column(name = "PRODUCT_NAME")
    private String name;

    @Column(name = "PRODUCT_IMAGE")
    private String productImage;

    @Column(name = "PRODUCT_PRICE")
    private Double price;

    @Column(name = "PRODUCT_ISUSED")
    private byte used;

    @Column(name = "PRODUCT_LINK")
    private String productLink;

    @Column(name = "PRODUCT_SOURCE")
    private String sourceWebsite;

    @Column(name = "PRODUCT_TYPE")
    private String productType;

    @Column(name = "PRODUCT_ADDITIONAL1")
    private String additional1;

    @Column(name = "PRODUCT_ADDITIONAL2")
    private String additional2;

    public String getUsedString(){
        if(used==1){
            return "tak";
        }
        else {
            return "nie";
        }
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public ProductData(String name, String productImage, Double price, byte used, String productLink, String sourceWebsite, String productType, String additional1, String additional2) {
        this.name = name;
        this.productImage = productImage;
        this.price = price;
        this.used = used;
        this.productLink = productLink;
        this.sourceWebsite = sourceWebsite;
        this.productType = productType;
        this.additional1 = additional1;
        this.additional2 = additional2;
    }

    public ProductData(){}

    public String getBase64String() throws IOException {
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(this);
        oos.flush();
        return Base64.getUrlEncoder().encodeToString(baos.toByteArray());
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public byte getUsed() {
        return used;
    }

    public void setUsed(byte used) {
        this.used = used;
    }

    public String getProductLink() {
        return productLink;
    }

    public void setProductLink(String productLink) {
        this.productLink = productLink;
    }

    public String getSourceWebsite() {
        return sourceWebsite;
    }

    public void setSourceWebsite(String sourceWebsite) {
        this.sourceWebsite = sourceWebsite;
    }

    public String getAdditional1() {
        return additional1;
    }

    public void setAdditional1(String additional1) {
        this.additional1 = additional1;
    }

    public String getAdditional2() {
        return additional2;
    }

    public void setAdditional2(String additional2) {
        this.additional2 = additional2;
    }

    @Override
    public int hashCode() {
        return (int) (this.name.length() + this.userId +
                this.productLink.length()%this.name.length());
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ProductData){
            ProductData that = (ProductData) obj;
            return that.userId.equals(this.userId)
                    && that.productLink.equals(this.productLink)
                    && that.name.equals(this.name);
        }
        return false;
    }
}
