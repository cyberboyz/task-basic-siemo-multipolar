<%--
  Created by IntelliJ IDEA.
  User: fattah.rahadian
  Date: 14/11/2019
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Collection - Tampilan 1</title>
    </head>
    <body>
        <div align="center">
            <h1>Collection - Tampilan 1</h1>
            <table border="1" cellpadding="5">
                <tr>
                    <th>ID</th>
                    <th>Nama</th>
                    <th>Tanggal Masuk</th>
                    <th>Detail</th>
                </tr>
                <c:forEach var="employee" items="${employees}">
                    <tr>
                        <td><c:out value="${employee.id}" /></td>
                        <td><c:out value="${employee.name}" /></td>
                        <td><c:out value="${employee.date}" /></td>
                        <td><a href="golongan?id=<c:out value="${employee.id}" />">golongan</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>