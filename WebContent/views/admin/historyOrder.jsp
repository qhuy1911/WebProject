<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Purple Admin</title>
<!-- plugins:css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/views/admin/assets/vendors/mdi/css/materialdesignicons.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/views/admin/assets/vendors/css/vendor.bundle.base.css">
<!-- endinject -->
<!-- Plugin css for this page -->
<!-- End plugin css for this page -->
<!-- inject:css -->
<!-- endinject -->
<!-- Layout styles -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/views/admin/assets/css/style.css">
<!-- End layout styles -->
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/views/admin/assets/images/favicon.ico" />
</head>
<body>
	<div class="container-scroller">
		<!-- partial:../../partials/_navbar.html -->
		<jsp:include page="header.jsp"></jsp:include>
		<!-- partial -->
		<div class="container-fluid page-body-wrapper">
			<!-- partial:../../partials/_sidebar.html -->
			<jsp:include page="sidebar.jsp"></jsp:include>
			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper">
					<div class="page-header">
						<h3 class="page-title">History Order</h3>
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="#">History Order</a></li>
								<li class="breadcrumb-item active" aria-current="page">List
									History Order</li>
							</ol>
						</nav>
					</div>
					<div class="row">
						<div class="col-lg-12 stretch-card">
							<div class="card">
								<div class="card-body">
									<h4 class="card-title">List History Order</h4>
									<table class="table table-bordered">
										<thead>
											<tr>
												<th class="history-name">Name</th>
												<th class="history-phone">Phone</th>
												<th class="history-address">Address</th>
												<th class="history-product">Product</th>
												<th class="history-total">Total</th>
												<th class="history-date">Date order</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="orderItem" items="${listO}">
												<tr>
													<td>${orderItem.name}</td>
													<td>${orderItem.phone}</td>
													<td>${orderItem.address}</td>
													<td>${orderItem.product}</td>
													<td>${orderItem.total }$</td>
													<td>${orderItem.date }</td>
												</tr>

											</c:forEach>

										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- content-wrapper ends -->
				<!-- partial:../../partials/_footer.html -->
				<jsp:include page="footer.jsp"></jsp:include>
				<!-- partial -->
			</div>
			<!-- main-panel ends -->
		</div>
		<!-- page-body-wrapper ends -->
	</div>
	<!-- container-scroller -->
	<!-- plugins:js -->
	<script
		src="${pageContext.request.contextPath}/views/admin/assets/vendors/js/vendor.bundle.base.js"></script>
	<!-- endinject -->
	<!-- Plugin js for this page -->
	<!-- End plugin js for this page -->
	<!-- inject:js -->
	<script
		src="${pageContext.request.contextPath}/views/admin/assets/js/off-canvas.js"></script>
	<script
		src="${pageContext.request.contextPath}/views/admin/assets/js/hoverable-collapse.js"></script>
	<script
		src="${pageContext.request.contextPath}/views/admin/assets/js/misc.js"></script>
	<!-- endinject -->
	<!-- Custom js for this page -->
	<!-- End custom js for this page -->
</body>
</html>