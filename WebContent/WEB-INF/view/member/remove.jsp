<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
	<jsp:include page="../common/head.jsp"/>
<body>	
<div id="wrapper">
	<div id="header">
		<jsp:include page="../common/title-box.jsp"/>
		<jsp:include page="../common/login-box.jsp"/>
		<jsp:include page="../common/menu-box.jsp"/>
	</div> <!-- header end -->
	<div id="content-box">
		<form id="deleteForm"> <!-- DOM객체 -->
			비밀번호 재입력 <br>
			<input type="password" name="password" 
			id="password"/> <!-- DOM객체의 property -->
			<!-- <input type="hidden" name="action" value="delete"/> -->
			<input type="button" id="deleteBtn" value="회원탈퇴"/>
		</form>
	</div>
	<div id="footer">주소</div>
</div>
<script>
	document.getElementById('deleteBtn')
	.addEventListener('click',function(){
	var form = document.getElementById('deleteForm');
	if('${user.pass}' === form.password.value){
		form.action = "${context}/member.do";
		form.method = "post";
		var node = document.createElement('input'); //태크 생성하기
		/* node.innerHTML = 
			'<input type="hidden" name="action" value="delete"/>' *///HTML코딩넣기,오리지널 버전
		node.setAttribute('type','hidden');
		node.setAttribute('name','action');
		node.setAttribute('value','delete'); //OOP 코딩
		form.appendChild(node); //node를 form안에 넣기 위한 코드
		form.submit();
	}else{
		alert('비밀번호가 다릅니다.');
	}
	})
</script>
</body>
</html>
