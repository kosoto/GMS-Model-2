<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script>
function move(domain,action,page) {
	console.log('클릭 테스트 성공');
	alert('클릭 테스트 성공');
	location.href =
		"${context}/"
			+domain+".do?action="
				+action+"&page="+page;
}
</script>