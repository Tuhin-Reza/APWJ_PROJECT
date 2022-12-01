package com.controller;


import com.domain.User;
import com.repository.UserImplRepository;
import com.repository.UserRepository;
import com.service.UserImplService;
import com.service.UserService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    private UserRepository userRepository;
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository=userRepository;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    @RequestMapping("/create")
    public String show(Model model) {
        User user = new User();
        model.addAttribute("user",user);
        return "User/User_Registration";
    }

    @RequestMapping("/submit")
    public String submit(@Valid @ModelAttribute("user") User user, BindingResult bindingResult)  {
        if (!bindingResult.hasErrors()) {
            //userService.create(user);
            return "redirect:User/User_Registration";
        }
        return "User/User_Registration";

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
