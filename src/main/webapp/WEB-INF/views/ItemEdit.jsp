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
				<h2>WELCOME TO ITEM EDIT PAGE</h2>
			</div>

			<div class="card-body">
				<form:form action="update" method="post" modelAttribute="item">

					<div class="row mb-3">
						<div class="col-3">
							<label>ITEM CODE</label>
						</div>
						<div class="col-6">
							<form:input path="itemId" class="form-control" readonly="true" />
						</div>
					</div>

					<div class="row mb-3">
						<div class="col-3">
							<label>ITEM CODE</label>
						</div>
						<div class="col-6">
							<form:input path="itemCode" class="form-control" />
						</div>
					</div>

					<div class="row mb-3">
						<div class="col-3">
							<label>ITEM DIMENSIONS</label>
						</div>
						<div class="col-2">
							<label>WIDTH</label>
							<form:input path="itemWidht" class="form-control" />
						</div>
						<div class="col-2">
							<label>LENGTH</label>
							<form:input path="itemLength" class="form-control" />
						</div>
						<div class="col-2">
							<label>HEIGHT</label>
							<form:input path="itemHeight" class="form-control" />
						</div>
					</div>

					<div class="row mb-3">
						<div class="col-3">
							<label>BASE COST</label>
						</div>
						<div class="col-6">
							<form:input path="baseCost" class="form-control" />
						</div>
					</div>

					<div class="row mb-3">
						<div class="col-3">
							<label>BASE CURRENCY</label>
						</div>
						<div class="col-6">
							<form:select path="baseCurr" class="form-control">
								<form:option value="">-select-</form:option>
								<form:option value="INR">INR</form:option>
								<form:option value="USD">USD</form:option>
								<form:option value="AUS">AUS</form:option>
								<form:option value="ERU">ERU</form:option>
							</form:select>
						</div>
					</div>

					<div class="row mb-3">
						<div class="col-3">
							<label>DESCRIPTION</label>
						</div>
						<div class="col-6">
							<form:textarea path="itemDsc" class="form-control" />
						</div>
					</div>

					<div class="row mb-3">
						<div class="col-3">
							<label>SELECT UOM TYPE</label>
						</div>
						<div class="col-6">
							<form:select path="uom.uomId" class="form-control">
								<form:option value="">-select-</form:option>
								<form:options items="${uoms}" itemLabel="uomModel"
									itemValue="uomId" />
							</form:select>
							<form:errors path="uom" class="text-danger" />
						</div>
					</div>

					<div class="row mb-3">
						<div class="col-3">
							<label>SELECT ORDER METHOD</label>
						</div>
						<div class="col-6">
							<form:select path="orderMethod.oid" class="form-control">
								<form:option value="">-select-</form:option>
								<form:options items="${oms}" itemLabel="orderMode"
									itemValue="oid" />
							</form:select>
							<form:errors path="orderMethod" class="text-danger" />
						</div>
					</div>


					<div class="row">
						<div class="col-3"></div>
						<div class="col-6">
							<input type="submit" value="Update Item" class="btn btn-success" />
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