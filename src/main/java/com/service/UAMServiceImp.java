package com.service;

import com.domain.UAM;
import com.domain.User;
import com.repository.UAMRepository;
import com.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UAMServiceImp implements UAMService {
    private UAMRepository uamRepository;
    public UAMServiceImp(UAMRepository uamRepository) {
        this.uamRepository = uamRepository;
    }

    @Transactional
    public UAM create(UAM uam) {
        return  uamRepository.create(uam);
    }
}
