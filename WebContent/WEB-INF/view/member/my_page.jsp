<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="domain.*" %>
<%
	MemberBean member = (MemberBean) request.getAttribute("user");
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
		<h2 class="text-align"><%=member.getName()%>의 마이 페이지</h2>
		<a onclick="move('member','move','update_form')">비밀번호 변경</a>
		<a onclick="move('member','move','delete_form')">회원탈퇴</a>
	</div>
<jsp:include page="../common/moveFunction.jsp"/>
</body>
</html>