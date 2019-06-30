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
				<h2>WELCOME TO ITEM VIEW ONE PAGE</h2>
			</div>
			<!-- card header end -->

			<div class="card-body">

				<table  class="table table-bordered table-hover mt-3">
					<tr>
						<td>ID</td>
						<td>${item.itemId}</td>
					</tr>
					<tr>
						<td>CODE</td>
						<td>${item.itemCode}</td>
					</tr>
					<tr>
						<td>LENGTH</td>
						<td>${item.itemLength}</td>
					</tr>
					<tr>
						<td>WIDTH</td>
						<td>${item.itemWidht}</td>
					</tr>
					<tr>
						<td>HEIGHT</td>
						<td>${item.itemHeight}</td>
					</tr>
					<tr>
						<td>COST</td>
						<td>${item.baseCost}</td>
					</tr>
					<tr>
						<td>CURRENCY</td>
						<td>${item.baseCurr}</td>
					</tr>
					<tr>
						<td>DESC</td>
						<td>${item.itemDsc}</td>
					</tr>
					<tr>
						<td>UOM</td>
						<td>${item.uom.uomModel}</td>
					</tr>
					<tr>
						<td>ORDER METHOD</td>
						<td>${item.orderMethod.orderMode}</td>
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