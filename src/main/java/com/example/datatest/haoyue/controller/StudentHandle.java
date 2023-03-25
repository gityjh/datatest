package com.example.datatest.haoyue.controller;

import com.example.datatest.haoyue.entity.Student;
import com.example.datatest.haoyue.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentHandle {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    StudentMapper studentMapper;
    @RequestMapping("/getStudentList")
    public List<Map<String, Object>> getStudntList(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from student");
        return list;
    }
    @GetMapping("getStudentById/{id}")
    public Student getStudentById(@PathVariable("id") String id){
        if(id==null||"".equals(id)){
            return null;
        }
        Student student = studentMapper.getStudentById(id);
        return student;
    }
    @DeleteMapping("deleteStudentById/id")
    public int deleteStudentById(@PathVariable("id") String id){
        if(id==null||"".equals(id)){
            return 0;
        }
        int delete = studentMapper.deleteStudentById(id);
        return delete;
    }
    @GetMapping("insertStudent")
    public int insertStudent(String sName,String sSex,String sBirth){
        try {
            Student student = new Student();
            student.setsName(sName);
            student.setsSex(sSex);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            student.setsBirth(df.parse(sBirth));
            int insert = studentMapper.insertStudent(student);
            return insert;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
