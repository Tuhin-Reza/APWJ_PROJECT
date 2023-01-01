package com.controller;


import com.constant.PROFESSION;
import com.domain.Account;
import com.domain.Authority;
import com.domain.User;
import com.repository.AuthorityRepository;
import com.repository.UserRepository;
import com.service.AccountService;
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


    //----------------------- All Java Services Classes --------------------//
    private UserService userService;
    private AuthorityService authorityService;
    private AccountService accountService;
    public UserController(UserService userService,AuthorityService authorityService,AccountService accountService) {
        this.userService = userService;
        this.authorityService=authorityService;
        this.accountService=accountService;
    }
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }



    //----------------------- Log View --------------------//
    @RequestMapping("/login")
    public String login() {
        return "login/LoginView";
    }


    //----------------------- Log Error--------------------//
    @RequestMapping("/loginError")
    public String logError() {
        return "login/LoginView";
    }


    //----------------------- Log Out--------------------//
    @RequestMapping("/logout")
    public String logout() {
        return "login/LogOutView";
    }



    //----------------------- Decision Mapping--------------------//
    @RequestMapping("/decision")
    public String list(Model model) throws SQLException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(!auth.getName().isEmpty()){
        List<User> users = userService.getAll();
        for(User user1: users){
            if(auth.getName().equals(user1.getUsername())){
                System.out.println((auth.getName()));
                System.out.println((user1.getUsername()));
                List<Authority>authorities=authorityService.getAll();
                for(Authority authority:authorities){
                    System.out.println((authority.getAuthority()));
                    if(authority.getAuthority().equals("ROLE_USER")){
                        System.out.println((authority.getAuthority()));
                        User customerHome=userService.get(user1.getId());
                        model.addAttribute("customer",customerHome);
                        List<Account> accountHome = accountService.getAll();
                        for(Account account: accountHome){
                            if(user1.getUsername().equals(account.getUsername())){
                                model.addAttribute("amount",account.getBalance());
                                return "Customer/CustomerHome";
                            }
                        }
                    }
                    //
                }
                return "Lead/AdminHome";
            }
        }
        }
        return "login/LoginView";
    }
}
