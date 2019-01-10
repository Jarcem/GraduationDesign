<%--
  Created by IntelliJ IDEA.
  User: Jarcem
  Date: 2018/10/17
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<html>

	<head>
		<title>在线选课系统</title>
		<link href="../css/css.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<div class="wrapper">
			<div class="pageBox" style="text-align: center;width: 100%;">
				<p class="pageBoxTitle"><label>在 线 选 课 系 统</label></p>
			</div>
			<table>
				<tr>
					<td style="text-align: center;">
						<div class="pageBox" style="width: 170px;">
							<p class="pageBoxTitle">
								<label>目录</label>
							</p>
							<iframe frameborder="0" id="leftMenu" scrolling="auto" src="${leftmenuurl}" style="height: 720px; width: 170px;"></iframe>
						</div>
					</td>
					<td>
						<iframe frameborder="0" id="main" name="main" scrolling="auto" src="/userInfo" style="height: 800px; width: 1023px;"></iframe>
					</td>
				</tr>
			</table>
		</div>
	</body>

</html>