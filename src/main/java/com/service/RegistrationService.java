package com.service;

import com.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface RegistrationService{
    public List<User> getAll();
    public User create(User user);
}
