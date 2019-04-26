package main.server.database.dto;

import main.server.database.AbstractData;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCTS")
public class ProductData extends AbstractData {

    @Id
    @Column(name = "PRODUCT_ID")
    private Long id;

    @Column(name = "PRODUCTS_USER_ID")
    @JoinColumn(name = "USER_ID")
    private Long userId;

    @Column(name = "PRODUCT_LINK")
    private String productLink;

    @Column(name = "PRODUCT_NAME")
    private String name;

    public ProductData(){}

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getProductLink() {
        return productLink;
    }

    public void setProductLink(String productLink) {
        this.productLink = productLink;
    }
}
