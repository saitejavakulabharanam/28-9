<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<ul class="list-inline">
		<li>		<div class="dropdown">
				<button class="btn btn-primary dropdown-toggle" type="button"
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
				<button class="btn btn-primary dropdown-toggle" type="button"
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
				<button class="btn btn-primary dropdown-toggle" type="button"
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
				<button class="btn btn-primary dropdown-toggle" type="button"
					data-toggle="dropdown">
					Manage Users <span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<li><a href="Signup">Add User</a></li>
					<li class="divider"></li>
					<li><a href="userslist">User List</a></li>
				</ul>
			</div>
			</li>
			</ul>

</body>
</html>