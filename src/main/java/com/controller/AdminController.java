package com.controller;

import com.constant.PROFESSION;
import com.domain.Route;
import com.domain.User;
import com.service.RouteService;
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
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private RouteService routeService;
    public AdminController(RouteService routeService) {
        this.routeService=routeService;

    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    @RequestMapping("/routeCreate")
    public String show1(Model model) {
        Route route=new Route();
        model.addAttribute("route",route);
        return "Lead/route/routeCreate";
    }

    @RequestMapping("/routeSubmit")
    public String submit1(@Valid @ModelAttribute("route") Route route, BindingResult bindingResult, Model model)  {
        if (!bindingResult.hasErrors()) {
            routeService.create(route);
            return "redirect:/admin/list";
        }
        return "Lead/route/routeCreate";
    }
    @RequestMapping("/list")
    public String list(Model model) throws SQLException {
        List<Route> routes =routeService.getAll();
        model.addAttribute("routes",routes);
        return "Lead/route/routeView";
        // return "User/User_Registration";
    }

    @RequestMapping("/edit")
    public String edit(@RequestParam("id") Long id, Model model) throws SQLException {
        model.addAttribute("route", routeService.get(id));
        return "Lead/route/routeEdit";
    }

    @RequestMapping("/update")
    public String update(@Valid @ModelAttribute("route") Route route, BindingResult bindingResult) throws SQLException {
        if (!bindingResult.hasErrors()) {
            routeService.update(route);
            return "redirect:/admin/list";
        }
        return "Lead/route/routeEdit";
    }
    @RequestMapping("/delete")
    public String delete(@RequestParam("id") Long route_id) throws SQLException {
        routeService.delete(route_id);
        return "redirect:/admin/list";
    }
}
