package com.nhnacademy.student.Controller;

import com.nhnacademy.student.Factory.RequestMapping;
import com.nhnacademy.student.Student;
import com.nhnacademy.student.Repository.StudentRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Objects;
@RequestMapping(value="/student/update.do", method=RequestMapping.Method.GET)
public class StudentUpdateController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        StudentRepository studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");

        String id = req.getParameter("id");
        if(Objects.isNull(id) || id.isEmpty()){
            throw new IllegalArgumentException();
        }
        Student student = studentRepository.getStudentById(id);
        req.setAttribute("student", student);

        return "/student/register.jsp";
    }
}

//@Slf4j
//@WebServlet(name="studentUpdateServlet", urlPatterns="/student/update")
//public class StudentUpdateServlet extends HttpServlet {
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
//        if(Objects.isNull(id) || id.isEmpty()) {
//            log.debug("update - id is null or empty");
//            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
//        }
//        Student student = studentRepository.getStudentById(id);
//
//        req.setAttribute("student", student);
//
////        RequestDispatcher rd = req.getRequestDispatcher("/student/register.jsp");
////        rd.forward(req, resp);
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
//            throw new IllegalArgumentException("register - input is null");
//        }
//        Student student = new Student(id, name, Gender.valueOf(gender), Integer.parseInt(age), date);
//        studentRepository.update(student);
////        resp.sendRedirect("/student/view?id=" + id);
//        req.setAttribute("view", "redirect:/student/view.do?id="+id);
//    }
//}
