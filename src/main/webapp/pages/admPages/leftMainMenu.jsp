<%--
  Created by IntelliJ IDEA.
  User: Jarcem
  Date: 2018/10/18
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" isELIgnored="false" %>
<html style="background-color: #FEFEFE;">

<head>
    <title>Title</title>
    <link href="../../css/css.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="../../css/bootstrap.css"/>
    <script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="../js/bootstrap.js"></script>
</head>

<body>
<div class="pageMenu">
    <div class="list-group">
        <a href="#" class="list-group-item active">
            用户管理
        </a>
        <a href="/userInfo" target="main" class="list-group-item">个人信息</a>
        <a href="/queryUser" target="main" class="list-group-item">查询用户</a>
        <a href="/addUser" target="main" class="list-group-item">新增用户</a>
        <a href="#" class="list-group-item active">
            选课管理
        </a>
        <a href="/queryClass" target="main" class="list-group-item">查询课程</a>
        <a href="/examineClass" target="main" class="list-group-item">选课审核</a>
        <a href="/addNewClass" target="main" class="list-group-item">新增课程</a>
        <a href="#" class="list-group-item active">
            成绩管理
        </a>
        <a href="/scoreManage" target="main" class="list-group-item">成绩管理</a>
    </div>
</div>
</body>

</html>