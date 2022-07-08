<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Shoppers</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Mukta:300,400,700">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/views/user/fonts/icomoon/style.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/views/user/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/views/user/css/magnific-popup.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/views/user/css/jquery-ui.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/views/user/css/owl.carousel.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/views/user/css/owl.theme.default.min.css">


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/views/user/css/aos.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/views/user/css/style.css">

</head>
<body>

	<div class="site-wrap">
		<jsp:include page="header.jsp"></jsp:include>

		<div class="bg-light py-3">
			<div class="container">
				<div class="row">
					<div class="col-md-12 mb-0">
						<a href="HomeServlet">Home</a> <span class="mx-2 mb-0">/</span> <strong
							class="text-black">History order</strong>
					</div>
				</div>
			</div>
		</div>


		<div class="site-section">
			<div class="container">
				<form action="UpdateCart" method="post">
					<div class="row mb-5">
						<c:if test="${listO.size() == 0 }">
							<h2 class="text-black" style="text-align: center;">Empty
								History</h2>
						</c:if>
						<c:if test="${listO.size() != 0 }">
							<div class="col-md-12">
								<div class="site-blocks-table">
									<table class="table table-bordered">
										<thead>
											<tr>
												<th class="history-name">Name</th>
												<th class="history-phone">Phone</th>
												<th class="history-address">Address</th>
												<th class="history-product">Product</th>
												<th class="history-total">Total</th>
												<th class="history-date">Date order</th>
												<th class="history-date">Status</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="orderItem" items="${listO}">
												<tr>
													<td class="history-name">${orderItem.name}</td>
													<td class="history-phone">${ orderItem.phone}</td>
													<td>${orderItem.address}</td>
													<td>${orderItem.product}</td>
													<td>${orderItem.total }</td>
													<td>${orderItem.date }</td>
													<td>
														<p style='color: ${orderItem.status ? "green" : "red"}; font-weight: 600;'>${orderItem.status ? "paid" : "unpaid" }</p>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</c:if>
					</div>
				</form>
			</div>
		</div>

		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>