<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Đổi mật khẩu</title>

<body>
	<div class="page-wrapper bg-gra-02 p-t-130 p-b-100 font-poppins">
		<div class="wrapper wrapper--w680">
			<div class="card card-4">
				<div class="card-body">
					<h2 class="title">Đổi mật khẩu</h2>
					
					<div class="row">
					<div class="col-12">
						  <p style="color: red">${message}</p>
						</div>
						
					</div>
					<form method="post">
						<div class="row">
						
						<div class="col-12">
							<label class="label col-2">Mật khẩu</label> <input
								class="input--style-4" type="password" placeholder="mật khẩu mới" name="matkhau">
								<br>
								<label class="label col-2">Xác nhận mật khẩu</label> <input
								class="input--style-4" type="password" placeholder="nhập lại mật khẩu" name="xacnhanmatkhau">
						</div>
						<div class="col-12">
					
							<input type="submit" class="btn btn--radius-2 btn--blue"
								value="Đổi mật khẩu" />
						</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>