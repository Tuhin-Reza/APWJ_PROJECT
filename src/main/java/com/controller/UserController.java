package com.controller;


import com.constant.PROFESSION;
import com.domain.Authority;
import com.domain.User;
import com.repository.AuthorityRepository;
import com.repository.UserRepository;
import com.service.AuthorityService;
import com.service.UserService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;


import javax.validation.Valid;
import java.security.acl.AclEntry;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);
    private UserService userService;
    private UserRepository userRepository;
    private AuthorityService authorityService;
    private AuthorityRepository authorityRepository;
    public UserController(UserService userService, UserRepository userRepository,AuthorityService authorityService,AuthorityRepository authorityRepository) {
        this.userService = userService;
        this.userRepository=userRepository;

        this.authorityService=authorityService;
        this.authorityRepository=authorityRepository;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    @RequestMapping("/login")
    public String login() {
        return "login/LoginView";
    }
    @RequestMapping("/loginError")
    public String logError() {
        return "User/UserRegistration";
    }
    @RequestMapping("/logout")
    public String logout() {
        return "login/LoginView";
    }
//    @RequestMapping("/Customer")
//    public String customer(Model model) throws SQLException {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        //String name = auth.getName();
//        List<User> users = userService.getAll();
//        for(User user1: users){
//            if(auth.getName().equals(user1.getUsername())){
//                List<Authority>authorities=authorityService.getAll();
//                for(Authority authority:authorities){
//                    if(authority.getAuthority().equals("ROLE_ADMIN")){
//                        User customer=userService.get(user1.getId());
//                        model.addAttribute("customer",customer);
//                        return "Customer/CustomerHome";
//                    }
//                }
//            }
//        }
//        return "Customer/CustomerHome";
//    }
        @RequestMapping("/loginSubmit")
    public String loginSubmit(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
//        if (!bindingResult.hasErrors()) {
//            logger.info("I am working");
//            return "redirect:/users/list";
//        }
        return "redirect:/users/list";
        //return "login/LoginView";
    }

    @RequestMapping("/create")
    public String show(Model model) {
        User user = new User();
        List<PROFESSION> enums = Arrays.asList(PROFESSION.values());
        model.addAttribute("enums",enums);
        model.addAttribute("user",user);
        return "User/UserRegistration";
    }

    @RequestMapping("/submit")
    public String submit(@Valid @ModelAttribute("user") User user, BindingResult bindingResult,Model model)  {
        if (!bindingResult.hasErrors()) {
//            List<User> users = userService.getAll();
//            for(User user1: users) {
//                System.out.println(user1.getUsername());
//                System.out.println(user1.getPassword());
//            }
//            System.out.println(user.getProfession());
//            userService.create(user);
//            System.out.println(user.getId());
            return "redirect:/users/list";
        }
        List<PROFESSION> enums = Arrays.asList(PROFESSION.values());
        model.addAttribute("enums",enums);
        return "User/UserRegistration";
    }
    @RequestMapping("/list")
    public String list(Model model) throws SQLException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //String name = auth.getName();
        List<User> users = userService.getAll();
        for(User user1: users){
            if(auth.getName().equals(user1.getUsername())){
                List<Authority>authorities=authorityService.getAll();
                for(Authority authority:authorities){
                    if(authority.getAuthority().equals("ROLE_ADMIN")){
                        User customer=userService.get(user1.getId());
                        model.addAttribute("customer",customer);
                        System.out.println(customer.getUsername());
                        System.out.println(customer.getName());
                        return "Customer/CustomerHome";
                    }
                }
            }
        }
        return "login/LoginView";
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
    }
}
