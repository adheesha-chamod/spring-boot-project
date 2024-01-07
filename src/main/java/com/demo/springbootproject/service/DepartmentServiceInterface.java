package com.demo.springbootproject.service;

import com.demo.springbootproject.entity.Department;

import java.util.List;

public interface DepartmentServiceInterface {
    public Department addDepartment(Department department);

    public List<Department> getAllDepartments();

    public Department getDepartment(Long departmentId);
}
