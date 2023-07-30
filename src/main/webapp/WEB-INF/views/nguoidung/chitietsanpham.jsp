<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<title>Chi tiết sản phẩm</title>
<body class="js">
	<fmt:requestEncoding value="UTF-8" />
	<!-- Start Blog Single -->
	<section class="blog-single section">
		<div class="container">
			<form:form action="luu-binh-luan/${sp.id}" method="POST"
				enctype="multipart/form-data">
				<div class="row">
					<div class="col-lg-12 col-12">
						<div class="blog-single-main">
							<div class="row no-gutters">

								<div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
									<!-- Product Slider -->
									<div class="product-gallery">
										<div class="quickview-slider-active">
											<div class="single-slider">
												<img
													src="<c:url value="/resources/images/user/sanpham/${sp.anhDaiDien}"/>"
													alt="#">
											</div>
											<div class="single-slider">
												<img
													src="<c:url value="/resources/images/user/sanpham/${sp.anhDaiDien}"/>"
													alt="#">
											</div>

										</div>
									</div>
									<!-- End Product slider -->
								</div>
								<div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
									<div class="quickview-content">
										<h2>${sp.ten}</h2>
										<div class="quickview-ratting-review">
											<div class="quickview-ratting-wrap">
												<div class="quickview-ratting">
													<i class="yellow fa fa-star"></i> <i
														class="yellow fa fa-star"></i> <i
														class="yellow fa fa-star"></i> <i
														class="yellow fa fa-star"></i> <i class="fa fa-star"></i>
												</div>
												<a href="#"> ( ${sp.soLuotXem} lượt xem)</a>
											</div>
											<div class="quickview-stock">
												<c:if test="${sp.soLuong > 0}">
													<span><i class="fa fa-check-circle-o"></i> còn hàng
														${sp.soLuong}</span>

												</c:if>
												<c:if test="${sp.soLuong == 0}">
													<span><i class="fa fa-times-circle"></i> hết hàng</span>

												</c:if>

											</div>
										</div>
										
										<div class="quickview-peragraph">
											<p>Thương hiệu: ${sp.thuongHieu}</p>
										</div>
										
										<div class="quickview-peragraph">
											<p>	Thời gian bảo hành: ${sp.thoiGianBaoHanh} tháng</p>
										</div>
										
										<c:choose>
											<c:when
												test="${sp.gia == sp.gia - sp.gia*sp.phanTramGiamGia/100}">
												<div class="product-price">
													<span><fmt:formatNumber type="number"
															pattern="#,### VND" value="${sp.gia}" /></span>
												</div>
											</c:when>
											<c:otherwise>
											<div class="product-price"
													style="color: red;">
														Giá gốc: <span style="text-decoration: line-through;"><fmt:formatNumber type="number"
															pattern="#,### VND" value="${sp.gia}" /></span>
												</div>
												<div class="product-price">
													Giá khuyến mãi: <span><fmt:formatNumber type="number"
															pattern="#,### VND"
															value="${sp.gia - sp.gia*sp.phanTramGiamGia/100}" /></span>
												</div>
											</c:otherwise>
										</c:choose>
										<div class="quickview-peragraph">
											<p>${sp.moTa}</p>
										</div>
										<div class="add-to-cart">
											<a href="<c:url value="/gio-hang/them/${sp.id}"/>" class="btn">Thêm vào giỏ hàng</a>
										</div>

									</div>
								</div>
							</div>

						</div>
					</div>

				</div>
				<div class="row">
					<div class="col-8">
						<div class="blog-detail">
							<h2 class="blog-title">Chi tiết sản phẩm</h2>
							<div class="content">
								<p>${sp.noiDung}</p>
							</div>
						</div>

						<div class="comments">

							<div class="row">
								<div class="col-12">
									<h3 class="comment-title">Bình luận</h3>

									<textarea rows="3" cols="30" class="form-control"
										name="binhLuan"> </textarea>
									<br>
								</div>
							</div>

							<div class="row">
								<div class="col-10">
									<input name="anhSanPham" type="file">
								</div>

								<div class="col-2">
									<input type="submit" class="btn btn-primary" value="Bình Luận">
									<%-- 	<a href="<c:url value="luu-binh-luan/${sp.id}" />" type="submit" class="btn btn-primary" >Bình Luận</a> --%>
								</div>
							</div>

							<br>

							<c:forEach items="${listBL}" var="bl">
								<hr>
								<!-- Single Comment -->
								<div class="single-comment">
									<img
										src="https://png.pngtree.com/png-vector/20190710/ourmid/pngtree-user-vector-avatar-png-image_1541962.jpg"
										alt="#">
									<div class="content">
										<h4>${bl.nguoidung.ho}
											${bl.nguoidung.ten}<span>${bl.ngayBinhLuan}</span>
										</h4>
									</div>
								</div>
								<div class="content">
									<p>${bl.binhLuan}</p>
									<img style="width: 300px; height: 300px" alt="#"
										src="<c:url value="/resources/images/user/sanpham/${bl.anhSanPham}"/>">
								</div>
								<!-- End Single Comment -->
							</c:forEach>

						</div>

					</div>
				</div>
			</form:form>
		</div>

	</section>
	<!--/ End Blog Single -->

</body>