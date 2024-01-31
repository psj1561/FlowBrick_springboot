<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
 %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<fmt:requestEncoding value="utf-8"/>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css" >
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css" >
    <link href="${path}/a00_com/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${path}/a00_com/css/sb-admin-2.min.css" rel="stylesheet">
 
<style type="text/css">
	.input-group-text{width:100%;background-color:linen;
		color:black;font-weight:bolder;}
	.input-group-prepend{width:20%;}
	#chatArea{
		width:80%;height:200px;overflow-y:auto;text-align:left;
		border:1px solid green;
	}
	.jumbotron{padding:2%;}	
</style>


<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api" type="text/javascript"></script>
<script type="text/javascript">


	$(document).ready(function(){
		
		// submit 엔터 방지
		$("form").on("keypress",function(e){
			if(e.keyCode==13){ 
				e.preventDefault() 
			}
		})
	})
	
	
	function goToMaterialResource(repno){
		alert(repno)
	}
	
	
	function goToRepository(materialresourceno){
		alert(materialresourceno)
	}
	
	
</script>
</head>



<body id="page-top">





	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<%@ include file="inc/sliderBar.jsp" %>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar    -->
				<%@ include file="inc/topBar.jsp" %>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">


<div class="jumbotron text-center">
  <h2>비품창고 리스트</h2>
</div>

<div class="container">


		<form id="frm01" class="form"  method="post">
	  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">

		    <input placeholder="물적자원이름" name="materialresourcename"  value="${repositorySch.materialresourcename}"  class="form-control mr-sm-2"/>
		       
		    <button class="btn btn-info" type="button" id="schBtn">Search</button>
		    <button id="transferBtn" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter" type="button">물적자원 이동</button>
	 	</nav>
	</form>
	
	<!-- 물적자원 테이블 -->
	<table class="table table-hover table-striped">
   	<col width="20%">
   	<col width="20%">
   	<col width="20%">
   	<col width="20%">
   	<col width="20%">


    <thead>
    
      <tr class="table-success text-center">
        <th>물적자원번호</th>
		<th>프로젝트이름</th>
		<th>개당비용</th>
		<th>자원이름</th>
		<th>물건갯수</th>
      </tr>
    </thead>	
    <tbody>
    
    
    	<c:forEach var="mr" items="${mrList}">
    		<tr ondblclick="goToRepository(${mr.materialresourceno})">
    		<td>${mr.materialresourceno}</td>
    		<td>${mr.prjname}</td>
    		<td>${mr.price}</td>
    		<td>${mr.materialresourcename}</td>
    		<td>${mr.productcnt}</td>
    		</tr>
    	</c:forEach>
    	
    	<tr>
    	<td colspan="4" style="text-align:right;">총액 </td><td><fmt:formatNumber value="${totalPriceMr}"/></td>
    	</tr>
    </tbody>

	</table>  
	
	
	<!-- 비품창고 테이블 -->
   <table class="table table-hover table-striped">
   	<col width="16%">
   	<col width="16%">
   	<col width="16%">
   	<col width="16%">
   	<col width="16%">
   	<col width="16%">
    <thead>
    
      <tr class="table-success text-center">
        <th>저장번호</th>
		<th>시설or물건구분</th>
		<th>자원이름</th>
		<th>비품갯수</th>
		<th>임대or구매여부</th>
		<th>시설위치</th>
      </tr>
    </thead>	
    <tbody>
    	<c:forEach var="repository" items="${repositoryList}">
    		<tr ondblclick="goToMaterialResource(${repository.repno})"> 
    		<td>${repository.repno}</td>
    		<td>${repository.division}</td>
    		<td>${repository.materialresourcename}</td>
    		<td>${repository.repcnt}</td>
    		<td>${repository.rentorbuy}</td>
    		<td>${repository.facilityloc}</td>
    		</tr>
    	</c:forEach>
    	
    </tbody>
	</table>  
</div>

				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->
			
			
			
			<!-- Insert Project -->
			<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
					<div class="modal-dialog modal-dialog-centered" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="MateraiResourceTitle">물적자원 등록</h5>
								<button type="button" class="close" data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
							
							
							
								<form id="frm02" class="form" method="post">
								
	
									
									<div class="input-group mb-3">
										<div class="input-group-prepend ">
											<span class="input-group-text  justify-content-center">
												물적자원번호</span>
										</div>
										<input type="number" name="materialresourceno" class="form-control" value=""/>
									</div>
									
									
									
									
									
									<div class="input-group mb-3">
										<div class="input-group-prepend ">
											<span class="input-group-text  justify-content-center">
												프로젝트번호</span>
										</div>
										<input type="number" name="prjNo" class="form-control" readonly value=""/>
									</div>
									
									
									
									
									
									
									
									<div class="input-group mb-3">
										<div class="input-group-prepend ">
											<span class="input-group-text  justify-content-center">
												프로젝트이름</span>
										</div>
										<input type="text" name="prjname" class="form-control" readonly value=""/>
									</div>
									
									
									
									
									
									
									<div class="input-group mb-3">
										<div class="input-group-prepend ">
											<span class="input-group-text  justify-content-center">
												임대or구매</span>
										</div>
										<select name="rentorbuy" class="form-control">
											<option value="0">임대 or 구매 선택하세요</option>
											<option value="1">임대</option>
											<option value="2">구매</option>
										</select> 
									</div>
									
									
									
									
									
									
									
									<div class="input-group mb-3">
										<div class="input-group-prepend ">
											<span class="input-group-text  justify-content-center">
												개당비용</span>
										</div>
										<input type="number" name="price" class="form-control"/>
									</div>
									
									
									
													
									<div class="input-group mb-3">
										<div class="input-group-prepend ">
											<span class="input-group-text  justify-content-center">
												자원이름</span>
										</div>
										<input type="text" name="materialresourcename" class="form-control"/>
									</div>
									
									
									
									
									
																		
									<div class="input-group mb-3">
										<div class="input-group-prepend ">
											<span class="input-group-text  justify-content-center">
												물건갯수</span>
										</div>
										<input type="number" name="productcnt" class="form-control"/>
									</div>
									

									
																		
									<div class="input-group mb-3">
										<div class="input-group-prepend ">
											<span class="input-group-text  justify-content-center">
												시설위치</span>
										</div>
										<input type="text" name="facilityloc" class="form-control"/>
									</div>
									
									
									
									
									
									
									
									<div class="input-group mb-3">
										<div class="input-group-prepend ">
											<span class="input-group-text  justify-content-center">
												시설or물건</span>
										</div>
										<select name="division" class="form-control">
											<option value="0">시설 or 물건 선택하세요</option>
											<option value="1">시설</option>
											<option value="2">물건</option>
	
										</select>
									</div>
									
									
									
									
									
								</form>
							</div>
							
							
							
							
							
							
							
							
							
							<div class="modal-footer">
								<button type="button" id="regBtn" class="btn btn-primary">물적자원 등록</button>
								<button type="button" id="uptBtn" class="btn btn-info">물적자원 수정</button>
								<button type="button" id="delBtn" class="btn btn-warning">물적자원 삭제</button>
								<button type="button" id="toRepositoryBtn" class="btn btn-warning">비품창고 이전</button>
								<button type="button" id="clsBtn" class="btn btn-secondary" data-dismiss="modal">Close</button>
							</div>




						</div>
					</div>
				</div>
			<!-- End of Insert Project -->
			
			
			
			
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
	<a class="scroll-to-top rounded" href="#page-top"> 
		<i class="fas fa-angle-up"></i>
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

<!-- Page level custom scripts -->
<script src="${path}/a00_com/js/demo/chart-area-demo.js"></script>
<script src="${path}/a00_com/js/demo/chart-pie-demo.js"></script>	
</body>
</html>
