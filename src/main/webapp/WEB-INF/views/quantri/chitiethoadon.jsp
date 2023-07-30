<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<title>Quản lý hóa đơn</title>

<body>
	<div id="layoutSidenav_content">
		<main>
		<div class="container-fluid">
		<form> 
			<h1 class="mt-4">Quản lý hóa đơn</h1>
			
			<div class="card mb-4">
				<div class="card-header">
					<i class="fas fa-table mr-1"></i> Chi tiết hóa đơn
					
				</div>
			</div>
			
			<div class="row">
			
				<label class="col-sm-4 col-form-label">Mã đơn: ${hoaDon.id} </label> 
			</div>
			<div class="row">
			
				<label class="col-sm-4 col-form-label">Tên khách hàng: ${nguoiDung.ho} ${nguoiDung.ten} </label> 
			</div>
			
			<div class="row">
			
				<label class="col-sm-4 col-form-label">Số điện thoại: ${nguoiDung.soDienThoai} </label> 
			</div>
			
			<div class="row">
			
				<label class="col-sm-4 col-form-label">Ngày đặt: ${hoaDon.ngayDat} </label> 
			</div>
			
			<div class="row">
			
				<label class="col-sm-4 col-form-label">Ngày nhận dự kiến: ${hoaDon.ngayNhanDuKien} </label> 
			</div>
			
			<div class="row">
			
				<label class="col-sm-4 col-form-label">Ngày nhận : ${hoaDon.ngayNhan} </label> 
			</div>
			
			<div class="row">
			
				<label class="col-sm-4 col-form-label">Số lượng sản phẩm: ${hoaDon.soLuongSanPham} </label> 
			</div>
			
			<div class="row">
		
				<label class="col-sm-4 col-form-label">Tổng tiền:<span><fmt:formatNumber type="number" pattern = "#,### VND" value="${hoaDon.tongTienHoaDon}" /></span> </label> 
			</div>
			
			<div class="row">
		
				<label class="col-sm-4 col-form-label">Sản phẩm: </label> 
			</div>
			
			<div class="row">
		
			<div class="col-10">
				<div class="table-responsive">
						<table class="table table-bordered" id="dataTable" width="80%"
							cellspacing="0">
							<thead>
								<tr>
									<th>STT</th>
									<th>Tên sản phẩm</th>
										<th>Ảnh sản phẩm</th>
									<th>Giá</th>
									<th>Giá giảm</th>
									<th>Thời gian bảo hành</th>
									<th>Thương hiệu</th>
								</tr>
							</thead>

							<tbody>
							<c:forEach items="${listSP}" var="sp" varStatus="stt">
								<tr>
									<td>${stt.count}</td>
									<td>${sp.ten}</td>
									<td><img style="width:100px;height: 100px;" alt="" src="<c:url value="/resources/images/user/sanpham/${sp.anhDaiDien}"/>">  </td>
									<td><span><fmt:formatNumber type="number" pattern = "#,### VND" value="${sp.gia}" /></span></td>
									<td><span><fmt:formatNumber type="number" pattern = "#,### VND" value="${sp.gia - sp.gia * sp.phanTramGiamGia / 100}" /></span></td>
									<td>${sp.thoiGianBaoHanh } Tháng</td>
									<td>${sp.thuongHieu }</td>
								</tr>
								</c:forEach>
							</tbody>

						</table>
						
						<div class="row">
								<div class="col-lg-12 col-md-12 col-12">
									<nav aria-label="Page navigation">
										<ul class="pagination" id="pagination"></ul>
										<input type="hidden" value="" id="page" name="page" /> <input
											type="hidden" value="" id="limit" name="limit" />
									</nav>
								</div>
							</div>
					</div>
					</div>
					<div class="col-1"></div>
			</div>
			<div style="width: 100%; text-align: center;">
			<a href="<c:url value='/quan-tri/quan-ly-hoa-don?page=1&limit=3'/>" class="btn btn-primary">Quay Lại</a>
			</div>
		
			
			</form>
		</div>
		</main>
	</div>
</body>
