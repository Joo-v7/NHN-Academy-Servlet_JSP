<%--
  Created by IntelliJ IDEA.
  User: joo
  Date: 2024. 10. 22.
  Time: 오후 10:15
  To change this template use File | Settings | File Templates.
--%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
    <html>
    <head>
      <title>Student - Register</title>
        <link rel="stylesheet" href="/style.css" />
    </head>
    <body>
    <c:choose>
        <c:when test="${empty student}">
            <c:set var="action" value="/student/register.do" />
        </c:when>
        <c:otherwise>
            <c:set var="action" value="/student/update.do" />
        </c:otherwise>
    </c:choose>

    <form method="post" action="${action}">
        <table>
            <tbody>
            <tr>
                <th>ID</th>
                <td><input type="text" name="id" value="${student.id}" required /></td>
            </tr>
            <tr>
                <th>이름</th>
                <td><input type="text" name="name" value="${student.name}" required /></td>
            </tr>
            <tr>
                <th>성별</th>
                <td>
                    <input type="radio" name="gender" value="MALE" ${student.gender eq 'MALE' ? 'checked' : '' } />남
                    <input type="radio" name="gender" value="FEMALE" ${student.gender eq 'FEMALE' ? 'checked' : '' } />여
                </td>
            </tr>
            <tr>
                <th>나이</th>
                <td><input type="number" name="age" value="${student.age}" required /></td>
            </tr>
            </tbody>
        </table>
        <p>
            <button type="submit">
                <c:choose>
                    <c:when test="${empty student}">
                        등록
                    </c:when>
                    <c:otherwise>
                        수정
                    </c:otherwise>
                </c:choose>
            </button>
        </p>
    </form>
    </body>
    </html>

<%--내가한거--%>
<%--<h1>학생 등록</h1>--%>
<%--<form method="post" action="${action}">--%>
<%--    <table>--%>
<%--        <tbody>--%>
<%--        <tr>--%>
<%--            <th>ID</th>--%>
<%--            <td><input type="text" name="id" value="${student.id}" required/></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <th>이름</th>--%>
<%--            <td><input type="text" name="name" value="${student.name}" required/></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <th>성별</th>--%>
<%--            <td>--%>
<%--                <label><input type="radio" name="gender" value="MALE" required--%>
<%--                              <c:if test="${student.gender == 'MALE'}">checked</c:if>--%>
<%--                />남</label>--%>
<%--                <label><input type="radio" name="gender" value="FEMALE" required--%>
<%--                              <c:if test="${student.gender == 'FEMALE'}">checked</c:if>--%>
<%--                />여</label>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <th>나이</th>--%>
<%--            <td><input type="text" name="age" value="${student.age}" required/></td>--%>
<%--        </tr>--%>
<%--        </tbody>--%>
<%--    </table>--%>
<%--    <p>--%>
<%--        <button type="submit">--%>
<%--            <c:choose>--%>
<%--                <c:when test="${empty student}">등록</c:when>--%>
<%--                <c:otherwise>수정</c:otherwise>--%>
<%--            </c:choose>--%>
<%--        </button>--%>
<%--    </p>--%>
<%--</form>--%>