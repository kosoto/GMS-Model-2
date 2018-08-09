<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
	<jsp:include page="../common/head.jsp"/>
<body>

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
			<td><a>비밀번호</a></td>
			<td colspan="2">**********</td>
		</tr>
		<tr>
			<td>나이</td>
			<td>${user.age}</td>
			<td><a>팀명</a></td>
			<td>${user.teamId}</td>
		</tr>
		<tr>
		<td>성별</td>
		<td>${user.gender}</td>
		<td><a>역활</a></td>
		<td>${user.roll}</td>
		</tr>
	</table>
		<a id="moveUpdateForm">정보수정</a> &nbsp; &nbsp;
		<a id="moveDeleteForm">회원탈퇴</a> 
	
<script>
document.getElementById('moveUpdateForm')
	.addEventListener('click',
			function(){  //콜백 함수, 뒤따라 연이어 호출되는 함수
				router.move(
						{context : '${context}',
						domain : 'member',
						action : 'move',
						page : 'update_form'
							}
						)
			}
	);

document.getElementById('moveDeleteForm')
	.addEventListener('click',
			function(){  //콜백 함수, 뒤따라 연이어 호출되는 함수
				router.move(
					{context : '${context}',
					domain : 'member',
					action : 'move',
					page : 'delete_form'
						}
					)
			}
	);
</script>
</body>
</html>