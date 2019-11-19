<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fattah.rahadian
  Date: 14/11/2019
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Collection - Tampilan 2</title>
</head>
<body>
<div align="center">
    <h1>Collection - Tampilan 2</h1>
    <table border="1" cellpadding="5">
        <tr>
            <th>Golongan</th>
            <th>Gaji</th>
        </tr>
        <tr>
            <td><c:out value="${employee.employeeGroup.employeeGroup}" /></td>
            <td><c:out value="${employee.employeeGroup.monthlySalary}" /></td>
        </tr>
    </table>
</div>
</body>
</html>