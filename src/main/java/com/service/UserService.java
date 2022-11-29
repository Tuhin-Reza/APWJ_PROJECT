package com.service;

import com.domain.User;
import com.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Transactional
    public boolean insert(User user) {
        user.setName(user.getName());
        return userRepository.create(user);
    }

//    @Transactional(readOnly = true)
//    public Student get(Long student_id) {
//        return userRepository.get(student_id);
//    }
//
//    @Transactional(readOnly = true)
//    public List<Student> getAll() {
//        return userRepository.getAll();
//    }
//
//    @Transactional
//    public Student update(Student student) {
//        return userRepository.update(student);
//    }
//
//    @Transactional
//    public void delete(Long id) {
//        userRepository.delete(id);
//    }

}
