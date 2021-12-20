<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<header class="site-navbar" role="banner">
	<div class="site-navbar-top">
		<div class="container">
			<div class="row align-items-center">

				<div
					class="col-6 col-md-4 order-2 order-md-1 site-search-icon text-left">
					<form action="" class="site-block-top-search">
						<span class="icon icon-search2"></span> <input type="text"
							class="form-control border-0" placeholder="Search">
					</form>
				</div>

				<div
					class="col-12 mb-3 mb-md-0 col-md-4 order-1 order-md-2 text-center">
					<div class="site-logo">
						<a href="index.html" class="js-logo-clone">Shoppers</a>
					</div>
				</div>

				<div class="col-6 col-md-4 order-3 order-md-3 text-right">
					<div class="site-top-icons">
						<ul>
							<c:if test="${sessionScope.account == null }">
								<li><a href="LoginServlet"><span class="icon icon-person"></span></a></li>
							</c:if>
							<c:if test="${sessionScope.account != null }">
								<li>Hello ${sessionScope.account.username }, <a href="LogoutServlet"><span class="icon icon-exit_to_app"></span></a></li>
							</c:if>
							<li><a href="CartServlet" class="site-cart"> <span
									class="icon icon-shopping_cart"></span> <span class="count">
										<c:if test="${cart != null }">
											${cart.count }
										</c:if>
										<c:if test="${cart == null }">
											0
										</c:if>
									</span>
							</a></li>
							<li class="d-inline-block d-md-none ml-md-0"><a href="#"
								class="site-menu-toggle js-menu-toggle"><span
									class="icon-menu"></span></a></li>
						</ul>
					</div>
				</div>

			</div>
		</div>
	</div>
	<nav class="site-navigation text-right text-md-center"
		role="navigation">
		<div class="container">
			<ul class="site-menu js-clone-nav d-none d-md-block">
				<li class="has-children active"><a href="index.html">Home</a>
					<ul class="dropdown">
						<li><a href="#">Menu One</a></li>
						<li><a href="#">Menu Two</a></li>
						<li><a href="#">Menu Three</a></li>
						<li class="has-children"><a href="#">Sub Menu</a>
							<ul class="dropdown">
								<li><a href="#">Menu One</a></li>
								<li><a href="#">Menu Two</a></li>
								<li><a href="#">Menu Three</a></li>
							</ul></li>
					</ul></li>
				<li class="has-children"><a href="about.html">About</a>
					<ul class="dropdown">
						<li><a href="#">Menu One</a></li>
						<li><a href="#">Menu Two</a></li>
						<li><a href="#">Menu Three</a></li>
					</ul></li>
				<li><a href="shop.html">Shop</a></li>
				<li><a href="#">Catalogue</a></li>
				<li><a href="#">New Arrivals</a></li>
				<li><a href="contact.html">Contact</a></li>
			</ul>
		</div>
	</nav>
</header>