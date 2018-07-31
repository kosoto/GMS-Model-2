<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="menu-box">
	<ul id="menu">
		<li><a href="${context}">HOME</a></li>
		<li><a href="${context}/admin.do?action=move&page=main">ADMIN HOME</a></li>
		<li><a href="${context}/admin.do?action=search&page=memberList">MEMBER LIST</a></li>
		<li><a href="${context}/admin.do?action=search&page=main">FIND BY TEAM ID</a></li>
		<li><a href="${context}/admin.do?action=retrieve&page=main">FIND BY ID</a></li>
	</ul>
</div>