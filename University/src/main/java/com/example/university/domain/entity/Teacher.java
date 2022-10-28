package com.example.university.domain.entity;

//import com.example.java20.week4.orm.Teacher_Student;
import com.example.university.domain.entity.Teacher_Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teacher")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
 //   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
    private List<com.example.university.domain.entity.Teacher_Student> teacher_students = new ArrayList<>();

    public List<com.example.university.domain.entity.Teacher_Student> getTeacher_students() {
        return teacher_students;
    }

    public void setTeacher_students(List<com.example.university.domain.entity.Teacher_Student> teacher_students) {
        this.teacher_students = teacher_students;
    }

    public void addTeacher_students(com.example.university.domain.entity.Teacher_Student ts) {
        this.teacher_students.add(ts);
    }
}
