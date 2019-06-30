<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Register</title>
</head>
<body>

	<%@include file="UserMenu.jsp"%>
	<div class="container mt-4 mb-3">

		<div class="card">

			<div class="card-header bg-info text-white">
				<h2>WELCOME TO USER REGISTER PAGE</h2>
			</div>

			<div class="card-body">

				<form:form action="insert" method="post" modelAttribute="user">

					<div class="row mb-3">
						<div class="col-4">
							<label>User Name</label>
						</div>
						<div class="col-6">
							<form:input path="userName" class="form-control" />
						</div>
					</div>

					<div class="row mb-3">
						<div class="col-4">
							<label>User Email</label>
						</div>
						<div class="col-6">
							<form:input path="userEmail" class="form-control" />
						</div>
					</div>

					<div class="row mb-3">
						<div class="col-4">
							<label>User Password</label>
						</div>
						<div class="col-6">
							<form:password path="userPassword" class="form-control" />
						</div>
					</div>

					<div class="row mb-3">
						<div class="col-4">
							<label>User Contact</label>
						</div>
						<div class="col-6">
							<form:input path="userContact" class="form-control" />
						</div>
					</div>
					
					<div class="row mb-3">
						<div class="col-4">
							<label>User Roles</label>
						</div>
						<div class="col-6">
							<div class="form-check form-check-inline">
								<form:checkbox path="userRoles" class="form-check-input"
									value="ADMIN" />
								<label class="form-check-label">ADMIN</label>
							</div>
							<div class="form-check form-check-inline">
								<form:checkbox path="userRoles" class="form-check-input"
									value="APP USER" />
								<label class="form-check-label">APP USER</label>
							</div>
						</div>
					</div>


					<div class="row mb-3">
						<div class="col-4"></div>
						<div class="col-6">
							<input type="submit" class="btn btn-primary" value="Create User" /> 
							<a href="all" class="btn btn-info">View All</a>
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