<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
	<jsp:include page="head.jsp"/>
<body>	
<div id="wrapper">
	<div id="header">
		<jsp:include page="title-box.jsp"/>
		<jsp:include page="login-box.jsp"/>
		<jsp:include page="menu-box.jsp"/>
	</div> <!-- header end -->
	<jsp:include page="content-box.jsp"/>
	<div id="footer">주소</div>
</div>
<script>
	common.main('${context}');
</script>
</body>
</html>

