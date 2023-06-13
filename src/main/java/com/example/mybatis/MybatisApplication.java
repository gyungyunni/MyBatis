// MybatisApplication.java 파일
package com.example.mybatis;

import com.example.mybatis.dao.StudentDao;
import com.example.mybatis.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
//import org.apache.catalina.core.ApplicationContext; // 이거 안됨

@SpringBootApplication
public class MybatisApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext
                = SpringApplication.run(MybatisApplication.class, args);

        StudentDao dao = applicationContext.getBean(StudentDao.class);
        System.out.println(dao.readStudentAll()); // 전체 출력

        Student student = new Student();
        student.setName("dave");
        student.setAge(40);
        student.setPhone("010-1111-2222");
        student.setEmail("dave@naver.com");
        dao.createStudent(student); // 새로 set한 student 추가


        for (Long i = 1L; i <= 4L; i++) {
            System.out.println(dao.readStudent(i)); // i는 id값 , Student 한명씩 읽음
        }

        System.out.println(dao.readAllXmlStudent());

        System.out.println(dao.readStudentXml(2L));
    }
}

//출력결과
//Student(id=1, name=alex, age=35, phone=010-1234-5678, email=alex@gmail.com)
//Student(id=2, name=brad, age=35, phone=010-1234-5678, email=brad@gmail.com)
//Student(id=3, name=chad, age=35, phone=010-1234-5678, email=chad@gmail.com)
//Student(id=4, name=dave, age=40, phone=010-1111-2222, email=dave@naver.com)
