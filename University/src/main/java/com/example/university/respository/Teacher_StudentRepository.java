package com.example.university.respository;


import com.example.university.domain.entity.Teacher_Student;
import com.example.university.domain.entity.Teacher_Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Teacher_StudentRepository extends JpaRepository<Teacher_Student, String>, Teacher_StudentCustomRepo{
}
