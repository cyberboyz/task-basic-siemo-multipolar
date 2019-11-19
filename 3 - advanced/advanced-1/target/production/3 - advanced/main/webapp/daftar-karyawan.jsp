<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Data Karyawan</title>
</head>
<body>
<center>
    <h1>Data Karyawan</h1>
    <div>
        <h3>
        <div>
            <a href="new_employee">Tambahkan Karyawan Baru</a>
        </div>
        <div>
            <a href="new_employee_group">Tambahkan Golongan Baru</a>
        </div>
        </h3>
    </div>
</center>

<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Daftar Karyawan</h2></caption>
        <tr>
            <th>ID Karyawan</th>
            <th>Nama</th>
            <th>Tanggal Masuk</th>
            <th>Golongan</th>
            <th>Gaji per Bulan</th>
            <th>Insentif</th>
        </tr>
        <c:forEach var="employee" items="${employeeList}">
            <tr>
                <td><c:out value="${employee.employee.id}" /></td>
                <td><c:out value="${employee.employee.name}" /></td>
                <td><c:out value="${employee.employee.entryDate}" /></td>
                <td><c:out value="${employee.employee.group}" /></td>
                <td>Rp<c:out value="${employee.employeeGroup.monthlySalary}" /></td>
                <td><a href="incentive?id=<c:out value="${employee.employee.id}" />">Insentif <c:out value="${employee.employee.name}" /></a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
