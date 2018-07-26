<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="Login-box">
	<a id="move_user_login_form" > <!-- function -->
	LOGIN</a>
	&nbsp;&nbsp;&nbsp;
	<a id="move_join_form">JOIN</a>		
</div>
<script >
document.getElementById('move_user_login_form')
	.addEventListener('click',
			function(){  //콜백 함수, 뒤따라 연이어 호출되는 함수
			router.move(['${context}','member','move','user_login_form'])
			}
	);
document.getElementById('move_join_form')
	.addEventListener('click',
			function(){  //콜백 함수, 뒤따라 연이어 호출되는 함수
			router.move(['${context}','member','move','join_form'])
			}
	);
</script>