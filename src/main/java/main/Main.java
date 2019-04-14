package main;

import main.server.database.dto.Employee;
import main.server.database.dto.UserData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.MessageFormat;
import java.util.List;
import java.util.Properties;

@SpringBootApplication
public class Main {

    public static void main(String args[]) throws ClassNotFoundException {
//        System.out.println("Hello");
//        SpringApplication.run(Main.class,args);



        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("database");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(new UserData());
        entityManager.getTransaction().commit();

        UserData u = (UserData) entityManager.createQuery("SELECT x FROM UserData x").getSingleResult();
        System.out.println(u.getLogin() + " | " + u.getUserId());


    }
}
