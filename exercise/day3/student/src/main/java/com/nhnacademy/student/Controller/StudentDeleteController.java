package com.nhnacademy.student.Controller;

import com.nhnacademy.student.Factory.RequestMapping;
import com.nhnacademy.student.Repository.StudentRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RequestMapping(value="/student/delete.do", method=RequestMapping.Method.POST)
public class StudentDeleteController implements Command {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        StudentRepository studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");
        String id = req.getParameter("id");
        studentRepository.deleteById(id);
        return "redirect:/student/list.do";
    }
}


//@Slf4j
//@WebServlet(name="studentDeleteServlet", urlPatterns = "/student/delete")
//public class StudentDeleteServlet extends HttpServlet {
//
//    private StudentRepository studentRepository;
//
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
//    }
//
//    @Override
//    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String id = req.getParameter("id");
//        if(Objects.isNull(id) || id.isEmpty()) {
//            throw new RuntimeException("delete - id is null or empty");
//        }
//
//        studentRepository.deleteById(id);
//        // resp.sendRedirect("/student/list");
//
//        req.setAttribute("view", "redirect:/student/list.do");
//    }
//}
