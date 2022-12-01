package com.service;

import com.domain.User;
import com.repository.UserImplRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserImplService implements UserService {
    private UserImplRepository userRepository;

    public UserImplService(UserImplRepository userRepository) {

        this.userRepository = userRepository;
    }
    @Transactional(readOnly = true)
    public List<User> list() {
        return userRepository.list();
    }
    @Transactional(readOnly = true)
    public User get(Long id) {
        return userRepository.get(id);
    }
    @Transactional
    public User create(User user) {
        return userRepository.create(user);
    }
    @Transactional
    public User update(User user) {
        return userRepository.update(user);
    }
    @Transactional
    public void delete(Long id) {
        userRepository.delete(id);
    }
}
