var router = ( ()=>{
           return {move : x => {
                location.href =
                     x[0]+"/"
                     +x[1]
                     +".do?action="+x[2]
                     +"&page="+x[3];
                }};//closure, key(String) & value(object)의 map구조, scalar 문법
     })();  //이때는 ;이 빠지면 에러
var service = (()=>{
	return {
		loginvalidation : x => {
			var flag = false;
			
			if(x[0] === ""){
				
			}else if(x[1]=== ""){
				
			}else{
				flag = true;
			}
			return flag;
		},
		joinValidation : x => {
			var flag = false;
			
			if(x[0] === ""){ 
			
			}else if(x[1]===""){
				
			}else if(x[2].substring(7,8)==7 || x[2].substring(7,8)==8){

			}else if(parseInt(x[2].substring(2,3))<=0 
					|| parseInt(x[2].substring(2,3))>=13){
				
			}else if(parseInt(x[2].substring(4,5))<=0 
					|| parseInt(x[2].substring(4,5))>=32){
				
			}else{
				flag = true;
			}
			alert(flag);
			return flag;
		}
	};
})();
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
}

(function(){})(); //goofy
(function(){}()); //groovy