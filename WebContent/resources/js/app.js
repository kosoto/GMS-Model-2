function Common() {
		this.move = function (context,domain,action,page) {
			location.href =
				context+"/"
					+domain+".do?action="
						+action+"&page="+page;
		}
	}
function Member() {
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
		var flag = false;
		var id = this.getMemberId();
		var pass = this.getPass();
		var ssn = this.getSsn();
		
		if(id === ""){
			
		}else if(pass === ""){
			
		}else{
			flag = true;
		}
		return flag;
	}
	this.joinValidation = function () {
		var flag = false;
		var id = this.getMemberId();
		var pass = this.getPass();
		var ssn = this.getSsn();
		if(id === ""){ //.equels()와 같음
		
		}else if(pass===""){
			
		}else if(ssn.substring(7,8)==7 || ssn.substring(7,8)==8){

		}else if(parseInt(ssn.substring(2,3))<=0 
				|| parseInt(ssn.substring(2,3))>=13){
			
		}else if(parseInt(ssn.substring(4,5))<=0 
				|| parseInt(ssn.substring(4,5))>=32){
			
		}else{
			flag = true;
		}
		alert(flag);
		return flag;
	}
};