<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
	<jsp:include page="../common/head.jsp"/>
<body>
	<div>
		<h2>회원가입</h2>
		<form id="joinForm" name="joinForm">
		ID<br>
		<input type="text" name="userid"/><br>
		비밀번호<br>
		<input type="text" name="pass" /><br>
		이름 <br>
		<input type="text" name="name"/><br>
		주민번호<br>
		<input type="text" name="ssn" /><br>	
		<input id="joinBth" type="button" value="제출"/>
		<br>
	소속팀
		<input type="radio" name="teamid" 
			value="ateam" />걍놀자
		<input type="radio" name="teamid" 
			value="hteam" />지은이네
		<input type="radio" name="teamid" 
			value="steam" />왕거북이
		<input type="radio" name="teamid" 
			value="cteam" />코딩짱
			<input type="radio" name="teamid" 
			value="none" />없음
		<br>	
	프로젝트역활
		<select name="roll" id="roll">
			<option value="leader">팀장</option>
			<option value="front">프론트개발</option>
			<option value="back">백단개발</option>
			<option value="android">안드로이드개발</option>
			<option value="minfe">민폐</option>
			<option value="none">없음</option>
		</select>		
		<br>
	수강과목
		<input type="checkbox" name="subject"
			value="java" checked="checked"/> Java
		<input type="checkbox" name="subject" value="clang"/> C언어
		<input type="checkbox" name="subject" value="JSPlang"/> JSP
		<input type="checkbox" name="subject" value="PHP"/> PHP
		<input type="checkbox" name="subject" value="nodejs"/> NodeJS
		<input type="checkbox" name="subject" value="linux"/> Linux
		<input type="checkbox" name="subject" value="html"/> HTML
		<input type="checkbox" name="subject" value="spring"/> Spring
		</form>
	</div>
	<script>
	document.getElementById('joinBth')
	.addEventListener('click',function(){
		var x = (service.nullChecker(
				{id:document.joinForm.userid.value,
				 pass:document.joinForm.pass.value,
				 name:document.joinForm.name.value,
				 ssn:document.joinForm.ssn.value}
				)
		);
		if(x.checker){
			var form = document.getElementById('joinForm');
			form.action = "${context}/member.do";
			form.method = "POST"; //get은 입력값을 노출, post는 노출x form태그만 post방식이 있음
			member.join({
				 id:form.userid.value,
				 pass:form.pass.value,
				 name:form.name.value,
				 ssn:form.ssn.value});
			var arr =[
				{name:"action", value:"create"},
				{name:"gender", value:member.getGender()},
				{name:"age", value:member.getAge()}];
			for(var i=0;i<arr.length;i++){
				var node = document.createElement('input');
				node.setAttribute('type','hidden');
				node.setAttribute('name',arr[i].name);
				node.setAttribute('value',arr[i].value);
				form.appendChild(node);
			} 
			form.submit();
		}else{
			alert(x.text);
		}
	});
	</script>
</body>
</html>