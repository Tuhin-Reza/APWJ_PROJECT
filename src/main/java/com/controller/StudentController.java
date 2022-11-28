package com.controller;


import com.domain.Student;
import com.repository.StudentRepository;
import com.service.StudentService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;
    private StudentRepository studentRepository;
    public StudentController(StudentRepository studentRepository,StudentService studentService) {

       this.studentRepository=studentRepository;
        this.studentService = studentService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    @RequestMapping("/create")
    public String show(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "Student/StudentRegistration";
    }

    @RequestMapping("/submit")
    public String submit(@Valid @ModelAttribute("student") Student student,BindingResult bindingResult)  {
        if (!bindingResult.hasErrors()) {
            studentService.insert(student);
        }
        return "redirect:/students/list";
    }
    @RequestMapping("/getOne")
    public void get() {
        Student student = studentService.get(1L);
        System.out.println(student.getStudent_id() + " " + student.getStudent_name());
    }
    @RequestMapping("/list")
    public String list(Model model) throws SQLException {
        List<Student> students =studentService.getAll();
        model.addAttribute("student", students);
        return "Student/StudentView";
    }

    @RequestMapping("/edit")
    public String edit(@RequestParam("student_id") Long student_id, Model model) throws SQLException {
        model.addAttribute("student", studentService.get(student_id));
        return "Student/StudentEdit";
    }

    @RequestMapping("/update")
    public String update(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "Student/StudentEdit";
        }
        studentService.update(student);
        return "redirect:/students/list";
    }
    @RequestMapping("/delete")
    public String delete(@RequestParam("student_id") Long student_id) throws SQLException {
        studentService.delete(student_id);
        return "redirect:/students/list";
    }



}
