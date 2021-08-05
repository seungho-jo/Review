/**
 * 
 */
 var upload = document.querySelector("#upload");
 var tag = document.querySelector("#tag");
 var loc = document.querySelector("#loc");
 var val1 = document.querySelector(".value1");
 var hidval1 = document.querySelector("[name=tag]");
 var val2 = document.querySelector("#value2");
 var hidval2 = document.querySelector("[name=loc]");
 var vv = document.querySelector("#profile_pt");
 var pubRange = document.querySelector("select");
 var content = document.querySelector("textarea"); 
 var btn = document.querySelector("#btn");
 var frm = document.querySelector("#frm");
 btn.onclick = function(){
	var cont = pubRange.options[pubRange.selectedIndex].text; 
	if(cont == '선택하세요'){
		alert("공개범위를 선택하세요");
	}else if(content.value==""){
		alert("내용을 작성해 주세요");
	}else{
		frm.submit();
	}
 }
 var win;
 upload.onclick = function(){
 	vv.click();
 }
 tag.onclick = function(){
 	var url = "inputTag.jsp";
 	win = window.open(url,"","width=300,height=300");
 }
function checkWin1(){
	if(win.closed){
		val1.innerText = "";
 		hidval1.value = "";
		for(var idx = 0;idx<localStorage.length;idx++){
 			val1.innerText += "@"+localStorage.getItem(idx)+",";
 			hidval1.value += "@"+localStorage.getItem(idx)+",";
 		}
 		localStorage.clear();
 	}
}
function clears(){
	val1.innerText = "";
	hidval1.value = "";
}
 loc.onclick = function(){
 	var url = "inputLoc.jsp";
 	win = window.open(url,"","width=300,height=300");
 }
function checkWin2(){
	if(win.closed){
		val2.innerText = "";
		for(var idx = 0;idx<localStorage.length;idx++){
 			val2.innerText = localStorage.getItem(idx);
 			hidval2.value = localStorage.getItem(idx);
 		}
 		localStorage.clear();
 	}
}
function previewImage(targetObj, View_area) {
	var preview = document.getElementById(View_area); //div id
	var ua = window.navigator.userAgent;

  //ie일때(IE8 이하에서만 작동)
	if (ua.indexOf("MSIE") > -1) {
		targetObj.select();
		try {
			var src = document.selection.createRange().text; // get file full path(IE9, IE10에서 사용 불가)
			var ie_preview_error = document.getElementById("ie_preview_error_" + View_area);


			if (ie_preview_error) {
				preview.removeChild(ie_preview_error); //error가 있으면 delete
			}

			var img = document.getElementById(View_area); //이미지가 뿌려질 곳

			//이미지 로딩, sizingMethod는 div에 맞춰서 사이즈를 자동조절 하는 역할
			img.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+src+"', sizingMethod='scale')";
		} catch (e) {
			if (!document.getElementById("ie_preview_error_" + View_area)) {
				var info = document.createElement("<p>");
				info.id = "ie_preview_error_" + View_area;
				info.innerHTML = e.name;
				preview.insertBefore(info, null);
			}
		}
  //ie가 아닐때(크롬, 사파리, FF)
	} else {
		var files = targetObj.files;
		for ( var i = 0; i < files.length; i++) {
			var file = files[i];
			var imageType = /image.*/; //이미지 파일일경우만.. 뿌려준다.
			if (!file.type.match(imageType))
				continue;
			var prevImg = document.getElementById("prev_" + View_area); //이전에 미리보기가 있다면 삭제
			if (prevImg) {
				preview.removeChild(prevImg);
			}
			var img = document.createElement("img"); 
			img.id = "prev_" + View_area;
			img.classList.add("obj");
			img.file = file;
			img.style.width = '150px'; 
			img.style.height = '150px';
			preview.appendChild(img);
			if (window.FileReader) { // FireFox, Chrome, Opera 확인.
				var reader = new FileReader();
				reader.onloadend = (function(aImg) {
					return function(e) {
						aImg.src = e.target.result;
					};
				})(img);
				reader.readAsDataURL(file);
			} else { // safari is not supported FileReader
				//alert('not supported FileReader');
				if (!document.getElementById("sfr_preview_error_"
						+ View_area)) {
					var info = document.createElement("p");
					info.id = "sfr_preview_error_" + View_area;
					info.innerHTML = "not supported FileReader";
					preview.insertBefore(info, null);
				}
			}
		}
	}
}
