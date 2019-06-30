<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Warehouse - SHIPMENT</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>

	<div class="container mt-4 mb-4">
		<div class="card">

			<div class="card-header bg-info text-white">
				<h2>WELCOME TO SHIPMENT TYPE DATA PAGE</h2>
			</div>
			<!-- card header end -->

			<div class="card-body">
				<a class="btn btn-dark btn-sm" href="excelExp">Export Excel</a> <a
					class="btn btn-dark btn-sm" href="pdfExp">Export PDF</a>

				<c:choose>
					<c:when test="${empty list }">
						<h4 class="text-center">No Data Found</h4>
					</c:when>
					<c:otherwise>
					
						<table class="table table-bordered table-hover table-responsive mt-3">
							<tr class="thead-light">
								<th>ID</th>
								<th>MODE</th>
								<th>CODE</th>
								<th colspan="5">OPERATIONS</th>
							</tr>
							<c:forEach items="${list}" var="st">
								<tr>
									<td><c:out value="${st.id}" /></td>
									<td><c:out value="${st.shipmentMode}" /></td>
									<td><c:out value="${st.shipmentCode}" /></td>

									<td><a href="delete?sid=${st.id}"> <img
											src="../resources/images/delete.png" width="20" height="20" />
									</a></td>
									<td><a href="viewOne?sid=${st.id}"> <img
											src="../resources/images/view.png" width="20" height="20" />
									</a></td>
									<td><a href="editOne?sid=${st.id}"> <img
											src="../resources/images/edit.png" width="20" height="20" />
									</a></td>
									<td><a href="exportExcelOne?sid=${st.id}"> <img
											src="../resources/images/excel.png" width="20" height="20" />
									</a></td>
									<td><a href="exportPdfOne?sid=${st.id}"> <img
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