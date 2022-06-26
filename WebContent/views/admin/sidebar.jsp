<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<nav class="sidebar sidebar-offcanvas" id="sidebar">
          <ul class="nav">
            <li class="nav-item nav-profile">
              <a href="#" class="nav-link">
                <div class="nav-profile-image">
                  <img src="${pageContext.request.contextPath}/views/admin/assets/images/faces-clipart/pic-1.png" alt="profile">
                  <span class="login-status online"></span>
                  <!--change to offline or busy as needed-->
                </div>
                <div class="nav-profile-text d-flex flex-column">
                  <span class="font-weight-bold mb-2">${account.username }</span>
                  <span class="text-secondary text-small">Shop Manager</span>
                </div>
                <i class="mdi mdi-bookmark-check text-success nav-profile-badge"></i>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="HomeAdmin">
                <span class="menu-title">Home</span>
                <i class="mdi mdi-home menu-icon"></i>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="ProductAdmin">
                <span class="menu-title">Product</span>
                <i class="mdi mdi-tshirt-v menu-icon"></i>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="CategoryAdmin">
                <span class="menu-title">Category</span>
                <i class="mdi mdi-apps menu-icon"></i>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="HistoryOrderAdmin">
                <span class="menu-title">History Order</span>
                <i class="mdi mdi-clipboard-text menu-icon"></i>
              </a>
            </li>
            <!-- <li class="nav-item">
              <a class="nav-link" href="#">
                <span class="menu-title">Account</span>
                <i class="mdi mdi-account menu-icon"></i>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">
                <span class="menu-title">Order</span>
                <i class="mdi mdi-clipboard-text menu-icon"></i>
              </a>
            </li> -->
          </ul>
        </nav>