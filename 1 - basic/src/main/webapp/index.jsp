<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Basic 1 - String</title>
</head>
<body>
<center>
    <h1>Basic 1 - String</h1>
</center>

<div align="center">
    <form action="insert" method="post">
        <table border="1" cellpadding="5">
            <tr>
                <th>Input String: </th>
                <td>
                    <input type="text" name="inputString" size="45"
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
