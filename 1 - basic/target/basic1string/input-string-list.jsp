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
<%--<div align="center">--%>
<%--    <form action="insert" method="post"></form>--%>
<%--        <input name="stringInput" type="text" value="" /> <br />--%>
<%--        <input name="stringOutput" type="text" value="<c:out value='${basic.output}' />" /> <br />--%>
<%--        <input type="submit" value="Save" />--%>
<%--        <button type="submit" value="Save">Simpan</button>--%>
<%--        <button type="submit" value="Filter">Filter</button>--%>
<%--    </form>--%>
<%--</div>--%>

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
    <table border="1" cellpadding="5">
        <tr>
            <th>Last Output String: </th>
            <td>
                <textarea rows="4" cols="50"><c:out value="${lastInputString.output}" /></textarea>
            </td>
        </tr>
    </table>
</div>

<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Input Strings</h2></caption>
        <tr>
            <th>No</th>
            <th>Input</th>
            <th>Output</th>
            <th>Tanggal Proses</th>
            <th>Kata Berulang</th>
        </tr>
        <c:forEach var="inputString" items="${listInputString}">
            <tr>
                <td><c:out value="${inputString.id}" /></td>
                <td><c:out value="${inputString.input}" /></td>
                <td><c:out value="${inputString.output}" /></td>
                <td><c:out value="${inputString.processingDate}" /></td>
                <td><c:out value="${inputString.repeatedWords}" /></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
