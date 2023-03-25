package com.example.datatest.haoyue.mapper;

import com.example.datatest.haoyue.entity.Student;
import org.apache.ibatis.annotations.*;

//指定这是一个操作数据库的mapper
//@Mapper
public interface StudentMapper {
    @Select("select * from student where s_id=#{id}")
    Student getStudentById(String id);

    @Options(useGeneratedKeys = true,keyProperty ="s_id")
    @Insert("insert into student(s_name,s_sex,s_birth) values(#{sName},#{sSex},#{sBirth})")
    int insertStudent(Student student);

    @Delete("delete from student where s_id=#{id}")
    int deleteStudentById(String id);

    @Update("update student set s_birth=#{sBirth} where s_id={#sId}")
    int updateStudentById(Student student);
}
