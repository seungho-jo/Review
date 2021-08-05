/**
 * 
 */
function checkValue(){
		var id = document.querySelector("[name = id]");
		var pass = document.querySelector("[name = pass]");
		var form = document.querySelector("form");
	
		if(!id.value){
			alert("아이디를 작성해주세요.");
			id.focus();
			return false;
		}
		
		else if(!pass.value){
			alert("비밀번호를 작성해주세요.");
			pass.focus();
			return false;
		} else{
			form.submit();
		}
		
	}