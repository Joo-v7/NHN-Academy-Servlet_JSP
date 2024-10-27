package com.nhnacademy.student.Controller;

import com.nhnacademy.student.Gender;
import com.nhnacademy.student.Factory.RequestMapping;
import com.nhnacademy.student.Student;
import com.nhnacademy.student.Repository.StudentRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.time.LocalDateTime;
import java.util.Objects;
@RequestMapping(value="/student/register.do", method=RequestMapping.Method.POST)
public class StudentRegisterFormController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        StudentRepository studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String age = req.getParameter("age");
        LocalDateTime date = LocalDateTime.now();

        if(Objects.isNull(id) || Objects.isNull(name) || Objects.isNull(gender) || Objects.isNull(age)) {
            throw new IllegalArgumentException("register(post) - input is null");
        }
        Student student = new Student(id, name, Gender.valueOf(gender), Integer.parseInt(age), date);
        studentRepository.save(student);

        return "redirect:/student/view.do?id="+id;
    }
}
