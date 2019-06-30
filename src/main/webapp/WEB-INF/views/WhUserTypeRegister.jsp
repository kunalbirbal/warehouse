<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Welcome To Wh User Type Register Page</h2>

<form:form action="insert" method="post" modelAttribute="whUserType">
	<pre>
		User Type: 
			<form:radiobutton path="userType" value="VENDOR"/>Vendor
			<form:radiobutton path="userType" value="CUSTOMER"/>Customer
			
		User Code:
			<form:input path="userCode"/>
			
		User For:
			<form:input path="userFor"/>
		
		User Email:
			<form:input path="userEmail"/>
			
		User Contact:
			<form:input path="userContact"/>
			
		User Id Type:
			<form:select path="userIdType">
				<form:option value="">-Select-</form:option>
				<form:option value="PAN CARD">Pan Card</form:option>
				<form:option value="AADHAR">Aadhar</form:option>
				<form:option value="VOTER ID">Voter ID</form:option>
				<form:option value="OTHER">Other</form:option>
			</form:select>
			
		If Other:
			<form:input path="ifother"/>
			
		ID Number:
			<form:input path="idnumber"/>
			
			<input type="submit" value="Create Wh User Type" />
			
	</pre>
</form:form>

${message}
<br/>
<a href="all"> View All</a>


</body>
</html>