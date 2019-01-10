<%--
  Created by IntelliJ IDEA.
  User: Jarcem
  Date: 2018/10/24
  Time: 18:25
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
						<h3>用户信息</h3></div>
				</div>
				<br />
				<form action="${action}" method="post">
					<input name="uid" type="text" class="list-group-item " style="text-align: center;width: 100%;" placeholder="用户ID" value="${usb.use_id}" />
					<input name="uname" type="text" class="list-group-item" style="text-align: center;width: 100%;" placeholder="姓名" value="${usb.use_name}" />
					<input name="usex" type="text" class="list-group-item" style="text-align: center;width: 100%;" placeholder="性别" value="${usb.use_sex}" />
					<input name="utype" type="text" class="list-group-item" style="text-align: center;width: 100%;" placeholder="请填写'student','teacher','admin'中的一种" value="${usb.use_type}" />
					<input name="utel" type="text" class="list-group-item" style="text-align: center;width: 100%;" placeholder="电话" value="${usb.use_telephone}" />
					<input name="upwd" type="text" class="list-group-item" style="text-align: center;width: 100%;" placeholder="密码" value="${usb.use_password}" />
					<input name="ure" type="text" class="list-group-item" style="text-align: center;width: 100%;" placeholder="备注" value="${usb.reserve}" />
					<br/>
					<button type="submit" class="list-group-item active" style="text-align: center;">提交</button>
				</form>
			</div>
		</div>
	</body>

</html>