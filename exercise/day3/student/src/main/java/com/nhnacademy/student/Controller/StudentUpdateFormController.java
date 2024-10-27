package com.nhnacademy.student.Controller;

import com.nhnacademy.student.Gender;
import com.nhnacademy.student.Factory.RequestMapping;
import com.nhnacademy.student.Student;
import com.nhnacademy.student.Repository.StudentRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Objects;
@RequestMapping(value="/student/update.do", method=RequestMapping.Method.POST)
@Slf4j
public class StudentUpdateFormController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        StudentRepository studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String age = req.getParameter("age");
        LocalDateTime date = LocalDateTime.now();

        if(Objects.isNull(id) || Objects.isNull(name) || Objects.isNull(gender) || Objects.isNull(age)) {
            throw new IllegalArgumentException("register - input is null");
        }
        log.debug("update form check:{}", id, name, gender, age);
        Student student = new Student(id, name, Gender.valueOf(gender), Integer.parseInt(age), date);
        studentRepository.update(student);
        return "redirect:/student/view.do?id="+id;
    }
}
