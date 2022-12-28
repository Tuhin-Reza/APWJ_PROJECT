package com.service;

import com.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    public List<User> getAll();
    public User get(Long user_id);
    public User create(User user);
    public  User update(User user);
    public  void delete(Long user_id);

    public User getByUsername(String username);
}
