package com.demo.springbootproject.controller;

import com.demo.springbootproject.entity.Department;
import com.demo.springbootproject.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);


    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("Inside in saveDepartment of DepartmentController");

        return departmentService.addDepartment(department);
    }

//    @GetMapping("/departments")
//    public List<Department> getAllDepartments() {
//        return departmentService.getAllDepartments();
//    }

    @GetMapping("/departments")
    public List<Department> getAllDepartments(@RequestParam(name = "name", required = false) String departmentName) {
        LOGGER.info("Inside in getAllDepartments of DepartmentController");

        if (departmentName != null && departmentName != "") {
            return departmentService.getDepartmentsByName(departmentName);
        } else {
            return departmentService.getAllDepartments();
        }
    }

    @GetMapping("/departments/{id}")
    public Department getDepartment(@PathVariable("id") Long departmentId) {
        LOGGER.info("Inside in getDepartment of DepartmentController");

        return departmentService.getDepartment(departmentId);
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department) {
        LOGGER.info("Inside in updateDepartment of DepartmentController");

        return departmentService.updateDepartment(departmentId, department);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartment(@PathVariable("id") Long departmentId) {
        LOGGER.info("Inside in deleteDepartment of DepartmentController");

        departmentService.deleteDepartment(departmentId);
        return "Department deleted successfully";
    }
}
