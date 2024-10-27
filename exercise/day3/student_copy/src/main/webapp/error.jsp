<%--
  Created by IntelliJ IDEA.
  User: joo
  Date: 2024. 10. 23.
  Time: 오후 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
    <title>Error Page</title>
    <link rel="stylesheet" href="/style.css" />
</head>
<body>
<table>
    <tbody>
    <tr>
        <th>status_code</th>
        <td>${status_code}</td>
    </tr>
    <tr>
        <th>exception_type</th>
        <td>${exception_type}</td>
    </tr>
    <tr>
        <th>message</th>
        <td>${message}</td>
    </tr>
    <tr>
        <th>exception</th>
        <td>${exception}</td>
    </tr>
    <tr>
        <th>request_uri</th>
        ${request_uri}
    </tr>
    </tbody>
</table>
</body>
</html>
