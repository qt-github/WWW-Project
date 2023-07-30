<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<title>Thêm danh muc</title>
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
				<h3>
					<b>THÊM DANH MỤC</b>
				</h3>
				<br>
			</div>
			<form:form method="POST" modelAttribute="danhmuc">
				<div class="form-group row">
					<form:label path="ten" cssClass="col-sm-2 col-form-label">Tên loại sản phẩm:</form:label>
					<div class="col-sm-10">
						<form:input type="text" cssClass="form-control" path="ten" />
						<form:errors cssClass="error" path="ten"></form:errors>
					</div>
				</div>
				<div class="form-group row">
					<form:label path="ten" cssClass="col-sm-2 col-form-label">Loại sản phẩm:</form:label>
					<div class="col-sm-10">
						<select class="form-control" id="exampleFormControlSelect1"
							name="danhMucCha">
							<option value=""></option>
							<c:forEach items="${listDMCha}" var="dmcha">
								<option value="${dmcha.id}">${dmcha.ten}</option>
							</c:forEach>
						</select>
					</div>
				</div>


				<div class="form-group row" >
					<div class="col-sm-2"></div>

					<div class="col-sm-3">
						<a href="<c:url value="/quan-tri/danh-muc" />" type="submit"
							class="btn btn-danger">Quay lại</a>
					</div>
					<div class="col-sm-7">
						<button type="submit" class="btn btn-primary">Lưu thông
							tin</button>
					</div>
				</div>
			</form:form>
			<div class="form-group row"></div>
		</div>
		</main>

	</div>

</body>
