<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- list{inTube_ID,studentId,studentName,tubeID},tubeid -->
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>核酸采集界面</title>
	</head>
	<body>
		<div class="row" style="margin-top: 10px;text-align: center;">
			<table class="table"  style="margin:auto;">
				<thead>
				<tr>
				  <th>序号</th>
				  <th>学号</th>
				  <th>姓名</th>
				  <th>试管</th>
				</tr>
			  </thead>
				<c:forEach items="${list}" var="user">
					<tr>
					 <td>${user.inTube_ID}</td>
					 <td>${user.studentId}</td>
					 <td>${user.studentName}</td>
					 <td>${user.tubeID}</td>
					</tr>
				</c:forEach>
			</table>
			<form action="/Cov/whiteManage" method="POST">
				<input type="hidden" name="option" id="option" value="submit">
				<button class="btn" type = "submit">提交试管</button>
			</form>
		</div>
	
		
		<div class="row">
			<form action="/Cov/restful" method="GET">
				<div class="row" style="margin-top: 30px;text-align: center;">
					试管编号：<input style="margin-top: 50px;" value="${tubeid}" type="text" name="tubeid" id="tubeid" autofocus>
				</div>
				<div class="row" style="margin-top: 30px;text-align: center;">
					学号：<input style="margin-top: 15px; margin-bottom: 30px;" name="studentID">
				</div>
				<div class="row" style="margin-top: 30px;text-align: center;">
					<button class="btn btn-md btn-info btn-block" type="button" onclick="window.location.href = 'index.jsp'">返回</button>
					<button class="btn btn-md btn-primary btn-block" type="submit">添加被测者</button>
					<button class="btn btn-danger" type = "button" onclick="window.location.href = 'white_delete.jsp'">删除被测者</button>
				</div>
			</form>
		</div>
		
	</body>
</html>