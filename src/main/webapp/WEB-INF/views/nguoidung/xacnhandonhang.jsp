<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<title>Thông tin đơn hàng</title>
<body>
	<div id="layoutSidenav_content">
		<main>
		<div class="container">
			<div class="col-sm-12 text-center mt-3 mr-3" style="display: flex;justify-content: center;">
				<h3>Danh sách đơn hàng đang giao (${soLuongDonHang})</h3>
				<a
						href="<c:url value="don-hang/don-hang-da-nhan/${nguoidung.id}" />" style="color: blue; padding: 5px; text-transform: uppercase;text-decoration: underline;"><i class="ti-control-play mr-2"></i>Xem đơn
						hàng đã nhận tại đây</a>
				<hr>
			</div>
			<div class="card col-sm-12" style="padding: 2rem">
				<form action="trang-chu" method="get">
					<c:forEach items="${listHD}" var="hd">
						<div class="mt-3 mb-3">
							<div class="form-group row">
								<label class="col-sm-2 col-form-label">Mã đơn hàng: </label> <label
									class="col-sm-2 form-control" style="color: red">${hd.id}</label>

							</div>
							<div class="form-group row">
								<label class="col-sm-2 col-form-label">Họ tên người
									nhận: </label> <label class="col-sm-10 form-control">${nguoidung.ho}
									${nguoidung.ten}</label>
							</div>
							<div class="form-group row">
								<label class="col-sm-2 col-form-label">Email: </label> <label
									class="col-sm-10 form-control">${nguoidung.email}</label>
							</div>

							<div class="form-group row">
								<label class="col-sm-2 col-form-label">Ngày đặt: </label> <label
									class="col-sm-10 form-control">${hd.ngayDat}</label>
							</div>
							<div class="form-group row">
								<label class="col-sm-2 col-form-label">Ngày dự kiến
									nhận: </label> <label class="col-sm-10 form-control">${hd.ngayNhanDuKien}</label>
							</div>
							<div class="form-group row">
								<label class="col-sm-2 col-form-label">Tổng tiền: </label> <label
									class="col-sm-10 form-control"><span><fmt:formatNumber
											type="number" pattern="#,### VND"
											value="${hd.tongTienHoaDon}" /></span></label>
							</div>
							<div class="form-group row">
								<div class="col-9"></div>
								<div class="col-3">
									<a href="<c:url value="/don-hang/xac-nhan/${hd.id}" />"
										type="submit" class="btn btn-primary"><i
										class="ti-check mr-2"></i>Xác nhận đã nhận hàng</a>
								</div>
							</div>
						</div>
					</c:forEach>
				</form>
			</div>

			<div class="form-group row mt-3">
				<div class="col-3">
					<a href="<c:url value="/trang-chu" />" type="submit"
						class="btn btn-danger"><i class="ti-arrow-left"></i> Quay lại</a>
				</div>
			</div>
		</div>
		</main>

	</div>

</body>
