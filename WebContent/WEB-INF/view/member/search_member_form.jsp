<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String ctx = application.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
	<link rel="stylesheet" href="resources/css/style.css" />
</head>
<body>
	<div class="margin-200-auto text-align width-200 border">
		<h2 class="text-align">아이디로 찾기</h2>	
		<form action="<%=ctx %>/member.do">
		ID<br>
		<input type="text" name="user_id" /><br>
		<input type="hidden" name="action" value="retrieve"/>
		<input type="hidden" name="page" value="search_member_result"/>
		<input type="submit" value="제출" />
		</form>
	</div>
</body>
</html>