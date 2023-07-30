<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<title>Danh mục</title>

<body>

	<div id="layoutSidenav_content">
		<main>
		<div class="container-fluid">
			<form method="post"> 
			<div class="row">
			<div class="col-12">
				<h1 class="mt-4">Quản lý danh mục</h1>
			</div>
			
			</div>
				<div class="card mb-4">
					<div class="card-header">
						<i class="fas fa-table mr-1"></i> Danh sách danh mục sản phẩm
							<div style="float: right;">
								<a
									href="<c:url value='/quan-tri/danh-muc/them-danh-muc'/>"
									class="btn btn-primary">Thêm Danh mục</a>
							</div>
						</div>

					<div class="card-body">
					<div class="row">
					<label class="col-2" for="exampleFormControlSelect1">Loại sản phẩm:</label>
					<div class="col-5">
							<select class="form-control" id="exampleFormControlSelect1" name="dmchaID">
								<c:forEach items="${listDMCha}" var="dmcha">
											<c:choose>
												<c:when test="${ id ==dmcha.id }">
													<option value="${dmcha.id}" selected="selected">${dmcha.ten}</option>
												</c:when>
												<c:otherwise>
													<option value="${dmcha.id}">${dmcha.ten}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
							</select>
					</div>
					<div class="col-5">
						<input type="submit" class="btn btn-primary" value="Lọc ">
						
					</div>
							
						</div>
							<div class="table-responsive" style="margin-top: 20px;">
							<table class="table table-bordered" id="dataTable">
								<thead>
									<tr class="text-center">
										<th>STT</th>
										<th>Tên loại sản phẩm</th>
										<th>Quản lý</th>

									</tr>
								</thead>

								<tbody>
									<c:forEach items="${listDMCon}" var="dmcon" varStatus="count">
										<tr>
											<td>${count.count}</td>
											<td>${dmcon.ten}</td>
											<td>
											<a href=" <c:url value="/quan-tri/danh-muc/sua-danh-muc/${dmcon.id}" />" class="mr-2 ml-2"><i class="far fa-edit"></i>  Sửa thông tin</a>
											</td>
										</tr>
									</c:forEach>
								</tbody>

							</table>

							
						</div>
					</div>
				</div>
			</form>
		</div>

		</main>

	</div>

	
</body>
