package com.example.university.controller;

import com.example.university.domain.CommonResponse;
import com.example.university.domain.entity.Student;
import com.example.university.exception.ResourceNotFoundException;

import com.example.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<com.example.university.domain.CommonResponse> findStuById(@PathVariable String id) {
        return new ResponseEntity<>(studentService.findById(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<com.example.university.domain.CommonResponse> findAll() {
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<com.example.university.domain.CommonResponse> insert(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.insert(student), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<com.example.university.domain.CommonResponse> update(@RequestBody Student student, @PathVariable String id) {
        return new ResponseEntity<>(studentService.update(student,id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<com.example.university.domain.CommonResponse> delete(@PathVariable String id) {
        return new ResponseEntity<>(studentService.delete(id), HttpStatus.OK);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<com.example.university.domain.CommonResponse> handleNotFound() {
        return new ResponseEntity<>(
                    new com.example.university.domain.CommonResponse(-1, new Date(), "resource not found"),
                    HttpStatus.NOT_FOUND
                );
    }
}