<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<title>Đăng ký tài khoản</title>

<body>
	<div class="page-wrapper bg-gra-02 p-t-130 p-b-100 font-poppins">
		<div class="wrapper wrapper--w680">
			<div class="card card-4">
				<div class="card-body">
					<h2 class="title">Nhập mã xác nhận</h2>
					<form:form method="POST" action="/website-dungcuthethao/quen-mat-khau/doi-mat-khau">			
						<div class="col-4">
						<label class="label" >Một mã đã được gửi đến email đăng ký của bạn!</label>
						<label class="label" >Vui lòng kiểm tra email của bạn và nhập mã xác nhận để tiến hành đổi mật khẩu</label>
						<label class="label" >mã xác nhận</label>
						<input class="input--style-4" type="text" name="maXN" >
						</div>
						<div class="p-t-15">
							<input class="btn btn--radius-2 btn--blue" value="Xác nhận" type="submit">
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>