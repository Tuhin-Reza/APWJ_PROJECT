package com.repository;

import com.domain.Authority;
import java.util.List;

public interface AuthorityRepository {
    public List<Authority> getAll();
    public Authority get(Long authority_id);
    public Authority create(Authority authority);
    public Authority update(Authority authority);
    public  void delete(Long authority_id);
}
