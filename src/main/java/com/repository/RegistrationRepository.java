package com.repository;

import com.domain.User;

import java.util.List;

public interface RegistrationRepository {
    public List<User> getAll();
    public User create(User user);
}
