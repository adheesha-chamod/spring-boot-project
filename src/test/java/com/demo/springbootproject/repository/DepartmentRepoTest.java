package com.demo.springbootproject.repository;

import com.demo.springbootproject.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepoTest {

    @Autowired
    private DepartmentRepo departmentRepo;
    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .name("Test Dept 1")
                .code("D001")
                .address("Address 1")
                .build();

        testEntityManager.persist(department);
    }

    @Test
    public void whenFindById_thenReturnDepartment() {
        Department department = departmentRepo.findById(1L).get();
        assertEquals(department.getName(), "Test Dept 1");
    }
}