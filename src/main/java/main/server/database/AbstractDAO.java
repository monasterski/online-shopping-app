package main.server.database;

import main.server.database.dto.UserData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.reflections.Reflections;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public abstract class AbstractDAO<DATA> {

    private final static SessionFactory sessionFactory = initSessionFactory("main.server.database");
    private Class<DATA> data;

    protected abstract void initData();

    protected AbstractDAO(Class<DATA> data){
        this.data = data;
        initData();
    }

    private static SessionFactory initSessionFactory(String packege) {
        try {

            Configuration configuration = new AnnotationConfiguration();
            Reflections pkg = new Reflections(packege);
            Set<Class<? extends AbstractDAO>> classes = pkg.getSubTypesOf(AbstractDAO.class);
            for (Class<? extends AbstractDAO> abs : classes) {
                Class data = (Class<?>) ((ParameterizedType) abs.getGenericSuperclass()).getActualTypeArguments()[0];
                configuration.addAnnotatedClass(data);
            }
            configuration.configure();
            Properties properties = configuration.getProperties();
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(properties).buildServiceRegistry();
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            sessionFactory.openSession();
            return sessionFactory;

        }catch (Exception e){ e.printStackTrace(); }
        return null;
    }

    protected SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public DATA getItem(Long id){
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        DATA o = (DATA) session.get(data,id);
        session.flush();
        tx.commit();
        return o;
    }

    @SuppressWarnings("unchecked")
    public Collection<DATA> getAllItems(){
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<DATA> o = (List<DATA>) session.createCriteria(data).list();
        session.flush();
        tx.commit();
        return o;
    }

    public void createItem(DATA data){
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(data);
        session.flush();
        tx.commit();
    }
}
