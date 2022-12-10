package com.service;

import com.domain.Authority;
import com.domain.User;
import com.repository.AuthorityRepository;
import com.repository.AuthorityRepositoryImpl;
import com.repository.UserRepository;
import com.repository.UserRepositoryImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthorityServiceImpl implements AuthorityService {

    private AuthorityRepository authorityRepository;

    public AuthorityServiceImpl(AuthorityRepositoryImpl authorityRepository) {

        this.authorityRepository = authorityRepository;
    }
    @Transactional(readOnly = true)
    public List<Authority> list() {
        return authorityRepository.list();
    }
    @Transactional(readOnly = true)
    public Authority get(Long authority_id) {
        return authorityRepository.get(authority_id);
    }
    @Transactional
    public Authority create(Authority authority) {
        return authorityRepository.create(authority);
    }
    @Transactional
    public Authority update(Authority authority) {
        return authorityRepository.update(authority);
    }

    @Transactional
    public void delete(Long authority_id) {
        authorityRepository.delete(authority_id);
    }
}
