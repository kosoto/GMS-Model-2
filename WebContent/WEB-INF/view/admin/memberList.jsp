<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<jsp:include page="head.jsp"/>
<body>	
<div id="wrapper">
	<div id="header">
		<jsp:include page="../common/title-box.jsp"/>
		<jsp:include page="menu-box.jsp"/>
	</div> 
	<div id="content">
	<script>
	alert('${list}');
	</script>
	</div>
	<div id="footer">주소</div>
</div>

</body>
</html>