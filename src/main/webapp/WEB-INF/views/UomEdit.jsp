<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container mt-4 mb-3">

		<div class="card">

			<div class="card-header bg-info text-white">
				<h2>WELCOME TO UOM REGISTER PAGE</h2>
			</div>

			<div class="card-body">

				<form:form action="update" method="post" modelAttribute="uom">
					<div class="row mb-3">
						<div class="col-4">
							<label>UOM ID</label>
						</div>
						<div class="col-6">
							<form:input path="uomId" readonly="true" class="form-control" />
						</div>
					</div>

					<div class="row mb-3">
						<div class="col-4">
							<label>UOM Type</label>
						</div>
						<div class="col-6">
							<form:select class="form-control" path="uomType">
								<form:option value="">-select-</form:option>
								<form:option value="PACKING">PACKING</form:option>
								<form:option value="NO-PACKING">NO-PACKING</form:option>
								<form:option value="NA">NA</form:option>
							</form:select>
							<form:errors path="uomType" class="text-danger"/>
						</div>
					</div>

					<div class="row mb-3">
						<div class="col-4">
							<label>UOM Model</label>
						</div>
						<div class="col-6">
							<form:input path="uomModel" class="form-control" />
							<form:errors path="uomModel" class="text-danger"/>
						</div>
					</div>

					<div class="row mb-3">
						<div class="col-4">
							<label>UOM Description</label>
						</div>
						<div class="col-6">
							<form:textarea path="uomDsc" class="form-control" />
							<form:errors path="uomDsc" class="text-danger"/>
						</div>
					</div>

					<div class="row mb-3">
						<div class="col-4">
							<label>UOM Description</label>
						</div>
						<div class="col-6">
							<input type="submit"  class="btn btn-primary" value="Update Uom" />
						</div>
					</div>

				</form:form>

			</div>
			<!-- card body close -->

			<c:if test="${message != null }">
				<div class="card-footer bg-success text-white">${message}</div>
			</c:if>

		</div>
		<!-- card end -->
	</div>
	<!-- container end -->


</body>
</html>