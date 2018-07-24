<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
	<link rel="stylesheet" href="resources/css/style.css" />
</head>
<body>
<div>
	<h3>비밀번호 변경</h3>
	<form action="${context}/member.do?" onsubmit="return gate()"
	method="get">
	ID <br>
	<input type="text" name="user-id"/><br>
	이전 비밀번호 <br>
	<input type="text" name="pass"/><br>
	새로운 비밀번호 <br>
	<input type="text" name="newPass"/><br>
	<input type="hidden" name="action" value="update"/>
	<input type="hidden" name="page" value="my_page"/>
	<input type="submit" value="제출" />
	</form>
</div>
<jsp:include page="../common/gateFunction.jsp"/>
</body>
</html>