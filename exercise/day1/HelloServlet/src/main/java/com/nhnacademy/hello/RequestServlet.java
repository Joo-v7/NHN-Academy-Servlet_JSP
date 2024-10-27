package com.nhnacademy.hello;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@Slf4j
public class RequestServlet extends  HttpServlet {

    /* Day1 - 9 */
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/plain");
//        resp.setCharacterEncoding("UTF-8");
//
//        try(PrintWriter out = resp.getWriter()) {
//            out.println("locale=" + req.getLocale());
//            out.println("parameter name=" + req.getParameter("userId"));
//            out.println("content type=" + req.getContentType());
//            out.println("content length=" + req.getContentLength());
//            out.println("method=" + req.getMethod());
//            out.println("servlet path=" + req.getServletPath());
//            out.println("request uri=" + req.getRequestURI());
//            out.println("request url=" + req.getRequestURL());
//            out.println("User-Agent header=" + req.getHeader("User-Agent"));
//        }catch (Exception e) {
//            log.error("/req : {}", e.getMessage(), e);
//        }
//    }

    /* Day2 - 10 */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // buffer size 지정: 1024 byte 이하는 바로 전송, 그 이상은 출력 버퍼가 가득 차기 전까지 데이터를 쌓은 후 한 번에 전송.
        log.info("default buffer size: {}", resp.getBufferSize());
        resp.setBufferSize(1024);

        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");

        try(PrintWriter out = resp.getWriter()){

            out.println("locale=" + req.getLocale());
            out.println("parameter name=" + req.getParameter("name"));

            String userId = req.getParameter("userId");
            log.info("user id: {}", userId);
            if (userId == null || userId.isEmpty()) {
                resp.reset();

                resp.setStatus(500);
                resp.sendError(500, "name is empty");
                return;
            }

            String redirect = req.getParameter("redirect");
            if(Objects.nonNull(redirect)) {
                resp.sendRedirect(redirect);
                return;
            }
            out.println("method=" + req.getMethod());
            out.println("request uri=" + req.getRequestURI());

            resp.resetBuffer();

            out.println("User-Agent header=" + req.getHeader("User-Agent"));
        }catch(Exception e) {
            log.error("/req: {}", e.getMessage(), e);
        }
    }
}
