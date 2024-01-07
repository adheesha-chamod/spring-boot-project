package com.demo.springbootproject.service;

import com.demo.springbootproject.entity.Department;
import com.demo.springbootproject.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements DepartmentServiceInterface{

    @Autowired
    private DepartmentRepo departmentRepo;


    @Override
    public Department addDepartment(Department department) {
        return departmentRepo.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepo.findAll();
    }
}
