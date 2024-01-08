package com.demo.springbootproject.service;

import com.demo.springbootproject.entity.Department;
import com.demo.springbootproject.exception.DepartmentNotFoundException;
import com.demo.springbootproject.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Department getDepartment(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> existingDepartment = departmentRepo.findById(departmentId);

        if (!existingDepartment.isPresent()) {
            throw new DepartmentNotFoundException("Department not found with id: " + departmentId);
        }

        return existingDepartment.get();
    }

    @Override
    public List<Department> getDepartmentsByName(String departmentName) {
//        return departmentRepo.findAllByName(departmentName);
        return departmentRepo.findAllByNameIgnoreCase(departmentName);
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
