<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<title>Thêm địa chỉ</title>
<body>
	<div id="layoutSidenav_content">
		<main>
		<div class="container">
				<div class="col-sm-12 text-center mt-3 mb-3">
					<h3>Thêm địa chỉ </h3>
				</div>
				<c:if test="${not empty message}">
								<div class="alert alert-danger text-center">${message}</div>
							</c:if>
				<form:form action="luu-dia-chi"  method="POST" >
					
				
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Số nhà:</label> 
					 <div class="col-sm-10">
						<input type="text" class="form-control" name="soNha"> 	
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Quận/Huyện:</label> 
					 <div class="col-sm-10">
						<input type="text" class="form-control" name="quanHuyen"> 	
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Tỉnh/Thành phố:</label> 
					 <div class="col-sm-10">
						<input type="text" class="form-control" name="tinhThanhPho"> 	
					</div>
				</div>
				<div class="form-group row" >
					<div class="col-sm-2"></div>
					<div class="col-sm-10">
							
						<button type="submit" class="btn btn-primary float-right ml-2"><i class="ti-save mr-2"></i>Lưu Địa chỉ</button>
						<a href="<c:url value="/thong-tin-tai-khoan" />" type="submit"
							class="btn btn-danger float-right"><i class="ti-arrow-left"></i>Quay lại</a>
					</div>
				</div>
			</form:form>
			<div class="form-group row">

		</div>
</div>
		</main>

	</div>

</body>
