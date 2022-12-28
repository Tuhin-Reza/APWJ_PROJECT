package com.controller;


import com.constant.PROFESSION;
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
import java.util.Arrays;
import java.util.List;

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
    @RequestMapping("/login")
    public String login(Model model) {
        User user = new User();
        model.addAttribute("user",user);
        return "login/LoginView";
    }
    @RequestMapping("/create")
    public String show(Model model) {
        User user = new User();
        List<PROFESSION> enums = Arrays.asList(PROFESSION.values());
        model.addAttribute("enums",enums);
        model.addAttribute("user",user);
        return "User/UserRegistration";
        //return "redirect:/users/list";
    }

    @RequestMapping("/submit")
    public String submit(@Valid @ModelAttribute("user") User user, BindingResult bindingResult,Model model)  {
        if (!bindingResult.hasErrors()) {
            List<User> users = userService.getAll();
            for(User user1: users) {
                System.out.println(user1.getUsername());
                System.out.println(user1.getPassword());
            }
            System.out.println(user.getProfession());
            userService.create(user);
            System.out.println(user.getId());
            return "redirect:/users/list";
        }
        List<PROFESSION> enums = Arrays.asList(PROFESSION.values());
        model.addAttribute("enums",enums);
        return "User/UserRegistration";
    }
    @RequestMapping("/list")
    public String list(Model model) throws SQLException {
        List<User> users = userService.getAll();
        model.addAttribute("users",users);
        return "User/UserView";
       // return "User/User_Registration";
    }
    @RequestMapping("/edit")
    public String edit(@RequestParam("id") Long user_id, Model model) throws SQLException {
        model.addAttribute("user", userService.get(user_id));
        List<PROFESSION> enums = Arrays.asList(PROFESSION.values());
        model.addAttribute("enums",enums);
        return "User/UserEdit";
    }

    @RequestMapping("/update")
    public String update(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) throws SQLException {
        if (!bindingResult.hasErrors()) {
            userService.update(user);
            return "redirect:/users/list";
        }
        return "User/UserEdit";

    }
    @RequestMapping("/delete")
    public String delete(@RequestParam("id") Long user_id) throws SQLException {
        userService.delete(user_id);
        return "redirect:/users/list";
    }
    @RequestMapping("/list2")
    public String list2(Model model) throws SQLException {
        List<User> users = userService.getAll();
        model.addAttribute("users",users);
        return "User/UserView";
        // return "User/User_Registration";
    }
}
