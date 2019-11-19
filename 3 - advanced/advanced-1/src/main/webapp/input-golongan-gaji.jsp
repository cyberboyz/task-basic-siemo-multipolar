<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Input Golongan dan Gaji Karyawan</title>
</head>
<body>
<center>
    <h1>Input Golongan dan Gaji Karyawan</h1>
</center>

<div align="center">
    <form action="insert_employee_group" method="post">
        <table border="1" cellpadding="5">
            <tr>
                <th>Golongan: </th>
                <td>
                    <input type="text" name="employeeGroup" size="45"
                           value=""
                    />
                </td>
            </tr>
            <tr>
                <th>Gaji: </th>
                <td>
                    <input type="number" name="monthlySalary" size="45"
                           value=""
                    />
                </td>
            </tr>
            <tr>
                <th>Persentase Insentif: </th>
                <td>
                    <input type="number" name="incentivePercentage" size="45"
                           value="" step="0.01"
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
