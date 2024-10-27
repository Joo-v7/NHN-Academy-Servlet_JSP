package com.nhnacademy.student;

import com.nhnacademy.student.Repository.JsonStudentRepository;
import com.nhnacademy.student.Repository.StudentRepository;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.random.RandomDataGenerator;

import java.time.LocalDateTime;

/* JsonStudentRepository */
@Slf4j
@WebListener
public class WebApplicationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        StudentRepository studentRepository = new JsonStudentRepository();
        log.debug("sutdentRepository 생성됨");

        for(int i=1; i<=10; i++) {
            String id = "stupdent"+i;
            String name = "아카데미"+i;
            Gender gender = Gender.MALE;
            int age = new RandomDataGenerator().nextInt(20, 29);
            LocalDateTime localDateTime = LocalDateTime.now();

            Student student = new Student(id, name, gender, age, localDateTime);
            studentRepository.save(student);
        }
        context.setAttribute("studentRepository", studentRepository);
        log.debug("studentRepository context에 등록");
    }
}

/* MapStudentRepository */
//@Slf4j
//@WebListener
//public class WebApplicationListener implements ServletContextListener {
//
//    @Override
//    public void contextInitialized(ServletContextEvent sce) {
//        ServletContext context = sce.getServletContext();
//        StudentRepository studentRepository = new MapStudentRepository();
//        log.debug("sutdentRepository 생성됨");
//
//        for(int i=1; i<=10; i++) {
//            String id = "stupdent"+i;
//            String name = "아카데미"+i;
//            Gender gender = Gender.MALE;
//            int age = new RandomDataGenerator().nextInt(20, 29);
//            LocalDateTime localDateTime = LocalDateTime.now();
//
//            Student student = new Student(id, name, gender, age, localDateTime);
//            studentRepository.save(student);
//        }
//        context.setAttribute("studentRepository", studentRepository);
//        log.debug("studentRepository context에 등록");
//    }
//}
