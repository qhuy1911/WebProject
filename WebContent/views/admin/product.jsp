<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Purple Admin</title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/admin/assets/vendors/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/admin/assets/vendors/css/vendor.bundle.base.css">
    <!-- endinject -->
    <!-- Plugin css for this page -->
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <!-- endinject -->
    <!-- Layout styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/admin/assets/css/style.css">
    <!-- End layout styles -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/views/admin/assets/images/favicon.ico" />
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
              <h3 class="page-title"> Product</h3>
              <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                  <li class="breadcrumb-item"><a href="#">Product</a></li>
                  <li class="breadcrumb-item active" aria-current="page">List Product</li>
                </ol>
              </nav>
            </div>
            <div class="row"> 
              <div class="col-lg-12 stretch-card">
                <div class="card">
                  <div class="card-body">
                    <h4 class="card-title">List Product</h4>
                   
                    <table class="table table-bordered">
                      <thead>
                        <tr>
                          <th> ID </th>
                          <th> Name </th>
                          <th> Title </th>
                          <th> Price </th>
                          <th>  </th>
                        </tr>
                      </thead>
                      <tbody>
                      	<c:forEach var="item" items="${listP}">
                        	<tr >
                          		<td> ${item.id } </td>
                         		<td> ${item.name } </td>
                          		<td> ${item.title } </td>
                        		<td> $ ${item.price } </td>
                          		<td>  
                            		<a href="EditProduct?pid=${item.id }" > <i class="icon-table icon-edit mdi mdi-grease-pencil "></i></a> 
                            		<a href="DeleteProduct?pid=${item.id }"><i class="icon-table icon-delete mdi mdi-delete "  style="color: crimson;"></i></a>
                          		</td>
                        	</tr>
                      	
                      	</c:forEach>
                        
                      </tbody>
                    </table>  
                      <div style="margin-top: 20px;"><button type="button" class="btn btn-gradient-success btn-fw">
                        <a href="AddProduct" style="color: white; text-decoration: none">Add new</a>
                      </button>
                    </div>
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
    <script src="${pageContext.request.contextPath}/views/admin/assets/vendors/js/vendor.bundle.base.js"></script>
    <!-- endinject -->
    <!-- Plugin js for this page -->
    <!-- End plugin js for this page -->
    <!-- inject:js -->
    <script src="${pageContext.request.contextPath}/views/admin/assets/js/off-canvas.js"></script>
    <script src="${pageContext.request.contextPath}/views/admin/assets/js/hoverable-collapse.js"></script>
    <script src="${pageContext.request.contextPath}/views/admin/assets/js/misc.js"></script>
    <!-- endinject -->
    <!-- Custom js for this page -->
    <!-- End custom js for this page -->
  </body>
</html>