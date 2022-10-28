package com.example.university.respository.impl;

import com.example.university.domain.entity.Student;
import com.example.university.respository.StudentCustomRepo;
import com.example.university.domain.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class StudentCustomRepoImpl implements StudentCustomRepo {

    private final EntityManager entityManager;

    @Autowired
    public StudentCustomRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Student insert(Student student) {
        entityManager.persist(student);
        return student;
    }

    @Override
    public Student update(Student student, String id) {
//        Student student1 = entityManager.find(Student.class, student.getId());
//        student1.setName(student.getName());
        Student student1 = entityManager.find(Student.class, id);
        // entityManager.merge(student);
        student1.setName(student.getName());
        entityManager.merge(student1);
        return student;
    }
}
