<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="<%=application.getContextPath() %>" />
<div id="menu-box">
	<ul id="menu">
		<li><a href="${context}/admin.do?action=search&page=memberList">MEMBER LIST</a></li>
		<li><a href="${context}/admin.do?action=search&page=main">FIND BY TEAM ID</a></li>
		<li><a href="${context}/admin.do?action=retrieve&page=main">FIND BY ID</a></li>
	</ul>
</div>