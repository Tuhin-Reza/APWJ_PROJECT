package com.service;

import com.domain.User;
import com.repository.RegistrationRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {
    private RegistrationRepository registrationRepository;
    private PasswordEncoder passwordEncoder;
    public RegistrationServiceImpl(RegistrationRepository registrationRepository, PasswordEncoder passwordEncoder) {

        this.registrationRepository = registrationRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return registrationRepository.getAll();
    }

    @Transactional
    public User create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return registrationRepository.create(user);
    }
}
