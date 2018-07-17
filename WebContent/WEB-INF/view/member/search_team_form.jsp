<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String ctx = request.getContextPath();
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
	<h2 class="text-align">팀이름으로 검색</h2>
		<form action="<%=ctx %>/member/search_team_result.do">
		팀 이름 <br>
		<input type="text" name="team_id"/><br>
		<input type="submit" value="제출" />
		</form>
	</div>
</body>
</html>