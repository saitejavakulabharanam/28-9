<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SignIn</title>
<style>
table{text-align:center;}
</style>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
</head>
<body>
<center>
<h2>Welcome To SignIn Page</h2>
<form method="POST" action="perform_login">
<table style="height:400px;width:400px;text-align:center">
<tr><td>User Name:</td><td><input type="text" name="username" /></td></tr>
<tr><td>Password:</td><td><input name="password" type="password" /></td></tr>
<tr><td><input type="submit" value="Submit" /></td><td><input type="submit" value="Reset" /></td></tr>
</table>
</form>
</center>
</body>
</html>