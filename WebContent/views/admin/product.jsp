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
    <link rel="stylesheet" href="./assets/vendors/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="./assets/vendors/css/vendor.bundle.base.css">
    <!-- endinject -->
    <!-- Plugin css for this page -->
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <!-- endinject -->
    <!-- Layout styles -->
    <link rel="stylesheet" href="./assets/css/style.css">
    <!-- End layout styles -->
    <link rel="shortcut icon" href="./assets/images/favicon.ico" />
  </head>
  <body>
    <div class="container-scroller">
      <!-- partial:../../partials/_navbar.html -->
      <jsp:include page="header.jsp"></jsp:include>
      <!-- partial -->
      <div class="container-fluid page-body-wrapper">
        <!-- partial:../../partials/_sidebar.html -->
        <nav class="sidebar sidebar-offcanvas" id="sidebar">
          <ul class="nav">
            <li class="nav-item nav-profile">
              <a href="#" class="nav-link">
                <div class="nav-profile-image">
                  <img src="./assets/images/faces-clipart/pic-1.png" alt="profile">
                  <span class="login-status online"></span>
                  <!--change to offline or busy as needed-->
                </div>
                <div class="nav-profile-text d-flex flex-column">
                  <span class="font-weight-bold mb-2">Huy Nguyen</span>
                  <span class="text-secondary text-small">Shop Manager</span>
                </div>
                <i class="mdi mdi-bookmark-check text-success nav-profile-badge"></i>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/index.html">
                <span class="menu-title">Home</span>
                <i class="mdi mdi-home menu-icon"></i>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/pages/tables/product.html">
                <span class="menu-title">Product</span>
                <i class="mdi mdi-tshirt-v menu-icon"></i>
              </a>
            </li>
          </ul>
        </nav>
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
                          <th> # </th>
                          <th> Name </th>
                          <th> Amount </th>
                          <th> Price </th>
                          <th>  </th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr >
                          <td> 1 </td>
                          <td> Herman Beck </td>
                          <td> 2 </td>
                          <td> $ 77.99 </td>
                          <td>  
                            <a href="editProduct.jsp" > <i class="icon-table icon-edit mdi mdi-grease-pencil "></i></a></i> 
                            <a href="#"><i class="icon-table icon-delete mdi mdi-delete "  style="color: crimson;"></i></a>
                          </td>
                        </tr>
                        <tr class="table-warning">
                          <tr>
                            <td> 1 </td>
                            <td> Herman Beck </td>
                            <td> 2 </td>
                            <td> $ 77.99 </td>
                            <td>  
                              <a href="editProduct.jsp" > <i class="icon-table icon-edit mdi mdi-grease-pencil "></i></a></i> 
                              <a href="#"><i class="icon-table icon-delete mdi mdi-delete " style="color: crimson;"></i></a>
                            </td>
                          </tr>
                        </tr>
                        
                      </tbody>
                    </table>  
                      <div style="margin-top: 20px;"><button type="button" class="btn btn-gradient-success btn-fw">
                        <a href="addNewProduct.jsp" style="color: white; text-decoration: none">Add new</a>
                      </button>
                    </div>
                  </div> 
                </div>
              </div>
            </div>
          </div>
          <!-- content-wrapper ends -->
          <!-- partial:../../partials/_footer.html -->
          <footer class="footer">
            <div class="container-fluid clearfix">
              <span class="text-muted d-block text-center text-sm-left d-sm-inline-block">Copyright © shopbanquanao.com 2021</span>
            </div>
          </footer>
          <!-- partial -->
        </div>
        <!-- main-panel ends -->
      </div>
      <!-- page-body-wrapper ends -->
    </div>
    <!-- container-scroller -->
    <!-- plugins:js -->
    <script src="../../assets/vendors/js/vendor.bundle.base.js"></script>
    <!-- endinject -->
    <!-- Plugin js for this page -->
    <!-- End plugin js for this page -->
    <!-- inject:js -->
    <script src="../../assets/js/off-canvas.js"></script>
    <script src="../../assets/js/hoverable-collapse.js"></script>
    <script src="../../assets/js/misc.js"></script>
    <!-- endinject -->
    <!-- Custom js for this page -->
    <!-- End custom js for this page -->
  </body>
</html>