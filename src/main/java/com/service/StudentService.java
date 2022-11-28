package com.service;

import com.domain.Student;
import com.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }

    @Transactional
    public boolean insert(Student student) {
        student.setStudent_name(student.getStudent_name());
        return studentRepository.create(student);
    }

    @Transactional(readOnly = true)
    public Student get(Long student_id) {
        return studentRepository.get(student_id);
    }

    @Transactional(readOnly = true)
    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    @Transactional
    public Student update(Student student) {
        return studentRepository.update(student);
    }

    @Transactional
    public void delete(Long id) {
        studentRepository.delete(id);
    }



}
