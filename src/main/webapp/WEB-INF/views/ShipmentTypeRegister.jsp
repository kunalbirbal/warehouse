<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shipment Register</title>
</head>
<body>

<h2>Welcome to Shipment Register page</h2>

<form:form action="insert" method="post" modelAttribute="shipmentType">
	<pre>
		Shipment Mode: 
			<form:select path="shipmentMode">
				<form:option value="">-Select-</form:option>
				<form:option value="AIR">Air</form:option>
				<form:option value="TRUCK">Truck</form:option>
				<form:option value="SHIP">Ship</form:option>
				<form:option value="TRAIN">Train</form:option>
			</form:select>
			
		ShipmentCode:
			<form:input path="shipmentCode"/>
			
		Enable Shipment:
			<form:select path="enableShipment">
				<form:option value="">-Select-</form:option>
				<form:option value="YES">Yes</form:option>
				<form:option value="NO">No</form:option>
			</form:select>
		
		Shipment Grade: 
			<form:radiobutton path="shipmentGrade" value="A"/>A
			<form:radiobutton path="shipmentGrade" value="B"/>B
			<form:radiobutton path="shipmentGrade" value="C"/>C
			
		Description:
			<form:textarea path="shipDesc"/>
			
			<input type="submit" value="Create Shipment" />
			
	</pre>
</form:form>

${ message }

<br/>
<a href="all">View All</a>

</body>
</html>