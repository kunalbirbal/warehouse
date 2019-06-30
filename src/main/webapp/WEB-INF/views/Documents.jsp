<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Document upload</title>
</head>
<body>

<h2>Welcome to Documents Page</h2>

<form action="upload" method="post" enctype="multipart/form-data">
	<pre>
		SELECT DOCUMENT:
			<input type="file" name="fileob" />
			
			<input type="submit" value="Upload" />
	</pre>
</form>

<table border="1">
	<tr>
		<th>ID</th>
		<th>NAME</th>
		<th>LINK</th>
	</tr>
	<c:forEach items="${list}" var="ob">
		<tr>
			<td> <c:out value="${ob[0]}" /> </td>
			<td> <c:out value="${ob[1]}" /> </td>
			<td>
				<a href="download?docid=${ob[0]}">
					<img src="../resources/images/download.png" width="25" height="25"/>
				</a>
			</td>
		</tr>
	</c:forEach>
</table>

<br/>
${message}

</body>
</html>