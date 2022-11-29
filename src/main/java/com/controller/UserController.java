package com.controller;


import com.domain.User;
import com.repository.UserRepository;
import com.service.UserService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
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
public class UserController {

    private UserService userService;
    private UserRepository userRepository;
    public UserController(UserRepository userRepository, UserService userService) {

       this.userRepository = userRepository;
        this.userService = userService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    @RequestMapping("/create")
    public String show(Model model) {
        User student = new User();
        model.addAttribute("student", student);
        return "UserRegistration";
    }

    @RequestMapping("/submit")
    public String submit(@Valid @ModelAttribute("student") User student, BindingResult bindingResult)  {
        if (!bindingResult.hasErrors()) {
            userService.insert(student);
            return "redirect:/students/list";
        }
        return "UserRegistration";

    }
//    @RequestMapping("/getOne")
//    public void get() {
//        User student = userService.get(1L);
//        System.out.println(student.getStudent_id() + " " + student.getStudent_name());
//    }
//    @RequestMapping("/list")
//    public String list(Model model) throws SQLException {
//        List<User> students = userService.getAll();
//        model.addAttribute("student", students);
//        return "UserView";
//    }
//
//    @RequestMapping("/edit")
//    public String edit(@RequestParam("student_id") Long student_id, Model model) throws SQLException {
//        model.addAttribute("student", userService.get(student_id));
//        return "UserEdit";
//    }
//
//    @RequestMapping("/update")
//    public String update(@Valid @ModelAttribute("student") User student, BindingResult bindingResult) throws SQLException {
//        if (bindingResult.hasErrors()) {
//            return "UserEdit";
//        }
//        userService.update(student);
//        return "redirect:/students/list";
//    }
//    @RequestMapping("/delete")
//    public String delete(@RequestParam("student_id") Long student_id) throws SQLException {
//        userService.delete(student_id);
//        return "redirect:/students/list";
//    }



}
