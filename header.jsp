<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Shopping India | LocalKart.Com</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootswatch/3.2.0/sandstone/bootstrap.min.css">
<script	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.23/angular.min.js"></script>
  
<link rel="stylesheet" href="resources/css/homeheader.css">

<!-- 
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
 -->  
 <script>
var app = angular.module('myApp', []);
 
function MyController($scope, $http) {

	 $scope.sortType = 'name'; // set the default sort type
	  $scope.sortReverse = false;  // set the default sort order
	  $scope.searchBTitle = '';
	  
        $scope.getDataFromServer = function() {
                $http({
                        method : 'GET',
                        url : 'GsonCon'
                }).success(function(data, status, headers, config) {
                        $scope.prod = data;  
                }).error(function(data, status, headers, config) {
                        // called asynchronously if an error occurs
                        // or server returns response with an error status.
                });
        };
};



</script>
 
    
</head>

<body style="background-color:#F9F4F4">
<center>
<c:choose>
<c:when test="${isAdmin == 1}">
<div class="container">
<br>
<span style="float:left;font-size:25px"><b>welcome : ${username}</b></span>
<p><a href="perform_logout" style="text-decoration:none;font-size:25px;float:right">Log Out</a></p>
	<br>
	
	<ul class="list-inline" style="min-width:625px">
		<li>		<div class="dropdown">
				<button class="btn btn-primary dropdown-toggle shadow" style="height:40px" type="button"
					data-toggle="dropdown">
					Manage Products <span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<li><a href="Addproduct">Add Product</a></li>
					<li class="divider"></li>
					<li><a href="productlist">Product List</a></li>
				</ul>
			</div></li>
		<li>	<div class="dropdown">
				<button class="btn btn-primary dropdown-toggle shadow" style="height:40px" type="button"
					data-toggle="dropdown">
					Manage Categories <span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<li><a href="Addcategory">Add Category</a></li>
					<li class="divider"></li>
					<li><a href="categorylist">Category List</a></li>
				</ul>
			</div></li>
<li>			<div class="dropdown">
				<button class="btn btn-primary dropdown-toggle shadow" style="height:40px" type="button"
					data-toggle="dropdown">
					Manage Suppliers <span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<li><a href="Addsupplier">Add Supplier</a></li>
					<li class="divider"></li>
					<li><a href="supplierlist">Supplier List</a></li>
				</ul>
			</div>
	
	</li><li>		<div class="dropdown">
				<button class="btn btn-primary dropdown-toggle shadow" style="height:40px" type="button"
					data-toggle="dropdown">
					Manage Users <span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<li><a href="userslist">User List</a></li>
				</ul>
			</div>
			</li>
			</ul>
		</div>
		<hr class="style14">

</c:when>
<c:otherwise>
<div class="shadow" style="background-color:#326AEC;position:fixed;width: 100%; z-index: 20">
<div class="container" style="min-width:950px">

<table style="float:right;font-size:12.5px;margin:10px 0px 10px">
<tr><td><a class="sellline" href="">Sell</a></td>
<td><a class="sellline" href="">Gift Voucher</a></td>
<td><a class="sellline" href=""><span class="glyphicon glyphicon-phone">&nbsp;Download App</a></td>
<td><a class="sellline" href="">24x7 Customer Care</a></td>
<td><a class="sellline" href="">Track Order</a></td>
<c:choose>
<c:when test="${!empty username}">
<td><div class="dropdown">
  <a class="dropbtn sellline">Hi ${username}</a>
  <div class="dropdown-content">
    <a href="#">Link 1</a>
    <a href="#">Link 2</a>
    <a href="perform_logout"><span class="glyphicon glyphicon-log-out"> Log Out</a>
  </div>
</div></td>
</c:when>
<c:otherwise>
<!-- data-toggle="modal" data-target="#myModal1" -->
<td><a class="sellline" href="memberShip.obj" >SignUp</a></td>
<td><a class="sellline" href="" data-toggle="modal" data-target="#myModal"> <span class="glyphicon glyphicon-log-in">&nbsp;LogIn</a></td>
</c:otherwise>
</c:choose>
</tr>
</table>

<br>
<table style="min-width:950px">
<tr><td><a class="w" href="main" style="font-size:25px"><i>LocalKart</i><img src="resources/images/logo.png" style="height:45px;width:70px;margin-left:10px"></a></td>
<td><form>
<div class="input-group shadow" style="margin:0px 25px 0px"><input type="text" name="search" style="height:40px;width:520px" class="form-control" placeholder="Search for Products,Brands and More" aria-describedby="basic-addon2"><input type="submit" value="" class="input-group-addon" id="basic-addon2" style="height:40px;width:80px;background-color:#F3D363"> </div>
</form></td>
<td><a href="viewmycart${username}" class="btn btn-primary btn-lg shadow" style="height:40px"><span class="glyphicon glyphicon-shopping-cart"></span> CART <span class="badge">${cartvalue}</span></a></td></tr>
</table>

<table style="min-width:940px;margin:10px 0px 7px">
<tr>
<td><div class="dropdown">
  <a class="dropbtn w">ELECTRONICS</a>
  <div class="dropdown-content">
<c:forEach items="${eleccat}" var="category">
    <a href="navselect${category.id}">${category.name}</a>
</c:forEach>
  </div>
</div></td>
<td><div class="dropdown">
  <a class="dropbtn w">APPLIANCES</a>
  <div class="dropdown-content">
<c:forEach items="${applcat}" var="category">
    <a href="#">${category.name}</a>
</c:forEach>  </div>
</div></td>
<td><div class="dropdown">
  <a class="dropbtn w">MEN</a>
  <div class="dropdown-content">
 <c:forEach items="${mencat}" var="category">
    <a href="#">${category.name}</a>
</c:forEach> </div>
</div>&nbsp;&nbsp;</td>
<td><div class="dropdown">
  <a class="dropbtn w">WOMEN</a>
  <div class="dropdown-content">
<c:forEach items="${womencat}" var="category">
    <a href="#">${category.name}</a>
</c:forEach>  </div>
</div></td>
<td><div class="dropdown">
  <a class="dropbtn w">BABY & KIDS</a>
  <div class="dropdown-content">
<c:forEach items="${kidcat}" var="category">
    <a href="#">${category.name}</a>
</c:forEach>  </div>
</div></td>
<td><div class="dropdown">
  <a class="dropbtn w">HOME & FURNITURE</a>
  <div class="dropdown-content">
  <c:forEach items="${homecat}" var="category">
    <a href="#">${category.name}</a>
</c:forEach></div>
</div></td>
<td><div class="dropdown">
  <a class="dropbtn w">BOOKS & MORE</a>
  <div class="dropdown-content">
    <c:forEach items="${bookcat}" var="category">
    <a href="#">${category.name}</a>
</c:forEach></div>
</div></td>
<td>OFFER ZONE</td>
</tr>
</table>
</div>
</div>

<div class="container" style="min-width:1100px">
<table style="background-color:white;margin-top:121px;height:27px;font-size:14px;min-width:1080px">
<tr><td>&nbsp;&nbsp;GO quickly to</td><td>&rarr;</td>
<td><a href="gomobile" class="goline">Mobiles</a></td>
<td><a href="gosport" class="goline">Sports</a></td>
<td><a href="gotab" class="goline">Tablets</a></td>
<td><a href="gotowel" class="goline">Bath Towels</a></td>
<td><a href="gobulb" class="goline">LED Bulbs</a></td>
<td><a href="gotv" class="goline">TV</a></td>
<td><a href="gowash" class="goline">Washing Machines</a></td>
<td><a href="golap" class="goline">Laptops</a></td>
<td><a href="gohead" class="goline">Headphones</a></td>
<td><a href="gofan" class="goline">Fans</a></td>
<td><a href="" class="goline">Travel</a></td>
<td><a href="gobook" class="goline">Books</a></td>
<td><a href="" class="goline">Auto</a></td></tr>
</table></div>



<!--Login Modal -->
<div class="modal fade" id="myModal" role="dialog">
<div class="modal-dialog modal-lg">
<div class="modal-content">
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal">&times;</button>
<h4 class="modal-title">Welcome To SignIn Page</h4></div>
<div class="modal-body">
<form method="POST" action="perform_login">
<table style="height:400px;width:400px;text-align:center">
<tr><td>User Name:</td><td><input type="text" name="username" autofocus/></td></tr>
<tr><td>Password:</td><td><input name="password" type="password" /></td></tr>
<tr><td><input type="submit" value="Submit" /></td><td><input type="submit" value="Reset" /></td></tr>
</table>
</form>
</div>
<div class="modal-footer">
</div></div></div></div>
<%-- 
<!--SignUp Modal -->
<div class="modal fade" id="myModal1" role="dialog">
<div class="modal-dialog modal-lg" style="width:450px">
<div class="modal-content">
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal">&times;</button>
<h4 class="modal-title">Welcome To SignIn Page</h4>
</div>
<div class="modal-body">
<form:form method="POST" commandName="userDetails">
<table style="height:400px;width:400px;text-align:center">
<tr><td>User Name:</td><td><form:input type="text" path="id" /></td></tr>
<tr><td>Password:</td><td><form:input path="password" type="password" /></td></tr>
<tr><td>Confirm Password:</td><td><form:input type="password" path="psw2" /></td></tr>
<tr><td>Email:</td><td><form:input type="email" path="mail" /></td></tr>
<tr><td>Address:</td><td><form:input type="textarea" rows="5" column="5" path="address"/></td></tr>
<tr><td>Contact:</td><td><form:input type="text" path="contact" /></td></tr>
<tr><td><input type="submit" name="_eventId_submit" value="Submit" /></td><td><input type="reset" value="Reset"/></td></tr>
</table></form:form>
</div>
<div class="modal-footer">
</div></div></div></div> --%>
</c:otherwise>
</c:choose>
</center>