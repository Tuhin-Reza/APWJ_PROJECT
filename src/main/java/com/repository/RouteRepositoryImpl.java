package com.repository;

import com.domain.Route;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RouteRepositoryImpl implements RouteRepository{
    private SessionFactory sessionFactory;
    public RouteRepositoryImpl(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }
    public List<Route> getAll()  {
        Session session = sessionFactory.getCurrentSession();//get the current hibernate session
        Query<Route> routeQuery= session.createQuery("from Route", Route.class);//create query
        return routeQuery.getResultList();
    }
    public Route create(Route route)  {
        Session session = sessionFactory.getCurrentSession();
        session.save(route);
        return route;
    }
    public Route get(Long  route_id)  {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Route.class,route_id);
    }
    public Route update(Route route) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(route);
        return  route;
    }
    public void delete(Long route_id) {
        Session session = sessionFactory.getCurrentSession();
        Route  route= get(route_id);
        if (route!= null) {
            session.delete(route);
        }
    }

}
