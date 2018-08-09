"use strict";
var router = ( ()=>{
           return {move : x => {
                location.href =
                     x.context+"/"
                     +x.domain
                     +".do?action="+x.action
                     +"&page="+x.page;
                }};//closure, key(String) & value(object)의 map구조, scalar 문법
     })();  //이때는 ;이 빠지면 에러
var common = (()=>{
	return {
		main : x=>{
			document.getElementById('moveAdmin')
			.addEventListener('click',function(){  
				router.move(
						{context : x,
						domain : 'admin',
						action : 'search',
						page : 'main'}
						)
				/*var isAdmin = confirm('관리자입니까?'); //window의 method,BOM객체
				if(isAdmin){
					var password = prompt('관리자 비번을 입력바랍니다.');
					if(password == 1){
						router.move(
								{context : x,
								domain : 'admin',
								action : 'search',
								page : 'main'}
								)
					}
				}else{
					alert('관리자만 접근이 허용됩니다.');
				}	*/	
			}
			);
			document.getElementById('move_user_login_form')
        	.addEventListener('click',
        			function(){ 
        			router.move(
        					{context : '${context}',
        						domain : 'member',
        						action : 'move',
        						page : 'login'}
        					)
        			}
        	);
        	document.getElementById('move_join_form')
        	.addEventListener('click',
        			function(){  
        			router.move(
        					{context :'${context}',
        						domain :'member',
        						action :'move',
        						page :'add'})
        			}
        	);
		}
	};
})();
var admin = (()=>{
	return{
		main : x=>{
			document.getElementById('searchBtn')
			.addEventListener('click',function(){
				if(document.getElementById('option').value !== 'none'){
					if(document.getElementById('word').value!==""){
						var action = "";
						var page = "";
						switch(document.getElementById('option').value){
						case 'mem_id' :
							action = "retrieve";
							page = "memberDetail"
							break;
						case 'name' :		
						case 'team_id' :
							action = "search";
							page = "main";
							break;
						default : break;
						}
					 location.href = x
					+"/admin.do?"
					+"action="+action
					+"&page="+page
					+"&option="
					+document.getElementById('option').value
					+"&word="
					+document.getElementById('word').value
					+"&table=member"
					}else{
						alert('검색어를 입력하세요.');
					}
				}else{
					 alert('검색조건을 선택하세요');
				}
			}); //'searchBtn' 끝
			document.getElementById('contentBoxMeta').style.width = '80%';
			document.getElementById('contentBoxMeta').className = 'bgColorisYellow';
			for(var i of document.querySelectorAll('.username')){
                 service.addClass(i,'cursor fontColorBlue');
                 i.addEventListener('click',function(){
                       location.href = x
                            +"/admin.do?action=retrieve&page=memberDetail&option=mem_id&table=member&word="
                           +this.getAttribute('id');//콜백함수에서의 this는 이 함수를 호출한 객체
                 });
            };
            for(var i of document.querySelectorAll('.pageNum')){
            	service.addClass(i,'cursor fontColorBlue');
            	i.addEventListener('click',function(){
        			location.href = x
        			+"/admin.do?action=search&page=main&pageNum="
        			+this.getAttribute('id');
        		});
        	};
        	
        	
        	
		}//main method 끝
	}
}
)();
var service = (()=>{
	return {
		nullChecker : x=>{
			var json = {
					checker : true,
					text : '필수 입력값이 없습니다.'
			}; //closure 가 없는 객체, 가볍다.
			for(var key in x){ // for-each loop
				if(x[key] === ""){
					json.checker = false;
				}
			}
			return json;
		},
		addClass : (dom,cName)=>{
			var arr = cName.split(" ");
				if(arr.indexOf(cName) == -1){ //없을때 -1을 리턴
					dom.className += " " + cName;
				}
		},
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

var member = (()=> {
	var _memberId,_ssn,_pass,_name,_age,_teamId,_gender,_roll;		
	var setMemberId = (memberId)=> {
		if(memberId.length>=2){
			this._memberId = memberId;
		}else{
			alert('아이디는 2자 이상입력 하세요.');
		}
	}
	var setSsn = (ssn)=> {
		var flag = false;
		if(ssn.substring(7,8)==7 || ssn.substring(7,8)==8){

		}else if(parseInt(ssn.substring(2,4))<=0 
				|| parseInt(ssn.substring(2,4))>=13){
			
		}else if(parseInt(ssn.substring(4,6))<=0 
				|| parseInt(ssn.substring(4,6))>=32){
			
		}else if(ssn.substring(6,7)==="-"){
			flag = true;
		}
		if(flag){
			this._ssn = ssn;
		}else{
			alert('잘못된 주민번호');
		}
	}
	var setName = (name)=> {this._name = name;}
	var setPass = (pass)=> {this._pass = pass;}
	var setAge = x=> {
		this._age = (new Date().getFullYear())-parseInt('19'+x.substring(0,2));
		}
	var setTeamId = (teamId )=> {this._teamId = teamId;}
	var setRoll = (roll)=> {this._roll = roll;}
	var setGender = x=> {
		var gender;
		if(parseInt(x.substring(7,8)) % 2 == 1){
			gender = '남';
		}else{
			gender = '여';
		}
		this._gender = gender;
		}
	var getMemberId = ()=> {return this._memberId;}
	var getSsn =  ()=> {return this._ssn;}
	var getPass =  ()=> {return this._pass;}
	var getName =  ()=> {return this._name;}
	var getTeamId =  ()=> {return this._teamId;}
	var getSsn =  ()=> {return this._ssn;}
	var getRoll =  ()=> {return this._roll;}
	var getAge =  ()=> {return this._age;}
	var getGender =  ()=> {return this._gender;}
	return {
		setMemberId : setMemberId,
		setSsn : setSsn,
		setPass : setPass,
		setAge : setAge,
		setTeamId : setTeamId,
		setName : setName,
		setGender : setGender,
		setRoll : setRoll,
		getMemberId : getMemberId,
		getSsn : getSsn,
		getPass : getPass,
		getAge : getAge,
		getTeamId : getTeamId,
		getName : getName,
		getGender : getGender,
		getRoll : getRoll,
		join : x=>{
			member.setMemberId(x.id);
			member.setPass(x.pass);
			member.setName(x.name);
			member.setSsn(x.ssn);
			member.setAge(x.ssn);
			member.setGender(x.ssn);
		}
	}
})();


(function(){})(); //goofy
(function(){}()); //groovy