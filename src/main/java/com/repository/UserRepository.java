package com.repository;

import com.domain.User;

import java.util.List;

public interface UserRepository {
    public List<User> getAll();
    public User get(Long user_id);
    public User create(User user);
    public  User update(User user);
    public  void delete(Long user_id);
    public User getByUsername(String username);
}
