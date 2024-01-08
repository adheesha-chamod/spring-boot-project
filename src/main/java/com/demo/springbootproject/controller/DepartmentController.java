package com.demo.springbootproject.controller;

import com.demo.springbootproject.entity.Department;
import com.demo.springbootproject.exception.DepartmentNotFoundException;
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
        LOGGER.info("saveDepartment of DepartmentController called");

        return departmentService.addDepartment(department);
    }

//    @GetMapping("/departments")
//    public List<Department> getAllDepartments() {
//        return departmentService.getAllDepartments();
//    }

    @GetMapping("/departments")
    public List<Department> getAllDepartments(@RequestParam(name = "name", required = false) String departmentName) {
        LOGGER.info("getAllDepartments of DepartmentController called");

        if (departmentName != null && departmentName != "") {
            return departmentService.getDepartmentsByName(departmentName);
        } else {
            return departmentService.getAllDepartments();
        }
    }

    @GetMapping("/departments/{id}")
    public Department getDepartment(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        LOGGER.info("getDepartment of DepartmentController called");

        return departmentService.getDepartment(departmentId);
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department) {
        LOGGER.info("updateDepartment of DepartmentController called");

        return departmentService.updateDepartment(departmentId, department);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartment(@PathVariable("id") Long departmentId) {
        LOGGER.info("deleteDepartment of DepartmentController called");

        departmentService.deleteDepartment(departmentId);
        return "Department deleted successfully";
    }
}
