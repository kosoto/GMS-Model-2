<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
	<jsp:include page="../common/head.jsp"/>
<body>
	<div>
		<h2>사용자 로그인</h2>	
		<form id="login_form" onsubmit="return gate()">
			ID <br>
			<input type="text" name="userid" ><br>
			Pass <br>
			<input type="text" name="pass"  ><br>
			<input type="hidden" name="action" value="login"/>
			<input type="hidden" name="page" value="my_page"/>
			<input id="login_btn" type="button" value="제출">
		</form><br>
	</div>
	<jsp:include page="../common/gateFunction.jsp"/>
	<script>
	document.getElementById('login_btn')
	.addEventListener('click',function(){
		var member = new Member();
		var form = document.getElementById('login_form');
		form.action = "${context}/member.do";
		form.method = "post"; //get은 입력값을 노출, post는 노출x form태그만 post방식이 있음
		member.setMemberId(form.userid.value);
		member.setPass(form.userid.value);
		if(member.loginValidation()){
			form.submit();
		}else{
			alert("유효하지 않음");
		}
	});
	</script>
</body>
</html>