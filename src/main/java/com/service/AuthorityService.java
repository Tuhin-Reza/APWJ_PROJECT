package com.service;

import com.domain.Authority;
import com.domain.User;

import java.util.List;

public interface AuthorityService {

    public List<Authority> list();
    public Authority get(Long authority_id);
    public Authority create(Authority authority);
    public Authority update(Authority authority);
    public  void delete(Long authority_id);
}
