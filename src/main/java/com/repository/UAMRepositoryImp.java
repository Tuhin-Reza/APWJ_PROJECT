package com.repository;

import com.domain.UAM;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

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
}
