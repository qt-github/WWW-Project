<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.websitedungcuthethao.util.SecurityUtils"%>
<%@include file="/common/taglib.jsp"%>
<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
	<a class="navbar-brand" href="<c:url value="/quan-tri/trang-chu"/> ">Trang quản trị</a>
	<button class="btn btn-link btn-sm order-1 order-lg-0"
		id="sidebarToggle" href="#!">
		<i class="fas fa-bars"></i>
	</button>
	<!-- Navbar Search-->
	<div class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0"></div>
	<!-- Navbar-->
	<ul class="navbar-nav ml-auto ml-md-0">
		<div class="dropdown">
			<a class="nav-link dropdown-toggle" type="button"
				id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> 
				<security:authorize access="isAuthenticated()">
					Welcome <%=SecurityUtils.getPrincipal().getFullName() %><i class="fas fa-user fa-fw"></i>
				</security:authorize>
			</a>
			<div class="dropdown-menu dropdown-menu-right"
				aria-labelledby="dropdownMenuButton"> <a
					class="dropdown-item" href="<c:url value="/dang-xuat"/>">Đăng xuất</a>
			</div>
		</div>
	</ul>
</nav>
<div id="layoutSidenav">
	<div id="layoutSidenav_nav">
		<nav class="sb-sidenav accordion sb-sidenav-dark"
			id="sidenavAccordion">
			<div class="sb-sidenav-menu">
				<div class="nav">
					<div class="sb-sidenav-menu-heading">Đơn hàng</div>

					</a> <a class="nav-link" href="<c:url value="/quan-tri/quan-ly-hoa-don/don-hang-chua-xac-nhan?page=1&limit=12" />">
						<div class="sb-nav-link-icon">
							<i class="fas fa-table"></i>
						</div> Đơn hàng chưa xác nhận
					</a>
					<div class="sb-sidenav-menu-heading">Quản lý</div>
					<a class="nav-link collapsed" href="#" data-toggle="collapse"
						data-target="#collapseLayouts" aria-expanded="false"
						aria-controls="collapseLayouts">
						<div class="sb-nav-link-icon">
							<i class="fas fa-columns"></i>
						</div> Quản lý
						<div class="sb-sidenav-collapse-arrow">
							<i class="fas fa-angle-down"></i>
						</div>
					</a>
					<div class="collapse" id="collapseLayouts"
						aria-labelledby="headingOne" data-parent="#sidenavAccordion">
						<nav class="sb-sidenav-menu-nested nav">
							<a class="nav-link"
								href="<c:url value="/quan-tri/quan-ly-nguoi-dung?page=1&limit=12"/> ">Quán
								lý người dùng</a> <a class="nav-link"
								href=" <c:url value="/quan-tri/quan-ly-san-pham?page=1&limit=12"/> ">Quản lý
								sản phẩm</a> 
								<a class="nav-link" href="<c:url value="/quan-tri/quan-ly-hoa-don?page=1&limit=12"/> ">Quản
								lý hóa đơn</a>
								
								<a class="nav-link" href="<c:url value="/quan-tri/danh-muc?page=1&limit=12"/> ">Quản lý danh mục</a>
								<a class="nav-link" href="<c:url value="/quan-tri/nha-cung-cap?page=1&limit=12"/> ">Quản lý nhà cung cấp</a>
								
								
								
						</nav>
					</div>

				</div>
			</div>
			<div class="sb-sidenav-footer">
				<div class="small"></div>Sunvy
				
			</div>
		</nav>
	</div>