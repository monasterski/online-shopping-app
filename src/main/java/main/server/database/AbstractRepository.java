package main.server.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

public abstract class AbstractRepository<DATA> {

    @Autowired
    private SessionFactory sessionFactory;
    private Class<DATA> data;
    protected abstract void initData();

    protected AbstractRepository(Class<DATA> data){
        this.data = data;
    }

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public DATA getItem(Long id){
        Session session = sessionFactory.getCurrentSession();
        DATA o = session.get(data,id);
        return o;
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public Collection<DATA> getAllItems(){
        Session session = sessionFactory.getCurrentSession();
        List<DATA> o = (List<DATA>) session.createCriteria(data).list();
        return o;
    }

    @Transactional
    public DATA createItem(DATA data){
        Session session = sessionFactory.getCurrentSession();
        session.persist(data);
        return data;
    }

    @Transactional
    public DATA modifyItem(DATA data){
        Session session = sessionFactory.getCurrentSession();
        session.update(data);
        return data;
    }
}
