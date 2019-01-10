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
    <script type="text/javascript" src="../../js/jquery-3.3.1.js"></script>
    <script>
        function getQueryVariable(variable) {
            var query = window.location.search.substring(1);
            var vars = query.split("&");
            for (var i = 0; i < vars.length; i++) {
                var pair = vars[i].split("=");
                if (pair[0] == variable) {
                    return pair[1];
                }
            }
            return (false);
        }
    </script>
</head>
<script>
    window.onload=function () {
        $("#urlPar").val(getQueryVariable("urlPar"));
        $("#uId").val(getQueryVariable("uid"));
    }
</script>
<body>
<div class="pageMenu">
    <div class="list-group">
        <a href="#" class="list-group-item active">
            个人信息
        </a>
        <a href="/userInfo" target="main" class="list-group-item">个人信息</a>
        <a href="#" class="list-group-item active">
            课程管理
        </a>
        <a href="/queryStudentInfo" target="main" class="list-group-item">学生信息</a>
        <a href="/teaScoreManage" target="main" class="list-group-item">成绩评定</a>
    </div>
</div>
</body>

</html>