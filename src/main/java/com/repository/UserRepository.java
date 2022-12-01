package com.repository;

import com.domain.User;

import java.util.List;

public interface UserRepository {
    public List<User> list();
    public User get(Long id);
    public User create(User user);
    public  User update(User user);
    public  void delete(Long id);
}
