package com.controller;

import com.constant.PROFESSION;
import com.domain.Account;
import com.domain.Route;
import com.domain.User;
import com.service.AccountService;
import com.service.AuthorityService;
import com.service.RouteService;
import com.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    //----------------------- All Java Services Classes --------------------//
    private UserService userService;
    private AccountService accountService;
    private AuthorityService authorityService;
    private RouteService routeService;
    public CustomerController(UserService userService,AccountService accountService,AuthorityService authorityService,RouteService routeService) {
        this.userService = userService;
        this.accountService=accountService;
        this.authorityService=authorityService;
        this.routeService=routeService;
    }



    //----------------------- Home Page Mapping --------------------//
    @RequestMapping("/main")
    public String c_main(Model model) throws SQLException {
        Authentication auth2 = SecurityContextHolder.getContext().getAuthentication();
        List<User> users = userService.getAll();
        for(User user1: users){
            if(auth2.getName().equals(user1.getUsername())){
                User customer=userService.get(user1.getId());
                model.addAttribute("customer",customer);

                List<Account> accountHome = accountService.getAll();
                for(Account account: accountHome){
                    if(user1.getUsername().equals(account.getUsername())){
                       model.addAttribute("amount",account.getBalance());
                        return "Customer/CustomerHome";
                    }
                }
            }
        }
        return "login/LoginView";
    }


    //----------------------- Customer Profile Mapping --------------------//
    @RequestMapping("/customerProfile")
    public String c_profile(@RequestParam("id") Long user_id,Model model) {
        User customer=userService.get(user_id);
        model.addAttribute("customer",customer);
        System.out.println(customer.getName());
        System.out.println(customer.getProfession());
        return "Customer/CustomerProfile";
    }


    //-----------------------Customer Profile  Update Mapping--------------------//
    @RequestMapping("/customerEdit")
    public String edit(@RequestParam("id") Long user_id, Model model) throws SQLException {
        model.addAttribute("customer", userService.get(user_id));
        List<PROFESSION> enums = Arrays.asList(PROFESSION.values());
        model.addAttribute("enums",enums);
        return "Customer/CusProUpdate";
    }
    @RequestMapping("/customerUpdate")
    public String update(@Valid @ModelAttribute("customer") User user,BindingResult bindingResult,Model model) throws SQLException {
        if (!bindingResult.hasErrors()) {
            userService.update(user);
            return "Customer/CustomerHome";
        }
        List<PROFESSION> enums = Arrays.asList(PROFESSION.values());
        model.addAttribute("enums",enums);
        return "Customer/CusProUpdate";
    }


    //-----------------------Added Balance Mapping--------------------//
    @RequestMapping("/amountAdded")
    public String amount_added(@RequestParam("id") Long user_id, Model model) throws SQLException {
        User user=userService.get(user_id);
        List<Account> accounts = accountService.getAll();
        for(Account account: accounts){
            if(user.getUsername().equals(account.getUsername())){
                Account account2=accountService.get(account.getId());
                    model.addAttribute("account",account2);
                    return "Customer/CusAccUpdate";
                }
            }
        return "Customer/CustomerHome";
    }
    @RequestMapping("/amountUpdate")
    public String update(@Valid @ModelAttribute("account")Account account,BindingResult bindingResult) throws SQLException {
        if (!bindingResult.hasErrors()) {
            Account account2=accountService.get(account.getId());
            account.setBalance(account.getBalance()+account2.getBalance());
            accountService.update(account);
            return "redirect:/customers/main";
        }
        return "Customer/CusAccUpdate";
    }


    //-----------------------Ticket Mapping--------------------//
    @RequestMapping("/routeList")
    public String list(@RequestParam("id") Long user_id,Model model) throws SQLException {
        User user=userService.get(user_id);
        List<Route> routes =routeService.getAll();
        model.addAttribute("routes",routes);
        model.addAttribute("customer",user.getUsername());
        return "Customer/routeView";
    }
    @RequestMapping("/buyTicket")
    public String buy_ticket(@RequestParam("id") Long user_id,Model model) throws SQLException {
        User user=userService.get(user_id);
        List<Route> routes =routeService.getAll();
        model.addAttribute("routes",routes);
        model.addAttribute("customer",user.getUsername());
        return "Customer/routeView";
    }
    @RequestMapping("/confirmTicket")
    public String submit1(@Valid @ModelAttribute("route") Route route, BindingResult bindingResult, Model model)  {
        if (!bindingResult.hasErrors()) {
            routeService.create(route);
            return "redirect:/admin/list";
        }
        return "Lead/route/routeCreate";
    }

}
