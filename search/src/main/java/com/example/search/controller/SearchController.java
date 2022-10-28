package com.example.search.controller;

import com.example.search.service.EmployeeService;
import com.example.university.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {

    private final EmployeeService employeeService;

    public SearchController(EmployeeService employeeService, StudentService studentService) {
        this.employeeService = employeeService;
        this.studentService = studentService;
    }

    @GetMapping("/search/employees")
    public ResponseEntity<?> getDetails(@RequestParam List<Integer> ages) {
        //TODO
        return new ResponseEntity<>(employeeService.fetchAllEmployeesByAges(ages), HttpStatus.OK);
    }


    // fetch the university Service  ———> into studentservice
    public final StudentService studentService;

    @GetMapping("/search/university/")
    public ResponseEntity<?> getData(@RequestParam List<Integer> ages) {
        //TODO
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }


}


