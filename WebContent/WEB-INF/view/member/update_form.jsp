<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
	<jsp:include page="../common/head.jsp"/>
<body>
<div>
	<h3>비밀번호 변경</h3>
	<form id="updateForm">
	ID <br>
	<input type="text" name="userid"/><br>
	이전 비밀번호 <br>
	<input type="text" name="pass"/><br>
	새로운 비밀번호 <br>
	<input type="text" name="newPass"/><br>
	<input type="hidden" name="action" value="update"/>
	<input type="hidden" name="page" value="my_page"/>
	<input id="updateBtn" type="button" value="제출" />
	</form>
</div>
<script>
document.getElementById('updateBtn')
.addEventListener('click',function(){
	var member = new Member();
	var form = document.getElementById('updateForm');
	form.action = "${context}/member.do";
	form.method = "post"; //get은 입력값을 노출, post는 노출x form태그만 post방식이 있음
	//member.setMemberId(form.userid.value);
	//member.setPass(form.pass.value+"/"+form.newPass.value);
	//유효성 체크
	form.submit();
});
</script>
</body>
</html>