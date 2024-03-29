package com.demo.springbootproject.service;

import com.demo.springbootproject.entity.Department;
import com.demo.springbootproject.exception.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentServiceInterface {
    public Department addDepartment(Department department);

    public List<Department> getAllDepartments();

    public Department getDepartment(Long departmentId) throws DepartmentNotFoundException;

    public List<Department> getDepartmentsByName(String departmentName);

    public void deleteDepartment(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);
}
