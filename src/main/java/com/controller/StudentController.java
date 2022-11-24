package com.controller;


import com.domain.Student;
import com.service.StudentService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;
    public StudentController(StudentService studentService) {

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
    public String submit(@Valid @ModelAttribute("student") Student student,
                         BindingResult bindingResult)  {
        if (bindingResult.hasErrors()) {
            return "Student/StudentRegistration";
        }
        else {
            studentService.insert(student);
            return "Student/StudentRegistration";
        }
    }

}
