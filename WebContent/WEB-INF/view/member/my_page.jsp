<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="domain.*" %>
<%
	MemberBean member = (MemberBean) request.getAttribute("user");
%>
<!doctype html>
<html lang="en">
	<jsp:include page="../common/head.jsp"/>
<body>
	<div class="margin-200-auto text-align width-200 border">
		<h2 class="text-align"><%=member.getName()%>의 마이 페이지</h2>
		<a id="moveUpdateForm">비밀번호 변경</a>
		<a id="moveDeleteForm">회원탈퇴</a>
	</div>
<script>
document.getElementById('moveUpdateForm')
	.addEventListener('click',
			function(){  //콜백 함수, 뒤따라 연이어 호출되는 함수
				new Common().move(['${context}','member','move','update_form'])
			}
	);document.getElementById('moveDeleteForm')
	.addEventListener('click',
			function(){  //콜백 함수, 뒤따라 연이어 호출되는 함수
				new Common().move(['${context}','member','move','delete_form'])
			}
	);
</script>
</body>
</html>