<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>学生注册界面</title>
	</head>
	<body>	
		<div class="row">
		<form action="/Cov/studentRegister" method="POST">
			<div class="row" style="margin-top: 30px;text-align: center;">
				<h2>学生注册</h2>
			</div>
			<input type="hidden" name="option" value="register">
			<div class="row" style="margin-top: 30px;text-align: center;">
				学号：<input style="margin-top: 50px;" type="text" name="username" autofocus>
			</div>
			<div class="row" style="margin-top: 30px;text-align: center;">
				姓名：<input style="margin-top: 15px;" name="name" id="name" class="form-control">
			</div>
			<div class="row" style="margin-top: 30px;text-align: center;">
				密码：<input style="margin-top: 15px; margin-bottom: 30px;" type="password" name="password">
			</div>
			<div class="row" style="margin-top: 30px;text-align: center;">
				<button type="button" onclick="window.location.href = 'index.jsp'">返回</button>
				<button  type="submit">注册</button>
			</div>
		</form>
		</div>
		
	</body>
</html>