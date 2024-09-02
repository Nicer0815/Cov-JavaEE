<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- status,action -->
<html>
	<head>
		<meta charset="utf-8">
		<title>添加${status}</title>
	</head>
	<body>
		<div class="row">
			<form action="${action}" method="POST">
				<div class="row" style="text-align: center;">
					<h2>添加${status}</h2>
				</div>
				<div class="row" style="text-align: center;">
					用户名：<input style="margin-top: 50px;" type="text" name="username" autofocus>
				</div>
				<div class="row" style="text-align: center;">
					密码  ：<input style="margin-top: 15px; margin-bottom: 30px;" type="password" name="password">
				</div>
				<div class="row" style="text-align: center;">
					<button class="btn btn-md btn-info btn-block" type="button" onclick="window.location.href = 'index.jsp'">返回</button>
					<button class="btn btn-md btn-primary btn-block" type="submit">添加</button>
				</div>
			</form>
		</div>
	</body>
</html>