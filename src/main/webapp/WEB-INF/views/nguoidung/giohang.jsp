<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<title>Giỏ hàng</title>
<body>
	<!-- Shopping Cart -->
	<div class="shopping-cart section">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<!-- Shopping Summery -->
					<table class="table shopping-summery">
						<thead>
							<tr class="main-hading">
								<th class="text-center">Sản phẩm</th>
								<th class="text-center">Tên</th>
								<th class="text-center">Giá</th>
								<th class="text-center">Số lượng</th>
								<th class="text-center">Thành tiền</th>
								<th class="text-center"  style="width: 15%;"><i class="ti-settings"></i></th>
							</tr>
						</thead>
						<tbody>

							<c:forEach items="${gioHang}" var="item" varStatus="count">
								<tr>
									<td class="image" data-title="No"><img
										src="<c:url value="/resources/images/user/sanpham/${item.value.sanPham.anhDaiDien}"/>"
										alt="#"></td>
									<td class="product-des" data-title="Description">
										<p class="product-name">
											<a href="<c:url value="/chi-tiet-san-pham/${item.key}"/>">${item.value.sanPham.ten}</a>
										</p>
										
									</td>
									<td class="price" data-title="Price">
											<span><fmt:formatNumber type="number" pattern = "#,### VND" value="${item.value.getGiaBanThucTe()}" /></span>
											</td>
									<td class="qty" data-title="Qty">
										<!-- Input Order -->
										<div class="input-group">
											<div class="button minus">
												<button type="button" class="btn btn-primary btn-number"
													 data-type="minus"
													data-field="quant[${item.key}]">
													<i class="ti-minus"></i>
												</button>
											</div>
											<input type="text" name="quant[${item.key}]"
												class="input-number" data-min="1" data-max="${item.value.sanPham.soLuong}"
												value="${item.value.soLuong}" id="so-luong-${item.key}" >
											<div class="button plus">
												<button type="button" class="btn btn-primary btn-number"
													data-type="plus" data-field="quant[${item.key}]">
													<i class="ti-plus"></i>
												</button>
											</div>
										</div> <!--/ End Input Order -->
									</td>
									<td class="total-amount" data-title="Total">
											<span><fmt:formatNumber type="number" pattern = "#,### VND" value="${item.value.tongGia}" /></span>
											</td>
									<td class="action" data-title="Remove">
										<button data-id="${item.key}" class="edit-cart mr-2"><i class="ti-save"></i>
										</button>
										<a href="<c:url value="/gio-hang/xoa/${item.key}"/>" style="margin-right: 10px; color: red"><i
											class="ti-trash remove-icon"></i>
										</a>
									</td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
					<!--/ End Shopping Summery -->
				</div>
			</div>
			<div class="row">
				<div class="col-12">
					<!-- Total Amount -->
					<div class="total-amount">
						<div class="row">
							<div class="col-lg-8 col-md-5 col-12">
								<div class="left">
									
									<a href="<c:url value="/"/>" class="btn" style="background-color: #F7941D;">Tiếp tục mua hàng</a>
								</div>
							</div>
							<div class="col-lg-4 col-md-7 col-12">
								<div class="right">
									<ul>
										<li>Tổng tiền hàng
												<span><fmt:formatNumber type="number" pattern = "#,### VND" value="${tongThanhTienGioHang}" /></span>
										</li>
										<li>Phí vận chuyển<span>Miễn phí</span></li>
										<!-- <li>Giảm giá<span>$20.00</span></li> -->
										<li class="last">Tổng thanh toán
											<span><fmt:formatNumber type="number" pattern = "#,### VND" value="${tongThanhTienGioHang}" /></span>
										</li>
									</ul>
									<div class="button5">
										<a href='<c:url value="/thanh-toan"/>' class="btn">Mua hàng</a>
										<!-- <a href="#" class="btn">Continue shopping</a>  -->
									</div>
								</div>
							</div>
						</div>
					</div>
					<!--/ End Total Amount -->
				</div>
			</div>
		</div>
	</div>
	<!--/ End Shopping Cart -->
	<content tag="script">
	<script>
		$(".edit-cart").on("click", function(){
			var id = $(this).data("id");
			var soluong = $("#so-luong-"+id).val();
			window.location = "gio-hang/sua/"+id+"/"+soluong;
			alert("Cập nhật thành công");
		});
	</script>
	</content>

</body>