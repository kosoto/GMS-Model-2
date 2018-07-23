<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="<%=application.getContextPath() %>" />
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>ADMIN</title>
	<link rel="stylesheet" href="${context}/resources/css/style.css" />
</head>
<body>	
<div id="wrapper">
	<div id="header">
		<jsp:include page="../common/title-box.jsp"/>
		<jsp:include page="menu-box.jsp"/>
	</div> <!-- header end -->
	<jsp:include page="content-box.jsp"/>
	<div id="footer">주소</div>
</div>

</body>
</html>