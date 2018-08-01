<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="menu-box">
	<ul id="menu">
		<li><a href="${context}">HOME</a></li>
		<li><a href="${context}/admin.do?action=search&page=main">ADMIN HOME</a></li>
		<li><a href="${context}/admin.do?action=search&page=main">MEMBER LIST</a></li>
		<li><a id="findByTeam">FIND BY TEAM ID</a></li>
		<li><a href="${context}/admin.do?action=retrieve&page=main">FIND BY ID</a></li>
	</ul>
</div>
<script >
 document.getElementById('findByTeam')
.addEventListener('click',function(){
	location.href =
		"${context}"
		+"/admin.do?action=search&page=main&team_id="
		+prompt('팀 이름을 입력하세요.');
}
); 
</script>
