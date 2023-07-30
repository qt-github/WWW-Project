<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<title>Nhà cung cấp</title>

<body>

	<div id="layoutSidenav_content">
		<main>
		<div class="container-fluid">
			<form action="<c:url value='/quan-tri/nha-cung-cap/?page=${abstractDTO.page}&limit=${abstractDTO.limit}'/>" id="formSubmit"> 
			<div class="row">
			<div class="col-12">
				<h1 class="mt-4">Quản lý nhà cung cấp</h1>
			</div>
			
			</div>
				<div class="card mb-4">
					<div class="card-header">
						<i class="fas fa-table mr-1"></i> Danh sách nhà cung cấp
							<div style="float: right;">
								<a
									href="<c:url value='/quan-tri/nha-cung-cap/them-nha-cung-cap'/>"
									class="btn btn-primary">Thêm nhà cung cấp</a>
							</div>
						</div>

					<div class="card-body">

						<div class="table-responsive">

							<table class="table table-bordered" id="dataTable">
								<thead>
									<tr class="text-center">
										<th>STT</th>
										<th>Tên nhà cung cấp</th>
										<th>Địa chỉ</th>
										<th>Số điện thoai</th>
										<th>Email</th>
										
										<th>Quản lý</th>

									</tr>
								</thead>

								<tbody>
									<c:forEach items="${listNCC}" var="ncc" varStatus="count">
										<tr>
											<td>${count.count}</td>
											<td>${ncc.tenNhaCungCap}</td>
											<td>${ncc.diachi}</td>
											<td>${ncc.soDienThoai}</td>
											<td>${ncc.email}</td>
											<td>
											<a href=" <c:url value="/quan-tri/nha-cung-cap/sua-nha-cung-cap/${ncc.id}" />" class="mr-2 ml-2"><i class="far fa-edit"></i></a>
											<button  type="button" onclick="myFunction(${ncc.id})" ><i class="fas fa-trash-alt "></i></button>											
											</td>
										</tr>
									</c:forEach>
								</tbody>

							</table>

							<div class="row">
								<div class="col-lg-12 col-md-12 col-12">
									<nav aria-label="Page navigation">
										<ul class="pagination" id="pagination"></ul>
										<input type="hidden" value="" id="page" name="page" /> <input
											type="hidden" value="" id="limit" name="limit" />
									</nav>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>

		</main>

	</div>

	<content tag="script"> <script type="text/javascript">
		var totalPages = ${abstractDTO.totalPage};
		var currentPage = ${abstractDTO.page};
		var limit = ${abstractDTO.limit};
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : totalPages,
				visiblePages : 10,
				startPage : currentPage,
				onPageClick : function(event, page) {
					if (currentPage != page) {
						$('#limit').val(limit);
						$('#page').val(page);
						$('#formSubmit').submit();
					}
				}
			});
		});
		
		// thay đổi trạng thái sản phẩm
		
		function myFunction(id) {
            var r = confirm("bạn có chắc xóa nhà cung cấp này không ?");
            if (r == true) {
                window.location.href= "http://localhost:8080/website_dungcuthethao_war_exploded/quan-tri/nha-cung-cap/xoa-nha-cung-cap/"+id;
            } else{
				alert("Đã hủy thay đổi")
			}
          
        }
	</script> </content>
</body>
