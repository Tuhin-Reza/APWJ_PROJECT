package com.repository;

import com.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RegistrationRepositoryImpl implements RegistrationRepository {

    private SessionFactory sessionFactory;

    public RegistrationRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<User> getAll()  {
        Session session = sessionFactory.getCurrentSession();//get the current hibernate session
        Query<User> userQuery = session.createQuery("from User", User.class);//create query
        List<User> users=userQuery.getResultList();
        return userQuery.getResultList();
    }
    public User create(User user)  {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
        return user ;
    }
}


