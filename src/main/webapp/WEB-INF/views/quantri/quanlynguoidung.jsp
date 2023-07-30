<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<title>Danh sách người dùng</title>

<body>
	<div id="layoutSidenav_content">
		<main>
		<div class="container-fluid">
		<form action="<c:url value='/quan-tri/quan-ly-nguoi-dung?page=${abstractDTO.page}&limit=${abstractDTO.limit}'/>" id="formSubmit"> 
			<h1 class="mt-4">Quản lý người dùng</h1>
			

			<div class="card mb-4">
				<div class="card-header row">
					<div class="col-9">
					<i class="fas fa-table mr-1"></i> Danh sách người dùng
					</div>
				</div>
						<div class="card-body">

					<div class="table-responsive">
						
						<table class="table table-bordered" id="dataTable" 
							>
							<thead>
								<tr class="text-center">
									<th>STT</th>
									<th>ID</th>
									<th>Họ </th>
									<th>Tên</th>
									<th>Giới tính</th>
						
									<th>Email</th>
									<th>Số điện thoại</th>
									<th>Ngày tạo</th>
									<th>Trạng thái</th>
									<th>Quản lý</th>
									
								</tr>
							</thead>

							<tbody>
							<c:forEach items="${listNguoiDung}" var="nd" varStatus="stt">
								<tr>
									<td>${stt.count}</td>
									<td>${nd.id }</td>
									<td>${nd.ho }</td>
									<td>${nd.ten }</td>
									<td>${nd.gioiTinh? "Nam" : "Nữ"}</td>
									<td>${nd.email}</td>
									<td>${nd.soDienThoai }</td>
									<td>${nd.ngayTao }</td>
									<td>${nd.trangThai? "Hoạt động":"Đã chặn" }</td>
									<td class="text-center">
										<button  type="button" onclick="myFunction(${nd.id})" ><i class="fas fa-trash-alt"></i></button>
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
		
		
// thay đổi trạng thái người dùng
		
		function myFunction(id) {
            var r = confirm("bạn có muốn chặn / bỏ chặn người dùng này không ?");
            if (r == true) {
                window.location.href= "http://localhost:8080/website_dungcuthethao_war_exploded/quan-tri/quan-ly-nguoi-dung/sua-trang-thai/"+id;
            } else{
				alert("Đã hủy thay đổi")
			}
          
        }
	</script>
	 </content>
</body>
