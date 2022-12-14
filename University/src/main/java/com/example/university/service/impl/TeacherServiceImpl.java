package com.example.university.service.impl;

import com.example.university.domain.CommonResponse;
import com.example.university.domain.entity.Student;
import com.example.university.domain.entity.Teacher;
import com.example.university.exception.ResourceNotFoundException;
import com.example.university.respository.TeacherRepository;
import com.example.university.service.TeacherService;
import com.example.university.domain.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import javax.transaction.Transactional;
import javax.transaction.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public CommonResponse findById(String id) {
        Optional<Teacher> tea =  teacherRepository.findById(id);
//        if(tea.isEmpty()) {
//            //log
//            throw new ResourceNotFoundException("...");
//        }
        return new CommonResponse(0, new Date(), tea.get());
    }

    @Override
    public CommonResponse findAll() {
        List<Teacher> stuList =  teacherRepository.findAll();
        return new CommonResponse(0, new Date(), stuList);
    }

    @Override
    @Transactional
    public CommonResponse insert(Teacher tea) {
        Teacher teacher = teacherRepository.insert(tea);
        return new CommonResponse(0, new Date(), teacher.getId());
    }

    @Override
    @Transactional
    public CommonResponse update(Teacher teacher, String id) {
        Teacher teacher1 = teacherRepository.update(teacher,id);
        return new CommonResponse(0, new Date(), teacher1.getId());
    }

    @Override
    public CommonResponse delete(String id) {

        Optional<Teacher> byId = teacherRepository.findById(id);
//        if(byId.isEmpty()) {
//            //log
//            throw new ResourceNotFoundException("...");
//        }
        teacherRepository.delete(byId.get());
        return new CommonResponse(0, new Date(), byId.get());
    }
}
