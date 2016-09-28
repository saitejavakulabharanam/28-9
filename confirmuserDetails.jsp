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
<div class="content">
		<fieldset>
			<legend>Confirm Details</legend>
			<!-- for triggering webflow events using links,
					 the eventId to be triggered is given in "href" attribute as:
				 -->
			<a href="${flowExecutionUrl}&_eventId_home">Home</a><br /> <br />
			<form:form modelAttribute="userDetails">
				<form:label path="id">User ID :</form:label>${userDetails.id}
					<br />
				<br />
				<form:label path="password">Password :</form:label>${userDetails.password}
					<br />


				<form:label path="mail">Email:</form:label>${userDetails.mail}
					<br />
				<br />
				<form:label path="contact">Mobile #:</form:label>${userDetails.contact}
					<br />
				<br />
				<form:label path="address">Address :</form:label>${userDetails.address}
					<br />
				<br />
				<input name="_eventId_edit" class="btn btn-danger" type="submit" value="Edit" />
				<input name="_eventId_submit" class="btn btn-primary" type="submit" value="Confirm Details" />
				<br />
			</form:form>
		</fieldset>
	</div>
</center>
</body>
</html>