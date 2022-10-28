package com.example.university.service;

import com.example.university.domain.CommonResponse;
import com.example.university.domain.entity.Teacher_Student;
import org.springframework.stereotype.Service;

@Service
public interface Teacher_StudentService {
    CommonResponse findById(String id);
    CommonResponse findAll();
    CommonResponse insert(Teacher_Student tea_stu);
    CommonResponse update(Teacher_Student tea_stu, String id);
    CommonResponse delete(String id);
}
