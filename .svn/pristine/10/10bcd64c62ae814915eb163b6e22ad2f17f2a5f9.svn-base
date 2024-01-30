<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<fmt:requestEncoding value="utf-8" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FlowBrick-signUp</title>




<%--
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script
	src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api"
	type="text/javascript"></script>

<script type="text/javascript">
	$(document).ready(function() {

	});
</script>
 --%>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {

				$("#signUpBtn").click(function() {

					//초기화 구문
					$('.failureEname-message').addClass('hide');
					$('.failureEmail-message').addClass('hide');
					$('.failureJob-message').addClass('hide');
					$('.failureDept-message').addClass('hide');

					// 입력 필드 검증
					var ename = $("#ename").val();
					var email = $("#email").val();
					var dept = $("#dept").val();
					var job = $("#job").val();

					if (ename === "") {
						$("#ename").focus();
						$('.failureEname-message').removeClass('hide');

						return; // 사원번호가 비어있으면 처리 중단
					}

					if (email === "" || emailFormat(email) === false) {
						$("#email").focus();
						$('.failureEmail-message').removeClass('hide');
						return; // 이메일이 비어있거나 형식이 맞지않으면 처리 중단
					}

					if (dept === "") {
						$("#dept").focus();
						$('.failureDept-message').removeClass('hide');
						return; // 부서명이 비어있으면 처리 중단
					}

					if (job === "") {
						$("#job").focus();
						$('.failureJob-message').removeClass('hide');
						return; // 직급이 비어있으면 처리 중단
					}

					// 모든 검증이 통과되면 폼 제출
					$("#signUpFrm").submit(); 
				
			
				})

				// emailFormat 함수 정의
				function emailFormat(str) {
					return /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+$/
							.test(str);
				}

				var msg = "${msg}"
				if (msg != "") {
					if (!confirm(msg + "\n계속 등록하시겠습니까?")) {
						location.href = "${path}/sigunUp.do"
					}
					/* location.href = "${path}/sigunUp.do" */
				}

			});
</script>










<!-- Custom fonts for this template-->
<link href="${path}/a00_com/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="${path}/a00_com/css/sb-admin-2.min.css" rel="stylesheet">
<link href="${path}/a00_com/css/login.css" rel="stylesheet">


</head>





<body class="bg-gradient-primary">

	<div class="container">

		<!-- Outer Row -->
		<div class="row justify-content-center">

			<div class="col-xl-10 col-lg-12 col-md-9">

				<div class="card o-hidden border-0 shadow-lg my-5">
					<div class="card-body p-0">
						<!-- Nested Row within Card Body -->
						<div class="row">
							<div class="col-lg-6 d-none d-lg-block signUp-image">
								<img src="${path}/a00_com/img/signUp.jpg">
							</div>
							<div class="col-lg-6">
								<div class="p-5">
									<div class="text-center">
										<div class="brand-icon">
											<img class='img-icon' src="${path}/a00_com/img/FB_icon4.png">
										</div>
										<h1 class="h4 text-gray-900 mb-4">사원등록</h1>
									</div>
									<form class="user" method="post" id="signUpFrm">
										<div class="form-group">
											<input type="text" name="ename"
												class="form-control form-control-user" id="ename"
												placeholder="이름 입력">
										</div>
										<div class="failureEname-message hide error-message">이름을
											입력해주세요</div>
										<div class="form-group">
											<input type="email" name="email"
												class="form-control form-control-user" id="email"
												placeholder="이메일 입력">
										</div>
										<div class="failureEmail-message hide error-message">올바른
											이메일 형식이 아닙니다.</div>

										<div class="form-group">
											<select class="form-select form-control " name="deptno"
												id="dept">
												<option value="" hidden selected>부서 선택</option>
												<option value="10">개발팀</option>
												<option value="20">인사팀</option>
												<option value="30">기획팀</option>
												<option value="40">디자인팀</option>
												<option value="50">마케팅팀</option>
											</select>
										</div>
										<div class="failureDept-message hide error-message">부서를
											입력해주세요</div>


										<div class="form-group">
											<select class="form-select form-control" name="job" id="job">
												<option value="" hidden selected>직급 선택</option>
												<option value="대표">대표</option>
												<option value="팀장">팀장</option>
												<option value="부장">부장</option>
												<option value="차장">차장</option>
												<option value="과장">과장</option>
												<option value="대리">대리</option>
												<option value="주임">주임</option>
												<option value="사원">사원</option>
												<option value="인턴">인턴</option>
											</select>
										</div>
										<div class="failureJob-message hide error-message">직급을
											입력해주세요</div>


										<button type="button"
											class="btn btn-primary btn-user btn-block" id=signUpBtn>사원등록</button>

									</form>
									<hr>
									<div class="text-center">
										<a class="small" href="${path}/maintenanceFrm.do">관리자페이지로 이동</a>
									</div>
									<!-- <div class="text-center">
										<a class="small" href="forgot-password.html">비밀번호 찾기</a>
									</div> -->
									<!-- <div class="text-center">
										<a class="small" href="register.html">사원번호 등록 신청</a>
									</div> -->
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>

	</div>


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

	<!-- Page level custom scripts -->
	<script src="${path}/a00_com/js/demo/chart-area-demo.js"></script>
	<script src="${path}/a00_com/js/demo/chart-pie-demo.js"></script>
</body>
</html>