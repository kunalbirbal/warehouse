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
				<h2>WELCOME TO ITEM DATA PAGE</h2>
			</div>
			<!-- card header end -->

			<div class="card-body">
				<a class="btn btn-dark btn-sm" href="excelExp">Export Excel</a> <a
					class="btn btn-dark btn-sm" href="pdfExp">Export PDF</a>

				<c:choose>
					<c:when test="${empty list}">
						<h4 class="text-center">No Data Found</h4>
					</c:when>
					<c:otherwise>
						<table
							class="table table-bordered table-hover mt-3">
							<tr class="thead-light">
								<th>ID</th>
								<th>CODE</th>
								<th>COST</th>
								<th>CURRENCY</th>
								<th>UOM</th>
								<th>ORDER METHOD</th>
								<th colspan="5">OPERATIONS</th>
							</tr>
							<c:forEach items="${list}" var="itm">
								<tr>
									<td><c:out value="${itm.itemId}" /></td>
									<td><c:out value="${itm.itemCode}" /></td>
									<td><c:out value="${itm.baseCost}" /></td>
									<td><c:out value="${itm.baseCurr}" /></td>
									<td><c:out value="${itm.uom.uomModel}" /></td>
									<td><c:out value="${itm.orderMethod.orderMode}" /></td>
									<td><a href="delete?itmid=${itm.itemId}"> <img
											src="../resources/images/delete.png" width="20" height="20" />
									</a></td>
									<td><a href="viewOne?itmid=${itm.itemId}"> <img
											src="../resources/images/view.png" width="20" height="20" />
									</a></td>
									<td><a href="editOne?itmid=${itm.itemId}"> <img
											src="../resources/images/edit.png" width="20" height="20" />
									</a></td>
									<td><a href="exportExcelOne?itmid=${itm.itemId}"> <img
											src="../resources/images/excel.png" width="20" height="20" />
									</a></td>
									<td><a href="exportPdfOne?itmid=${itm.itemId}"> <img
											src="../resources/images/pdf.png" width="20" height="20" />
									</a></td>
								</tr>
							</c:forEach>
						</table>
					</c:otherwise>
				</c:choose>
			</div>
			<!-- card body class end -->

			<c:if test="${message != null}">
				<div class="card-footer bg-danger text-white">${message}</div>
			</c:if>

		</div>
		<!-- card class end -->
	</div>
	<!--  container class end -->
</body>
</html>