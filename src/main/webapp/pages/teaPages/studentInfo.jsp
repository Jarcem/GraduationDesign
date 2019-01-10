<%--
  Created by IntelliJ IDEA.
  User: Jarcem
  Date: 2018/10/28
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/css.css" />
    <link rel="stylesheet" href="../css/bootstrap.css" />
    <script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="../js/bootstrap.js"></script>
</head>

<body>
<br/>
<div class="pageBox" style="width: 100%;height: 800px; text-align: center;">
    <div class="pageBox" style="width: 100%; text-align: center;">
        <table style="width: 100%;">
            <tr>
                <td>ID</td>
                <td>姓名</td>
                <td>性别</td>
                <td>电话</td>
                <td>备注</td>
            </tr>
            <tr>
                <td><br></td>
            </tr>
            <c:forEach var="user" items="${userList}">
                <tr>
                    <td>${user.use_id}</td>
                    <td>${user.use_name}</td>
                    <td>${user.use_sex}</td>
                    <td>${user.use_telephone}</td>
                    <td>${user.reserve}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>

</html>