package com.controller;


import com.constant.PROFESSION;
import com.domain.*;
import com.repository.AuthorityRepository;
import com.repository.UserRepository;
import com.service.*;
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
    private RouteService routeService;
    private UAMService uamService;
    public UserController(UserService userService,AuthorityService authorityService,AccountService accountService,RouteService routeService,UAMService uamService) {
        this.userService = userService;
        this.authorityService=authorityService;
        this.accountService=accountService;
        this.routeService=routeService;
        this.uamService=uamService;
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
    public String logError(Model model) {
        model.addAttribute("error","*provide correct info");

        return "login/LoginView";
    }


    //----------------------- Log Out--------------------//
    @RequestMapping("/logout")
    public String logout() {
        return "login/LoginView";
    }


    //----------------------- Decision Mapping--------------------//
    @RequestMapping("/decision")
    public String list(Model model) throws SQLException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(!auth.getName().isEmpty()){
        List<User> users = userService.getAll();
        for(User user1: users){
            if(auth.getName().equals(user1.getUsername())){

                List<UAM> uams=uamService.getAll();
                for(UAM uam1:uams){
                    if(uam1.getUserid().equals(user1.getId())){

                        List<Authority>authorities=authorityService.getAll();
                        for(Authority authority:authorities){
                            if(uam1.getAuthority_id().equals(authority.getId())){
                                if((authority.getName().equals("ROLE_USER"))){
                                    System.out.println("++++++I am user +++++++");
                                    User customerHome=userService.get(user1.getId());
                                    model.addAttribute("customer",customerHome);

                                    List<Route> routes =routeService.getAll();
                                    model.addAttribute("routes",routes);

                                    List<Account> accountHome = accountService.getAll();
                                    for(Account account: accountHome){
                                        if(user1.getUsername().equals(account.getUsername())){
                                            model.addAttribute("amount",account.getBalance());
                                            return "Customer/CustomerHome";
                                        }
                                    }
                                }else {
                                    List<Route> routes =routeService.getAll();
                                    model.addAttribute("routes",routes);
                                    System.out.println("++++++I am Admin +++++++");
                                    return "Lead/AdminHome";
                                }
                            }
                        }
                    }
                }
            }
        }
        }
        return "login/LoginView";
    }
}
