<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="base">${pageContext.request.requestURL}</c:set>
<c:set var="url" value="${fn:replace(base, pageContext.request.requestURI, pageContext.request.contextPath)}" />


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<style>
	.bg-nav-bar{background: #563d7c;}
	.navbar-brand{background: #fff; border-radius: 5px; padding: 0; margin: 10px 10px 10px;}
	.navbar{justify-content: space-around;}
</style>

<nav class="navbar navbar-expand-sm bg-nav-bar navbar-dark ">
	<!-- Brand -->
	<a class="navbar-brand " href="#"><img src="../resources/images/logo.png" /></a>

	<!-- Links -->
	<ul class="navbar-nav">
		
		<!--Uom Dropdown start -->
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbardrop" data-toggle="dropdown"> UOM </a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="${url}/uom/register">Register </a> <a
					class="dropdown-item" href="${url}/uom/all">View All</a> 
			</div></li>
		<!--Uom Dropdown end -->


		<!-- Order Method start-->
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbardrop" data-toggle="dropdown"> Order Method </a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="${url}/order/register">Register </a>
        <a class="dropdown-item" href="${url}/order/all">View All</a>
       
			</div></li>
		<!-- Order Method end-->

		<!-- Shipment Type start-->
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbardrop" data-toggle="dropdown"> Shipment Type </a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="${url}/shipment/register">Register </a>
        <a class="dropdown-item" href="${url}/shipment/all">View All</a>
      
			</div></li>
		<!-- Shipment Type end-->


		<!-- WH USER TYPE -->

		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbardrop" data-toggle="dropdown"> Warehouse User </a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="${url}/whuser/register">Register </a>
        <a class="dropdown-item" href="${url}/whuser/all">View All</a>
       
			</div></li>

		<!-- ITEM  -->
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbardrop" data-toggle="dropdown">Item</a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="${url}/item/register">Register </a>
        <a class="dropdown-item" href="${url}/item/all">View All</a>
       
			</div></li>
		<!-- Employee -->
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbardrop" data-toggle="dropdown">Employee</a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="${url}/employee/register">Register </a>
        <a class="dropdown-item" href="${url}/employee/all">View All</a>
       
			</div></li>

		<!-- Purchase Order -->
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbardrop" data-toggle="dropdown">Purchase Order</a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="${url}/purchase_order/register">Register </a> <a
					class="dropdown-item" href="${url}/purchase_order/all">View All</a> 
			</div></li>
			
		<!-- Sale Order -->
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbardrop" data-toggle="dropdown">Sale Order</a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="${url}/sale/register">Register </a> <a
					class="dropdown-item" href="${url}/sale/viewAll">View All</a>
			</div></li>

		<!-- SWAGGER -->
		<%-- <li class="nav-item"><a class="nav-link"
			href="${url}/swagger-ui.html">Swagger</a></li> --%>

		<li class="nav-item"><a class="nav-link" href="${url}/logout">logout</a></li>

	</ul>
</nav>