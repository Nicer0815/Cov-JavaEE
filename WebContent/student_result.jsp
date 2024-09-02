<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>上传检测结果</title>
	</head>
	<script>
		function scan(){
			if("${state}" == "阴性"){
				document.getElementById("res").style.color='green';
			}
		}
	</script>
	<body onload="scan()">
		<div class="row">
			<form action="#" method="POST">
				<div class="row" style="text-align: center;">
					<h4 style="color:black;">学生查询页面：</h4>
				</div>
				<div class="row" style="text-align: center;">
					<h5 id="res" style="color: red;">采样结果：${state}</h5>
				</div>
				<div class="row" style="text-align: center;">
					<input type="hidden" name="opt" id="opt" value="del">
					学号：<input style="margin-top: 50px;" type="text" value="${studentID}" readonly>
				</div>
				<div class="row" style="text-align: center;">
					姓名：<input style="margin-top: 20px;margin-bottom: 20px;" type="text" value="${studentName}" readonly>
				</div>
				<div class="row" style="text-align: center;">
					采集时间：<input style="margin-top: 20px;margin-bottom: 20px;" type="text" value="${operateTime}" readonly>
				</div>
				<div class="row" style="text-align: center;">
					检测时间：<input style="margin-top: 20px;margin-bottom: 20px;" type="text" value="${resultTime}" readonly>
				</div>
				<div class="row" style="text-align: center;">
					<button class="btn btn-md btn-info btn-block" type="button" onclick="window.location.href = 'index.jsp'">返回</button>
				</div>
			</form>
		</div>
	</body>
</html>