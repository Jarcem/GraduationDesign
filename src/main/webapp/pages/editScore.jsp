<%--
  Created by IntelliJ IDEA.
  User: Jarcem
  Date: 2018/10/27
  Time: 17:09
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
                <h3>成绩信息</h3></div>
        </div>
        <br />
        <form action="editScore" method="post">
            <input name="scid" type="text" class="list-group-item " style="text-align: center;width: 100%;" placeholder="编号" value="${score.sco_id}" />
            <input name="sid" type="text" class="list-group-item " style="text-align: center;width: 100%;" placeholder="学生编号" value="${score.stu_id}" />
            <input name="cid" type="text" class="list-group-item" style="text-align: center;width: 100%;" placeholder="课程ID" value="${score.cla_id}" />
            <input name="sco" type="text" class="list-group-item" style="text-align: center;width: 100%;" placeholder="请填写成绩" value="${score.score}" />
            <br/>
            <button type="submit" class="list-group-item active" style="text-align: center;">提交</button>
        </form>
    </div>
</div>
</body>

</html>