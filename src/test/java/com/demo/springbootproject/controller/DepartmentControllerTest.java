package com.demo.springbootproject.controller;

import com.demo.springbootproject.entity.Department;
import com.demo.springbootproject.exception.DepartmentNotFoundException;
import com.demo.springbootproject.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DepartmentService departmentService;
    private Department department;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .id(1L)
                .name("Dept 1")
                .code("D001")
                .address("Address 1")
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .name("Dept 1")
                .code("D001")
                .address("Address 1")
                .build();

        Mockito.when(departmentService.addDepartment(inputDepartment)).thenReturn(department);

        mockMvc.perform(post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"name\": \"Dept 1\",\n" +
                        "    \"code\": \"D001\",\n" +
                        "    \"address\": \"Address 1\"\n" +
                        "}"))
                .andExpect(status().isOk());
    }

//    @Test
//    void getDepartment() throws Exception {
//        Mockito.when(departmentService.getDepartment(1L)).thenReturn(department);
//
//        mockMvc.perform(get("/departments/1")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name")
//                        .value(department.getName()));
//    }
}