/**
 * 
 */

function checkValue(){
		var id = document.querySelector("[name = id]");
		var pass = document.querySelector("[name = pass]");
		var repass = document.querySelector("[name=repass]");
		var pullname = document.querySelector("[name=name]");
		
		if(!id.value){
			alert("아이디를 입력하세요!");
			id.focus();
			return false;
		}
		 if(!pass.value){
			alert("비밀번호를 입력하세요!");
			pass.focus();
			return false;
		}
		
		 if(!repass.value){
			alert("비밀번호를 다시한번 입력하세요!");
			repass.focus();
			return false;
		}else{
			if(pass.value != repass.value){
				alert("입력한 비밀번호가 일치하지 않습니다.");
				return false;
			}
		}
		
		if(!pullname.value){
			alert("사용자의 이름을 입력해주세요.");
			pullname.focus();
			return false;
		} else{
			form.submit();
		}
		
		alert("회원가입 완료");
	}