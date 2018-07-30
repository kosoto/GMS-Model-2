<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String ctx = application.getContextPath(); %>
<!doctype html>
<html lang="en">
	<jsp:include page="../common/head.jsp"/>
<body>
	<div>
	<h3>회원탈퇴</h3>
		<form id="deleteForm" name="deleteForm" action="${context}/member.do?">
		ID <br>
		<input type="text" name="userid"/><br>
		비밀번호 <br>
		<input type="text" name="pass"/><br>
		<input type="hidden" name="action" value="delete"/>
		<input type="hidden" name="page" value=""/>
		<input id="deleteBtn" type="button" value="제출" />
		</form>
	</div>
	<script>
	document.getElementById('deleteBtn')
	.addEventListener('click',function(){
		var x = (service.nullChecker(
				{id:document.deleteForm.userid.value,
				 pass:document.deleteForm.pass.value}
				)
		);
		if(x.checker){
			var form = document.getElementById('deleteForm');
			form.action = "${context}/member.do";
			form.method = "POST";
			form.submit();
		}else{
			alert(x.text);
		}
		
	});
	</script>
</body>
</html>



