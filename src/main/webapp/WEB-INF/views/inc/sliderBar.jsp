<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<fmt:requestEncoding value="utf-8"/>
<style>
.img-icon{ 
	width:45px; /*로고 이미지 크기*/ 
}
</style>  
		<ul	class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">

			<!-- 로고 이미지 -->
			<a	class="sidebar-brand d-flex align-items-center justify-content-center"
				href="${path}/index.do">	
				<div class="sidebar-brand-icon">
					<img class='img-icon' src="${path}/a00_com/img/FB_icon2.png">
				</div>
				<div class="sidebar-brand-text mx-1	">
					FLOW BRICK
				</div>
			</a>

			<hr class="sidebar-divider my-0">

			<!-- Dashboard -->
			<li class="nav-item active"><a class="nav-link"
				href="${path}/index.do"> <i class="fas fa-fw fa-tachometer-alt"></i> <span>대시보드</span></a>
			</li>

			<hr class="sidebar-divider">

			<!-- Heading -->
			<div class="sidebar-heading">업무</div>

			<!-- 프로젝트 -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapsePages"
				aria-expanded="true" aria-controls="collapsePages"> <i
					class="fas fa-fw fa-folder"></i> <span>프로젝트</span>
			</a>
				<div id="collapsePages" class="collapse"
					aria-labelledby="headingPages" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<h6 class="collapse-header">내 프로젝트</h6>
						<a class="collapse-item" href="${path}/projectList">프로젝트 리스트</a>
						<a class="collapse-item" href="${path}/riskList">리스크</a>
					</div>
				</div></li>
				
			<!-- 자산 -->
			<li class="nav-item"><a class="nav-link" href="${path}/z05_bootTmp/a60_chart.jsp">
					<i class="fas fa-fw fa-chart-area"></i> <span>자산</span>
			</a></li>

			<!-- 일정 -->
			<li class="nav-item"><a class="nav-link" href="${path}/z05_bootTmp/a70_tables.jsp">
					<i class="fas fa-fw fa-table"></i> <span>일정</span>
			</a></li>

			<hr class="sidebar-divider d-none d-md-block">
			
			<!-- Heading -->
			<div class="sidebar-heading">기타기능</div>

			<!-- 관리자모드 -->
			<c:if test="${empResult.auth == '관리자'||empResult.auth == '인사관리자'}">
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseTwo"
				aria-expanded="true" aria-controls="collapseTwo"> <i
					class="fas fa-fw fa-cog"></i>
			<span>관리자모드</span>
			</a>
				<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
					data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<c:if test="${empResult.auth == '관리자'||empResult.auth == '인사관리자'}">
							<h6 class="collapse-header">사원관리</h6>
							<a class="collapse-item" href="${path}/empList.do">사원목록</a> <a
								class="collapse-item" href="${path}/signUp.do">사원등록</a>
						</c:if>
						<c:if test="${empResult.auth == '관리자'||empResult.auth == '인사관리자'}">
							<h6 class="collapse-header">부서관리</h6>
							<a class="collapse-item" href="${path}/deptList.do">부서목록</a> <a
								class="collapse-item" href="${path}/deptReg.do">부서등록</a>
						</c:if>
						<c:if test="${empResult.auth=='관리자'}">
							<h6 class="collapse-header">프로젝트관리</h6>
							<a class="collapse-item" href="${path}/riskManage.do">리스크 승인대기</a>
						</c:if>
					</div>
				</div></li>			
			</c:if>


			<!-- Nav Item - Utilities Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseUtilities"
				aria-expanded="true" aria-controls="collapseUtilities"> <i
					class="fas fa-fw fa-wrench"></i> <span>Utilities</span>
			</a>
				<div id="collapseUtilities" class="collapse"
					aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<h6 class="collapse-header">Custom Utilities:</h6>
						<a class="collapse-item" href="${path}/z05_bootTmp/a30_colors.jsp">Colors</a> <a
							class="collapse-item" href="${path}/z05_bootTmp/a40_borders.jsp">Borders</a> <a
							class="collapse-item" href="${path}/z05_bootTmp/a21_animation.jsp">Animations</a>
						<a class="collapse-item" href="${path}/z05_bootTmp/a42_others.jsp">Other</a>
					</div>
				</div></li>

			<!-- Divider -->
			<hr class="sidebar-divider">

			<!-- Sidebar Toggler (Sidebar) -->
			<div class="text-center d-none d-md-inline">
				<button class="rounded-circle border-0" id="sidebarToggle"></button>
			</div>

			<!-- Sidebar Message -->
			<div class="sidebar-card d-none d-lg-flex">
				<img class="sidebar-card-illustration mb-2"
					src="${path}/a00_com/img/undraw_rocket.svg" alt="...">
				<%--	
				<p class="text-center mb-2">
					<strong>SB Admin Pro</strong> is packed with premium features,
					components, and more!
				</p>
				<a class="btn btn-success btn-sm"
					href="https://startbootstrap.com/theme/sb-admin-pro">Upgrade to
					Pro!</a>
				 --%>	
			</div>

		</ul>