package com.controller;


import com.constant.PROFESSION;
import com.domain.Account;
import com.domain.Authority;
import com.domain.UAM;
import com.domain.User;
import com.repository.RegistrationRepository;
import com.service.AccountService;
import com.service.AuthorityService;
import com.service.RegistrationService;
import com.service.UAMService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    private AuthorityService authorityService;
    private UAMService uamService;
    private RegistrationService registrationService;
    private RegistrationRepository registrationRepository;
    private AccountService accountService;
    public RegistrationController(RegistrationService registrationService, RegistrationRepository registrationRepository,AuthorityService authorityService,UAMService uamService,AccountService accountService) {
        this.registrationService = registrationService;
        this.registrationRepository = registrationRepository;
        this.authorityService=authorityService;
        this.uamService=uamService;
        this.accountService=accountService;
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
        return "LoginView";
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
            List<User> users = registrationService.getAll();
            for(User user1: users) {
                if(user.getUsername().equals(user1.getUsername())){
                    model.addAttribute("unError",("*unique name"));
                    List<PROFESSION> enums = Arrays.asList(PROFESSION.values());
                    model.addAttribute("enums",enums);
                    return "User/UserRegistration";
                }
                if(user.getPassword().equals(user1.getPassword())){
                    model.addAttribute("passError",("*unique password"));
                    List<PROFESSION> enums = Arrays.asList(PROFESSION.values());
                    model.addAttribute("enums",enums);
                    return "User/UserRegistration";
                }
            }
            registrationService.create(user);
            Authority authority=authorityService.get(3L);
            UAM uam=new UAM();
            uam.setUserid(user.getId());
            uam.setAuthority_id(authority.getId());
            uamService.create(uam);

            Account account=new Account();
            account.setUsername(user.getUsername());
            account.setBalance(0);
            accountService.create(account);



            return "login/LoginView";
        }
        List<PROFESSION> enums = Arrays.asList(PROFESSION.values());
        model.addAttribute("enums",enums);
        return "User/UserRegistration";
    }
}
