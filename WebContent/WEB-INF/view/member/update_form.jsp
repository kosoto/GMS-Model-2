<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String ctx = request.getContextPath(); %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
	<link rel="stylesheet" href="resources/css/style.css" />
</head>
<body>
<div class="margin-200-auto text-align width-200 border">
	<h3 class="text-align">비밀번호 변경</h3>
	<form action="<%=ctx %>/member.do?">
	ID <br>
	<input type="text" name="user-id"/><br>
	이전 비밀번호 <br>
	<input type="text" name="pass"/><br>
	새로운 비밀번호 <br>
	<input type="text" name="newPass"/><br>
	<input type="hidden" name="action" value="move"/>
	<input type="hidden" name="page" value="update_result"/>
	<input type="submit" value="제출" />
	</form>
</div>
</body>
</html>