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
        //return "redirect:/users/list";
    }

    @RequestMapping("/submit")
    public String submit(@Valid @ModelAttribute("user") User user, BindingResult bindingResult)  {
        if (!bindingResult.hasErrors()) {
            userService.create(user);
            return "redirect:/users/list";
        }
        return "User/User_Registration";
    }
    @RequestMapping("/list")
    public String list(Model model) throws SQLException {
        List<User> users = userService.list();
        model.addAttribute("users",users);
        return "User/User_View";
       // return "User/User_Registration";
    }
    @RequestMapping("/edit")
    public String edit(@RequestParam("user_id") Long user_id, Model model) throws SQLException {
        model.addAttribute("user", userService.get(user_id));
        return "User/User_Edit";
    }

    @RequestMapping("/update")
    public String update(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) throws SQLException {
        if (!bindingResult.hasErrors()) {
            userService.update(user);
            return "redirect:/users/list";
        }
        return "User/User_Edit";

    }
    @RequestMapping("/delete")
    public String delete(@RequestParam("user_id") Long user_id) throws SQLException {
        userService.delete(user_id);
        return "redirect:/users/list";
    }

}
