package com.repository;

import com.domain.UAM;
import com.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UAMRepositoryImp implements UAMRepository{
    private SessionFactory sessionFactory;

    public UAMRepositoryImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public UAM create(UAM uam)  {
        Session session = sessionFactory.getCurrentSession();
        session.save(uam);
        return uam;
    }

    public List<UAM> getAll()  {
        Session session = sessionFactory.getCurrentSession();//get the current hibernate session
        Query<UAM> uamQuery = session.createQuery("from UAM", UAM.class);//create query
        List<UAM> uam=uamQuery.getResultList();
        return uamQuery.getResultList();
    }
}
