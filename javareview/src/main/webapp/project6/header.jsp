<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/search.css">
</head>
<body>
	<header>
		<div class="head">
			<a id="title" href="main.jsp"><img src="img/title.png"></a>
			<div class="head_left">
				<a id="write" href="write.jsp"><img src="img/write.PNG"></a>
				<img id="refresh" src="img/refresh.PNG">
				<img id="profile" src="img/bambi.jpg">
	<!--		<a href="index.jsp"><span>로그아웃</span></a>  -->
				<form name="form1" method="post" action="tagsearch.jsp">
					<input type="text" id="searchKeyword" placeholder="검색어를 입력하세요">
				</form> 
				<div id="autocomplete">
     			</div>
					
			</div>
		</div>
	</header>
</body>
<script type="text/javascript" src="js/header.js"></script>
<script type="text/javascript">

window.onload = function(){ 

   var searchKeyword = document.getElementById("searchKeyword");
   var autocomplete = document.getElementById("autocomplete");
   var keyword = "";
   
   searchKeyword.onkeydown = function(e) {
       searchKeyword.onkeyup(e);
   };

   searchKeyword.onkeyup = function(e){
         keyword = searchKeyword.value;
      if ( keyword == "" ) {
         autocomplete.style.display = "none";
      }
      else {
         autocomplete.style.display = "block";
         fillSearchResult(autocomplete);
      } 
   };
   
   
};

function fillSearchResult( autocomplete ) {

   autocomplete.innerHTML = "";
   var searchResults = ["#튤립" , "#개발", "#코딩"];
   for (var i=0; i < searchResults.length; i++) {
      autocomplete.innerHTML += "<div onclick='selectData(this);'>" + searchResults[i] + "</div>";
   }
   
}
function selectData(that) {
    var searchKeyword = document.getElementById("searchKeyword");
    searchKeyword.value = that.innerText;
    
    var autocomplete = document.getElementById("autocomplete");
    autocomplete.style.display="none";
}


</script>
</html>