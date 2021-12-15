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
      <!-- partial:./partials/_navbar.html -->
      <jsp:include page="header.jsp"></jsp:include>
      <!-- partial -->
      <div class="container-fluid page-body-wrapper">
        <!-- partial:./partials/_sidebar.html -->
        <jsp:include page="sidebar.jsp"></jsp:include>
        <!-- partial -->
        <div class="main-panel">
          <div class="content-wrapper">
            <div class="page-header">
              <h3 class="page-title">Edit Product</h3>
              <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                  <li class="breadcrumb-item"><a href="/pages/tables/product.html">Product</a></li>
                  <li class="breadcrumb-item active" aria-current="page">Edit Product</li>
                </ol>
              </nav>
            </div>
            <div class="row">
              <div class="col-12 grid-margin stretch-card">
                <div class="card">
                  <div class="card-body">
                    <form class="forms-sample" action="EditProduct" method="post">
                    	<div class="form-group">
                        <input type="hidden" name="id" class="form-control" value="${product.id }">
                      </div>
                      <div class="form-group">
                        <label>Name</label>
                        <input type="text" name="name" class="form-control" value="${product.name }" placeholder="Name">
                      </div>
                      <div class="form-group">
                        <label >Title</label>
                        <input type="text" name="title" class="form-control" value="${product.title }" placeholder="Title">
                      </div>
                      <div class="form-group">
                        <label >Description</label>
                        <input type="text" name="description" class="form-control" value="${product.description }" placeholder="Description">
                      </div>
                      <div class="form-group">
                        <label >Price</label>
                        <input type="text" name="price" class="form-control" value="${product.price }" placeholder="Price">
                      </div>
                      <div class="form-group">
                        <label>Image upload</label>
                        <input type="file" name="img[]" class="file-upload-default">
                        <div class="input-group col-xs-12">
                          <input type="text" class="form-control file-upload-info" disabled placeholder="Upload Image">
                          <span class="input-group-append">
                            <button class="file-upload-browse btn btn-gradient-primary" type="button">Upload</button>
                          </span>
                        </div>
                      </div>  
                      <button type="submit" class="btn btn-gradient-primary mr-2" name="action" value="Submit">Submit</button>
                      <button class="btn btn-light" name="action" value="Cancel">Cancel</button>
                    </form>
                  </div>
                </div>
              </div>  
          </div>
          <!-- content-wrapper ends -->
          <!-- partial:./partials/_footer.html -->
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
    <script src="${pageContext.request.contextPath}/views/admin/assets/js/file-upload.js"></script>
    <!-- End custom js for this page -->
  </body>
</html>