package com.example.university.service.impl;


import com.example.university.domain.CommonResponse;
import com.example.university.domain.entity.Teacher;
import com.example.university.domain.entity.Teacher_Student;
import com.example.university.exception.ResourceNotFoundException;
import com.example.university.respository.Teacher_StudentRepository;
import com.example.university.service.Teacher_StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import javax.transaction.Transactional;
import javax.transaction.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class Teacher_StudentServiceImpl  implements Teacher_StudentService {

    private final com.example.university.respository.Teacher_StudentRepository teacher_studentRepository;

    @Autowired
    public Teacher_StudentServiceImpl(Teacher_StudentRepository teacher_studentRepository) {
        this.teacher_studentRepository = teacher_studentRepository;
    }

    @Override
    public CommonResponse findById(String id) {
        Optional<Teacher_Student> tea =  teacher_studentRepository.findById(id);
//        if(tea.isEmpty()) {
//            //log
//            throw new ResourceNotFoundException("...");
//        }
        return new CommonResponse(0, new Date(), tea.get());
    }

    @Override
    public CommonResponse findAll() {
        List<Teacher_Student> stuList =  teacher_studentRepository.findAll();
        return new CommonResponse(0, new Date(), stuList);
    }

    @Override
    @Transactional
    public CommonResponse insert(Teacher_Student tea) {
        Teacher_Student teacher =  teacher_studentRepository.insert(tea);
        return new CommonResponse(0, new Date(), teacher.getId());
    }

    @Override
    @Transactional
    public CommonResponse update(Teacher_Student teacher, String id) {
        Teacher_Student teacher1 =  teacher_studentRepository.update(teacher,id);
        return new CommonResponse(0, new Date(), teacher1.getId());
    }

    @Override
    public CommonResponse delete(String id) {
        Optional<Teacher_Student> byId =  teacher_studentRepository.findById(id);
//        if(byId.isEmpty()) {
//            //log
//            throw new ResourceNotFoundException("...");
//        }
        teacher_studentRepository.delete(byId.get());
        return new CommonResponse(0, new Date(), byId.get());
    }

//
}
