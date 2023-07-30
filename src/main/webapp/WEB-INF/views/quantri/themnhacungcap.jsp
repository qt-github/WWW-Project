<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<title>Thêm nhà cung cấp</title>
<style type="text/css">
.error {
	color: red;
}
</style>
<body>
	<div id="layoutSidenav_content">
		<main>
		<div class="container">
				<div class="col-sm-12 text-center mt-3 mb-3">
					<h3>thêm nhà cung cấp</h3>
				</div>
				<form:form  method="POST" modelAttribute="nhaCungCap">
				<div class="form-group row">
					<form:label path="tenNhaCungCap" cssClass="col-sm-2 col-form-label">Tên nhà cung cấp:</form:label> 
					 <div class="col-sm-10">
						<form:input type="text" cssClass="form-control" path="tenNhaCungCap"/> 
						<form:errors cssClass="error" path="tenNhaCungCap"></form:errors>
					</div>
				</div>
				
				<div class="form-group row">
					<form:label path="soDienThoai" cssClass="col-sm-2 col-form-label">Số điện thoại:</form:label> 
					 <div class="col-sm-10">
						<form:input type="text" cssClass="form-control" path="soDienThoai"/> 
						<form:errors cssClass="error" path="soDienThoai"></form:errors>
					</div>
				</div>
				<div class="form-group row">
					<form:label path="email" cssClass="col-sm-2 col-form-label">Email:</form:label> 
					 <div class="col-sm-10">
						<form:input type="text" cssClass="form-control" path="email"/> 
						<form:errors cssClass="error" path="email"></form:errors>
					</div>
				</div>
				<div class="form-group row">
					<form:label path="diachi" cssClass="col-sm-2 col-form-label">Địa chỉ:</form:label> 
					 <div class="col-sm-10">
						<form:input type="text" cssClass="form-control" path="diachi"/>
						<form:errors cssClass="error" path="diachi"></form:errors> 
					</div>
				</div>
			
				<div class="form-group row" style="float: right;">
					<div class="col-sm-2"></div>
					
					<div class="col-sm-3">
						<a href="<c:url value="/quan-tri/nha-cung-cap?page=1&limit=12" />" type="submit" class="btn btn-danger" >Hủy</a>
					</div>
					<div class="col-sm-7">
						<button type="submit" class="btn btn-primary" >Lưu thông tin</button>
					</div>
				</div>
			</form:form>
			<div class="form-group row">

		</div>
</div>
		</main>

	</div>

</body>
