<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<title>Đăng ký tài khoản</title>
<style type="text/css">
.error {
	color: red;
	font-weight: bold;
}
</style>
<body class="bg-primary">
<fmt:requestEncoding value = "UTF-8" />
	<div id="layoutAuthentication">
		<div id="layoutAuthentication_content">
			<main>
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-lg-8">
						
						<div class="card shadow-lg border-0 rounded-lg mt-5">
							<div class="card-header">
								<h3 class="text-center font-weight-light my-4">Đăng ký tài khoản</h3>
							</div>
							<c:if test="${not empty mesErr}">
								<div class="alert alert-danger text-center">${mesErr}</div>
							</c:if>
							<div class="card-body">
							
								<form:form method="POST" action="" modelAttribute="nguoiDungDangKy">
									<div class="row">
										<div class="col-5">
											<div class="form-group">
												<form:label cssClass="small mb-1" path="ho">Họ</form:label> 
												<form:input cssClass="form-control py-4" type="text"  path="ho" />
												<form:errors path="ho" cssClass="error"></form:errors>
											</div>
										</div>
										<div class="col-7">
											<div class="form-group">
												<form:label path="ten" class="small mb-1">Tên</form:label>
												<form:input cssClass="form-control py-4" type="text"  path="ten" />
												<form:errors path="ten" cssClass="error"></form:errors>
											</div>
										</div>
									</div>
									
									<div class="form-group">
										<div class="row">
											
											<div class="col-5">
												<form:label path="gioiTinh" class="small mb-1">Giới tính</form:label>
												<div class="p-t-10">
													<form:radiobutton value="true" path="gioiTinh" label="Nam" />
													<form:radiobutton value="false" path="gioiTinh" label="Nữ"/>						
												</div>
											</div>
										</div>
										
									</div>
									<div class="form-group">
										<form:label path="tenDangNhap"  class="small mb-1">Tên đăng nhập</form:label>
										<form:input cssClass="form-control py-4" type="text" path="tenDangNhap" />
										<form:errors path="tenDangNhap" cssClass="error"></form:errors>
									</div>	
									<div class="form-group">
										<form:label path="email" class="small mb-1">Email</form:label>
										<form:input cssClass="form-control py-4" type="email" path="email" />
										<form:errors path="email" cssClass="error"></form:errors>
									</div>
									<div class="form-group">
										<form:label path="soDienThoai" class="small mb-1">Số điện thoại</form:label>
										<form:input cssClass="form-control py-4" type="text"
											path="soDienThoai" />
											<form:errors path="soDienThoai" cssClass="error"></form:errors>
									</div>
									<div class="form-group">
										<form:label path="matKhau" class="small mb-1">Mật khẩu</form:label>
										<form:password cssClass="form-control py-4" path="matKhau" />
										<form:errors path="matKhau" cssClass="error"></form:errors>
									</div>
									<div class="form-group">
										<form:label path="xacNhanMatKhau" class="small mb-1">Nhập lại mật khẩu</form:label>
										<form:password cssClass="form-control py-4" path="xacNhanMatKhau" />
										<form:errors path="xacNhanMatKhau" cssClass="error"></form:errors>
									</div>
									<div class="form-group float-right">
										<a href="<c:url value="/dang-nhap"/>"class="btn btn-danger">Về đăng nhập</a>
										<button type="submit" class="btn btn-primary">Đăng ký</button>
									</div>

								</form:form>
							</div>

						</div>
					</div>
				</div>
			</div>
			</main>
		</div>
		<div id="layoutAuthentication_footer">
			<footer class="py-4 bg-light mt-auto">
				<div class="container-fluid">
					<div
						class="d-flex align-items-center justify-content-between small">
						<div class="text-muted">Copyright &copy; Your Website 2021</div>
						<div>
							<a href="#">Privacy Policy</a> &middot; <a href="#">Terms
								&amp; Conditions</a>
						</div>
					</div>
				</div>
			</footer>
		</div>
	</div>
</body>