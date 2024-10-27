package com.nhnacademy.student;

import com.nhnacademy.student.Controller.*;
import com.nhnacademy.student.Factory.ControllerFactory;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import static jakarta.servlet.RequestDispatcher.*;

@Slf4j
@WebServlet(name="frontServlet", urlPatterns = "*.do")
public class FrontServlet extends HttpServlet {
    private static final String REDIRECT_PREFIX="redirect";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        try{
//            Command command = resolveCommand(req.getServletPath(), req.getMethod());
            ControllerFactory controllerFactory = (ControllerFactory) req.getServletContext().getAttribute("controllerFactory");
            Command command = (Command) controllerFactory.getBean(req.getMethod(), req.getServletPath());

            String view = command.execute(req, resp);

            log.debug("frontservlet view:{}", view);

            if(view.startsWith(REDIRECT_PREFIX)) {
                log.error("redirect-url: {}", view.substring(REDIRECT_PREFIX.length()+1));
                resp.sendRedirect(view.substring(REDIRECT_PREFIX.length()+1));
            }else {
                RequestDispatcher rd = req.getRequestDispatcher(view);
                rd.include(req, resp);
            }
        }catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            req.setAttribute("status_code", req.getAttribute(ERROR_STATUS_CODE));
            req.setAttribute("exception_type", req.getAttribute(ERROR_EXCEPTION_TYPE));
            req.setAttribute("message", req.getAttribute(ERROR_MESSAGE));
            req.setAttribute("exception", req.getAttribute(ERROR_EXCEPTION));
            req.setAttribute("request_uri", req.getAttribute(ERROR_REQUEST_URI));
            log.error("status_code:{}", req.getAttribute(ERROR_STATUS_CODE));
            RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
            rd.forward(req,resp);
        }
    }

    /* ControllerFactory로 대체 */
//    private Command resolveCommand(String servletPath, String method) {
//        Command command = null;
//        if ("/student/list.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
//            command = new StudentListController();
//        } else if ("/student/view.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
//            command = new StudentViewController();
//        } else if ("/student/delete.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
//            command = new StudentDeleteController();
//        } else if ("/student/update.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
//            command = new StudentUpdateController();
//        } else if ("/student/update.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
//            command = new StudentUpdateFormController();
//        } else if ("/student/register.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
//            command = new StudentRegisterController();
//        } else if ("/student/register.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
//            command = new StudentRegisterFormController();
//        } else if ("/error.do".equals(servletPath)) {
//            command = new ErrorController();
//        }
//        return command;
//    }
}

//@Slf4j
//@WebServlet(name="frontServlet", urlPatterns = "*.do")
//public class FrontServlet extends HttpServlet {
//    private static final String REDIRECT_PREFIX="redirect";
//
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // 공통 처리
//        req.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html");
//
//        try {
//            // 실제 요청 처리할 servlet을 결정
//            String processingServletPath = resolveServlet(req.getServletPath());
//            RequestDispatcher rd = req.getRequestDispatcher(processingServletPath);
//            rd.include(req, resp);
//
//            // 실제 요청을 처리한 servlet이 'view'라는 request 속성값으로 view를 전달해줌
//            String view = (String) req.getAttribute("view"); // jsp를 받음.
//
//            if(view.startsWith(REDIRECT_PREFIX)) { // redirect인지 확인하는거
//                log.error("redirect-url entire:{}", view);
//                log.error("redirect-url : {}", view.substring(REDIRECT_PREFIX.length()+1));
//                resp.sendRedirect(view.substring(REDIRECT_PREFIX.length()+1));
//
//            }else { // JSP에게 view 처리를 위임하여 그 결과를 include 시킴.
//                log.debug("include:{}", view);
//                rd = req.getRequestDispatcher(view);
//                rd.include(req, resp);
//            }
//        }catch(Exception e) {
//            log.error("",e);
//            req.setAttribute("exception", e);
//            RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
//            rd.forward(req, resp);
//        }
//    }
//
//    private String resolveServlet(String servletPath) {
//        String processingServlet=null;
//        if("/student/list.do".equals(servletPath)) {
//            processingServlet = "/student/list";
//        }
//        else if("/student/register.do".equals(servletPath)) {
//            processingServlet = "/student/register";
//        }else if("/student/update.do".equals(servletPath)) {
//            processingServlet = "/student/update";
//        }else if("/student/delete.do".equals(servletPath)) {
//            processingServlet = "/student/delete";
//        }else if("/student/view.do".equals(servletPath)) {
//            processingServlet = "/student/view";
//        }
//        return processingServlet;
//    }
//}
