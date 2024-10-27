package com.nhnacademy.student.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import static jakarta.servlet.RequestDispatcher.*;


public class ErrorController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("status_code", req.getAttribute(ERROR_STATUS_CODE));
        req.setAttribute("exception_type", req.getAttribute(ERROR_EXCEPTION_TYPE));
        req.setAttribute("message", req.getAttribute(ERROR_MESSAGE));
        req.setAttribute("exception", req.getAttribute(ERROR_EXCEPTION));
        req.setAttribute("request_uri", req.getAttribute(ERROR_REQUEST_URI));

        return "/error.jsp";
    }
}

//@WebServlet(name="errorServlet", urlPatterns="/error")
//public class ErrorServlet extends HttpServlet {
//
//    @Override
//    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("status_code", req.getAttribute(ERROR_STATUS_CODE));
//        req.setAttribute("exception_type", req.getAttribute(ERROR_EXCEPTION_TYPE));
//        req.setAttribute("message", req.getAttribute(ERROR_MESSAGE));
//        req.setAttribute("exception", req.getAttribute(ERROR_EXCEPTION));
//        req.setAttribute("request_uri", req.getAttribute(ERROR_REQUEST_URI));
//
//        jakarta.servlet.RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
//        rd.forward(req, resp);
//    }
//}
