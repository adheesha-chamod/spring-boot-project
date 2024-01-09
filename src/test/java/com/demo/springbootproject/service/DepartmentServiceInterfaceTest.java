package com.demo.springbootproject.service;

import com.demo.springbootproject.entity.Department;
import com.demo.springbootproject.exception.DepartmentNotFoundException;
import com.demo.springbootproject.repository.DepartmentRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceInterfaceTest {

    @Autowired
    private DepartmentService departmentService;
    @MockBean
    private DepartmentRepo departmentRepo;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .id(1L)
                .name("Dept 1")
                .code("D001")
                .address("Address 1")
                .build();

        Mockito.when(departmentRepo.findById(1L))
                .thenReturn(Optional.ofNullable(department));
    }

    @Test
    @DisplayName("Test getDepartment() method")
    public void whenValidDepartment_thenDepartmentShouldBeFound() throws DepartmentNotFoundException {
        Long departmentId = 1L;
        Department found = departmentService.getDepartment(departmentId);

        assertEquals(departmentId, found.getId());
    }
}