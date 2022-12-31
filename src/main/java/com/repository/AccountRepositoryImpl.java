package com.repository;

import com.domain.Account;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountRepositoryImpl implements AccountRepository{
    private SessionFactory sessionFactory;
    public AccountRepositoryImpl(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }
    public List<Account> getAll()  {
        Session session = sessionFactory.getCurrentSession();//get the current hibernate session
        Query<Account> accountQuery= session.createQuery("from Account",Account.class);//create query
        return accountQuery.getResultList();
    }
    public Account create(Account account)  {
        Session session = sessionFactory.getCurrentSession();
        session.save(account);
        return account;
    }
    public Account get(Long account_id)  {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Account.class,account_id);
    }
    public Account update(Account account) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(account);
        return  account;
    }
    public void delete(Long account_id) {
        Session session = sessionFactory.getCurrentSession();
        Account  account= get(account_id);
        if (account!= null) {
            session.delete(account);
        }
    }

}
