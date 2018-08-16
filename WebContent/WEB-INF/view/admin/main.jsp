<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp"/>
<body>	
<div id="wrapper">
	<div id="header">
		<h1>관리자 페이지</h1>
		<div id="menu-box">
			<ul id="menu">
				<li><a id="moveHome">HOME</a></li>
				<li><a id="moveAdmin">ADMIN</a></li>
			</ul>
		</div>
	</div> <!-- header end -->
	
	<div id="footer">주소</div>
</div>
<jsp:include page="../member/search.jsp"/>
<script>
	admin.main(
			{
				context : '${context}',
				option : '${option}',
				word : '${word}'
			}
			);
</script>
</body>
</html>