<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
 request.setCharacterEncoding("utf-8");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
</style>
</head>
<body>
	<div id="form-commentInfo">
		<div id="comment-count">
			댓글 <span id="count">0</span>
		</div>
		<input id="comment-input" placeholder="댓글을 입력해 주세요.">
		<button id="submit">등록</button>
	</div>
	<div id=comments></div>
	<script src="index.js">
		//1.입력받으면 입력값 초기화 //2. 입력값 댓글로들어가기 //3. 댓글 삭제, 수정기능 //4. 좋아요 투표기능 //5. 타임스템프기능 //6. 무작위 아이디 //7. 댓글 삭제기능 //8. 댓글 수정기능 
		const inputBar = document.querySelector("#comment-input");
		const rootDiv = document.querySelector("#comments");
		const btn = document.querySelector("#submit");
		const mainCommentCount = document.querySelector('#count'); //맨위 댓글 숫자 세는거. //타임스템프 만들기 
		function generateTime() {
			const date = new Date();
			const year = date.getFullYear();
			const month = date.getMonth();
			const wDate = date.getDate();
			const hour = date.getHours();
			const min = date.getMinutes();
			const sec = date.getSeconds();
			const time = year + '-' + month + '-' + wDate + ' ' + hour + ':'
					+ min + ':' + sec;
			return time;
		} //유저이름 발생기 //유저이름은 8글자로 제한. 
		function numberCount(event) {
			console.log(event.target);
			if (event.target === voteUp) {
				console.log("2");
				return voteUp.innerHTML++;
			} else if (event.target === voteDown) {
				return voteDown.innerHTML++;
			}
		}
		//댓글보여주기 
		function showComment(comment) {
			const userName = document.createElement('div');
			const inputValue = document.createElement('span');
			const showTime = document.createElement('div');
			const voteDiv = document.createElement('div');
			const countSpan = document.createElement('span')
			const voteUp = document.createElement('button');
			const voteDown = document.createElement('button');
			const commentList = document.createElement('div');
			//이놈이 스코프 밖으로 나가는 순간 하나지우면 다 지워지고 입력하면 리스트 다불러옴. 
			//삭제버튼 만들기 
			const delBtn = document.createElement('button');
			delBtn.className = "deleteComment";
			delBtn.innerHTML = "삭제";
			commentList.className = "eachComment";
			userName.className = "name";
			inputValue.className = "inputValue";
			showTime.className = "time";
			voteDiv.className = "voteDiv";
			//유저네임가져오기 
			userName.innerHTML = generateUserName();
			userName.appendChild(delBtn);
			//입력값 넘기기 
			inputValue.innerText = comment;
			//타임스템프찍기 
			showTime.innerHTML = generateTime();
			countSpan.innerHTML = 0;
			//댓글뿌려주기 
			commentList.appendChild(userName);
			commentList.appendChild(inputValue);
			commentList.appendChild(showTime);
			commentList.appendChild(voteDiv);
			rootDiv.prepend(commentList);
			voteUp.addEventListener("click", numberCount);
			voteDown.addEventListener("click", numberCount);
			delBtn.addEventListener("click", deleteComments);
			console.dir(rootDiv);
		}
		//버튼만들기+입력값 전달 
		function pressBtn() {
			const currentVal = inputBar.value;
			if (!currentVal.length) {
				alert("댓글을 입력해주세요!!");
			} else {
				showComment(currentVal);
				mainCommentCount.innerHTML++;
				inputBar.value = '';
			}
		}
		btn.onclick = pressBtn;
	</script>
</body>
</html>
