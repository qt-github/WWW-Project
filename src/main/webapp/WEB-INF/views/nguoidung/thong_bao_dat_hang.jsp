<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<title>Thông báo đặt hàng</title>

<body class="bg-primary">
	<div id="layoutAuthentication">
		<div id="layoutAuthentication_content">
			<main>
			<div class="container mb-5">
				<div class="row justify-content-center">
					<div class="col-lg-8">
						<div class="card shadow-lg border-0 rounded-lg mt-5">
							<div class="card-header">
								<h3 class="text-center font-weight-light my-4">Đơn hàng của
									bạn đã được gửi đến người bán. Vui lòng chờ xác nhận từ cửa
									hàng</h3>
							</div>
							<div class="card-body text-center">
								<a href=" <c:url value="/"/>">Quay lại trang chủ</a>
							</div>
						</div>
					</div>
				</div>
			</div>
			</main>
		</div>
	</div>
</body>