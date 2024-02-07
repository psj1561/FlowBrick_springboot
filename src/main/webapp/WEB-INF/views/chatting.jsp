<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<fmt:requestEncoding value="utf-8"/>     
<!DOCTYPE html>
<%--


 --%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css" >
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css" >
<style>
	td{text-align:center;}
	.jumbotron{padding:2%;}
	.input-group-text{width:100%;
		color:black;font-weight:bolder;}
	.input-group-prepend{width:20%;}
	#chatArea{
		width:80%;height:200px;overflow-y:scroll;text-align:left;
		border:1px solid green;
		padding-right: 15px;
	}	
</style>
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api" type="text/javascript"></script>
<script type="text/javascript">
	// 화면 크기에 따라 동적으로 조절 처리
	window.addEventListener("resize",function(){
		$("#chatMessageArea>div").width(
				$("#chatArea").width()-5)
		
	})
	$(document).ready(function(){
		var wsocket = null;
		$("#enterBtn").click(function(){
			var idVal = $("#id").val()
			wsocket = new WebSocket(
				"ws:localhost:2222/chat"	
			)
			
			wsocket.onopen = function(evt){
				console.log(evt)
				
				wsocket.send(idVal+":접속하셨습니다!")
			}
			wsocket.onmessage = function(evt){
				// 서버에서 push 접속한 모든 client에 전송..
				revMsg(evt.data) // 메시지 처리 공통 함수 정의				
			}
		})
		
		function revMsg(msg){
			// 보내는 메시지는 오른쪽
			// 받는 메시지는 왼쪽 정렬 처리 : 사용자아이디:메시지 내용
			var alignOpt = "left"
			var msgArr = msg.split(":") // 사용자명:메시지 구분 하여 처리..
			var sndId = msgArr[0] // 보내는 사람 메시지 id
			if($("#id").val()==sndId){ 
				// 보내는 사람과 받는 사람의 아이디 동일:현재 접속한 사람이 보낸 메시지 
				alignOpt = "right"
				msg = msgArr[1] // 받는 사람 아이디 생략 처리
			}
			var msgObj = $("<div></div>").text(msg).attr("align",
					alignOpt).css("width",$("#chatArea").width())
			$("#chatMessageArea").append(msgObj);
			
			// 스크롤링 처리..
			// 1. 전체 해당 데이터의 높이를 구한다.
			// 2. 포함하고 있는 부모 객체(#chatArea)에서
			//    스크롤 기능 메서드로 스크롤되게 처리한다. scrollTop()
			var height = parseInt($("#chatMessageArea").height())
			mx += height+20
			$("#chatArea").scrollTop(mx)

		}
		var mx = 0;
		$("#sndBtn").click(function(){
			sendMsg()	
		})
		$("#msg").keyup(function(){
			if(event.keyCode==13){
				sendMsg()
			}
		})
		$("#exitBtn").click(function(){
			if(confirm("접속을 종료하시겠습니까?")){
				wsocket.close()
			}
		})
		function sendMsg(){
			wsocket.send($("#id").val()+":"+$("#msg").val())
			$("#msg").val("")			
		}
	});
</script>
</head>

<body>
<div class="jumbotron text-center">
  <h2>채팅화면</h2>

</div>
<%-- 
		
--%>
<div class="container">
	<div class="input-group mb-3">	
		<div class="input-group-prepend ">
			<span class="input-group-text  justify-content-center">
			아이디</span>
		</div>
		<input type="text" id="id" 
			class="form-control" placeholder="접속할 아이디 입력" />
		<input id="enterBtn" type="button" class="btn btn-info" value="채팅방입장" />
		<input id="exitBtn" type="button" class="btn btn-danger" value="채팅방나가기" />
				
	</div>	
	<div class="input-group mb-3">	
		<div class="input-group-prepend ">
			<span class="input-group-text  justify-content-center">
				접속자</span>
		</div>
		<div class="input-group-append" id="chatM">
			<div id="chatGroup"></div>
		</div>			
	</div>
	<div class="input-group mb-3">	
		<div class="input-group-prepend ">
			<span class="input-group-text  justify-content-center">
				메시지</span>
		</div>
		<div id="chatArea" style="overflow-x:hidden"
			class="input-group-append">
			<div id="chatMessageArea"></div>
		</div>
	</div>		
	<div class="input-group mb-3">	
		<div class="input-group-prepend ">
			<span class="input-group-text  justify-content-center">
				메시지</span>
		</div>
		<input type="text" id="msg" class="form-control" 
			placeholder="전송할 메시지 입력"/>
		<input type="button" id="sndBtn" class="btn btn-success" 
			value="메시지전송" />	
	</div>		
	<%--
	<div class="input-group mb-3">
		<div class="input-group-prepend ">
			<span class="input-group-text  justify-content-center">
				기타기능</span>
		</div>
		<input type="button" class="btn btn-info" value="수정" id="uptBtn"/>
		<input type="button" class="btn btn-danger" value="삭제" id="delBtn"/>
		<input type="button" class="btn btn-success" value="조회리스트" id="mainBtn"/>
	</div>
	 --%>	
		<script type="text/javascript">
			$("#mainBtn").click(function(){
				location.href="${path}/deptList02.do"
			})
		</script>
</div>

</body>
</html>