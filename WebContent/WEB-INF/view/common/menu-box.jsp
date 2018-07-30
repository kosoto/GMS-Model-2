<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="menu-box">
	<ul id="menu">
		<li><a href="">HOME</a></li>
		<li><a href="">ABOUT</a></li>
		<li><a id="moveAdmin">ADMIN</a></li>
	</ul>
</div>
<script>
document.getElementById('moveAdmin')
.addEventListener('click',
		function(){  //콜백 함수, 뒤따라 연이어 호출되는 함수
			router.move(
					{
						context : '${context}',
						domain : 'admin',
						action : 'move',
						page : 'main'}
					)
		}
);
</script>
