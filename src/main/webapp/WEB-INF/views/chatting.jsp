<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<fmt:requestEncoding value="utf-8" />
<!DOCTYPE html>
<%--


 --%>
<html>
<head>
<meta charset="UTF-8">
<title>chatting</title>

<style>
#frm {
/* 	margin: auto;
	background: #86A7FC; */
	

    margin: auto;
    background: #f1f1f1; /* 채팅 창 배경색상 */
    border: 1px solid #ddd; /* 채팅 창 테두리 스타일 */
    border-radius: 10px; /* 채팅 창 테두리 둥글게 처리 */
    padding: 15px;
    box-shadow: 0px 0px 10px 0px #ddd; /* 그림자 효과 */

	
}

#chatArea {
	width: 100%;
	height: 400px;
	overflow-y: scroll;
	text-align: left;
	margin: auto;
	padding-right: 15px;
}

#chatGroup {
	padding: auto;
	text-align: center;
}

.text-container {
	margin-bottom: 10px;
}

.text-container span {
	display: inline-block;
	background-color: #4e73df;
	padding: 3%;
	border-radius: 10px;
	color: #fff;
	max-width: 70%;
}

#chatArea::-webkit-scrollbar {
   display: none;
}
</style>



<!-- Custom fonts for this template-->
<link href="${path}/a00_com/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400&display=swap"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="${path}/a00_com/css/sb-admin-2.min.css" rel="stylesheet">


<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script type="text/javascript">
	// 화면 크기에 따라 동적으로 조절 처리
	window.addEventListener("resize", function() {
		$("#chatMessageArea>div").width($("#chatArea").width() - 5)

	})
	// $("#chRoomBtn").text() conFun()
	function conFun() {
		var roomVal = $("#chRoomBtn").text() == "새로운방" ? $("#chRoom").val()
				: $("#chRooms").val()

		$
				.ajax({
					url : "${path}/enterChRoom",
					type : "post",
					data : {
						chroom : roomVal,
						id : $("#id").val()
					},
					dataType : "json",
					success : function(data) {
						//alert(data.result)
						if ($("#chRoomBtn").text() == "새로운방")
							$("#chRoomBtn").click()
							//if(data.result=="입장성공"){
						connChat()
						//}
						var add = ""
						$(data.conIds).each(function(idx, id) {
							add += id + ", "
						})
						$("#chatGroup").text(add)
						if ($("#chRoomBtn").text() == "새로운방") {
							var addHtml = "<option value=''>접속할 채팅방 선택<option>"
							$(data.conRooms)
									.each(
											function(idx, room) {
												addHtml += "<option "
														+ ($("#chRoom").val() == room ? "selected"
																: "") + ">"
														+ room + "</option>"
											})
							$("#chRooms").html(addHtml)
						}
						var account = {
							id : $("#id").val(),
							room : roomVal
						}
						saveAccount(account)//loadAccount()

					},
					error : function(err) {
						console.log(err)
					}

				})
	}
	var wsocket = null;
	function connChat() {
		var socketServer = '${socketServer}'.replace(/^"|"$/g, '')
		wsocket = new WebSocket(socketServer)
		// 주의: localhost:로 현재 pc로 완료가 되었으면 서버(공유아이피주소설정)
		// 업로드 후, 서버에서 잘 작동되는지 확인..

		wsocket.onopen = function(evt) {
			console.log(evt)

			wsocket.send($("#id").val() + ":접속하셨습니다!")
		}
		wsocket.onmessage = function(evt) {
			// 서버에서 push 접속한 모든 client에 전송..
			revMsg(evt.data) // 메시지 처리 공통 함수 정의				
		}

	}
	var mx = 0;
	function revMsg(msg) {
		// 보내는 메시지는 오른쪽
		// 받는 메시지는 왼쪽 정렬 처리 : 사용자아이디:메시지 내용
		var alignOpt = "left"
		var msgArr = msg.split(":") // 사용자명:메시지 구분 하여 처리..
		var sndId = msgArr[0] // 보내는 사람 메시지 id
		if ($("#id").val() == sndId) {
			// 보내는 사람과 받는 사람의 아이디 동일:현재 접속한 사람이 보낸 메시지 
			alignOpt = "right"
			msg = msgArr[1] // 받는 사람 아이디 생략 처리
		}
		/* 		var msgObj = $("<div></div>").text(msg).attr("align", alignOpt).css(
		 "width", $("#chatArea").width()) */

		var msgObj = $("<div class='text-container'></div>").append(
				$("<span></span>").text(msg)).attr("align", alignOpt).css({
			"width" : $("#chatArea").width()
		})

		$("#chatMessageArea").append(msgObj);
		//alert("저장할 메시지:"+$("#chatMessageArea").html())

		saveMessageToLocalStore($("#chatMessageArea").html())
		// 스크롤링 처리..
		// 1. 전체 해당 데이터의 높이를 구한다.
		// 2. 포함하고 있는 부모 객체(#chatArea)에서
		//    스크롤 기능 메서드로 스크롤되게 처리한다. scrollTop()
		var height = parseInt($("#chatMessageArea").height())
		mx += height + 20
		$("#chatArea").scrollTop(mx)

		RoomInfos()
		console.log("접속 방 정보")
		connectorInfo()
		console.log("접속 자 정보")

	}
	$(document).ready(function() {

		$("#enterBtn").click(function() {
			conFun()
		})

		$("#sndBtn").click(function() {
			sendMsg()
		})
		$("#msg").keyup(function() {
			if (event.keyCode == 13) {
				sendMsg()
			}
		})
		$("#exitBtn").click(function() {
			if (confirm("접속을 종료하시겠습니까?")) {
				wsocket.send($("#id").val() + ":접속종료하셨습니다!")
				wsocket.close()
				//alert($("#chRooms").val()+",id:"+$("#id").val())
				$.ajax({
					url : "${path}/exitChRoom",
					type : "post",
					data : {
						chroom : $("#chRooms").val(),
						id : $("#id").val()
					},
					dataType : "json",
					success : function(data) {
						if (delMessageToLocalStore()) {
							$("#chRooms").val("")
							$("#chatGroup").text("")
						} else {
							connectorInfo()
						}

					},
					error : function(err) {
						console.log(err)
					}
				})
			}
		})
		function sendMsg() {
			var message = $("#msg").val(); 
			if (message !== "") { // 메시지가 비어있지 않은 경우에만 전송
				wsocket.send($("#id").val() + ":" + message);
				$("#msg").val("");
			}
		}

		$("#chRoom").show()
		$("#chRooms").hide()
		$("#chRoomBtn").click(

		function() {
			//alert("##현재 방 종류:"+$(this).text())
			if ($(this).text() == "새로운방") {
				$(this).text("방선택")
				$("#chRoom").hide()
				$("#chRooms").show()

				// conRooms  방 ajax
				RoomInfos()

			} else {
				$(this).text("새로운방")

				$("#chRoom").show()
				$("#chRooms").hide()

			}
		})
		$("#chRooms").change(function() {
			var room = $(this).val()
			if (room != "") {
				connectorInfo()
			}
		})

		loadMessages()
		loadAccount()
	});

	function connectorInfo() {
		var roomVal = $("#chRoom").val()
		console.log("##방정보1##")
		console.log(roomVal)	
		if (roomVal == "")
			roomVal = $("#chRooms").val()
			//alert("방정보:"+roomVal)
		console.log("##방정보2##")
		console.log(roomVal)
		$.ajax({
			url : "${path}/conIds",
			type : "get",
			data : {
				chroom : roomVal
			},
			dataType : "json",
			success : function(data) {
				var add = ""
				$(data.conIds).each(function(idx, id) {
					add += id + ", "
				})
				$("#chatGroup").text(add)
			},
			error : function(err) {
				console.log(err)
			}

		})
	}
	function RoomInfos() {
		var roomVal = $("#chRoom").val()
		console.log("##방정보1##")
		console.log(roomVal)	
		if (roomVal == "")
			roomVal = $("#chRooms").val()
		$.ajax({
			url : "${path}/conRooms",
			type : "get",
			dataType : "json",
			success : function(data) {
				var addHtml = "<option value=''>접속할 채팅방 선택<option>"
				$(data.conRooms).each(
						function(idx, room) {
							addHtml += "<option "
									+ (roomVal == room ? "selected"
											: "") + ">" + room + "</option>"
						})
				$("#chRooms").html(addHtml)
			},
			error : function(err) {
				console.log(err)
			}

		})
	}
	function saveMessageToLocalStore(message) {
		var msgStr = localStorage.getItem('chatMessages')
		var messages = JSON.parse((msgStr != null && msgStr != "") ? msgStr
				: "[]");
		messages.push(message);
		localStorage.setItem('chatMessages', JSON.stringify(messages));
	}
	function delMessageToLocalStore() {
		if (confirm("메시지 및 등록 계정 삭제하시겠습니까?")) {
			$("#chatMessageArea").html("")
			$("#chRoom").val("")
			$("#id").val("")
			localStorage.setItem('chatMessages', "");
			localStorage.setItem('account', "");
			location.reload();
			return true;
		} else {
			return false;
		}
	}

	function saveAccount(account) {
		console.log("# 채팅방 입장시 로컬에 저장 #")
		console.log(account)
		localStorage.setItem('account', JSON.stringify(account));
	}

	function loadMessages() {
		console.log('#메시지#')
		//console.log( localStorage.getItem('chatMessages') )
		var msgStr = localStorage.getItem('chatMessages')
		console.log("msgStr:" + msgStr)
		console.log("msgStr:" + typeof (msgStr))
		var messages = JSON.parse((msgStr != null && msgStr != "") ? msgStr
				: "[]");
		console.log(messages)
		//alert("로딩메시지:"+messages)
		messages.forEach(function(message) {
			displayMessage(message);
		});
	}
	function loadAccount() {
		console.log('#계정#') // 
		//console.log( localStorage.getItem('account') )
		var accStr = localStorage.getItem('account')
		var account = JSON.parse(accStr != null && accStr != "" ? accStr
				: "{\"id\":\"\"}");
		console.log(account)
		//alert("로딩계정:"+account.id+":"+account.room)
		if (account.id != "") {
			$("#id").val(account.id)
			$("#chRoom").val(account.room)
			//alert("#방종류 클릭 이벤트 직전")

			//$("#chRoomBtn").click()
			//alert("#방종류 클릭 이벤트 직후")
			//$("#chRooms").val(account.room)
		}

	}

	function displayMessage(message) {
		$("#chatMessageArea").html(message)
		var height = parseInt($("#chatMessageArea").height())
		mx += height + 20
		$("#chatArea").scrollTop(mx)
	}
</script>
</head>

<body id="page-top">


	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<%@ include file="inc/sliderBar.jsp"%>

		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div class="content">

				<!-- Topbar    -->
				<%@ include file="inc/topBar.jsp"%>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">


					<div class="input-group mb-3">
						<div class="input-group-prepend ">
							<span id="chRoomBtn"
								class="input-group-text  justify-content-center">새로운방</span>

						</div>
						<select id="chRooms" class="form-control">
							<option value="">접속할 채팅방 선택</option>
						</select> <input type="text" id="chRoom" class="form-control"
							placeholder="신규 채팅방 만들기" /> <input type="hidden" id="id"
							class="form-control" value="${empResult.ename}" /> <input
							id="enterBtn" type="button" class="btn btn-info" value="채팅방입장" />
						<input id="exitBtn" type="button" class="btn btn-danger"
							value="채팅방나가기" />

					</div>
					<div class="col-xl-4" id="frm">
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

							<div id="chatArea" style="overflow-x: hidden"
								class="input-group-append">
								<div id="chatMessageArea"></div>
							</div>
						</div>
						<div class="input-group mb-3">

							<input type="text" id="msg" class="form-control"
								placeholder="메시지 입력" /> <input type="button" id="sndBtn"
								class="btn btn-success" value="전송" /> <input type="button"
								id="delBtn" class="btn btn-success" value="메시지삭제"
								onclick="delMessageToLocalStore()" />
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Bootstrap core JavaScript-->
	<script src="${path}/a00_com/vendor/jquery/jquery.min.js"></script>
	<script
		src="${path}/a00_com/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="${path}/a00_com/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="${path}/a00_com/js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="${path}/a00_com/vendor/chart.js/Chart.min.js"></script>

</body>
</html>