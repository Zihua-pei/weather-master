package com.example.university.controller;


import com.example.university.domain.CommonResponse;
import com.example.university.domain.entity.Teacher_Student;
import com.example.university.exception.ResourceNotFoundException;

import com.example.university.service.Teacher_StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class Teacher_StudentController {
    
    private final Teacher_StudentService teacher_studentService;

    @Autowired
    public Teacher_StudentController(Teacher_StudentService teacher_studentService) {
        this.teacher_studentService =teacher_studentService;
    }

    @GetMapping("/teacher_student")
    public ResponseEntity<CommonResponse> getAll() {
        return new ResponseEntity<>(teacher_studentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/teacher_student/{id}")
    public ResponseEntity<CommonResponse> getTeacher_StudentById(@PathVariable String id) {
        return new ResponseEntity<>(teacher_studentService.findById(id), HttpStatus.OK);
    }


    @PostMapping("/teacher_student")
    public ResponseEntity<CommonResponse> createTeacher_Student(@RequestBody Teacher_Student ts){
        return new ResponseEntity<>(teacher_studentService.insert(ts), HttpStatus.CREATED);
    }


    @PutMapping("/teacher_student/{id}")
    public ResponseEntity<CommonResponse> updateTeacher_Student(@PathVariable String id, @RequestBody Teacher_Student ts) {
        return new ResponseEntity<>(teacher_studentService.update(ts,id),HttpStatus.OK);
    }


    @DeleteMapping("/teacher_student/{id}")
    public ResponseEntity<CommonResponse> deleteAuthor(@PathVariable String id) {
        return new ResponseEntity<>(teacher_studentService.delete(id),HttpStatus.OK);
    }

    @ExceptionHandler(com.example.university.exception.ResourceNotFoundException.class)
    public ResponseEntity<CommonResponse> handleNotFound() {
        return new ResponseEntity<>(
                new CommonResponse(-1, new Date(), "resource not found"),
                HttpStatus.NOT_FOUND
        );
    }
}
