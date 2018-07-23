<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="<%=application.getContextPath() %>" />
<div id="menu-box">
	<ul id="menu">
		<li><a href="">HOME</a></li>
		<li><a href="">ABOUT</a></li>
		<li><a href="${context}/admin.do?action=move&page=main">ADMIN</a></li>
	</ul>
</div>