<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="content">
	<div id="content-box">
	<table id="contentBoxTab">
		<tr id="contentBoxMeta">
			<th>아이디</th>
			<th>이 름</th>
			<th>나 이</th>
			<th>성 별</th>
			<th>역 활</th>
			<th>팀 명</th>
		</tr>
		<c:forEach items="${list}" var="member">
		<tr>
			<td>${member.memberId}</td>
			<%-- <td><a href="${context}/admin.do?action=retrieve&page=memberDetail&user_id=${member.memberId}" style="cursor: pointer;">${member.name}</a></td> --%> <!-- 이렇게 하지 말자 -->
			<td><a class="username" id="${member.memberId}">${member.name}</a></td>
			<td>${member.age}</td>
			<td>${member.gender}</td>
			<td>${member.roll}</td>
			<td>${member.teamId}</td>
		</tr>
		</c:forEach>
	</table>
		<h1>ADMIN MANGEMENT</h1>
	</div>
</div>
<script>
document.getElementById('contentBoxMeta').className = 'bgColorisYellow';
var x = document.querySelectorAll('.username');
for(i in x){
	x[i].style.color = 'blue';
	x[i].style.cursor = 'pointer';
	x[i].addEventListener('click',function(){
		location.href =
			"${context}"
			+"/admin.do?action=retrieve&page=memberDetail&user_id="
			+this.getAttribute('id');//콜백함수에서의 this는 이 함수를 호출한 객체
	});	
}
</script>








