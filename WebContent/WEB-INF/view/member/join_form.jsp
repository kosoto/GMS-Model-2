<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
	<jsp:include page="../common/head.jsp"/>
<body>
	<div>
		<h2>회원가입</h2>
		<form id="joinForm" onsubmit="return gate()">
		ID<br>
		<input type="text" name="userid"/><br>
		비밀번호<br>
		<input type="text" name="pass" /><br>
		이름 <br>
		<input type="text" name="name"/><br>
		주민번호<br>
		<input type="text" name="ssn" /><br>	
		<input type="hidden" name="action" value="create"/>
		<input type="hidden" name="page" value="user_login_form"/>
		<input id="joinBth" type="button" value="제출"/>
		</form>
	</div>
	<jsp:include page="../common/gateFunction.jsp"/>
	<script>
	document.getElementById('joinBth')
	.addEventListener('click',function(){
		var form = document.getElementById('joinForm');
		form.action = "${context}/member.do";
		form.method = "post"; //get은 입력값을 노출, post는 노출x form태그만 post방식이 있음
		member.setMemberId(form.userid.value);
		member.setPass(form.pass.value);
		member.setSsn(form.ssn.value);
		if(member.joinValidation()){
			form.submit();
		}else{
			alert("유효하지 않음");
		}
	});
	</script>
</body>
</html>