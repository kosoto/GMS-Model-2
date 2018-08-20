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

var members = (()=>{
	return {
		main : x=>{
			switch(x.pagename){
			case "add" : 
				document.getElementById('joinBth')
				.addEventListener('click',function(){
					var y = (service.nullChecker(
							{id:document.joinForm.userid.value,
							 pass:document.joinForm.pass.value,
							 name:document.joinForm.name.value,
							 ssn:document.joinForm.ssn.value}
							)
					);
					if(y.checker){
						var form = document.getElementById('joinForm');
						form.action = x.context+"/member.do";
						form.method = "POST"; //get은 입력값을 노출, post는 노출x form태그만 post방식이 있음
						member.join({
							 id:form.userid.value,
							 pass:form.pass.value,
							 name:form.name.value,
							 ssn:form.ssn.value});
						var arr =[
							{name:"action", value:"add"},
							{name:"gender", value:member.getGender()},
							{name:"age", value:member.getAge()}];
						for(var i=0;i<arr.length;i++){
							var node = document.createElement('input');
							node.setAttribute('type','hidden');
							node.setAttribute('name',arr[i].name);
							node.setAttribute('value',arr[i].value);
							form.appendChild(node);
						} 
						form.submit();
					}else{
						alert(y.text);
					}
				});
				break;
			case 'login':
				document.getElementById('login_btn')
				.addEventListener('click',function(){
					var y = service.nullChecker(
							{id:document.loginForm.userid.value, //여기서 loginForm은 form의 name
							 pass:document.loginForm.pass.value}
							);
					if(y.checker){
						var form = document.getElementById('loginForm'); //여기서 loginForm 은 form의 id
						form.action = x.context+"/member.do";
						form.method = "post"; //get은 입력값을 노출, post는 노출x form태그만 post방식이 있음
						form.submit();
					}else{
						alert(y.text);
					}
				});
				break;
			case 'modify':
				var form = document.getElementById('updateForm');
				var teamid = document.getElementsByName('teamid');
				for(var i in teamid){
					if(teamid[i].value === x.teamId.toLowerCase()){
						document.getElementById(teamid[i].value).checked = true;
					}
				}

				var roll = document.getElementById('roll');
				for(var i=0;i<roll.options.length;i++){
					if(roll.options[i].value === x.roll){
						roll.options[i].setAttribute("selected","selected");
					}
				}

				var newPass = form.newPass.value;
				
				document.getElementById('updateBtn')
				.addEventListener('click',function(){
					alert('newPass : '+newPass);
					if((newPass !== "" && newPass !== x.pass) ||
					   !document.getElementById(x.teamId.toLowerCase()).checked ||
					   roll.value !== x.roll){
						if(newPass === ""){
							form.newPass.value = x.pass;
						}
						var node = document.createElement('input');
						node.setAttribute('type','hidden');
						node.setAttribute('name','action');
						node.setAttribute('value','modify');
						form.appendChild(node);
						form.action = x.context+"/member.do";
						form.method = "post"; //get은 입력값을 노출, post는 노출x form태그만 post방식이 있음
						form.submit();
					}else{
						alert('수정사항이 없습니다.');
					}
					
				});
				break;
			case 'remove':
				alert('remove 페이지 진입');
				document.getElementById('deleteBtn')
				.addEventListener('click',function(){
				alert('삭제 버튼 누름');
				var form = document.getElementById('deleteForm');
				form.action = x.context+"/member.do";
				form.method = "post";
				var node = document.createElement('input'); //태크 생성하기
				node.setAttribute('type','hidden');
				node.setAttribute('name','action');
				node.setAttribute('value','remove'); //OOP 코딩
				form.appendChild(node); //node를 form안에 넣기 위한 코드
				form.submit();
			/*	if(x.user.pass === form.password.value){
					form.action = x.context+"/member.do";
					form.method = "post";
					var node = document.createElement('input'); //태크 생성하기
					node.setAttribute('type','hidden');
					node.setAttribute('name','action');
					node.setAttribute('value','remove'); //OOP 코딩
					form.appendChild(node); //node를 form안에 넣기 위한 코드
					form.submit();
				}else{
					alert('비밀번호가 다릅니다.');
				}*/
				})
				break;
			default :
				document.getElementById('moveUpdateForm')
				.addEventListener('click',
						function(){  //콜백 함수, 뒤따라 연이어 호출되는 함수
							router.move(
									{context : x.context,
									domain : 'member',
									action : 'move',
									page : 'modify'
										}
									)
						}
				);

				document.getElementById('moveDeleteForm')
				.addEventListener('click',
						function(){  //콜백 함수, 뒤따라 연이어 호출되는 함수
							router.move(
								{context : x.context,
								domain : 'member',
								action : 'move',
								page : 'remove'
									}
								)
						}
				);
				
				document.getElementById('logOut')
				.addEventListener('click',()=>{
					location.href =
						x.context+"/member.do?action=login&flag=logout"
				});
				break;
			}
			
			service.addClass(document.getElementById('profile'), 'width-200 height-150');
			document.getElementById('moveHome')
			.addEventListener('click',()=>{
				location.href = 
					x.context+"/common.do"
			})
		}//main end
	}//return end
})();

var common = (()=>{
	return {
		main : x=>{
			document.getElementById('moveAdmin')
			.addEventListener('click',function(){  
				 location.href =
                     x+"/admin.do?action=search&pageNum=1";
				/*router.move(
						{context : x,
						domain : 'admin',
						action : 'search',
						page : 'main'}
						)*/
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
        	.addEventListener('click',function(){ 
        			router.move(
        					{context : x,
        						domain : 'member',
        						action : 'move',
        						page : 'login'}
        					)
        			}
        	);
        	document.getElementById('move_join_form')
        	.addEventListener('click',function(){  
        			router.move(
        					{context : x,
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
						var domain = "";
						var action = "";
						switch(document.getElementById('option').value){
						case 'mem_id' :
							domain = "member";
							action = "retrieve";
							break;
						case 'name' :		
						case 'team_id' :
							domain = "admin"
							action = "search";
							break;
						default : break;
						}
					 location.href = x.context
					+"/"+domain+".do?"
					+"action="+action
					+"&option="
					+document.getElementById('option').value
					+"&word="
					+document.getElementById('word').value
					+"&table=member&pageNum=1"
					}else{
						alert('검색어를 입력하세요.');
					}
				}else{
					 alert('검색조건을 선택하세요');
				}
			}); //'searchBtn' 끝
			
			document.getElementById('listBtn')
			.addEventListener('click',function(){
				location.href =
					x.context+"/admin.do?action=search&pageNum=1";	
			})
			
			document.getElementById('contentBoxMeta').style.width = '80%';
			document.getElementById('contentBoxMeta').className = 'bgColorisYellow';
			
			for(var i of document.querySelectorAll('.username')){
                 service.addClass(i,'cursor fontColorBlue');
                 i.addEventListener('click',function(){
                       location.href = x.context
                            +"/member.do?action=retrieve&option=mem_id&table=member&word="
                           +this.getAttribute('id');//콜백함수에서의 this는 이 함수를 호출한 객체
                 });
            };
            for(var i of document.querySelectorAll('.pageNum')){
            	service.addClass(i,'cursor fontColorBlue');
            	i.addEventListener('click',function(){
        			location.href = x.context
        			+"/admin.do?action=search&page=main&pageNum="
        			+this.getAttribute('id')
        			+((x.option === "")?
        				""
        				:"&option="+x.option
	        			 +"&word="+x.word);
            	
        		});
        	};
        	document.getElementById('moveHome')
			.addEventListener('click',()=>{
				location.href = 
					x.context+"/common.do"
			})
        	
        	
		}//main method 끝
	}
}//admin function 끝
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