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

    @Override
    public Department getDepartment(Long departmentId) {
        return departmentRepo.findById(departmentId).get();
    }

    @Override
    public List<Department> getDepartmentsByName(String departmentName) {
        return departmentRepo.findAllByName(departmentName);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department existingDepartment = departmentRepo.findById(departmentId).get();

        if (department.getName() != null && department.getName() != "") {
            existingDepartment.setName(department.getName());
        }

        if (department.getCode() != null && department.getCode() != "") {
            existingDepartment.setCode(department.getCode());
        }

        if (department.getAddress() != null && department.getAddress() != "") {
            existingDepartment.setAddress(department.getAddress());
        }

        return departmentRepo.save(existingDepartment);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        departmentRepo.deleteById(departmentId);
    }
}
