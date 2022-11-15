package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/LeaveApplications")
public class LeaveApplicationController  {
    @RequestMapping("/employeeCreate")
    public String employeeCreate() {
        return "Department/test";
    }
    @RequestMapping("/employeeEdit")
    public String employeeEdit() {
        return "Department/test";
    }
    @RequestMapping("/employeeUpdate")
    public String employeeUpdate() {
        return "Department/test";
    }

    @RequestMapping("/leaveApplication")
    public String leaveApplication() {
        return "Department/test";
    }
    @RequestMapping("/leaveApplicationDelete")
    public String leaveApplicationDelete() {
        return "Department/test";
    }

}
