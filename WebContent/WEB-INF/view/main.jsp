<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="<%=application.getContextPath() %>" />
<!doctype html>
<html lang="en">
	<jsp:include page="common/head.jsp"/>
<body>	
<div id="wrapper">
	<div id="header">
		<jsp:include page="common/title-box.jsp"/>
		<jsp:include page="common/login-box.jsp"/>
		<jsp:include page="common/menu-box.jsp"/>
	</div> <!-- header end -->
	<jsp:include page="common/content-box.jsp"/>
	<div id="footer">주소</div>
</div>
</body>
</html>