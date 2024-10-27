<%--
  Created by IntelliJ IDEA.
  User: joo
  Date: 2024. 10. 22.
  Time: 오전 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@page%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Objects" %>
<html>
<head>
    <title>sessionCounter</title>
</head>
<body>
  <%
    Long counter = 0l;
    if(Objects.nonNull(session.getAttribute("counter"))){
      counter = (Long) session.getAttribute("counter");
    }
    session.setAttribute("counter", ++counter);
  %>
<h1>
  counter:<%=counter%>
</h1>
</body>
</html>
