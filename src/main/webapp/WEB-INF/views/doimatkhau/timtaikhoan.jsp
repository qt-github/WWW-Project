<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Quên mật khẩu - Tìm tài khoản</title>



<body class="bg-primary">
	<div id="layoutAuthentication">
		<div id="layoutAuthentication_content">
			<main>
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-lg-5">

						<div class="card shadow-lg border-0 rounded-lg mt-5">
							<div class="card-header">
								<h3 class="text-center font-weight-light my-4">Tìm tài khoản</h3>
							</div>
							<div class="card-body">
								<form action="tim-tai-khoan/xac-nhan" method="post">

									<div class="form-group">
									 <input class="form-control py-4" id="inputPassword"
											type="text" placeholder="Nhập tài khoản" name="tenDangNhap" />
									</div>
									<div class="p-t-15" style="float: right;">
										<input type="submit" class="btn btn-primary"
											value="Tìm tài khoản" />
									</div>
								</form>
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