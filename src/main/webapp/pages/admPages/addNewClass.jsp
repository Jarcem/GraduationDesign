<%--
  Created by IntelliJ IDEA.
  User: Jarcem
  Date: 2018/10/24
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../css/css.css" />
    <link rel="stylesheet" href="../../css/bootstrap.css" />
    <script type="text/javascript" src="../../js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="../../js/bootstrap.js"></script>
</head>

<body>
<div class="pageBox" style="width: 100%;height: 800px; text-align: center;">
    <div class="list-group" style="margin-top: 10px;">
        <div class="pageBox">
            <div class="pageBoxTitle">
                <h3>课程信息</h3></div>
        </div>
        <br />
        <form action="${action}" method="post">
            <input name="cname" type="text" class="list-group-item" style="text-align: center;width: 100%;" placeholder="课程名称" value="${clas.cla_name}" />
            <input name="cid" type="hidden" value="${clas.cla_id}" />
            <input name="tid" type="text" class="list-group-item" style="text-align: center;width: 100%;" placeholder="授课教师ID" value="${clas.tea_id}" />
            <br/>
            <button type="submit" class="list-group-item active" style="text-align: center;">提交</button>
        </form>
    </div>
</div>
</body>
</html>
