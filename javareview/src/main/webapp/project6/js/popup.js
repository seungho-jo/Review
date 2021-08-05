/**
 * 
 */

function Sharefb(){
	window.open(
	  'https://www.facebook.com/sharer/sharer.php?u=' + encodeURIComponent('http://203.216.179.152:7080/scrollBook/main.jsp')
	);
}
function Sharett(){
	var sendText = "scrollBook";
	var sendUrl = "http://203.216.179.152:7080/scrollBook/main.jsp";
	window.open("https://twitter.com/intent/tweet?text=" + sendText + "&url=" + sendUrl);
	
}

Kakao.init('e132a3811afb598bd7dd12e4683143bc');
function Sharekk(){
	var sh_title = "scrollBook";
	var sh_desc = "5조의 scrollBook"; 
		Kakao.Link.sendDefault({ 
		objectType: 'feed',
			content: { 
			title: sh_title, 
			description: sh_desc, 
			imageUrl: "https://ifh.cc/g/3JWKOt.png", 
			link: { mobileWebUrl: "http://203.216.179.152:7080/scrollBook/main.jsp", 
					webUrl: "http://203.216.179.152:7080/scrollBook/main.jsp" 
					} 
				}, 
		});
}
