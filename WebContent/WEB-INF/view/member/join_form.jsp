<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String ctx = application.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>회원가입화면</title>
	<link rel="stylesheet" href="resources/css/style.css" />
</head>
<body>
	<div class="margin-200-auto text-align width-200 border">
		<h2 class="text-align">회원가입</h2>
		<form action="<%=ctx %>/member.do">
		ID<br>
		<input type="text" name="user-id"/><br>
		비밀번호<br>
		<input type="text" name="pass" /><br>
		이름 <br>
		<input type="text" name="name"/><br>
		주민번호<br>
		<input type="text" name="ssn" /><br>	
		<input type="hidden" name="action" value="move"/>
		<input type="hidden" name="page" value="join_result"/>
		<input type="submit" value="제출"/>
		</form>
	</div>
	
</body>
</html>