package com.repository;

import com.domain.TransitionHis;
import com.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

@Repository
public class TransitionHisRepositoryImpl implements TransitionHisRepository{
    private SessionFactory sessionFactory;
    public TransitionHisRepositoryImpl(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }

    public List<TransitionHis> getAll()  {
        Session session = sessionFactory.getCurrentSession();//get the current hibernate session
        Query<TransitionHis> transitionHisQuery= session.createQuery("from TransitionHis", TransitionHis.class);//create query
        return transitionHisQuery.getResultList();
    }

    public TransitionHis create(TransitionHis transitionHis)  {
        Session session = sessionFactory.getCurrentSession();
        session.save(transitionHis);
        return transitionHis;
    }

    public TransitionHis get(Long  transitionHis_id)  {
        Session session = sessionFactory.getCurrentSession();
        return session.get(TransitionHis.class,transitionHis_id);
    }

    public TransitionHis update(TransitionHis transitionHis) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(transitionHis);
        return  transitionHis;
    }

    public void delete(Long transitionHis_id) {
        Session session = sessionFactory.getCurrentSession();
        TransitionHis  transitionHis= get(transitionHis_id);
        if (transitionHis!= null) {
            session.delete(transitionHis);
        }
    }

    public List<TransitionHis> getPerson(Long transitionHis_id){
        Session session = sessionFactory.getCurrentSession();//get the current hibernate session
        Query<TransitionHis> transitionHisQuery= session.createQuery("from TransitionHis where id = :id", TransitionHis.class);//create query
        return transitionHisQuery.getResultList();
    }

}
