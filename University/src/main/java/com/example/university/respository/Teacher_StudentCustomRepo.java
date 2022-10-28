package com.example.university.respository;

import com.example.university.domain.entity.Student;
import com.example.university.domain.entity.Teacher_Student;
import org.springframework.stereotype.Repository;

@Repository
public interface Teacher_StudentCustomRepo {
    Teacher_Student insert(Teacher_Student teacher_student);
    Teacher_Student update(Teacher_Student teacher_student,String id);
}
