package com.example.datatest.haoyue.controller;

import com.example.datatest.haoyue.entity.Teacher;
import com.example.datatest.haoyue.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("teacher")
public class TeacherHandle {
    @Autowired
    TeacherMapper teacherMapper;
    @GetMapping("getTeacherById/{id}")
    public Teacher getTeacherById(@PathVariable("id") String id){
       return teacherMapper.getTeacherById(id);
    }
    @GetMapping("insertTeacher")
    public int insertTeacher(Teacher teacher){
        return teacherMapper.insertTeacher(teacher);
    }
    @GetMapping("getTeacherByPram")
    public Teacher getTeacherByPram(Teacher teacher){
        return teacherMapper.getTeacherByPram(teacher);
    }
}
