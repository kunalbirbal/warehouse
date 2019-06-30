<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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
				<h2>WELCOME TO ORDER METHOD VIEW PAGE</h2>
			</div>
			<!-- card header end -->

			<div class="card-body">

				<table class="table table-bordered table-hover mt-3">
					<tr>
						<td>ID</td>
						<td>${om.oid}</td>
					</tr>
					<tr>
						<td>MODE</td>
						<td>${om.orderMode}</td>
					</tr>
					<tr>
						<td>CODE</td>
						<td>${om.orderCode}</td>
					</tr>
					<tr>
						<td>Execution</td>
						<td>${om.exeType}</td>
					</tr>
					<tr>
						<td>DESC</td>
						<td>${om.orderDsc}</td>
					</tr>
					<tr>
						<td>Accept</td>
						<td>${om.orderAccept}</td>
					</tr>
				</table>


			</div>
			<!-- card body class end -->

			<div class="card-footer bg-light">
				<a href="all" class="btn btn-primary">Come Back</a>
			</div>

		</div>
		<!-- card class end -->
	</div>
	<!--  container class end -->


</body>
</html>