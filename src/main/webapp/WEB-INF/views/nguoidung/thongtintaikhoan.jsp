<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<title>Thông tin tài khoản</title>
<body>
	<div id="layoutSidenav_content">
		<main>
		<div class="container">
			<div class="col-sm-12">
				<h3 class="text-center mt-3">Thông tin tài khoản</h3>
			</div>
			
			<div class="col-sm-12 mt-3 mb-3">
				<form action="trang-chu" method="get" modelAttribute="nguoidung">
				<div class="form-group row">
					<label  class="col-sm-2 col-form-label">Họ tên: </label>
					<label  class="col-sm-10 form-control">${nguoidung.ho} ${nguoidung.ten}</label>
				</div>
				<div class="form-group row">
					<label  class="col-sm-2 col-form-label">Email: </label>
					<label  class="col-sm-7 form-control">${nguoidung.email}</label>
					
					<label  class="col-sm-2 col-form-label">Giới Tính: </label>
					<label  class="col-sm-1 form-control">${nguoidung.gioiTinh?"Nam" : "Nữ"}</label>
				</div>
				<div class="form-group row">
					<label  class="col-sm-2 col-form-label">Tài khoản: </label>
					<label  class="col-sm-4 form-control">${nguoidung.tenDangNhap}</label>
					
					<label  class="col-sm-2 col-form-label">Mật khẩu: </label>
					<label  class="col-sm-1 form-control">******</label>
					
					<div class="col-sm-3 ">
						<a href="<c:url value="doi-mat-khau/${nguoidung.id}" />"
							 class="btn btn-warning float-right" style="width: 100%"><i class="ti-eraser"></i>Đổi mất khẩu</a>
					</div>
					
				</div>

				<div class="form-group row">
					<label  class="col-sm-2 col-form-label">Số điện thoại: </label>
					<label  class="col-sm-10 form-control">${nguoidung.soDienThoai}</label>
				</div>

				<div class="form-group row">
					<label  class="col-sm-2 col-form-label">Địa chỉ:</label>
					<div class="col-sm-8">
						<c:forEach items="${listDC}" var="dc" varStatus="stt">
						<label class="form-control">Địa chỉ ${stt.count}: ${dc.toString()}</label>
					</c:forEach>
					</div>
					<div class="col-sm-2">
						<a href="<c:url value="them-dia-chi/${nguoidung.id}" />"
							type="submit" class="btn btn-primary" style="width: 100%"><i class="ti-plus"></i>Thêm địa chỉ</a>
					</div>
				</div>

				<div class="form-group row">
					<div class="col-2">
						<a href="<c:url value="/trang-chu" />" type="submit"
							class="btn btn-danger" style="width: 100%"><i class="ti-arrow-left" ></i> Quay lại</a>
					</div>

				</div>
			</form>
			</div>
			

		</div>
		</main>

	</div>

</body>
