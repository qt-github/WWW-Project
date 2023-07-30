<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<title>Đăng ký tài khoản - Mã xác nhận</title>

<body>
	<div class="page-wrapper bg-gra-02 p-t-130 p-b-100 font-poppins">
		<div class="wrapper wrapper--w680">
			<div class="card card-4">
				<div class="card-body">
					<c:if test="${not empty mesMaXacNhanSai}">
								<div class="alert alert-danger ">${mesMaXacNhanSai}</div>
							</c:if>
					<h3 class="title">Nhập mã xác nhận</h3>
					<form method="POST" action="<c:url value="/dangky/luu-nguoi-dung"/>">			
						<div class="col-4">
						<label class="label" >Một mã đã được gửi đến email đăng ký của bạn!</label>
						<label class="label" >Vui lòng kiểm tra email của bạn và nhập mã xác nhận để tiến hành đổi mật khẩu</label>
						<label class="label" >Mã xác nhận</label>
						<input class="input--style-4" type="text" name="maXN" >
						</div>
						<div class="p-t-15">
							<input class="btn btn--radius-2 btn--blue" value="Xác nhận" type="submit">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>