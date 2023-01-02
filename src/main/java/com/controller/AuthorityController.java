package com.controller;


import com.domain.Authority;
import com.domain.User;
import com.repository.AuthorityRepository;
import com.service.AuthorityService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/authorities")
public class AuthorityController {

    private AuthorityService authorityService;
    public AuthorityController(AuthorityService authorityService) {
        this.authorityService=authorityService;
    }
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/create")
    public String show(Model model) {
        User user = new User();
        Authority authority= new Authority();
        model.addAttribute("authority",authority);
        return "Authority/CreateAuthority";
    }

    @RequestMapping("/submit")
    //@ExceptionHandler({ExceptionHandler.class})
    public String submit(@Valid @ModelAttribute("authority") Authority authority, BindingResult bindingResult)  {
        if (!bindingResult.hasErrors()) {
            authorityService.create(authority);
            return "redirect:/authorities/getAll";
        }
        return "Authority/CreateAuthority";
    }

    @RequestMapping("/getAll")
    public String list(Model model) throws SQLException {
        List<Authority> authorities = authorityService.getAll();
        model.addAttribute("authorities",authorities);
        return "Authority/ViewAuthority";
    }

    @RequestMapping("/edit")
    public String edit(@RequestParam("id") Long authority_id, Model model) throws SQLException {
        model.addAttribute("authority",authorityService.get(authority_id));
        return "Authority/EditAuthority";
    }

    @RequestMapping("/update")
    public String update(@Valid @ModelAttribute("authority") Authority authority, BindingResult bindingResult) throws SQLException {
        if (!bindingResult.hasErrors()) {
            authorityService.update(authority);
            return "redirect:/authorities/getAll";
        }
        return "Authority/EditAuthority";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("id") Long authority_id) throws SQLException {
       authorityService.delete(authority_id);
        return "redirect:/authorities/getAll";
    }
    @RequestMapping("/get")
    public void get() {
        Authority authority= authorityService.get(1L);
        System.out.println(authority.getId());
        System.out.println(authority.getName());
    }

}
