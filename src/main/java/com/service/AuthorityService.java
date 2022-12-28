package com.service;

import com.domain.Authority;
import java.util.List;

public interface AuthorityService {

    public List<Authority> getAll();
    public Authority get(Long authority_id);
    public Authority create(Authority authority);
    public Authority update(Authority authority);
    public  void delete(Long authority_id);
}
