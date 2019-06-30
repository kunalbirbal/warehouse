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
	<div class="container mt-4 mb-3">

		<div class="card">

			<div class="card-header bg-info text-white">
				<h2>WELCOME TO USER VIEW PAGE</h2>
			</div>

			<div class="card-body">

				<table class="table table-bordered table-hover mt-3">
					<tr>
						<td>ID</td>
						<td>${user.userId}</td>
					</tr>
					<tr>
						<td>USERNAME</td>
						<td>${user.userName}</td>
					</tr>
					<tr>
						<td>EMAIL</td>
						<td>${user.userEmail}</td>
					</tr>
					<tr>
						<td>PASSWORD</td>
						<td>${user.userPassword}</td>
					</tr>
					<tr>
						<td>CONTACT</td>
						<td>${user.userContact}</td>
					</tr>
					<tr>
						<td>ROLES</td>
						<td>${user.userRoles}</td>
					</tr>


				</table>
			</div>
			<!-- card body close -->

			<div class="card-footer bg-light">
				<a href="all" class="btn btn-primary">Come Back</a>
			</div>


		</div>
		<!-- card end -->
	</div>
	<!-- container end -->



</body>
</html>