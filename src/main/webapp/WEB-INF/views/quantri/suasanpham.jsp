<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<title>Sửa sản phẩm</title>
<style type="text/css">
.error {
	color: red;
}
</style>
<body>
<fmt:requestEncoding value = "UTF-8" />
	<div id="layoutSidenav_content">
		<main>
		<div class="container">
				<div class="col-sm-12 text-center mt-3 mb-3">
					<h3>Sửa sản phẩm</h3>
				</div>
			<%-- 	<form:input path="id" type="hidden"/> --%>
				<form:form action="luu-thong-tin" method="POST" modelAttribute="themSanPhamDTO" enctype="multipart/form-data">
				<div class="form-group row">
					<form:label path="ten" cssClass="col-sm-2 col-form-label">Tên sản phẩm</form:label> 
					 <div class="col-sm-10">
						<form:input type="text" cssClass="form-control" path="ten"/> 
						<form:errors cssClass="error" path="ten"></form:errors>	
					</div>
				</div>
				
				<div class="form-group row">
					<form:label path="anhDaiDien" cssClass="col-sm-2 col-form-label">Ảnh đại diện</form:label> 
					 <div class="col-sm-4">
					<form:input type="file" cssClass="form-control-file" path="anhDaiDien" /> 	
					<form:errors cssClass="error" path="anhDaiDien"></form:errors>
					</div>
					
					<form:label path="gia" cssClass="col-sm-1 col-form-label">Giá</form:label> 
					 <div class="col-sm-5">
					<form:input type="text" cssClass="form-control" path="gia" /> 
					<form:errors cssClass="error" path="gia"></form:errors>	
					</div>
					
					<form:label path="phanTramGiamGia" cssClass="col-sm-2 col-form-label">Giảm giá (%)</form:label> 
					 <div class="col-sm-10">
					<form:input type="text" cssClass="form-control" path="phanTramGiamGia" /> 
					<form:errors cssClass="error" path="phanTramGiamGia"></form:errors>	
					
						
					</div>
				</div>
				
				<div class="form-group row">
					<form:label path="moTa" cssClass="col-sm-2 col-form-label">Mô tả</form:label> 
					 <div class="col-sm-10">
					<form:textarea rows = "3" cols = "30" cssClass="form-control" path="moTa" /> 
					<form:errors cssClass="error" path="moTa"></form:errors>		
					</div>
				</div>
				
				<div class="form-group row">
					<form:label path="noiDung" cssClass="col-sm-2 col-form-label">Nội dung</form:label> 
					 <div class="col-sm-10">
					<form:textarea rows = "3" cols = "30" cssClass="form-control" path="noiDung" /> 
					<form:errors cssClass="error" path="noiDung"></form:errors>		
					</div>
				</div>
				
				<div class="form-group row">
					
					<form:label path="thoiGianBaoHanh" cssClass="col-sm-2 col-form-label">Thời gian bảo hành</form:label> 
					 <div class="col-sm-2">
					<form:input type="text" cssClass="form-control" path="thoiGianBaoHanh" /> 
					<form:errors cssClass="error" path="thoiGianBaoHanh"></form:errors>	
					</div>	
					
					<form:label path="thuongHieu" cssClass="col-sm-2 col-form-label">Thương hiệu</form:label> 
					 <div class="col-sm-2">
					<form:input type="text" cssClass="form-control" path="thuongHieu" /> 
					<form:errors cssClass="error" path="thuongHieu"></form:errors>	
					</div>	
				</div>
				<div class="form-group row" style="float: right;">
					<div class="col-sm-2"></div>
					
					<div class="col-sm-3">
						<a href="<c:url value="/quan-tri/quan-ly-san-pham?page=1&limit=12" />" type="submit" class="btn btn-danger" >Hủy</a>
					</div>
					<div class="col-sm-7">
						<button type="submit" class="btn btn-primary" >Sửa sản phẩm</button>
					</div>
				</div>
			</form:form>
			<div class="form-group row">

		</div>
</div>
		</main>

	</div>

</body>
