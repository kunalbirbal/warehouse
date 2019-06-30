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
				<h2>WELCOME TO PURCHASE ORDER REGISTER PAGE</h2>
			</div>

			<div class="card-body">
				<form:form action="insert" method="post" modelAttribute="purchaseOrder">

					<div class="row mb-3">
						<div class="col-3">
							<label>ORDER CODE</label>
						</div>
						<div class="col-6">
							<form:input path="orderCode" class="form-control" />
							<form:errors path="orderCode" class="text-danger"/>
						</div>
					</div>
					
					<div class="row mb-3">
						<div class="col-3">
							<label>REFERENCE NUMBER</label>
						</div>
						<div class="col-6">
							<form:input path="refNum" class="form-control" />
							<form:errors path="refNum" class="text-danger"/>
						</div>
					</div>
					
					<div class="row mb-3">
						<div class="col-3">
							<label>QUALITY CHECK</label>
						</div>
						<div class="col-6">
							<div class="form-check form-check-inline">
							  <form:radiobutton class="form-check-input" path="qualityCheck" id="inlineRadio1" value="REQUIRED"/>
							  <label class="form-check-label" for="inlineRadio1">REQUIRED</label>
							</div>
							<div class="form-check form-check-inline">
							  <form:radiobutton class="form-check-input" path="qualityCheck" id="inlineRadio2" value="NOT REQUIRED"/>
							  <label class="form-check-label" for="inlineRadio2">NOT REQUIRED</label>
							</div>	
							<form:errors path="qualityCheck" class="text-danger"/>						
						</div>
					</div>

					<div class="row mb-3">
						<div class="col-3">
							<label>DEFAULT STATUS</label>
						</div>
						<div class="col-6">
							<form:input path="orderStatus" value="OPEN" disabled="true" class="form-control" />
						</div>
					</div>

					<div class="row mb-3">
						<div class="col-3">
							<label>DESCRIPTION</label>
						</div>
						<div class="col-6">
							<form:textarea path="orderDesc" class="form-control" />
							<form:errors path="orderDesc" class="text-danger"/>
						</div>
					</div>

					<div class="row mb-3">
						<div class="col-3">
							<label>SELECT WHUSER TYPE</label>
						</div>
						<div class="col-6">
							<form:select path="whUserType.userId" class="form-control">
								<form:option value="">-select-</form:option>
								<form:options items="${whusers}" itemLabel="userCode" itemValue="userId"/>
							</form:select>
							<form:errors path="whUserType" class="text-danger"/>
						</div>
					</div>
					
					<div class="row mb-3">
						<div class="col-3">
							<label>SELECT SHIPMENT TYPE</label>
						</div>
						<div class="col-6">
							<form:select path="shipmentType.id" class="form-control">
								<form:option value="">-select-</form:option>
								<form:options items="${shiptype}" itemLabel="shipmentMode" itemValue="id"/>
							</form:select>
						</div>
					</div>

					<div class="row">
						<div class="col-3"></div>
						<div class="col-6">
							<input type="submit" value="Create PurchaseOrder" class="btn btn-success" />
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