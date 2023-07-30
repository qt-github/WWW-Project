<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<title>Chi tiết đơn hàng</title>

<body>
	<div id="layoutSidenav_content">
		<main>
		<div class="container">
			<h3>Chi tiết đơn hàng</h3>
				<div class="row">
					<label class="col-sm-4 col-form-label">Mã đơn hàng: ${hoaDon.id}
					</label>
				</div>
				<div class="row">

					<label class="col-sm-4 col-form-label">Tên khách hàng:
						${nguoiDung.ho} ${nguoiDung.ten} </label>
				</div>

				<div class="row">

					<label class="col-sm-4 col-form-label">Số điện thoại:
						${nguoiDung.soDienThoai} </label>
				</div>

				<div class="row">

					<label class="col-sm-4 col-form-label">Ngày đặt:
						${hoaDon.ngayDat} </label>
				</div>

				<div class="row">

					<label class="col-sm-4 col-form-label">Ngày nhận dự kiến:
						${hoaDon.ngayNhanDuKien} </label>
				</div>

				<div class="row">

					<label class="col-sm-4 col-form-label">Ngày nhận :
						${hoaDon.ngayNhan} </label>
				</div>

				<div class="row">

					<label class="col-sm-4 col-form-label">Số lượng sản phẩm:
						${hoaDon.soLuongSanPham} </label>
				</div>

				<div class="row">

					<label class="col-sm-4 col-form-label">Tổng tiền: <fmt:formatNumber
							type="number" pattern="#,### VND"
							value="${hoaDon.tongTienHoaDon}" /></label>
				</div>

				<div class="row">

					<label class="col-sm-4 col-form-label">Sản phẩm: </label>
				</div>

				<div class="row">

					<div class="col-12">
						<div class="table-responsive">
							<table class="table table-bordered" id="dataTable" 
								cellspacing="0">
								<thead>
									<tr>
										<th>STT</th>
										<th>Tên sản phẩm</th>
										<th>Ảnh sản phẩm</th>
										<th>Giá</th>

										<th>Thời gian bảo hành</th>
										<th>Thương hiệu</th>
										<th>Tác vụ</th>
									</tr>
								</thead>

								<tbody>
									<c:forEach items="${listSP}" var="sp" varStatus="stt">
										<tr>
											<td>${stt.count}</td>
											<td>${sp.ten}</td>
											<td><img style="width: 100px; height: 100px;" alt=""
												src="<c:url value="/resources/images/user/sanpham/${sp.anhDaiDien}"/>">
											</td>

											<td><span><fmt:formatNumber type="number"
														pattern="#,### VND"
														value="${sp.gia - sp.gia * sp.phanTramGiamGia/100}" /></span></td>
											<td>${sp.thoiGianBaoHanh }Tháng</td>
											<td>${sp.thuongHieu }</td>
											<td><a
												href="<c:url value="/chi-tiet-san-pham/${sp.id}"/>"> <i class="ti-marker-alt"></i> Đánh
													giá</a></td>
										</tr>
									</c:forEach>
								</tbody>

							</table>


						</div>
					</div>
				</div>
			</div>
		</div>
		</main>
</body>
