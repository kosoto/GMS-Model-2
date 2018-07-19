<%@page import="service.MemberServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "domain.*" %>
<%@ page import="java.util.*" %>
<%
	String ctx = application.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
	<style>
	table, tr, td, th {border: 1px solid black}
	</style>
</head>
<body>
	<a href="<%=ctx%>/member.do?action=search">회원목록</a>
</body>
</html>








