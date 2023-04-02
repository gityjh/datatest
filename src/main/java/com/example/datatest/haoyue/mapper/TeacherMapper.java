package com.example.datatest.haoyue.mapper;

import com.example.datatest.haoyue.entity.Teacher;

import java.util.List;

public interface TeacherMapper {
    Teacher getTeacherById(String id);
    int insertTeacher(Teacher teacher);
    List<Teacher> getTeacherByPram(Teacher teacher);
}
