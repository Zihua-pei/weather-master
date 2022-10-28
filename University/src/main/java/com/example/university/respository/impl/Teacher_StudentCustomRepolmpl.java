package com.example.university.respository.impl;

import com.example.university.domain.entity.Teacher_Student;
import com.example.university.respository.TeacherCustomRepo;
import com.example.university.respository.Teacher_StudentCustomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class Teacher_StudentCustomRepolmpl implements Teacher_StudentCustomRepo {

    private final EntityManager entityManager;

    @Autowired
    public Teacher_StudentCustomRepolmpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Teacher_Student insert(Teacher_Student teacher_student) {
        entityManager.persist(teacher_student);
        return teacher_student;
    }

    @Override
    public Teacher_Student update(Teacher_Student teacher_student, String id) {
        Teacher_Student ts = entityManager.find(Teacher_Student.class,id);
      //  ts.setName(teacher_student.getName());
        entityManager.merge(ts);
        return teacher_student;
    }

}
