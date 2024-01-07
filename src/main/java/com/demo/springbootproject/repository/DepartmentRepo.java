package com.demo.springbootproject.repository;

import com.demo.springbootproject.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {
    public List<Department> findAllByName(String departmentName);

    public List<Department> findAllByNameIgnoreCase(String departmentName);
}
