package com.example.datatest.haoyue.controller;

import com.example.datatest.haoyue.entity.Teacher;
import com.example.datatest.haoyue.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("teacher")
public class TeacherHandle {
    @Resource
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
    public Map<String,Object> getTeacherByPram(Teacher teacher){
        Map<String,Object> map = new HashMap<>(5);
        List<Teacher> list = teacherMapper.getTeacherByPram(teacher);
        map.put("code","0");
        map.put("list",list);
        return map;
    }
}
