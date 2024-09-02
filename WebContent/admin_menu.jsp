<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>管理员界面</title>
	</head>
	<script>
		function setWhite(){
			document.getElementById("option").value="white";
		}
		function setCheck(){
			document.getElementById("option").value="check";
		}
	</script>
	<body>
		<div class="row">
			<!-- 处理Servlet控制跳转信息 -->
			<form action="/Cov/AddDispatcher">
				<input type="hidden" name="option" id="option"/>
				<div class="row" style="margin-top: 60px;text-align: center;">
					<button style="align: center;" onclick="setWhite()">添加大白用户</button>
				</div>
				<div class="row" style="margin-top: 30px;text-align: center;">
					<button style="align: center;" onclick="setCheck()">添加上传用户</button>
				</div>
				<div class="row" style="margin-top: 30px;text-align: center;">
					<button style="align: center;" type="button" onclick="window.location.href = 'index.jsp'">--  返回  --</button>
				</div>
			</form>
		</div>
	</body>
</html>