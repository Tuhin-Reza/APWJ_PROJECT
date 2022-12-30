package com.controller;

import com.constant.PROFESSION;
import com.domain.User;
import com.repository.UserRepository;
import com.service.UserService;
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
    private UserService userService;
    private UserRepository userRepository;
    public CustomerController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository=userRepository;
    }
    @RequestMapping("/customerProfile")
    public String delete(@RequestParam("id") Long user_id,Model model) throws SQLException {
        User customer=userService.get(user_id);
        model.addAttribute("customer",customer);
        System.out.println(customer.getName());
        System.out.println(customer.getProfession());
        return "Customer/CustomerProfile";
    }

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
}
