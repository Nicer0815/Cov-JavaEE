<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- null -->
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>上传检测结果</title>
	</head>
	<body>
		<form action="/Cov/checkerManage" method="POST">
			<div class="row" style="margin-top: 30px;text-align: center;">
				<h4>检测结果上传：</h4>
			</div>
			<input type="hidden" name="opt" id="opt" value="del">
			<div class="row" style="margin-top: 10px;text-align: center;">
				<input style="margin-top: 50px;margin-bottom: 20px;" type="text" name="tubeID" required>
				<select name="state">
				  <option value ="阴性" style="color: green;">阴性</option>
				  <option value ="阳性" style="color: red;">阳性</option>
				</select>
			</div>
			<div class="row" style="margin-top: 30px;text-align: center;">
				<button class="btn btn-md btn-info btn-block" type="button" onclick="window.location.href = 'index.jsp'">返回</button>
				<button class="btn btn-md btn-danger btn-block" type="submit">提交</button>
			</div>
		</form>
	</body>
</html>