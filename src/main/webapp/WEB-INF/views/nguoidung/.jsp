<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<title>Thêm sản phẩm</title>
<body>
	<div id="layoutSidenav_content">
		<main>
		<div class="container">
				<div class="col-sm-12 text-center mt-3 mb-3">
					<h3>Thêm sản phẩm</h3>
				</div>
				<form:form action="them-san-pham" method="POST" modelAttribute="sanPham" enctype="multipart/form-data">
				<div class="form-group row">
					<form:label path="ten" cssClass="col-sm-2 col-form-label">Tên sản phẩm</form:label> 
					 <div class="col-sm-10">
						<form:input type="text" cssClass="form-control" path="ten"/> 	
					</div>
				</div>
				
				<div class="form-group row">
					<form:label path="anhDaiDien" cssClass="col-sm-2 col-form-label">Ảnh đại diện</form:label> 
					 <div class="col-sm-4">
					<form:input type="file" cssClass="form-control-file" path="anhDaiDien" /> 	
					</div>
					
					<form:label path="gia" cssClass="col-sm-1 col-form-label">Giá</form:label> 
					 <div class="col-sm-5">
					<form:input type="text" cssClass="form-control" path="gia" /> 	
					</div>
					
				</div>
				
				<div class="form-group row">
					<form:label path="moTa" cssClass="col-sm-2 col-form-label">Mô tả</form:label> 
					 <div class="col-sm-10">
					<form:textarea rows = "3" cols = "30" cssClass="form-control" path="moTa" /> 	
					</div>
				</div>
				
				<div class="form-group row">
					<form:label path="noiDung" cssClass="col-sm-2 col-form-label">Nội dung</form:label> 
					 <div class="col-sm-10">
					<form:textarea rows = "3" cols = "30" cssClass="form-control" path="noiDung" /> 	
					</div>
				</div>
				
				<div class="form-group row">
					<form:label path="soLuong" cssClass="col-sm-2 col-form-label">Số lượng</form:label> 
					 <div class="col-sm-2">
					<form:input type="text" cssClass="form-control" path="soLuong" /> 	
					</div>
					
					<form:label path="thoiGianBaoHanh" cssClass="col-sm-2 col-form-label">Thời gian bảo hành</form:label> 
					 <div class="col-sm-2">
					<form:input type="text" cssClass="form-control" path="thoiGianBaoHanh" /> 
					</div>	
					
					<form:label path="thuongHieu" cssClass="col-sm-2 col-form-label">Thương hiệu</form:label> 
					 <div class="col-sm-2">
					<form:input type="text" cssClass="form-control" path="thuongHieu" /> 
					</div>	
				</div>
				
		
				<div class="form-group row">
					<form:label path="tenDanhMuc" cssClass="col-sm-2 col-form-label">DanhMuc</form:label>
					 <div class="col-sm-10">
					<form:select class="form-control" id="exampleFormControlSelect1"
						path="tenDanhMuc">
						<c:forEach items="${listDanhMuc}" var="danhmuc">
							<form:option value="${danhmuc.ten}">${danhmuc.ten}</form:option>
						</c:forEach>
					</form:select>	
					</div>
				</div>
				
				<div class="form-group row">
					<form:label path="tenNhaCungCap" cssClass="col-sm-2 col-form-label">Nhà cung cấp</form:label>
					 <div class="col-sm-10">
					<form:select class="form-control" id="exampleFormControlSelect1"
						path="tenNhaCungCap">
						<c:forEach items="${listNhaCungCap}" var="ncc">
							<form:option value="${ncc.tenNhaCungCap}">${ncc.tenNhaCungCap}</form:option>
						</c:forEach>
					</form:select>	
					</div>
				</div>
				
				<div class="form-group row">
					<form:label path="tenNhaCungCap" cssClass="col-sm-2 col-form-label">Thuộc tính sản phẩm</form:label>
					 <div class="col-sm-10">
					<form:select class="form-control" id="exampleFormControlSelect1"
						path="tenThuocTinh">
						<c:forEach items="${listThuocTinh}" var="tt">
							<form:option value="${tt.tenThuoctinh}">${tt.tenThuoctinh}</form:option>
						</c:forEach>
					</form:select>	
					</div>
					
					
				</div>
				
				<div class="form-group row">
				
				<form:label path="giaTriThuocTinh" cssClass="col-sm-2 col-form-label">Giá trị thuộc tính</form:label> 
					 <div class="col-sm-10">
					<form:input type="text" cssClass="form-control" path="giaTriThuocTinh" /> 
					</div>
				</div>
				
				<div class="form-group row" style="float: right;">
					<div class="col-sm-2"></div>
					
					<div class="col-sm-3">
						<a href="<c:url value="/quan-tri/quan-ly-san-pham?page=1&limit=3" />" type="submit" class="btn btn-danger" >Hủy</a>
					</div>
					<div class="col-sm-7">
						<button type="submit" class="btn btn-primary" >Thêm sản phẩm</button>
					</div>
				</div>
			</form:form>
			<div class="form-group row">

		</div>
</div>
		</main>

	</div>

</body>
