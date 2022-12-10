package com.service;

import com.domain.User;
import com.repository.UserRepository;
import com.repository.UserRepositoryImpl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    //private PasswordEncoder passwordEncoder;
    public UserServiceImpl(UserRepositoryImpl userRepository) {

        this.userRepository = userRepository;
    }
    @Transactional(readOnly = true)
    public List<User> list() {
        return userRepository.list();
    }
    @Transactional(readOnly = true)
    public User get(Long user_id) {
        return userRepository.get(user_id);
    }
    @Transactional
    public User create(User user) {
        // user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.create(user);
    }
    @Transactional
    public User update(User user) {
        return userRepository.update(user);
    }
    @Transactional
    public void delete(Long user_id) {
        userRepository.delete(user_id);
    }



    @Transactional(readOnly = true)
    public User getByUsername(String user_name) {
        return userRepository.getByUsername(user_name);
    }

    @Override
    public UserDetails loadUserByUsername(String user_name) throws UsernameNotFoundException {
        User user = getByUsername(user_name);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUser_name(), user.getUser_password(),user.getAuthorities());
    }
}
