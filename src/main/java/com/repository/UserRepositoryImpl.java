package com.repository;

import com.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository{

    private SessionFactory sessionFactory;

    public UserRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<User> list()  {
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
    public User get(Long user_id)  {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, user_id);
    }
    public User update(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
        return user;
    }
    public void delete(Long user_id) {
        Session session = sessionFactory.getCurrentSession();
        User user = get(user_id);
        if (user!= null) {
            session.delete(user);
        }
    }


    @Override
    public User getByUsername(String user_name) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> userQuery = session.createQuery("from User where user_name = :user_name", User.class);
        userQuery.setParameter("user_name", user_name);
        return userQuery.getSingleResult();
    }
}


