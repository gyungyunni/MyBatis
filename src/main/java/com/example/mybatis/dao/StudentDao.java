//StudentDao.java 파일
package com.example.mybatis.dao;

import com.example.mybatis.mapper.StudentMapper;
import com.example.mybatis.mapper.StudentXmlMapper;
import com.example.mybatis.model.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

// @Repository 어노테이션은 스프링에서 해당 클래스를 리포지토리(데이터 액세스 객체)로
// 인식하도록 지정
@Repository
public class StudentDao {

    // SqlSessionFactory는 MyBatis에서 세션을 생성하기 위한 팩토리 클래스, 생성자를 통해 주입
    private final SqlSessionFactory SessionFactory;

    public StudentDao(SqlSessionFactory sessionFactory){
        this.SessionFactory = sessionFactory;
    }

    // readStudentAll 메서드는 모든 학생을 조회하는 기능을 제공
// SqlSession을 사용하여 데이터베이스 세션을 열고, StudentMapper를 얻어와서
// selectStudentAll() 메서드를 호출하여 모든 Student를 조회한 후, 결과를 반환
    public List<Student> readStudentAll(){
        try(SqlSession sqlSession = SessionFactory.openSession()){
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            return studentMapper.selectStudentAll();
        }
    }

    // createStudent 메서드는 학생을 생성하는 기능을 제공
// SqlSession을 사용하여 데이터베이스 세션을 열고, StudentMapper를 얻어와서
// insertStudent() 메서드를 호출하여 Student를 생성
    public void createStudent(Student student){
        try(SqlSession sqlSession = SessionFactory.openSession()){
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            studentMapper.insertStudent(student);
        }
    }

    // readStudent 메서드는 특정 학생을 조회하는 기능을 제공
// SqlSession을 사용하여 데이터베이스 세션을 열고, StudentMapper를 얻어와서
// selectStudent() 메서드를 호출하여 주어진 id에 해당하는 Student를 조회한 후, 결과를 반환
    public Student readStudent(Long id){
        try(SqlSession sqlSession = SessionFactory.openSession()){
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            return studentMapper.selectStudent(id);
        }
    }

    public List<Student> readAllXmlStudent() {
        try (SqlSession session = SessionFactory.openSession()) {
            StudentXmlMapper studentXmlMapper = session.getMapper(StudentXmlMapper.class);
            return studentXmlMapper.selectStudentAll();
        }
    }
    public Student readStudentXml(Long id) {
        try (SqlSession session = SessionFactory.openSession()){
            StudentXmlMapper studentXmlMapper = session.getMapper(StudentXmlMapper.class);
            return studentXmlMapper.selectStudent(id);
        }
    }
}