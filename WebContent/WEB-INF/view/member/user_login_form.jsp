<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<form action="${context}/member.do" onsubmit="return gate()" method="get">
			ID <br>
			<input type="text" name="user-id" ><br>
			Pass <br>
			<input type="text" name="pass"  ><br>
			<input type="hidden" name="action" value="login"/>
			<input type="hidden" name="page" value="my_page"/>
			<input type="submit" value="제출">
		</form><br>
	</div>
	<jsp:include page="../common/gateFunction.jsp"/>
</body>
</html>