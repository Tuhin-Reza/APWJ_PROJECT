package com.service;


import com.domain.Account;
import com.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements  AccountService{
    private AccountRepository accountRepository;
    public  AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository=accountRepository;
    }

    @Transactional(readOnly = true)
    public List<Account> getAll() {
        return accountRepository.getAll();
    }

    @Transactional(readOnly = true)
    public Account get(Long account_id) {
        return accountRepository.get(account_id);
    }

    @Transactional
    public  Account create(Account account) {
        return accountRepository.create(account);
    }

    @Transactional
    public  Account update(Account account) {
        return accountRepository.update(account);
    }

    @Transactional
    public void delete(Long account_id) {
        accountRepository.delete(account_id);
    }
}