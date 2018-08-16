<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp"/>
<body>	
<div id="wrapper">
	<div id="header">
		<h1>멤버 페이지</h1>
		<div id="menu-box">
			<ul id="menu">
				<li><a id="moveHome">HOME</a></li>
			</ul>
		</div>
	</div>
	<div id="content-box">
	<c:choose>
		<c:when test="${pagename eq 'add'}">
			<jsp:include page="add.jsp"/>
		</c:when>
		<c:when test="${pagename eq 'login'}">
			<jsp:include page="login.jsp"/>
		</c:when>
		<c:when test="${pagename eq 'modify'}">
			<jsp:include page="modify.jsp"/>
		</c:when>
		<c:when test="${pagename eq 'remove'}">
			<jsp:include page="remove.jsp"/>
		</c:when>
		<c:otherwise>
			<jsp:include page="retrieve.jsp"/>
		</c:otherwise>
	</c:choose>
	</div>
</div>
<script>
	members.main(
			{context : '${context}',
			pagename : '${pagename}',
			teamId   : '${user.teamId}',
			roll 	 : '${user.roll}',
			pass     : '${user.pass}'
			}
			);
</script>
</body>
</html>