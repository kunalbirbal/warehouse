<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Welcome to Wh User Type View Page</h2>

<table border="1">
	<tr>
		<td>ID</td>
		<td>${wu.userId}</td>
	</tr>
	<tr>
		<td>TYPE</td>
		<td>${wu.userType}</td>
	</tr>
	<tr>
		<td>CODE</td>
		<td>${wu.userCode}</td>
	</tr>
	<tr>
		<td>USER FOR</td>
		<td>${wu.userFor}</td>
	</tr>
	<tr>
		<td>EMAIL</td>
		<td>${wu.userEmail}</td>
	</tr>
	<tr>
		<td>CONTACT</td>
		<td>${wu.userContact}</td>
	</tr>
	<tr>
		<td>USER ID TYPE</td>
		<td>${wu.userIdType}</td>
	</tr>
	<tr>
		<td>OTHER</td>
		<td>${wu.ifother}</td>
	</tr>
	<tr>
		<td>ID No.</td>
		<td>${wu.idnumber}</td>
	</tr>
	
	
</table>

<a href="all">Come Back</a>


</body>
</html>