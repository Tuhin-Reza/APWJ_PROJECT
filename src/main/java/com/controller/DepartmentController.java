package com.controller;

import com.domain.Department;
import com.repository.DepartmentRepository;
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
@RequestMapping("/Departments")
public class DepartmentController {
    private DepartmentRepository departmentRepository;
    public DepartmentController(DepartmentRepository departmentRepository){
        this.departmentRepository=departmentRepository;
    }
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

   @RequestMapping("/createDepartment")
    public String CreateDepartment(Model model){
        model.addAttribute("department",new Department());
        return "Department/CreateDepartment";
    }
   @RequestMapping("/departmentStore")
    public String DepartmentStore(@Valid @ModelAttribute("department")Department department, BindingResult bindingResult)throws SQLException{
        if(bindingResult.hasErrors()){
            return "Department/CreateDepartment";
        }
        departmentRepository.create(department);
        return "redirect:/Departments/list";
    }


    @RequestMapping("/list")
    public String list(Model model) throws SQLException {
        List<Department> departmentList = departmentRepository.list();
        model.addAttribute("departments", departmentRepository.list());
        return "Department/DepartmentDetails";
    }

    @RequestMapping("/edit")
    public String edit(@RequestParam("departmentId") int departmentId, Model model) throws SQLException {
        model.addAttribute("department", departmentRepository.get(departmentId));
        return "Department/Edit";
    }

    @RequestMapping("/update")
    public String update(@Valid @ModelAttribute("department") Department department, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "Department/Edit";
        }
        departmentRepository.update(department);
        return "redirect:/Departments/list";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("departmentId") int departmentId) throws SQLException {
        departmentRepository.delete(departmentId);
        return "redirect:/Departments/list";
    }

}
