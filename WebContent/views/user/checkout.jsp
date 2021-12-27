<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Shoppers &mdash; Colorlib e-Commerce Template</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Mukta:300,400,700"> 
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/user/fonts/icomoon/style.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/user/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/user/css/magnific-popup.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/user/css/jquery-ui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/user/css/owl.carousel.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/user/css/owl.theme.default.min.css">


    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/user/css/aos.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/user/css/style.css">
    
  </head>
  <body>
  
  <div class="site-wrap">
    <jsp:include page="header.jsp"></jsp:include>

    <div class="bg-light py-3">
      <div class="container">
        <div class="row">
          <div class="col-md-12 mb-0"><a href="HomeServlet">Home</a> <span class="mx-2 mb-0">/</span> <a href="CartServlet">Cart</a> <span class="mx-2 mb-0">/</span> <strong class="text-black">Checkout</strong></div>
        </div>
      </div>
    </div>

    <div class="site-section">
      <div class="container">
      	<c:if test="${account == null }">
        <div class="row mb-5">
          <div class="col-md-12">
            <div class="border p-4 rounded" role="alert">
              Returning customer? <a href="LoginServlet">Click here</a> to login
            </div>
          </div>
        </div>
        </c:if>
        
        <c:if test="${account != null }">
        <form action="Checkout" method="post">
        <div class="row">
          <div class="col-md-6 mb-5 mb-md-0">
            <h2 class="h3 mb-3 text-black">Billing Details</h2>
            <div class="p-3 p-lg-5 border">
              <div class="form-group row">
                <div class="col-md-6">
                  <label for="c_fname" class="text-black">First Name <span class="text-danger">*</span></label>
                  <input type="text" class="form-control" id="c_fname" name="c_fname" placeholder="First name">
                </div>
                <div class="col-md-6">
                  <label for="c_lname" class="text-black">Last Name <span class="text-danger">*</span></label>
                  <input type="text" class="form-control" id="c_lname" name="c_lname" placeholder="Last name">
                </div>
              </div>
              <div class="form-group row">
                <div class="col-md-12">
                  <label for="c_address" class="text-black">Address <span class="text-danger">*</span></label>
                  <input type="text" class="form-control" id="c_address" name="c_address" placeholder="Street address">
                </div>
              </div>
              <div class="form-group row">
                <div class="col-md-12">
                  <label for="c_phone" class="text-black">Phone <span class="text-danger">*</span></label>
                  <input type="text" class="form-control" id="c_phone" name="c_phone" placeholder="Phone Number">
                </div>
              </div>
              <div class="form-group ">
                <label for="c_order_notes" class="text-black">Order Notes</label>
                <textarea name="c_order_notes" id="c_order_notes" cols="30" rows="5" class="form-control" placeholder="Write your notes here..."></textarea>
              </div>

            </div>
          </div>
          <div class="col-md-6">
            <div class="row mb-5">
              <div class="col-md-12">
                <h2 class="h3 mb-3 text-black">Your Order</h2>
                <div class="p-3 p-lg-5 border">
                  <table class="table site-block-order-table mb-5">
                    <thead>
                      <th>Product</th>
                      <th>Total</th>
                    </thead>
                    <tbody>
                      <c:forEach var="cartItem" items="${cart.items }">
                        <tr>
                          <td>${cartItem.product.name } <strong class="mx-2">x</strong> ${cartItem.quantity }</td>
                          <td>$${cartItem.price }</td>
                        </tr>
                      </c:forEach>
                      <tr>
                        <td class="text-black font-weight-bold"><strong>Total</strong></td>
                        <td class="text-black font-weight-bold"><strong>$${cart.sumPrice }</strong></td>
                      </tr>
                    </tbody>
                  </table>
                  <div class="form-group">
                    <button class="btn btn-primary btn-lg py-3 btn-block" onclick="window.location='thankyou.html'">Place Order</button>
                  </div>

                </div>
              </div>
            </div>

          </div>
        </div>
        </form>
        </c:if>
      </div>
    </div>

    <jsp:include page="footer.jsp"></jsp:include>
  </div>

  <script src="${pageContext.request.contextPath}/views/user/js/jquery-3.3.1.min.js"></script>
  <script src="${pageContext.request.contextPath}/views/user/js/jquery-ui.js"></script>
  <script src="${pageContext.request.contextPath}/views/user/js/popper.min.js"></script>
  <script src="${pageContext.request.contextPath}/views/user/js/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/views/user/js/owl.carousel.min.js"></script>
  <script src="${pageContext.request.contextPath}/views/user/js/jquery.magnific-popup.min.js"></script>
  <script src="${pageContext.request.contextPath}/views/user/js/aos.js"></script>

  <script src="${pageContext.request.contextPath}/views/user/js/main.js"></script>
    
  </body>
</html>