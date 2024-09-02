<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>确认被测者</title>
	</head>
	<script>
		function setCancel(){
			document.getElementById("option").value='cancel';
		}
	</script>
	<body>
		<div class="container">
			<div class="row">
			<form action="/Cov/whiteManage" method="POST">
				<div class="row" style="margin-top: 50px;text-align: center;">
					<h4 style="color:red ;">请确认删除编号：</h4>
				</div>
				<input type="hidden" name="option" id="option" value="del">
		        <div class="row" style="margin-top: 10px;text-align: center;">
					编号：<input style="margin-top: 50px;margin-bottom: 20px;" type="text" name="studentID">
		        </div>
				<div class="row" style="margin-top: 30px;text-align: center;">
					<button class="btn btn-md btn-info btn-block" onclick="setCancel();">取消删除</button>
					<button class="btn btn-md btn-danger btn-block" type="submit">确认删除</button>
				</div>
			</form>

			</div>
		</div>
	</body>
</html>