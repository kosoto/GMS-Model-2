<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
<jsp:include page="common/gateFunction.jsp"/>
<jsp:include page="common/moveFunction.jsp"/>
<!-- body안에다가, 전역메소드 처리 -->
</body>
</html>
