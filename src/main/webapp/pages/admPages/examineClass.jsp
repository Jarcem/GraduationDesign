<%--
  Created by IntelliJ IDEA.
  User: Jarcem
  Date: 2018/10/25
  Time: 16:15
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
<table>
    <tr>
        <td style="text-align: center;">
            <a href="examineClass?state=audit" class="list-group-item active">待审核</a>
        </td>
        <td style="text-align: center;">
            <a href="examineClass?state=success" class="list-group-item active">已通过</a>
        </td>
        <td style="text-align: center;">
            <a href="examineClass?state=refuse" class="list-group-item active">已驳回</a>
        </td>
    </tr>
</table>
<br/>
<div class="pageBox" style="width: 100%;height: 800px; text-align: center;">
    <div class="pageBox" style="width: 100%; text-align: center;">
        <table style="width: 100%;">
            <tr>
                <td>编号</td>
                <td>学生编号</td>
                <td>教师编号</td>
                <td>成绩</td>
                <td>状态</td>
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
                    <td>
                        <a href="auditClass?cid=${score.sco_id}&state=dopass" target="main">通过</a>
                        <a href="auditClass?cid=${score.sco_id}}&state=dorefuse" target="main">驳回</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
