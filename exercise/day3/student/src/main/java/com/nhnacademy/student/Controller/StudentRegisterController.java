package com.nhnacademy.student.Controller;

import com.nhnacademy.student.Factory.RequestMapping;
import com.nhnacademy.student.Repository.StudentRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value="/student/register.do", method=RequestMapping.Method.GET)
public class StudentRegisterController implements Command {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {

        StudentRepository studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");

        return "/student/register.jsp";
    }
}

//@Slf4j
//@WebServlet(name="studentRegisterServlet", urlPatterns = "/student/register")
//public class StudentRegisterServlet extends HttpServlet {
//
//    private StudentRepository studentRepository;
//
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
//    }
//
//    @Override
//    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // RequestDispatcher rd = req.getRequestDispatcher("/student/register.jsp");
//        // rd.forward(req, resp);
//        req.setAttribute("view", "/student/register.jsp");
//    }
//
//    @Override
//    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String id = req.getParameter("id");
//        String name = req.getParameter("name");
//        String gender = req.getParameter("gender");
//        String age = req.getParameter("age");
//        LocalDateTime date = LocalDateTime.now();
//
//        if(Objects.isNull(id) || Objects.isNull(name) || Objects.isNull(gender) || Objects.isNull(age)) {
//            throw new IllegalArgumentException("register의 input이 뭔가가 null임");
//        }
//        Student student = new Student(id, name, Gender.valueOf(gender), Integer.parseInt(age), date);
//        studentRepository.save(student);
//        // resp.sendRedirect("/student/view?id=" + id);
//        req.setAttribute("view", "redirect:/student/view.do?id="+id);
//    }
//}
