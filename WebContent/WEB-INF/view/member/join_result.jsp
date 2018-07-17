<%@ page import="service.*"%>
<%@ page import="repository.*"%>
<%@ page import="domain.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String ctx = request.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>회원가입결과</title>
</head>
<body>
	<button><a href="<%=ctx %>/member.do?action=move&page=user_login_form">로그인하기</a></button>
</body>
</html>