package com.nhnacademy.student.Controller;

import com.nhnacademy.student.Factory.RequestMapping;
import com.nhnacademy.student.Student;
import com.nhnacademy.student.Repository.StudentRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequestMapping(value="/student/list.do", method=RequestMapping.Method.GET)
public class StudentListController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {

        StudentRepository studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");
        List<Student> studentList = studentRepository.getStudents();
        req.setAttribute("studentList", studentList);


        // return view
        return "/student/list.jsp";
    }
}

//@Slf4j
//@WebServlet(name = "studentListServlet", urlPatterns = "/student/list")
//public class StudentListServlet extends HttpServlet {
//
//    private StudentRepository studentRepository;
//
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<Student> studentList = studentRepository.getStudents();
//        req.setAttribute("studentList", studentList);
//
////        RequestDispatcher rd = req.getRequestDispatcher("/student/list.jsp");
////        rd.forward(req, resp);
//
//
//        req.setAttribute("view", "/student/list.jsp");
//        log.debug("view:{}", req.getAttribute("view"));
//    }
//}
