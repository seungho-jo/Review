/**
 * 
 */
var listImg = document.querySelectorAll("#list ul li img");
var li = document.querySelectorAll("#list ul li");
li[0].style.borderBottom = "1px solid black";
function click(idx){
	li[idx].onclick = function(){
		for(var i=0;i<li.length;i++){
			li[i].style.borderBottom = "none";
		}
		li[idx].style.borderBottom = "1px solid black";
	}
}
for(var idx=0;idx<li.length;idx++){
	click(idx);
}
var picture = document.querySelectorAll(".picture");
var moreDiv = document.querySelectorAll(".morediv");
var up_del = document.querySelectorAll(".up_del");
function shows(idx){
	picture[idx].onmouseover = function(){	
		moreDiv[idx].style.display = "inline-block";
	}
	moreDiv[idx].onmouseover = function(){
		moreDiv[idx].style.display = "inline-block";
	}
	picture[idx].onmouseout = function(){	
		moreDiv[idx].style.display = "none";
		up_del[idx].style.display = "none";
	}
	moreDiv[idx].onclick = function(){
		up_del[idx].style.display = "inline-block";
	}
}
for(var idx=0;idx<picture.length;idx++){
	shows(idx);
}