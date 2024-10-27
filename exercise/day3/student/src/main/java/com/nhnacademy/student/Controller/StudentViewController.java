package com.nhnacademy.student.Controller;

import com.nhnacademy.student.Factory.RequestMapping;
import com.nhnacademy.student.Student;
import com.nhnacademy.student.Repository.StudentRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Objects;
@RequestMapping(value="/student/view.do", method=RequestMapping.Method.GET)
public class StudentViewController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        StudentRepository studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");
        String id = req.getParameter("id");

        if(Objects.isNull(id)) {
            throw new IllegalArgumentException("view - id is null");
        }
        Student student = studentRepository.getStudentById(id);
        req.setAttribute("student", student);

        return "/student/view.jsp";
    }
}

//@Slf4j
//@WebServlet(name="studentViewServlet", urlPatterns="/student/view")
//public class StudentViewServlet extends HttpServlet {
//    private StudentRepository studentRepository;
//
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
//    }
//
//    @Override
//    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String id = req.getParameter("id");
//
//        if(Objects.isNull(id)){
//            throw new ServletException("view - id is null");
//        }
//
//        Student student = studentRepository.getStudentById(id);
//        req.setAttribute("student", student);
//
////        RequestDispatcher rd = req.getRequestDispatcher("/student/view.jsp");
////        rd.forward(req, resp);
//
//        req.setAttribute("view", "/student/view.jsp");
//
//    }
//}
