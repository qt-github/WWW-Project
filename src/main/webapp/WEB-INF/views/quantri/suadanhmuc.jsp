<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<title>Sửa danh muc</title>
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
					<b>SỬA DANH MỤC</b>
				</h3>
				<br>
			</div>
			<form:form method="POST" modelAttribute="danhmuc"
				action="luu-thong-tin">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Tên loại sản phẩm:</label>
					<div class="col-sm-10">
						<form:input type="text" cssClass="form-control" path="ten" />
						<form:errors cssClass="error" path="ten"></form:errors>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Loại sản phẩm(nếu
						có):</label>
					<div class="col-sm-10">
						<select class="form-control" id="exampleFormControlSelect1"
							name="danhMucCha">
							<option value=""></option>
							<c:forEach items="${listDMCha}" var="dmcha">
								<c:choose>
									<c:when test="${ id==dmcha.id }">
										<option value="${dmcha.id}" selected="selected">${dmcha.ten}</option>
									</c:when>
									<c:otherwise>
										<option value="${dmcha.id}">${dmcha.ten}</option>
									</c:otherwise>
								</c:choose>

							</c:forEach>
						</select>
					</div>
				</div>


				<div class="form-group row">
					<div class="col-sm-12" style="display: flex;justify-content: flex-end;">
						<a href="<c:url value="/quan-tri/danh-muc" />" type="submit"
							class="btn btn-danger mr-2"><i class="fas fa-arrow-left mr-2"></i>Quay lại</a>
						<button type="submit" class="btn btn-primary"> <i class="fas fa-check mr-2"></i>Xác nhận</button>
					</div>
				</div>
			</form:form>
			<div class="form-group row"></div>
		</div>
		</main>

	</div>

</body>
