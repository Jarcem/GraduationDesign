<%@ page import="org.jarcem.Beans.UserInfoBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<title>在线选课系统</title>
		<link href="css/css.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery-3.3.1.js" ></script>
	</head>

	<body>
		<div class="wrapper">
			<div class="pageBox" style="text-align: center">
				<p class="pageBoxTitle"><label>用户登录</label></p>
			</div>

			<form action="userLogin" method="post">
				<div class="pageBox">
					<div class="pageBoxCenter">
						<p><label for="username">用户名：</label></p>
						<p><input type="text" id="username" name="username" class="pageInput" autofocus="autofocus" required="required" autocomplete="off" placeholder="请输入用户名" value="" /></p>
						<p><label for="password">密码</label>
							<p><input type="password" id="password" name="password" class="pageInput" required="required" placeholder="请输入密码" value="" /></p>
					</div>
					<div class="pageBoxButtons">
						<button type="submit" class="pageBtn">登录</button>
					</div>
				</div>
			</form>
			<div class="pageBox" style="text-align: center">
				<p class="pageBoxTitle"><label>现有的基础账户</label></p>
				<label>管理员 - 账号: 123 -- 密码: 123</label><br />
				<label>教师 - 账号: 1234 -- 密码: 1234</label><br />
				<label>学生 - 账号: 12345 -- 密码: 12345</label><br />
			</div>
		</div>
	</body>

</html>