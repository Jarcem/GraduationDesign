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
		<link href="../../css/css.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="../../css/bootstrap.css" />
	</head>

	<body>
		<div class="pageMenu">
			<div class="list-group">
				<a href="#" class="list-group-item active">
					个人信息
				</a>
				<a href="/userInfo" target="main" class="list-group-item">个人信息</a>
				<a href="#" class="list-group-item active">
					在线选课
				</a>
				<a href="/classScore" target="main" class="list-group-item">课程信息</a>
				<a href="/applyClass" target="main" class="list-group-item">申请课程</a>
			</div>
		</div>
	</body>

</html>