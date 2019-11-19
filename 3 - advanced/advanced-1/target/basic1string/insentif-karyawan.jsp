<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Insentif Karyawan</title>
</head>
<body>
<center>
    <h1>Insentif Karyawan</h1>
    <div>
        <h3>
            <div>
                <a href="list">Daftar Karyawan</a>
            </div>
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
        <caption>Tabel Insentif Karyawan</caption>
        <tr>
            <th>ID Karyawan</th>
            <td><c:out value="${employeeProfileWithIncentive.id}" /></td>
        </tr>
        <tr>
            <th>Nama</th>
            <td><c:out value="${employeeProfileWithIncentive.name}" /></td>
        </tr>
<%--        <tr>--%>
<%--            <th>Tanggal Masuk</th>--%>
<%--            <td><c:out value="${employeeProfileWithIncentive.entryDate}" /></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <th>Golongan</th>--%>
<%--            <td><c:out value="${employeeProfileWithIncentive.employeeGroup}" /></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <th>Gaji per Bulan</th>--%>
<%--            <td>Rp<c:out value="${employeeProfileWithIncentive.monthlySalary}" /></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <th>Persentase Insentif</th>--%>
<%--            <td><c:out value="${employeeProfileWithIncentive.incentivePercentage}" /></td>--%>
<%--        </tr>--%>
        <tr>
            <th>Nominal Insentif</th>
            <td>Rp<c:out value="${employeeProfileWithIncentive.incentiveNominal}" /></td>
        </tr>
    </table>
</div>
</body>
</html>
