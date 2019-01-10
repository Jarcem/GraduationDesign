<%--
  Created by IntelliJ IDEA.
  User: Jarcem
  Date: 2018/10/24
  Time: 21:22
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
                <td>课程ID</td>
                <td>课程名称</td>
                <td>教师ID</td>
                <td>操作</td>
            </tr>
            <tr>
                <td><br></td>
            </tr>
            <c:forEach var="clas" items="${classList}">
                <tr>
                    <td>${clas.cla_id}</td>
                    <td>${clas.cla_name}</td>
                    <td>${clas.tea_id}</td>
                    <td>
                        <a href="/editClass?cid=${clas.cla_id}" target="main">编辑</a>
                        <a href="/delClass?cid=${clas.cla_id}}">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>