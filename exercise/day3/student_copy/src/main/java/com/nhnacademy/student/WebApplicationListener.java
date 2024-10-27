package com.nhnacademy.student;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.apache.commons.math3.random.RandomDataGenerator;

import java.time.LocalDateTime;
import java.util.Random;

@WebListener
public class WebApplicationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        StudentRepository studentRepository = new MapStudentRepository();

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
    }
}
