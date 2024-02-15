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
<title>empDetail</title>

<!-- Custom fonts for this template-->
<link href="${path}/a00_com/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="${path}/a00_com/css/sb-admin-2.min.css" rel="stylesheet">

<style type="text/css">
td {
	text-align: center;
}

.jumbotron {
	padding: 2%;
}

.input-group-text {
	width: 100%;
	background-color: linen;
	color: black;
	font-weight: bolder;
}

.input-group-prepend {
	width: 20%;
}

#chatArea {
	width: 80%;
	height: 200px;
	overflow-y: auto;
	text-align: left;
	border: 1px solid green;
}
</style>

<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script type="text/javascript">
	var sessId = "${empResult.empno}"
	if (sessId == "") {
		alert("로그인을 하여야 현재화면을 볼 수 있습니다\n로그인 페이지 이동")
		location.href = "${path}/login.do"
	}
	var proc = "${proc}"
	var msg = "${msg}"
	if (proc != "") {
		if (proc == "upt") {
			if (confirm(msg + "\n사원리스트로 이동하시겠습니까?")) {
				location.href = "${path}/empList.do"
			}
		}
		if (proc == "del") {
			alert(msg + "\n사원리스트로 이동")
			location.href = "${path}/empList.do"
		}
	}
	$(document).ready(function() {
		$("#mainBtn").click(function() {
			location.href = "${path}/empList.do";
		})
		$("#uptBtn").click(function() {
			$("form").attr("action", "${path}/empUpdate")
			$("form").submit()
		})
		$("#delBtn").click(function() {
			if (confirm("삭제하시겠습니까?")) {
				var empno = $("[name=empno]").val()
				location.href = "${path}/empDelete?empno=" + empno;
			}
		});
	});
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
			<div id="content">

				<!-- Topbar    -->
				<%@ include file="inc/topBar.jsp"%>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">
				
					<!-- Page Heading -->
					<h1 class="h3 mb-2 text-gray-800">사원관리</h1>
					<p class="mb-4">사원 상세입니다.</p>
					
					<!-- DataTales Example -->
					<div class="container">
						<form method="post">
							<div class="input-group mb-0">
								<div class="input-group-prepend ">
									<span class="input-group-text  justify-content-center">
										사원 번호</span>
								</div>
								<input type="number" name="empno" class="form-control" readonly
									value="${emp.empno}" />
							</div>

							<div class="input-group mb-0">
								<div class="input-group-prepend ">
									<span class="input-group-text  justify-content-center">
										사원명</span>
								</div>
								<input type="text" name="ename" class="form-control"
									value="${emp.ename}" />
							</div>
							<div class="input-group mb-0">
								<div class="input-group-prepend ">
									<span class="input-group-text  justify-content-center">
										부서</span>
								</div>
								<select name="deptno" class="form-control">
									<c:forEach var="dept" items="${dlist}">
										<option value="${dept.deptno}">${dept.dname}
											[${dept.deptno}]</option>
									</c:forEach>
								</select>
								<script type="text/javascript">
									$("[name=deptno]").val("${emp.deptno}")
								</script>
							</div>
							<div class="input-group mb-0">
								<div class="input-group-prepend ">
									<span class="input-group-text  justify-content-center">
										직책</span>
								</div>
								<select name="job" class="form-control">
									<c:forEach var="job" items="${jobs}">
										<option>${job}</option>
									</c:forEach>
								</select>
								<script type="text/javascript">
									// 선택해서 다시 모델 데이터를 받았을 때, 기본 selected를
									// 설정할 때 처리..
									$("[name=job]").val("${emp.job}")
								</script>
							</div>
							<div class="input-group mb-0">
								<div class="input-group-prepend ">
									<span class="input-group-text  justify-content-center">
										전화번호</span>
								</div>
								<input type="text" name="tel" class="form-control"
									value="${emp.tel}" />
							</div>
							<div class="input-group mb-0">
								<div class="input-group-prepend ">
									<span class="input-group-text  justify-content-center">
										이메일</span>
								</div>
								<input type="email" name="email" class="form-control"
									value="${emp.email}" />
							</div>


							<!-- 버튼 div -->
							<div class="my-2"></div>
							<div class="d-sm-flex justify-content-between">
								<div></div>

								<div>
									<a id="uptBtn" class="btn btn-info btn-icon-split"> <span
										class="icon text-white-50"> <i
											class="fas fa-arrow-right"></i>
									</span> <span class="text">수정하기</span>
									</a> <a id="delBtn" class="btn btn-danger btn-icon-split"> <span
										class="icon text-white-50"> <i class="fas fa-trash"></i>
									</span> <span class="text">삭제하기</span>
									</a> <a id="mainBtn" href="${path}/empList.do"
										class="btn btn-secondary btn-icon-split"> <span
										class="icon text-white-50"> <i
											class="fas fa-arrow-right"></i>
									</span> <span class="text">사원목록</span>
									</a>
								</div>

							</div>
						</form>
					</div>
					<!-- /.container-fluid -->

				</div>
				<!-- End of Main Content -->

				<!-- Footer -->
				<footer class="sticky-footer bg-white">
					<div class="container my-auto">
						<div class="copyright text-center my-auto">
							<span>Copyright &copy; Your Website 2021</span>
						</div>
					</div>
				</footer>
				<!-- End of Footer -->

			</div>
			<!-- End of Content Wrapper -->

		</div>
		<!-- End of Page Wrapper -->


		<!-- Scroll to Top Button-->
		<a class="scroll-to-top rounded" href="#page-top"> <i
			class="fas fa-angle-up"></i>
		</a>

		<!-- Bootstrap core JavaScript-->
		<script src="${path}/a00_com/vendor/jquery/jquery.min.js"></script>
		<script
			src="${path}/a00_com/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

		<!-- Core plugin JavaScript-->
		<script
			src="${path}/a00_com/vendor/jquery-easing/jquery.easing.min.js"></script>

		<!-- Custom scripts for all pages-->
		<script src="${path}/a00_com/js/sb-admin-2.min.js"></script>

		<!-- Page level plugins -->
		<script src="${path}/a00_com/vendor/chart.js/Chart.min.js"></script>

		<!-- Page level custom scripts -->
		<script src="${path}/a00_com/js/demo/chart-area-demo.js"></script>
		<script src="${path}/a00_com/js/demo/chart-pie-demo.js"></script>
</body>
</html>