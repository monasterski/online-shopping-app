package main.server.controllers.authorization;

import main.server.controllers.data.Basket;
import main.server.database.dao.ProductDAO;

public class ApplicationContext {

    private String username;

    private Basket basket;

    public ApplicationContext(){}

    public String getUsername() {
        return username;
    }

    void initContext(String username){
        this.username = username;
        basket = new Basket();
        basket.setProducts(ProductDAO.getInstance().getProducts(username));
    }

    public Basket getBasket() {
        return basket;
    }
}
