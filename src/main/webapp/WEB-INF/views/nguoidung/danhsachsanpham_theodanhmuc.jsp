<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<title>Danh sách sản phẩm</title>
<body>
<form 
	action="
		<c:choose>
			  <c:when test = "${not empty giaTriSapXep }">
	           	<c:url value='/danh-sach-san-pham/danh-muc/${danhmucID}/sap-xep/${giaTriSapXep}?page=${abstractDTO.page}&limit=${abstractDTO.limit}'/>
	         </c:when>
	         <c:otherwise>
	         	<c:url value='/danh-sach-san-pham/danh-muc/${danhmucID}?page=${abstractDTO.page}&limit=${abstractDTO.limit}'/>
	         </c:otherwise>
		</c:choose>" 

	id="formSubmit" 
	method="get">


	<!-- Product Style -->
	<section class="product-area shop-sidebar shop section">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-4 col-12">
					<div class="shop-sidebar">

						<!-- Single Widget -->
						<div class="single-widget category">
							<h3 class="title">Loại sản phẩm</h3>
							<ul class="categor-list">
								<c:forEach items="${listDanhMuc}" var="item">
									<li><a href="<c:url value="/danh-sach-san-pham/danh-muc/${item.id}?page=1&limit=12"/>">${item.ten}</a></li>
								</c:forEach>
								
							</ul>
						</div>
						<!--/ End Single Widget -->
						
						
					</div>
				</div>
				<div class="col-lg-9 col-md-8 col-12">
					<div class="row">
						<div class="col-12">
							<!-- Shop Top -->
							<div class="shop-top">
								<div class="shop-shorter">									
									<div class="single-shorter">
										<label>Sắp xếp theo giá :</label> <select id="sepXep">
										<c:choose>
											  <c:when test = "${giaTriSapXep == 'asc' }">
										           	<option disabled >Giá</option>
													<option value="asc"selected="selected" >Giá: Thấp đến cao</option>
													<option value="desc">Giá: Cao đến thấp</option>
									         </c:when>
									         <c:when test = "${giaTriSapXep == 'desc' }">
										           	<option disabled>Giá</option>
													<option value="asc" >Giá: Thấp đến cao</option>
													<option value="desc" selected="selected">Giá: Cao đến thấp</option>
									         </c:when>
									         <c:otherwise>
									         		<option selected="selected" disabled>Giá</option>
													<option value="asc" >Giá: Thấp đến cao</option>
													<option value="desc">Giá: Cao đến thấp</option>
									         </c:otherwise>
										</c:choose>
										
											
										</select>
									</div>
								</div>
								<!-- <ul class="view-mode">
									<li class="active"><a href="shop-grid.html"><i
											class="fa fa-th-large"></i></a></li>
									<li><a href="shop-list.html"><i class="fa fa-th-list"></i></a></li>
								</ul> -->
							</div>
							<!--/ End Shop Top -->
						</div>
					</div>

					<!--  load san pham-->
					<div class="row">
						<c:forEach items="${dsSanPham}" var="sp">
							<div class="col-lg-4 col-md-6 col-12">
								<div class="single-product">
									<div class="product-img">
										<a href="<c:url value="/chi-tiet-san-pham/${sp.id}"/>"> <img class="default-img"
											src="<c:url value="/resources/images/user/sanpham/${sp.anhDaiDien}"/>"
											alt="#"> <img class="hover-img"
											src="<c:url value="/resources/images/user/sanpham/${sp.anhDaiDien}"/>"
											alt="#">
										</a>
										<div class="button-head">
											<div class="product-action-2">
												<a title="Add to cart" href=" <c:url value="/gio-hang/them/${sp.id}"/> ">Thêm vào giỏ hàng</a>
											</div>
										</div>
									</div>
									<div class="product-content">
										<h3>
											<a href="<c:url value="/chi-tiet-san-pham/${sp.id}"/>">${sp.ten}</a>
										</h3>
										<c:choose>
										  <c:when test = "${sp.gia == sp.gia - sp.gia*sp.phanTramGiamGia}">
								            <div class="product-price">
												<span><fmt:formatNumber type="number" pattern = "#,### VND" value="${sp.gia}" /></span>
											</div>
								         </c:when>
								         <c:otherwise>
								         	<div class="product-price"
												style="color: red; text-decoration: line-through;">
												<span><fmt:formatNumber type="number" pattern = "#,### VND" value="${sp.gia}" /></span>
											</div>
											<div class="product-price" >
												<span><fmt:formatNumber type="number" pattern = "#,### VND" value="${sp.gia - sp.gia*sp.phanTramGiamGia/100}" /></span>
											</div>
								         </c:otherwise>
									</c:choose>
									</div>
								</div>
							</div>
						</c:forEach>


					</div>

					<!--phan trang  -->
					<div class="row">
						<div class="col-lg-12 col-md-12 col-12">
							<nav aria-label="Page navigation">
								<ul class="pagination" id="pagination"></ul>
								<input type="hidden" value="" id="page" name="page" />
								 <input type="hidden" value="" id="limit" name="limit" />
							</nav>
						</div>
					</div>
					<!--phan trang  -->
				</div>
			</div>
		</div>
	</section>
	</form>
	<!--/ End Product Style 1  -->
	<content tag="script"> <script type="text/javascript">
	var totalPages = ${abstractDTO.totalPage};
	var currentPage = ${abstractDTO.page};
	var limit = ${abstractDTO.limit};
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : totalPages,
				visiblePages :10,
				startPage: currentPage,
				onPageClick : function(event, page) {
					if (currentPage != page) {
	            		$('#limit').val(limit);
						$('#page').val(page);
						$('#formSubmit').submit();
					}
				}
			});
		});
		
		$("#sepXep").change(function() {
				var x = $("#sepXep").val();
			  window.location = "http://localhost:8080/website-dungcuthethao/danh-sach-san-pham/danh-muc/"+${danhmucID}+"/sap-xep/"+x+"?page=1&limit=12";
			  
			});
	</script> </content>
</body>
