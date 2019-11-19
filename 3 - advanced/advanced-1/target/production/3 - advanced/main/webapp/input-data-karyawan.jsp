<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Input Data Karyawan</title>
</head>
<body>
<center>
    <h1>Input Data Karyawan</h1>
</center>

<div align="center">
    <form action="insert_employee" method="post">
        <table border="1" cellpadding="5">
            <tr>
                <th>Nama: </th>
                <td>
                    <input type="text" name="employeeName" size="45"
                           value=""
                    />
                </td>
            </tr>
            <tr>
                <th>ID Karyawan: </th>
                <td>
                    <input type="number" name="employeeID" size="45"
                           value=""
                    />
                </td>
            </tr>
            <tr>
                <th>Tanggal Masuk: </th>
                <td>
                    <input type="date" name="employeeEntryDate" size="45"
                           value=""
                    />
                </td>
            </tr>
            <tr>
                <th>Golongan: </th>
                <td>
                    <input type="text" name="employeeGroup" size="45"
                           value=""
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Simpan" />
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
