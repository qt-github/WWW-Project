<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<title>Trang chủ</title>
<body>
	<!-- Slider Area -->
	<section class="hero-slider">
		<!-- Single Slider -->
		<div class="single-slider">
			<div class="container">
				<div class="row no-gutters">
					<div class="col-lg-9 offset-lg-3 col-12">
						<div class="text-inner">
							<div class="row">
								<div class="col-lg-7 col-12"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--/ End Single Slider -->
	</section>

	<!-- Start Most Popular -->
	<div class="product-area most-popular section">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="section-title">
						<h2>Sản phẩm Nổi bật</h2>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-12">
					<div class="owl-carousel popular-slider">

						<c:forEach items="${dsSanPhamNoiBat}" var="item">
							<!-- Start Single Product -->
							<div class="single-product">
								<div class="product-img">
									<a href="<c:url value="/chi-tiet-san-pham/${item.id}"/>"> <img
										class="default-img"
										src=" <c:url value="/resources/images/user/sanpham/${item.anhDaiDien}"/> "
										alt="#"> <img class="hover-img"
										src="<c:url value="/resources/images/user/sanpham/${item.anhDaiDien}"/> "
										alt="#"> <span class="out-of-stock">Hot</span>
									</a>
									<div class="button-head">
										<div class="product-action-2">
											<a title="Add to cart"
												href="<c:url value="/gio-hang/them/${item.id}"/>">Thêm
												vào giỏ hàng</a>
										</div>
									</div>
								</div>
								<div class="product-content">
									<h3>
										<a href="<c:url value="/chi-tiet-san-pham/${item.id}"/>">${item.ten}</a>
									</h3>
									<c:choose>
										<c:when
											test="${item.gia == item.gia - item.gia*item.phanTramGiamGia/100}">
											<div class="product-price">
												<span><fmt:formatNumber type="number"
														pattern="#,### VND" value="${item.gia}" /></span>
											</div>
										</c:when>
										<c:otherwise>
											<div class="product-price"
												style="color: red; text-decoration: line-through;">
												<span><fmt:formatNumber type="number"
														pattern="#,### VND" value="${item.gia}" /></span>
											</div>
											<div class="product-price">
												<span><fmt:formatNumber type="number"
														pattern="#,### VND"
														value="${item.gia - item.gia*item.phanTramGiamGia/100}" /></span>
											</div>
										</c:otherwise>
									</c:choose>

								</div>
							</div>
							<!-- End Single Product -->
						</c:forEach>

					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Most Popular Area -->

	<!-- Start Shop Home List  -->
	<section class="shop-home-list section">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-6 col-12">
					<div class="row">
						<div class="col-12">
							<div class="shop-section-title">
								<h1>Giảm giá khủng</h1>
							</div>
						</div>
					</div>


					<c:forEach items="${dsSanPhamGiamGiaCaoNhat}" var="item">
						<!-- Start Single List  -->
						<div class="single-list">
							<div class="row">
								<div class="col-lg-6 col-md-6 col-12">
									<div class="list-image overlay">
										<img
											src=" <c:url value="/resources/images/user/sanpham/${item.anhDaiDien}"/> "
											alt="#"> <a
											href="<c:url value="/gio-hang/them/${item.id}"/>" class="buy"><i
											class="fa fa-shopping-bag"></i></a>
									</div>
								</div>

								<div class="col-lg-6 col-md-6 col-12 no-padding">
									<div class="content">
										<h5 class="title">
											<a href="<c:url value="/chi-tiet-san-pham/${item.id}"/>">${item.ten}</a>
										</h5>

										<c:choose>
											<c:when
												test="${item.gia == item.gia - item.gia*item.phanTramGiamGia/100}">
												<div class="price with-discount">
													<span><fmt:formatNumber type="number"
															pattern="#,### VND" value="${item.gia}" /></span>

												</div>
											</c:when>
											<c:otherwise>
												<div class="product-price">
													Giá gốc: <span
														style="color: red; text-decoration: line-through; margin-right: 10px"><fmt:formatNumber
															type="number" pattern="#,### VND" value="${item.gia}" /></span>

												</div>
												
												Giá hiện tại:   <div class="price with-discount">
													<span><fmt:formatNumber type="number"
															pattern="#,### VND"
															value="${item.gia - item.gia*item.phanTramGiamGia/100}" /></span>
												</div>
											</c:otherwise>
										</c:choose>
									</div>
								</div>
							</div>
						</div>
						<!-- End Single List  -->
					</c:forEach>
				</div>
				<div class="col-lg-6 col-md-6 col-12">
					<div class="row">
						<div class="col-12">
							<div class="shop-section-title">
								<h1>Lượt xem cao nhất</h1>
							</div>
						</div>
					</div>
					<c:forEach items="${dsSanPhamLuotXemCaoNhat}" var="item">
						<!-- Start Single List  -->
						<div class="single-list">
							<div class="row">
								<div class="col-lg-6 col-md-6 col-12">
									<div class="list-image overlay">
										<img
											src=" <c:url value="/resources/images/user/sanpham/${item.anhDaiDien}"/> "
											alt="#"> <a
											href="<c:url value="/gio-hang/them/${item.id}"/>" class="buy"><i
											class="fa fa-shopping-bag"></i></a>
									</div>
								</div>
								<div class="col-lg-6 col-md-6 col-12 no-padding">
									<div class="content">
										<h5 class="title">
											<a href="<c:url value="/chi-tiet-san-pham/${item.id}"/>">${item.ten}</a>
										</h5>
										<c:choose>
											<c:when
												test="${item.gia == item.gia - item.gia*item.phanTramGiamGia/100}">
												<div class="price with-discount">
													<span><fmt:formatNumber type="number"
															pattern="#,### VND" value="${item.gia}" /></span>

												</div>
											</c:when>
											<c:otherwise>
												<div class="product-price">
													Giá gốc: <span
														style="color: red; text-decoration: line-through; margin-right: 10px"><fmt:formatNumber
															type="number" pattern="#,### VND" value="${item.gia}" /></span>

												</div>												
												Giá hiện tại:   <div class="price with-discount">
													<span><fmt:formatNumber type="number"
															pattern="#,### VND"
															value="${item.gia - item.gia*item.phanTramGiamGia/100}" /></span>
												</div>
											</c:otherwise>
										</c:choose>
									</div>
								</div>
							</div>
						</div>
						<!-- End Single List  -->
					</c:forEach>
				</div>
			</div>
		</div>
	</section>
	<!-- End Shop Home List  -->

	<!-- Start Cowndown Area -->
	<section class="cown-down">
		<div class="section-inner ">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-6 col-12 padding-right">
						<div class="image">
							<img src="<c:url value="/resources/images/user/sanpham/${spGiamGiaTrongNgay.anhDaiDien}"/>" alt="#">
						</div>
					</div>
					<div class="col-lg-6 col-12 padding-left">
						<div class="content">
							<div class="heading-block">
								<p class="small-title">Giảm giá trong ngày</p>
									<h3 class="title">${spGiamGiaTrongNgay.ten}</h3>
									<p class="text">${spGiamGiaTrongNgay.moTa}</p>
									<h1 class="price">
										<span><fmt:formatNumber type="number" pattern = "#,### VND" value="${spGiamGiaTrongNgay.gia}" /></span> 
										<s><fmt:formatNumber type="number" pattern = "#,### VND" value="${spGiamGiaTrongNgay.gia - spGiamGiaTrongNgay.gia*spGiamGiaTrongNgay.phanTramGiamGia/100}" /></s>
									</h1>
									<div class="add-to-cart" >
											<a href="<c:url value="/gio-hang/them/${spGiamGiaTrongNgay.id}"/>" class="btn" style="color:white;">Thêm vào giỏ hàng</a>
										</div>
								
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- /End Cowndown Area -->


	<!-- Start Shop Services Area -->
	<section class="shop-services section home">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-6 col-12">
					<!-- Start Single Service -->
					<div class="single-service">
						<i class="ti-rocket"></i>
						<h4>Miễn phí vận chuyển</h4>
						<p>Hóa đơn trên 500.000vnd</p>
					</div>
					<!-- End Single Service -->
				</div>
				<div class="col-lg-3 col-md-6 col-12">
					<!-- Start Single Service -->
					<div class="single-service">
						<i class="ti-reload"></i>
						<h4>Hoàn trả hàng</h4>
						<p>Dưới 7 ngày</p>
					</div>
					<!-- End Single Service -->
				</div>
				<div class="col-lg-3 col-md-6 col-12">
					<!-- Start Single Service -->
					<div class="single-service">
						<i class="ti-lock"></i>
						<h4>Thanh toán an toàn</h4>
						<p>Kiểm tra trước khi thanh toán</p>
					</div>
					<!-- End Single Service -->
				</div>
				<div class="col-lg-3 col-md-6 col-12">
					<!-- Start Single Service -->
					<div class="single-service">
						<i class="ti-tag"></i>
						<h4>Giá tốt nhất</h4>
						<p>Giá tôt</p>
					</div>
					<!-- End Single Service -->
				</div>
			</div>
		</div>
	</section>
	<!-- End Shop Services Area -->

	<!-- Start Shop Newsletter  -->
	<!-- <section class="shop-newsletter section">
		<div class="container">
			<div class="inner-top">
				<div class="row">
					<div class="col-lg-8 offset-lg-2 col-12">
						Start Newsletter Inner
						<div class="inner">
							<h4>Bản tin</h4>
							<p>Đăng ký bản tin của chúng tôi và được giảm giá 10% khi mua
								hàng đầu tiên của bạn</p>
							<form action="mail/mail.php" method="get" target="_blank"
								class="newsletter-inner">
								<input name="EMAIL" placeholder="Nhập địa chỉ email" required=""
									type="email">
								<button class="btn">Đăng kí</button>
							</form>
						</div>
						End Newsletter Inner
					</div>
				</div>
			</div>
		</div>
	</section> -->
	<!-- End Shop Newsletter -->



</body>