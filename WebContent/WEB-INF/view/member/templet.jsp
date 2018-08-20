<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
	<jsp:include page="../common/head.jsp"/>
<body>
	<div>
		<h2>사용자 로그인</h2>	
		<form id="loginForm" name="loginForm">
			ID <br>
			<input type="text" name="userid" ><br>
			Pass <br>
			<input type="text" name="pass"  ><br>
			<input type="hidden" name="action" value="login"/>
			<input id="login_btn" type="button" value="제출"/>
		</form><br>
	</div>
	<script>
	document.getElementById('login_btn')
	.addEventListener('click',function(){
		var x = service.nullChecker(
				{id:document.loginForm.userid.value, //여기서 loginForm은 form의 name
				 pass:document.loginForm.pass.value}
				);
		if(x.checker){
			var form = document.getElementById('loginForm'); //여기서 loginForm 은 form의 id
			form.action = "${context}/member.do";
			form.method = "post"; //get은 입력값을 노출, post는 노출x form태그만 post방식이 있음
			form.submit();
		}else{
			alert(x.text);
		}
	});
	</script>
</body>
</html>