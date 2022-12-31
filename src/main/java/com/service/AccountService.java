package com.service;


import com.domain.Account;

import java.util.List;

public interface AccountService {
    public List<Account> getAll();
    public Account get(Long account_id);
    public Account create(Account account);
    public Account update(Account account);
    public  void delete(Long account_id);
}
