package com.nhnacademy.student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;

@Slf4j
@WebServlet(name="studentUpdateServlet", urlPatterns="/student/update")
public class StudentUpdateServlet extends HttpServlet {
    private StudentRepository studentRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if(Objects.isNull(id) || id.isEmpty()) {
            log.debug("update - id is null or empty");
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
        Student student = studentRepository.getStudentById(id);

        req.setAttribute("student", student);

//        RequestDispatcher rd = req.getRequestDispatcher("/student/register.jsp");
//        rd.forward(req, resp);
        req.setAttribute("view", "/student/register.jsp");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String age = req.getParameter("age");
        LocalDateTime date = LocalDateTime.now();

        if(Objects.isNull(id) || Objects.isNull(name) || Objects.isNull(gender) || Objects.isNull(age)) {
            throw new IllegalArgumentException("register - input is null");
        }
        Student student = new Student(id, name, Gender.valueOf(gender), Integer.parseInt(age), date);
        studentRepository.update(student);
//        resp.sendRedirect("/student/view?id=" + id);
        req.setAttribute("view", "redirect:/student/view.do?id="+id);
    }
}
