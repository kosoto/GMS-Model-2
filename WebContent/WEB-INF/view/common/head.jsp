<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
	<meta charset="UTF-8" />
	<title>GMS</title>
	<link rel="stylesheet" href="${context}/resources/css/style.css" />
	<script>
	var common = new (function Common(domain,action,page) {
		this.move = function (domain,action,page) {
			console.log('클릭 테스트 성공');
			alert('클릭 테스트 성공');
			location.href =
				"${context}/"
					+domain+".do?action="
						+action+"&page="+page;
		}
	})
	//anonymous function
	/* var Member = function () {
		 memberId,TeamId,name,ssn,roll,pass,age; 		
		this.loginValidation = function () {
			return "!!";
		};
	} */
	var member = new (function () {
		var memberId,ssn,pass;		
		this.setMemberId = function (x) {
			this.memberId = x;
		}
		this.setSsn = function (x) {
			this.ssn = x;
		}
		this.setPass = function (x) {
			this.pass = x;
		}
		this.getMemberId = function () {
			return this.memberId;
		}
		this.getSsn = function () {
			return this.ssn;
		}
		this.getPass = function () {
			return this.pass;
		}
		this.loginValidation = function () {
			return this.getMemberId();
		};
	});
	</script>
</head>