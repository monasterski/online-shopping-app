package main.server.database.dao;

import main.configuration.security.HashPasswordEncoder;
import main.server.controllers.data.User;
import main.server.database.AbstractDAO;
import main.server.database.dto.UserData;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserDAO extends AbstractDAO<UserData> {

    private static PasswordEncoder passwordEncoder = new HashPasswordEncoder();
    private static UserDAO dao = new UserDAO(UserData.class);

    public static synchronized UserDAO getInstance(){
        return dao;
    }

    private UserDAO(Class<UserData> data) { super(data);}

    public UserData getItem(String username){
        Session session = getInstance().getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        UserData user = (UserData) session.createQuery("from UserData where username = :username")
                .setParameter("username",username).uniqueResult();
        session.flush();
        tx.commit();
        return user;
    }

    //ONLY FOR DEVELOPER ISSUES
    @Override
    protected void initData() {
        UserData user = new UserData();
        user.setUsername("admin");
        user.setPassword(passwordEncoder.encode("admin"));
        createItem(user);
    }
}
