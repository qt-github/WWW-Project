<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ page import="com.websitedungcuthethao.util.SecurityUtils"%>
<!-- Header -->
<header class="header shop">
	<!-- Topbar -->
	<div class="topbar">
		<div class="container">
			<div class="row">
				<div class="col-lg-4 col-md-12 col-12">
					<!-- Top Left -->
					<div class="top-left">
						<ul class="list-main">
							<li><i class="ti-headphone-alt"></i> 0332 318 056</li>

						</ul>
					</div>
					<!--/ End Top Left -->
				</div>
				<div class="col-lg-8 col-md-12 col-12">
					<!-- Top Right -->
					<div class="right-content">
						<ul class="list-main">

							<security:authorize access="isAnonymous()">
								<li><i class="ti-power-off"></i><a
									href=" <c:url value="/dang-nhap"/> ">Đăng nhập</a></li>
								<li><i class="ti-arrow-right"></i> <a
									href="<c:url value="/dangky"/> ">Đăng ký</a></li>
							</security:authorize>

							<security:authorize access="isAuthenticated()">
								<li><i class="ti-power-off"></i>Welcome <%=SecurityUtils.getPrincipal().getFullName()%></li>
								<li><i class="ti-arrow-right"></i> <a
									href="<c:url value="/dang-xuat"/> ">Thoát</a></li>
							</security:authorize>

						</ul>
					</div>
					<!-- End Top Right -->
				</div>
			</div>
		</div>
	</div>
	<!-- End Topbar -->
	<div class="middle-inner">
		<div class="container">
			<div class="row">
				<div class="col-lg-2 col-md-2 col-12">
					<!-- Logo -->
					<div class="logo">
						<a href="<c:url value="/"/>"><img
							src="<c:url value="/resources/images/user/sunvy_trang.png"/>" alt="logo"></a>
					</div>
					<!--/ End Logo -->

					<div class="mobile-nav"></div>
				</div>
				<div class="col-lg-8 col-md-7 col-12">
					<div class="search-bar-top">
						<div class="search-bar">
							<form>
								<input name="keywork" placeholder="Tìm kiếm tại đây..."
									type="search" id="keywork">
								<button class="btnn" id="btn-search-sp" type="button">
									<i class="ti-search"></i>
								</button>
							</form>

						</div>
					</div>
				</div>
				<div class="col-lg-2 col-md-3 col-12">
					<div class="right-bar">
						<!-- Search Form -->

						<div class="sinlge-bar">
							<a href="<c:url value="thong-tin-tai-khoan" />"
								class="single-icon"><i class="fa fa-user-circle-o"
								aria-hidden="true"></i></a>
						</div>

						<div class="sinlge-bar">
							<a href="<c:url value="don-hang" />" class="single-icon"><i
								class="ti-alarm-clock"></i></a>
						</div>

						<div class="sinlge-bar shopping">

							<c:choose>
								<c:when test="${gioHang.size() > 0}">
									<a href=" <c:url value="/gio-hang"/> " class="single-icon"><i
										class="ti-bag"></i> <span class="total-count">${gioHang.size()}</span></a>
								</c:when>
								<c:otherwise>
									<a href=" <c:url value="/gio-hang"/> " class="single-icon"><i
										class="ti-bag"></i> <span class="total-count">0</span></a>
								</c:otherwise>
							</c:choose>
							<!-- Shopping Item -->

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Header Inner -->
	<div class="header-inner">
		<div class="container">
			<div class="cat-nav-head">
				<div class="row">
					<div class="col-lg-3">
						<div class="all-category">
							<h3 class="cat-heading">
								<i class="fa fa-bars" aria-hidden="true"></i>DANH MỤC
							</h3>
							<ul class="main-category">
								<c:forEach items="${dsDanhMuc}" var="item">
									<li><a
										href="<c:url value="/danh-sach-san-pham/danh-muc/${item.key.id}?page=1&limit=12"/>">${item.key.ten}
											<i class="fa fa-angle-right" aria-hidden="true"></i>
									</a>

										<ul class="sub-category">
											<c:forEach items="${item.value}" var="subItem">
												<li><a
													href="<c:url value="/danh-sach-san-pham/danh-muc/${subItem.id}?page=1&limit=12"/>">${subItem.ten}</a></li>
											</c:forEach>
										</ul></li>
								</c:forEach>

							</ul>
						</div>
					</div>
					<div class="col-lg-9 col-12">
						<div class="menu-area">
							<!-- Main Menu -->
							<nav class="navbar navbar-expand-lg">
								<div class="navbar-collapse">
									<div class="nav-inner">
										<ul class="nav main-menu menu navbar-nav">
											<li class="active"><a href="<c:url value="/"/>">Trang
													chủ</a></li>
											<li><a
												href=" <c:url value="/danh-sach-san-pham?page=1&limit=12"/> ">Sản
													phẩm</a></li>

											<li><a href=" <c:url value="/thong-tin-cua-hang"/> ">Thông
													tin cửa hàng</a></li>
										</ul>
									</div>
								</div>
							</nav>
							<!--/ End Main Menu -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--/ End Header Inner -->

</header>
<!--/ End Header -->