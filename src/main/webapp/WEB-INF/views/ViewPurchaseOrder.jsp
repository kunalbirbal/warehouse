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
				<h2>WELCOME TO PURCHASE ORDER VIEW ONE PAGE</h2>
			</div>
			<!-- card header end -->

			<div class="card-body">

				<table
					class="table table-bordered table-hover table-responsive mt-3">
					<tr>
						<td>ID</td>
						<td>${po.orderId}</td>
					</tr>
					<tr>
						<td>CODE</td>
						<td>${po.orderCode}</td>
					</tr>
					<tr>
						<td>REFERENCE NUMBER</td>
						<td>${po.refNum}</td>
					</tr>
					<tr>
						<td>QUALITY CHECK</td>
						<td>${po.qualityCheck}</td>
					</tr>
					<tr>
						<td>STATUS</td>
						<td>${po.orderStatus}</td>
					</tr>
					<tr>
						<td>DESC</td>
						<td>${po.orderDesc}</td>
					</tr>
					<tr>
						<td>SHIPMENT MODE</td>
						<td>${po.shipmentType.shipmentMode}</td>
					</tr>
					<tr>
						<td>WH USER TYPE</td>
						<td>${po.whUserType.userCode}</td>
					</tr>
				</table>

			</div>
			<!-- card body class end -->


			<div class="card-footer bg-light text-white">
				<a class="btn btn-primary" href="all">Come Back</a>
			</div>


		</div>
		<!-- card class end -->
	</div>
	<!--  container class end -->

</body>
</html>