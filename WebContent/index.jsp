<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String ctx = application.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>GMS</title>
	<link rel="stylesheet" href="resources/css/style.css" />
</head>
<body>		
	<h3>현재 회원수 :  <mark>20명</mark> </h3>
	<table class="margin-auto">
		<tr class="height-150">
			<th colspan="2">
			<font size="20em">
			GMS
			</font>
			</th>		
		</tr>
		<tr class="height-400">
			<td>
			<img src="img/home/images.jpg" alt=""
			class="image-size"/>
			</td>
			<td>
			<ul>
				<li><a href="<%=ctx %>/member.do?action=move&page=join_form">회원가입</a></li>
				<li><a href="<%=ctx %>/member.do?action=move&page=user_login_form">사용자로그인</a></li>
				<li><a href="<%=ctx %>/admin.do?action=move&page=admin_login">관리자로그인</a></li>
				<li><a href="<%=ctx %>/member.do?action=move&page=member_list">회원목록</a></li>
				<li><a href="<%=ctx %>/member.do?action=move&page=search_team_form">팀이름검색</a></li>
				<li><a href="<%=ctx %>/member.do?action=move&page=search_member_form">아이디검색</a></li>
			</ul>			
			</td>
		</tr>
		<tr class="height-150">
			<td colspan="2">
			<font size="10em">주소</font>			
			</td>			
		</tr>
	</table>
</body>
</html>