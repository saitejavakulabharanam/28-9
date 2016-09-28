<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootswatch/3.2.0/sandstone/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SignUp</title>
</head>
<body>
	<center>
		<h2>Welcome To SignUp Page</h2>
<br>
		<form:form method="POST" commandName="userDetails">
<table style="height:380px;width:500px">
<tr><td>User Name:</td><td><form:input type="text" path="id" /></td><td style="color:red;font-size:12px">
<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('name')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach> </td></tr>
<tr><td>Password:</td><td><form:input path="password" type="password" /></td><td style="color:red;font-size:12px">
<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('password')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach></td> </tr>
<tr><td>Confirm Password:</td><td><form:input type="password" path="psw2" /></td><td style="color:red;font-size:12px">
<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('cpassword')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach> </td></tr>
<tr><td>Email:</td><td><form:input type="email" path="mail" /></td><td style="color:red;font-size:12px">
<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('email')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach> </td></tr>
<tr><td>Address:</td><td><form:textarea rows="5" column="5" path="address"/></td><td style="color:red;font-size:12px">
<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('address')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach> </td></tr>

<tr><td>Contact:</td><td><form:input type="text" path="contact" /></td><td style="color:red;font-size:12px">
<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('mobile')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach> </td></tr>
</table>
<br>
<input class="btn btn-primary" type="submit" name="_eventId_submit" value="Register" /><input class="btn btn-danger" type="reset" value="Reset" style="margin-left:90px"/>
</form:form>

	</center>

</body>
</html>