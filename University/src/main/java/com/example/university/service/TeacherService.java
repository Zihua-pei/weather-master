package com.example.university.service;

import com.example.university.domain.CommonResponse;
import com.example.university.domain.entity.Student;
import com.example.university.domain.entity.Teacher;
import com.example.university.domain.entity.Teacher_Student;
import org.springframework.stereotype.Service;

@Service
public interface TeacherService {
    CommonResponse findById(String id);
    CommonResponse findAll();
    CommonResponse insert(Teacher tea);

    CommonResponse update(Teacher teacher, String id);

    CommonResponse delete(String id);
}
