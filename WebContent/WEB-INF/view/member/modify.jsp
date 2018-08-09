<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
	<jsp:include page="../common/head.jsp"/>
<body>
<div>
	<form id="updateForm" name="updateForm">
	
	<table>
		<tr>
			<td rowspan="3"><img src="${img}/home/cat.jpg" /></td>
			<td>아이디</td>
			<td colspan="2">${user.memberId}</td>
		</tr>
		<tr>
			<td>이름</td>
			<td colspan="2">${user.name}</td>
		</tr>
		<tr>
			<td><a id="moveUpdateForm">비밀번호</a></td>
			<td colspan="2"><input type="text" name="newPass" placeholder="${user.pass}"/></td>
		</tr>
		<tr>
			<td>나이</td>
			<td>${user.age}</td>
			<td><a id="moveUpdateTeamForm">팀명</a></td>
			<td>
				<input type="radio" name="teamid" id="ateam"
					value="ateam" />걍놀자
				<input type="radio" name="teamid" id="hteam"
					value="hteam" />지은이네
				<input type="radio" name="teamid" id="steam"
					value="steam" />왕거북이
				<input type="radio" name="teamid" id="cteam"
					value="cteam" />코딩짱 
			</td>
		</tr>
		<tr>
		<td>성별</td>
		<td>${user.gender}</td>
		<td><a id="moveUpdateRollForm">역활</a></td>
		<td>
			<select name="roll" id="roll">
				<option id="leader" value="leader">팀장</option>
				<option id="front" value="front">프론트개발</option>
				<option id="back" value="back">백단개발</option>
				<option id="android" value="android">안드로이드개발</option>
				<option id="minfe" value="minfe">민폐</option>
			</select>	
		</td>
		</tr>
	</table>
	<input id="updateBtn" type="button" value="수정" />
	</form>
</div>
<script>
var form = document.getElementById('updateForm');
var teamid = document.getElementsByName('teamid');
for(var i in teamid){
	if(teamid[i].value === '${user.teamId}'.toLowerCase()){
		document.getElementById(teamid[i].value).checked = true;
	}
}

var roll = document.getElementById('roll');
for(var i=0;i<roll.options.length;i++){
	if(roll.options[i].value === '${user.roll}'){
		roll.options[i].setAttribute("selected","selected");
	}
}

var newPass = form.newPass.value;
document.getElementById('updateBtn')
.addEventListener('click',function(){
	if((newPass !== "" && newPass !== '${user.pass}') ||
	   !document.getElementById('${user.teamId}'.toLowerCase()).checked ||
	   roll.value !== '${user.roll}'){
		if(newPass === ""){
			form.newPass.value = '${user.pass}';
		}
		var node = document.createElement('input');
		node.setAttribute('type','hidden');
		node.setAttribute('name','action');
		node.setAttribute('value','update');
		form.appendChild(node);
		form.action = "${context}/member.do";
		form.method = "post"; //get은 입력값을 노출, post는 노출x form태그만 post방식이 있음
		form.submit();
	}else{
		alert('수정사항이 없습니다.');
	}
	
});
</script>
</body>
</html>