<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<title>Đơn hàng đã nhận</title>

<body>
	<div id="layoutSidenav_content">
		<main>
		<div class="container">
				<h1 class="mt-4">Đơn hàng đã nhận</h1>
				<div class="card mb-4">
					<div class="card-header"></div>

					<div class="card-body">

						<div class="table-responsive">
							<table class="table table-bordered" id="dataTable">
								<thead>
									<tr class="text-center">
										<th>STT</th>
										<th>Mã hóa đơn</th>
										<th>Khách hàng</th>
										<th>Tổng tiền</th>
										<th>Ngày đặt</th>
										<th>Ngày nhận</th>
										<th>Giao hàng</th>
										<th>Tác vụ</th>

									</tr>
								</thead>

								<tbody>
									<c:forEach items="${listHD}" var="nd" varStatus="stt">
										<tr>
											<td>${stt.count}</td>
											<td>${nd.id}</td>
											<td>${nd.getNguoidung().getTen()}</td>
											<td><span><fmt:formatNumber type="number"
														pattern="#,### VND" value="${nd.tongTienHoaDon}" /></span></td>
											<td>${nd.ngayDat}</td>
											<td>${nd.ngayNhan}</td>
											<td>${nd.nguoiDungXacNhan ? "Đã nhận hàng" :"Đang giao"}</td>
											<td class="text-center" style="color: blue"><a
												href="<c:url value="/don-hang/don-hang-da-nhan/xem-chi-tiet/${nd.id}" />"
												class="mr-2 ml-2 "><i class="ti-link"></i>Xem chi tiết</a></td>
										</tr>
									</c:forEach>
								</tbody>

							</table>

						</div>
					</div>
				</div>
				<div class="form-group row">
					<div class="col-2">
						<a href="<c:url value="/don-hang" />" type="submit"
							class="btn btn-danger" style="width: 100%"><i class="ti-arrow-left" ></i> Quay lại</a>
					</div>

				</div>
		</div>
		</main>
	</div>
</body>
