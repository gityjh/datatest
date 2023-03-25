package com.example.datatest.haoyue.mapper;

import com.example.datatest.haoyue.entity.Teacher;

public interface TeacherMapper {
    Teacher getTeacherById(String id);
    int insertTeacher(Teacher teacher);
    Teacher getTeacherByPram(Teacher teacher);
}
