package com.repository;

import com.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    private SessionFactory sessionFactory;

    public UserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<User> list()  {
        Session session = sessionFactory.getCurrentSession();//get the current hibernate session
        Query<User> studentQuery = session.createQuery("from student", User.class);//create query
        List<User> student=studentQuery.getResultList();
        return studentQuery.getResultList();
    }
    public boolean create(User student)  {
        Session session = sessionFactory.getCurrentSession();
        session.save(student);
        return true;
    }
    public User get(Long student_id)  {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, student_id);
    }
    public List<User> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<User> studentQuery = session.createQuery("from Student", User.class);
        return studentQuery.getResultList();
    }

    public User update(User student) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(student);
        return student;
    }

    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        User student = get(id);
        if (student!= null) {
            session.delete(student);
        }
    }

}


