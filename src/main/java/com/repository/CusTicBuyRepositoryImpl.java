package com.repository;

import com.domain.CusTicBuy;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CusTicBuyRepositoryImpl implements CusTicBuyRepository{
    private SessionFactory sessionFactory;
    public CusTicBuyRepositoryImpl(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }
    public List<CusTicBuy> getAll()  {
        Session session = sessionFactory.getCurrentSession();//get the current hibernate session
        Query<CusTicBuy> cusTicBuyQuery= session.createQuery("from CusTicBuy", CusTicBuy.class);//create query
        return cusTicBuyQuery.getResultList();
    }
    public CusTicBuy create(CusTicBuy cusTicBuy)  {
        Session session = sessionFactory.getCurrentSession();
        session.save(cusTicBuy);
        return cusTicBuy;
    }
    public CusTicBuy get(Long cusTicBuy_id)  {
        Session session = sessionFactory.getCurrentSession();
        return session.get(CusTicBuy.class,cusTicBuy_id);
    }
    public CusTicBuy update(CusTicBuy cusTicBuy) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cusTicBuy);
        return cusTicBuy;
    }
    public void delete(Long cusTicBuy_id) {
        Session session = sessionFactory.getCurrentSession();
       CusTicBuy cusTicBuy= get(cusTicBuy_id);
        if (cusTicBuy!= null) {
            session.delete(cusTicBuy);
        }
    }

}
