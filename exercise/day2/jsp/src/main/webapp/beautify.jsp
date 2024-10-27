<%--
  Created by IntelliJ IDEA.
  User: joo
  Date: 2024. 10. 22.
  Time: 오전 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/plan;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<jsp:useBean id="htmlBeautifier" scope="request" class="com.nhnacademy.jsp.beans.HtmlBeautifier" />
<jsp:setProperty name="htmlBeautifier" property="html" param="html" />
<jsp:getProperty name="htmlBeautifier" property="html" />
