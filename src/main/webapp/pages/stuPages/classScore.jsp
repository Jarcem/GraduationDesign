<%--
  Created by IntelliJ IDEA.
  User: Jarcem
  Date: 2018/10/27
  Time: 19:47
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
                <td>编号</td>
                <td>学生编号</td>
                <td>课程编号</td>
                <td>成绩</td>
                <td>申请状态</td>
            </tr>
            <tr>
                <td><br></td>
            </tr>
            <c:forEach var="score" items="${scoreList}">
                <tr>
                    <td>${score.sco_id}</td>
                    <td>${score.stu_id}</td>
                    <td>${score.cla_id}</td>
                    <td>${score.score}</td>
                    <td>${score.state}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>