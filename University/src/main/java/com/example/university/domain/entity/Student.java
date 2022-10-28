package com.example.university.domain.entity;

import com.example.university.domain.entity.Teacher_Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "stu", fetch = FetchType.LAZY , cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Teacher_Student> teacher_students = new ArrayList<>();

    public List<Teacher_Student> getTeacher_students() {
        return teacher_students;
    }

    public void setTeacher_students(List<Teacher_Student> ts) {
        this.teacher_students = ts;
    }

    public void addTeacher_student(Teacher_Student ts) {
        this.teacher_students.add(ts);
    }
}
