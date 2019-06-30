<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>

	<div class="container mt-4 mb-4">
		<div class="card">

			<div class="card-header bg-info text-white">
				<h2>WELCOME TO UOM VIEW ONE PAGE</h2>
			</div>
			<!-- card header end -->
			<div class="card-body">

				<table class="table table-bordered table-hover mt-3">
					<tr>
						<td>ID</td>
						<td>${uom.uomId}</td>
					</tr>
					<tr>
						<td>TYPE</td>
						<td>${uom.uomType}</td>
					</tr>
					<tr>
						<td>MODEL</td>
						<td>${uom.uomModel}</td>
					</tr>
					<tr>
						<td>DESC</td>
						<td>${uom.uomDsc}</td>
					</tr>

				</table>

			</div>
			<!-- card body class end -->

			<div class="card-footer text-white">
				<a href="all" class="btn btn-primary">Come Back</a>
			</div>

		</div>
		<!-- card class end -->
	</div>
	<!--  container class end -->

</body>
</html>