<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@include file="/common/taglib.jsp"%>
<title>Thêm thuộc tính sản phẩm</title>
<body>
	<div id="layoutSidenav_content">
		<main>
		<div class="container">
			<div class="col-sm-12 text-center mt-3 mb-3">
				<h3>
					<b>Thêm thuộc tính sản phẩm</b>
				</h3>
				<br>
			</div>
			<form method="POST">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Tên thuộc tính:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="tenThuocTinh" />
					</div>
				</div>
				
				<div class="form-group row">
				<div class="col-sm-10"></div>
				<div class="col-sm-2 ">
					<a href="<c:url value="/quan-tri/quan-ly-san-pham?page=1&limit=12"/> " class="btn btn-danger mr-2">Trở lại</a>
					<button type="submit" class="btn btn-primary">Thêm</button>
				</div>
					
				</div>

			</form>
		</div>
		</main>

	</div>
</body>
