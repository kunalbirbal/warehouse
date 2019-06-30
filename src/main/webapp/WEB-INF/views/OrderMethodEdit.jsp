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
				<h2>WELCOME TO ORDER METHOD EDIT PAGE</h2>
			</div>

			<div class="card-body">

				<form:form action="update" method="post"
					modelAttribute="orderMethod">
					<div class="row mb-3">
						<div class="col-3">
							<label>Order Id</label>
						</div>
						<div class="col-6">
							<form:input path="oid" class="form-control" readonly="true" />
						</div>
					</div>

					<div class="row mb-3">
						<div class="col-3">
							<label>Order Mode</label>
						</div>
						<div class="col-6">

							<div class="form-check form-check-inline">
								<form:radiobutton path="orderMode" class="form-check-input"
									value="SALE" />
								<label class="form-check-label">SALE</label>
							</div>
							<div class="form-check form-check-inline">
								<form:radiobutton path="orderMode" class="form-check-input"
									value="PURCHASE" />
								<label class="form-check-label">PURCHASE</label>
							</div>

						</div>
					</div>

					<div class="row mb-3">
						<div class="col-3">
							<label>Order Code</label>
						</div>
						<div class="col-6">
							<form:input path="orderCode" class="form-control" />
						</div>
					</div>

					<div class="row mb-3">
						<div class="col-3">
							<label>Execution Type</label>
						</div>
						<div class="col-6">
							<form:select path="exeType" class="form-control">
								<form:option value="">-select-</form:option>
								<form:option value="FIFO">FIFO</form:option>
								<form:option value="LIFO">LIFO</form:option>
								<form:option value="FCFO">FCFO</form:option>
								<form:option value="FEFO">FEFO</form:option>
							</form:select>
						</div>
					</div>

					<div class="row mb-3">
						<div class="col-3">
							<label>Order Accept</label>
						</div>
						<div class="col-6">
							<div class="form-check form-check-inline">
								<form:checkbox path="orderAccept" value="Multi-Model" />
								<label class="form-check-label">Multi-Model</label>
							</div>
							<div class="form-check form-check-inline">
								<form:checkbox path="orderAccept" value="Accept Return" />
								<label class="form-check-label">Accept Return</label>
							</div>
							<div class="form-check form-check-inline">
								<form:checkbox path="orderAccept" value="Service Extend" />
								<label class="form-check-label">Service Extend</label>
							</div>
						</div>
					</div>

					<div class="row mb-3">
						<div class="col-3">
							<label>Description</label>
						</div>
						<div class="col-6">
							<form:textarea path="orderDsc" class="form-control" />
						</div>
					</div>

					<div class="row mb-3">
						<div class="col-3"></div>
						<div class="col-6">
							<input type="submit" value="Update Order Method"
								class="btn btn-success" />
						</div>
					</div>

				</form:form>
			</div>

		</div>
		<!-- card end -->
	</div>
	<!-- container end -->

</body>
</html>