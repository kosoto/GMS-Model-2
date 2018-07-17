<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String ctx = application.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>user-login</title>
	<link rel="stylesheet" href="resources/css/style.css" />
</head>
<body>
	<div class="margin-200-auto text-align width-200 border">
	<h2 class="text-align">사용자 로그인</h2>	
		<form action="<%=ctx%>/member.do">
			ID <br>
			<input type="text" name="user-id" ><br>
			Pass <br>
			<input type="text" name="pass"  ><br>
			<input type="hidden" name="action" value="move"/>
			<input type="hidden" name="page" value="user_login_result"/>
			<input type="submit" value="제출">
		</form><br>
	</div>
</body>
</html>