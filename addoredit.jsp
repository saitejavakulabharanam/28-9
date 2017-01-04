<center>
<div class="container shadow" style="background-color:white">

<c:choose>
<c:when test="${add == 0}">
<c:choose>
<c:when test="${edit == 1}">
<p style="margin-top:10px"><b style="font-size:17px">Edit Category Details</b></p>
<form:form method="POST" action="categoryupdate" commandName="category">
<table style="width:400px;height:250px">
<tr><td>Category Id:</td><td><form:input type="text" path="id" value="${cat.id}" readonly="true"/></td></tr>
<tr><td>Category Name:</td><td><form:input type="text" path="name" value="${cat.name}" /></td></tr>
<tr><td>Description:</td><td><textarea name="description" rows="4" cols="30">${cat.description}</textarea></td></tr>
<tr><td>Main Category:</td><td><form:select path="label">
   <form:option value="electronics" label="Electronics"/>
   <form:option value="appliances" label="Appliances"/>
   <form:option value="men" label="Men"/>
   <form:option value="women" label="Women"/>
   <form:option value="kids" label="Baby & Kids"/>
   <form:option value="home" label="Home & Furniture"/>
   <form:option value="books" label="Books & More"/>
</form:select>
</td></tr>
</table><br>
<input type="submit" value="Update" class="btn btn-primary shadow" style="height:38px"/>
</form:form>
</c:when>
<c:otherwise>

<p style="margin-top:10px"><b style="font-size:17px">ADD Category</b></p>
<form:form method="POST" action="Categoryreg" commandName="category">
<table style="width:400px;height:250px;">
<tr><td>Category Id:</td><td><form:input type="text" path="id" autofocus="autofocus"/><form:errors path="id" /></td></tr>
<tr><td>Category Name:</td><td><form:input type="text" path="name" /><form:errors path="name" /></td></tr>
<tr><td>Description:</td><td><form:textarea path="description" rows="4" cols="30"/></td></tr>
<tr><td>Main Category:</td><td>
<form:select path="label">
   <form:option value="electronics" label="Electronics"/>
   <form:option value="appliances" label="Appliances"/>
   <form:option value="men" label="Men"/>
   <form:option value="women" label="Women"/>
   <form:option value="kids" label="Baby & Kids"/>
   <form:option value="home" label="Home & Furniture"/>
   <form:option value="books" label="Books & More"/>
</form:select></td></tr>
</table>
<br>
<input type="submit" value="Add" class="btn btn-primary shadow" style="height:38px"/><input type="reset" value="Reset" class="btn btn-danger shadow" style="margin-left:80px;height:38px"/>
</form:form>
</c:otherwise>
</c:choose>
<hr class="style14">
</c:when>

<c:when test="${add == 1}">
<c:choose>
<c:when test="${edit == 1}">
<p style="margin-top:10px"><b style="font-size:17px">Edit Product Details</b></p>
<form:form method="POST" action="Updateproduct" commandName="product" enctype="multipart/form-data">
<table style="width:400px;height:365px">
<tr><td>Product Id:</td><td><form:input type="text" path="id" value="${prod.id}" readonly="true"/></td></tr>
<tr><td>Product Name:</td><td><form:input type="text" path="name" value="${prod.name}"/><form:errors path="name" /></td></tr>
<tr><td>Description:</td><td><textarea name="description" rows="4" cols="30">${prod.description}</textarea></td></tr>
<tr><td>Price:</td><td><form:input path="price" type="number" value="${prod.price}"/><form:errors path="price" /></td></tr>
<tr><td>Brand:</td><td><form:input path="brand" type="text" value="${prod.brand}"/><form:errors path="brand" /></td></tr>
<tr><td>Quantity:</td><td><form:input path="quantity" type="number" value="${prod.quantity}"/><form:errors path="quantity" /></td></tr>
<tr><td>Image:</td><td><form:input path="image" type="file" /></td></tr>
<tr><td>Category Name:</td>
<td><form:select path="category.name" items="${categoryList}" itemValue="name" itemLabel="name"></form:select></td></tr>
<tr><td>Supplier Name:</td>
<td><form:select path="supplier.name" items="${supplierList}" itemValue="name" itemLabel="name"></form:select></td></tr>
</table><br>
<input type="submit" value="Update" class="btn btn-primary shadow" style="height:38px"/>
</form:form>
</c:when>

<c:otherwise>
<p style="margin-top:10px"><b style="font-size:17px">ADD Product</b></p>
<form:form method="POST" action="Productreg" commandName="product" enctype="multipart/form-data">
<table style="width:400px;height:380px">
<tr><td>Product Id:</td><td><form:input type="text" path="id" autofocus="autofocus"/><form:errors path="id" /></td></tr>
<tr><td>Product Name:</td><td><form:input type="text" path="name" /><form:errors path="name" /></td></tr>
<tr><td>Description:</td><td><form:textarea path="description" rows="4" cols="30" /></td></tr>
<tr><td>Price:</td><td><form:input path="price" type="number" /><form:errors path="price" /></td></tr>
<tr><td>Brand:</td><td><form:input path="brand" type="text"/><form:errors path="brand" /></td></tr>
<tr><td>Quantity:</td><td><form:input path="quantity" type="number" /><form:errors path="quantity" /></td></tr>
<tr><td>Image:</td><td><form:input path="image" type="file" /></td></tr>
<tr><td>Category Name:</td>
<td><form:select path="category.name" items="${categoryList}" itemValue="name" itemLabel="name"></form:select></td></tr>
<tr><td>Supplier Name:</td>
<td><form:select path="supplier.name" items="${supplierList}" itemValue="name" itemLabel="name"></form:select></td></tr>
</table><br>
<input type="submit" value="Add" class="btn btn-primary shadow" style="height:38px"/><input type="reset" value="Reset" class="btn btn-danger shadow" style="margin-left:80px;height:38px"/>
</form:form>
</c:otherwise>
</c:choose>
<hr class="style14">
</c:when>

<c:when test="${add == 2}">
<c:choose>
<c:when test="${edit == 1}">
<p style="margin-top:10px"><b style="font-size:17px">Edit Supplier Details</b></p>
<form:form method="POST" action="Updatesupplier" commandName="supplier">
<table style="width:400px;height:200px">
<tr><td>Supplier Id:</td><td><form:input type="text" path="id" value="${supp.id}" readonly="true"/></td></tr>
<tr><td>Supplier Name:</td><td><form:input type="text" path="name" value="${supp.name}"/><form:errors path="name" /></td></tr>
<tr><td>Address:</td><td><textarea name="address" rows="4" cols="30">${supp.address}</textarea></td></tr>
</table><br>
<input type="submit" value="Update" class="btn btn-primary shadow" style="height:38px"/>
</form:form>
</c:when>
<c:otherwise>
<p style="margin-top:10px"><b style="font-size:17px">ADD Supplier</b></p>
<form:form method="POST" action="Supplierreg" commandName="supplier">
<table style="width:400px;height:200px">
<tr><td>Supplier Id:</td><td><form:input type="text" path="id" autofocus="autofocus"/><form:errors path="id" /></td></tr>
<tr><td>Supplier Name:</td><td><form:input type="text" path="name" /><form:errors path="name" /></td></tr>
<tr><td>Address:</td><td><form:textarea path="address" rows="4" cols="30" /></td></tr>
</table><br>
<input type="submit" value="Add" class="btn btn-primary shadow" style="height:38px"/><input type="reset" value="Reset" class="btn btn-danger shadow" style="margin-left:80px;height:38px"/>
</form:form>
</c:otherwise>
</c:choose>
<hr class="style14">
</c:when>
<c:when test="${add == 3}">
<c:choose>
<c:when test="${edit == 1}">
<p style="margin-top:10px"><b style="font-size:17px">Edit User Details</b></p>
<form:form method="POST" action="Updateuserdetails" commandName="userDetails">
<table style="width:400px;height:370px">
<tr><td>User Name:</td><td><form:input type="text" path="id" value="${user.id}" readonly="true"/></td></tr>
<tr><td>Password:</td><td><form:input path="password" type="password" value="${user.password}" readonly="true"/></td></tr>
<tr><td>Email:</td><td><form:input type="email" path="mail" value="${user.mail}"/></td></tr>
<tr><td>Address:</td><td><textarea name="address" rows="4" cols="30">${user.address}</textarea></td></tr>
<tr><td>Contact:</td><td><form:input type="text" path="contact" value="${user.contact}"/></td></tr>
<tr><td>Role:</td><td><form:input type="text" path="role" value="${user.role}"/><form:errors path="role" /></td></tr>
</table><br>
<input type="submit" value="Update" class="btn btn-primary shadow" style="height:38px"/>
</form:form>
</c:when>
<c:otherwise>
ADD User<br><br>
<form:form method="POST" action="Register" commandName="userDetails">
<table style="width:300px;height:200px;text-align:center">
<tr><td>User Name:</td><td><form:input type="text" path="id" /></td></tr>
<tr><td>Password:</td><td><form:input path="password" type="password" /></td></tr>
<tr><td>Confirm Password:</td><td><form:input type="password" path="psw2" /></td></tr>
<tr><td>Email:</td><td><form:input type="email" path="mail" /></td></tr>
<tr><td>Address:</td><td><form:textarea rows="4" cols="30" path="address" /></td></tr>
<tr><td>Contact:</td><td><form:input type="text" path="contact" /></td></tr>
<tr><td><input type="submit" value="Submit" /></td><td><input type="reset" value="Reset" /></td></tr>
</table>
</form:form><br>
</c:otherwise>
</c:choose>
<hr class="style14">
</c:when>
<c:when test="${add == 4}">
<c:choose>
<c:when test="${edit == 1}">
<p style="margin-top:10px"><b style="font-size:17px">Edit Shipping Address</b></p>
<form:form method="POST" action="addressupdate" commandName="billingAddress">
<table style="width:400px;height:250px;">
<tr><td>User Id:</td><td><form:input type="text" path="user_Id" value="${username}" readonly="true"/></td></tr>

<tr><td>Address Id:</td><td><form:input type="numbet" path="id" value="${address.id}" readonly="true"/></td></tr>
<tr><td>Name:</td><td><form:input type="text" path="name" /><form:errors path="name" /></td></tr>
<tr><td>House-No:</td><td><form:input type="text" path="houseno" value="${address.houseno}" autofocus="autofocus"/><form:errors path="houseno" /></td></tr>
<tr><td>Street:</td><td><form:input type="text" path="street" value="${address.street}"/><form:errors path="street" /></td></tr>
<tr><td>City:</td><td><form:input type="text" path="city" value="${address.city}"/><form:errors path="city" /></td></tr>
<tr><td>State:</td><td><form:input path="state" type="text" value="${address.state}"/><form:errors path="state" /></td></tr>
<tr><td>Country:</td><td><form:input type="text" path="country" value="${address.country}"/><form:errors path="country" /></td></tr>
<tr><td>Zip-code:</td><td><form:input type="text" path="zip" value="${address.zip}"/><form:errors path="zip" /></td></tr>
<tr><td>Contact:</td><td><form:input type="text" path="contact" /><form:errors path="contact" /></td></tr>
</table><br>
<input type="submit" value="Update" class="btn btn-primary shadow" style="height:38px"/>
</form:form>
</c:when>
<c:otherwise>

<p style="margin-top:10px"><b style="font-size:17px">ADD Shipping Address</b></p>
<form:form method="POST" action="addressreg" commandName="billingAddress">
<table style="width:400px;height:250px;">
<tr><td>User Id:</td><td><form:input type="text" path="user_Id" value="${username}" readonly="true"/></td></tr>
<tr><td>Name:</td><td><form:input type="text" path="name" /><form:errors path="name" /></td></tr>
<tr><td>House-No:</td><td><form:input type="text" path="houseno" autofocus="autofocus"/><form:errors path="houseno" /></td></tr>
<tr><td>Street:</td><td><form:input type="text" path="street" /><form:errors path="street" /></td></tr>
<tr><td>City:</td><td><form:input type="text" path="city" /><form:errors path="city" /></td></tr>
<tr><td>State:</td><td><form:input path="state" type="text"/><form:errors path="state" /></td></tr>
<tr><td>Country:</td><td><form:input type="text" path="country" /><form:errors path="country" /></td></tr>
<tr><td>Zip-code:</td><td><form:input type="text" path="zip" /><form:errors path="zip" /></td></tr>
<tr><td>Contact:</td><td><form:input type="text" path="contact" /><form:errors path="contact" /></td></tr>
</table>
<br>
<input type="submit" value="Add" class="btn btn-primary shadow" style="height:38px"/><input type="reset" value="Reset" class="btn btn-danger shadow" style="margin-left:80px;height:38px"/>
</form:form>
</c:otherwise>
</c:choose>
<hr class="style14">
</c:when>

<c:otherwise>
</c:otherwise>
</c:choose>

</div>
</center>