package com.demo.springbootproject.controller;

import com.demo.springbootproject.entity.Department;
import com.demo.springbootproject.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.addDepartment(department);
    }

//    @GetMapping("/departments")
//    public List<Department> getAllDepartments() {
//        return departmentService.getAllDepartments();
//    }

    @GetMapping("/departments")
    public List<Department> getAllDepartments(@RequestParam(name = "name", required = false) String departmentName) {
        if (departmentName != null && departmentName != "") {
            return departmentService.getDepartmentsByName(departmentName);
        } else {
            return departmentService.getAllDepartments();
        }
    }

    @GetMapping("/departments/{id}")
    public Department getDepartment(@PathVariable("id") Long departmentId) {
        return departmentService.getDepartment(departmentId);
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department) {
        return departmentService.updateDepartment(departmentId, department);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartment(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartment(departmentId);
        return "Department deleted successfully";
    }
}
