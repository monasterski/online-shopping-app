package main.server.database.dao;

import main.server.database.AbstractDAO;
import main.server.database.dto.ProductData;
import main.server.database.dto.UserData;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;

public class ProductDAO extends AbstractDAO<ProductData> {

    private static ProductDAO dao = new ProductDAO();

    public static synchronized ProductDAO getInstance(){
        return dao;
    }

    private ProductDAO() { super(ProductData.class);}

    public List<ProductData> getProducts(String username){
        return UserDAO.getInstance().getItem(username).getProducts();
    }

    @Override
    protected void initData() {
        UserData user = UserDAO.getInstance().getItem("admin");
        ProductData p1 = new ProductData();
        ProductData p2 = new ProductData();
        p1.setName("p1");
        p2.setName("p2");
        p1.setProductLink("dupa");
        p1.setUserId(user.getId());
        ProductData p3 = new ProductData();
        p3.setName("name3");
        p3.setUserId(user.getId());
        createItem(p1);
        createItem(p3);
        createItem(p2);
    }
}
