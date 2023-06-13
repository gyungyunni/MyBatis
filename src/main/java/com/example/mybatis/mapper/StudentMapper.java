//StudentMapper.java 파일
package com.example.mybatis.mapper;

import com.example.mybatis.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper //@Mapper 어노테이션은 이 인터페이스가 MyBatis 매퍼 인터페이스임을 나타냄.
public interface StudentMapper {

    // @Insert 어노테이션은 SQL INSERT 문을 정의하는 데 사용
    // students 테이블에 데이터를 삽입하기 위한 SQL 쿼리를 지정하며,
    // #{name}, #{age}, #{phone}, #{email}와 같은 플레이스홀더는 Student 객체의 속성과 대응
    @Insert("insert into students(name, age, phone, email)" +
            "values (#{name}, #{age}, #{phone}, #{email})")
    void insertStudent(Student student);

    // @Select 어노테이션은 SQL SELECT 문을 정의하는 데 사용
    // students 테이블에서 모든 레코드를 검색
    @Select("SELECT * FROM students")
    List<Student> selectStudentAll();

    // @Select 어노테이션을 사용하여 SQL SELECT 문을 정의하고, id라는 매개변수를 받음
    // SQL 쿼리는 students 테이블에서 id가 주어진 id와 일치하는 것을 찾음
    @Select("select * from students where id = #{id}")
    Student selectStudent(Long id);

    @Update("update students set " +
            "name = #{name}, "+
            "age = #{age}, "+
            "phone = #{phone}, "+
            "email = #{email}, "+
            "where id = #{id}")
    void updateStudent(Student student);

    @Delete("delete from students" +
            "where id = #{id}")
    void deleteStudent(Long id);
}