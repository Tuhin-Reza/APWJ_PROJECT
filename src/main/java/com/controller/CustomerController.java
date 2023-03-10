package com.controller;

import com.constant.PROFESSION;
import com.domain.*;
import com.service.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.apache.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    private static final Logger logger = Logger.getLogger(User.class);

    //----------------------- All Java Services Classes --------------------//
    private UserService userService;
    private AccountService accountService;
    private AuthorityService authorityService;
    private RouteService routeService;
    private CusTicBuyService cusTicBuyService;
    private TransitionHisService transitionHisService;
    public CustomerController(UserService userService,AccountService accountService,AuthorityService authorityService,RouteService routeService,CusTicBuyService cusTicBuyService,TransitionHisService transitionHisService) {
        this.userService = userService;
        this.accountService=accountService;
        this.authorityService=authorityService;
        this.routeService=routeService;
        this.cusTicBuyService=cusTicBuyService;
        this.transitionHisService=transitionHisService;
    }


    //----------------------- Log Out--------------------//
    @RequestMapping("/logout")
    public String logout() {
        return "login/LoginView";
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
                model.addAttribute("customer_id",customer.getId());

                List<Route> routes =routeService.getAll();
                model.addAttribute("routes",routes);

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
            //userService.update(user);
            return "Customer/CustomerHome";
        }
        List<PROFESSION> enums = Arrays.asList(PROFESSION.values());
        model.addAttribute("enums",enums);
        return "Customer/CusProUpdate";
    }


    //-----------------------Change User Password--------------------//
    @RequestMapping("/cngPass")
    public String editCngPass(@RequestParam("id") Long user_id, Model model) throws SQLException {
        model.addAttribute("customer", userService.get(user_id));
        List<PROFESSION> enums = Arrays.asList(PROFESSION.values());
        model.addAttribute("enums",enums);
        return "Customer/ChangePassword";
    }
    @RequestMapping("/cngPassUpdate")
    public String updateCngPass(@Valid @ModelAttribute("customer") User user,BindingResult bindingResult,Model model) throws SQLException {
       if(user.getPassword().isEmpty() || user.getPassword().length()<4 ){
           model.addAttribute("passError1","*not empty");
           model.addAttribute("passError2","*max length 4");
           return "Customer/ChangePassword";
       }
        List<User> users = userService.getAll();
        for(User user1: users){
            if(user.getUsername().equals(user1.getUsername())){

                User user2=new User();
                user2.setId(user1.getId());
                user2.setName(user1.getName());
                user2.setAge(user1.getAge());
                user2.setAddress(user1.getAddress());
                user2.setProfession(user1.getProfession());
                user2.setUsername(user1.getUsername());
                user2.setPassword(user.getPassword());
                userService.update(user2);
            }
        }
        return "Customer/CustomerHome";
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
            int amount=account.getBalance()+account2.getBalance();
            accountService.update(account);
            logger.info(account.getBalance()+" Amount added");
            logger.info(amount+"Present Balance");

            //-----------------------Transition History--------------------//
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            TransitionHis transitionHis=new TransitionHis();
            transitionHis.setUsername(auth.getName());
            transitionHis.setTransition("credited");
            transitionHis.setAmount(account.getBalance());
            transitionHis.setAvail_balance(amount);
            transitionHisService.create(transitionHis);

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
        model.addAttribute("username",user.getUsername());

        System.out.println(user.getUsername());
        return "Customer/customerDestinationView";
    }
    @RequestMapping("/buyTicket")
    public String buy_ticket(@RequestParam("id") Long route_id,Model model) throws SQLException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("route",routeService.get(route_id));
        model.addAttribute("username",auth.getName());
        return "Customer/buyTicket";
    }
    @RequestMapping("/confirmTicket")
    public String submit1(@Valid @ModelAttribute("route") Route route, BindingResult bindingResult,Model model)  {
        if (!bindingResult.hasErrors()) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            List<Account> accounts = accountService.getAll();
            for(Account account: accounts){
                if(auth.getName().equals(account.getUsername())){
                   if(account.getBalance()>200){
                       int amount=account.getBalance()-route.getFare();

                       //-----------------------Account Table--------------------//
                       Account account1=new Account();
                       account1.setId(account.getId());
                       account1.setUsername(auth.getName());
                       account1.setBalance(amount);
                       accountService.update(account1);

                       //-----------------------Ticket Information--------------------//
                       CusTicBuy cusTicBuy=new CusTicBuy();
                       cusTicBuy.setCus_username(auth.getName());
                       cusTicBuy.setRouteId(route.getId());
                        cusTicBuyService.create(cusTicBuy);

                       //-----------------------Transition History--------------------//
                       TransitionHis transitionHis=new TransitionHis();
                       transitionHis.setUsername(auth.getName());
                       transitionHis.setTransition("debited");
                       transitionHis.setAmount(route.getFare());
                       transitionHis.setAvail_balance(amount);
                       transitionHisService.create(transitionHis);
                       logger.info(auth.getName()+" User name");
                       logger.info(route.getFare()+" Amount Debited");
                       logger.info(amount+" Amount Again Credited");

                   }else {
                       model.addAttribute("error","*amount must be greater 200");
                       return "Customer/buyTicket";
                   }
                }
            }
            return "redirect:/customers/main";
        }
        return "Customer/buyTicket";
    }
    @RequestMapping("/TransitionList")
    public String list(Model model) throws SQLException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<TransitionHis> transitionHiss=transitionHisService.getAll();
        List<TransitionHis> tranHis = new ArrayList<TransitionHis>();
        for(TransitionHis transitionHis: transitionHiss){
            if(auth.getName().equals(transitionHis.getUsername())){
                TransitionHis transitionHis1=new TransitionHis();
                transitionHis1.setId(transitionHis.getId());
                transitionHis1.setUsername(transitionHis.getUsername());
                transitionHis1.setTransition(transitionHis.getTransition());
                transitionHis1.setAmount(transitionHis.getAmount());
                transitionHis1.setAvail_balance(transitionHis.getAvail_balance());
                tranHis.add(transitionHis1);
            }
        }
        for(TransitionHis transitionHis: tranHis) {
           System.out.println(transitionHis.getUsername());
        }
        model.addAttribute("transitions",tranHis);
        return "Customer/TransitionHistory";
    }


    //-----------------------Buying Ticket History--------------------//
    @RequestMapping("/buyingHistory")
    public String buying_History(Model model) throws SQLException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<CusTicBuy>cusTicBuys=cusTicBuyService.getAll();
        List<CusTicBuy> cusTicBuys2 = new ArrayList<CusTicBuy>();
        for(CusTicBuy cusTicBuy: cusTicBuys){
            if(auth.getName().equals(cusTicBuy.getCus_username())){
                CusTicBuy cusTicBuy1=new CusTicBuy();
                cusTicBuy1.setId(cusTicBuy.getId());
                cusTicBuy1.setCus_username(cusTicBuy.getCus_username());
                cusTicBuy1.setRouteId(cusTicBuy.getRouteId());

                cusTicBuys2.add(cusTicBuy1);
            }
        }
        for(CusTicBuy cusTicBuy:cusTicBuys2) {
            System.out.println(cusTicBuy.getId());
            System.out.println(cusTicBuy.getCus_username());
            System.out.println(cusTicBuy.getRouteId());
        }
        model.addAttribute("cusTickets", cusTicBuys2);
        model.addAttribute("username",auth.getName());
        return "Customer/CusTicket";

    }
}
