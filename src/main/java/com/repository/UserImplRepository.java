package com.repository;

import com.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserImplRepository implements UserRepository{

    private SessionFactory sessionFactory;

    public UserImplRepository(SessionFactory sessionFactory) {
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
    public User get(Long id)  {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }
    public User update(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
        return user;
    }
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        User student = get(id);
        if (student!= null) {
            session.delete(student);
        }
    }
}


