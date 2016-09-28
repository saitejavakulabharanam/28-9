
<center>

<c:if test="${listcat == 0}">
<c:if test="${!empty categoryList}">
<div class="container shadow" style="background-color:white;min-width:870px">
<p style="margin-top:10px"><b style="font-size:17px">CATEGORY LIST</b></p>

<table class="table table-hover container" style="width:800px;margin-top:8px">

<tr style=" background-color:#D8D4D4"><th>#</th>
<th>Category Name</th>
<th>Category Description</th>
<th>Main Category</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<c:forEach items="${categoryList}" var="category">
<tr><td>${category.id}</td>
<td>${category.name}</td>
<td>${category.description}</td>
<td>${category.label}</td>
<td><a href="<c:url value='Updatecat${category.id}'/>"><span class="glyphicon glyphicon-pencil"></span></a></td>
<td><a href="<c:url value='Deletecategory${category.id}'/>"><span class="glyphicon glyphicon-trash"></span></a></td>
</tr>
</c:forEach>
</table>
</div>
</c:if>
</c:if>


<c:if test="${listsupp == 0}">
<c:if test="${!empty supplierList}">
<div class="container shadow" style="background-color:white;min-width:870px">
<p style="margin-top:10px"><b style="font-size:17px">SUPPLIER LIST</b></p>
<table class="table table-hover" style="width:800px;margin-top:8px">
<tr style=" background-color:#D8D4D4"><th>#</th><th>Supplier Name</th><th>Supplier Address</th><th>Edit</th><th>Delete</th></tr>
<c:forEach items="${supplierList}" var="supplier">
<tr><td>${supplier.id}</td><td>${supplier.name}</td><td>${supplier.address}</td>
<td><a href="<c:url value='Updatesupp${supplier.id}'/>"><span class="glyphicon glyphicon-pencil"></span></a></td>
<td><a href="<c:url value='Deletesupplier${supplier.id}'/>"><span class="glyphicon glyphicon-trash"></span></a></td>
</tr>
</c:forEach>
</table>
</div>
</c:if>
</c:if>


 
<c:if test="${listprod == 0}">
<div class="container shadow" style="background-color:white;min-width:1400px">
<p style="margin-top:10px"><b style="font-size:17px">PRODUCT LIST</b></p>
<div class="container" ng-app="myApp" ng-controller="MyController" ng-init="getDataFromServer()">

  <form>
    <div class="form-group">
      <div class="input-group">
        <div class="input-group-addon"><i class="fa fa-search"></i></div>
       <input type="text" class="form-control" placeholder="Search Product Name" ng-model="searchPTitle">      
       </div>      
    </div>
  </form>
  
  <table class="table table-hover" style="min-width:1200px">
    
    <thead>
      <tr>
      <td>
          <a href="#" ng-click="sortType = 'id'; sortReverse = !sortReverse">
            Product Id 
            <span ng-show="sortType == 'id' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'id' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        
        <td>
          <a href="#" ng-click="sortType = 'productname'; sortReverse = !sortReverse">
            Product Name 
            <span ng-show="sortType == 'productname' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'productname' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        <td>
          <a href="#" ng-click="sortType = 'productdescription'; sortReverse = !sortReverse">
            Product Description 
            <span ng-show="sortType == 'productdescription' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'productdescription' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        <td>
          <a href="#" ng-click="sortType = 'quantity'; sortReverse = !sortReverse">
          Quantity
            <span ng-show="sortType == 'quantity' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'quantity' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        <td>
          <a href="#" ng-click="sortType = 'price'; sortReverse = !sortReverse">
          Price
            <span ng-show="sortType == 'price' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'price' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        <td>
          <a href="#" ng-click="sortType = 'brand'; sortReverse = !sortReverse">
            Brand 
            <span ng-show="sortType == 'brand' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'brand' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
       
       
       
        <td>
          <a href="#" ng-click="sortType = 'more'; sortReverse = !sortReverse">
          Category Name
            <span ng-show="sortType == 'more' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'more' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        <td>
          <a href="#" ng-click="sortType = 'more'; sortReverse = !sortReverse">
          Supplier Name
            <span ng-show="sortType == 'more' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'more' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
         <td>
          <a href="#" ng-click="sortType = 'more'; sortReverse = !sortReverse">
          Image
            <span ng-show="sortType == 'more' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'more' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        
        </tr>
    </thead>
    
    <tbody>
      <tr ng-repeat="p1 in prod | orderBy:sortType:sortReverse | filter:searchPTitle">
           		<td>{{p1.id}}</td>
           		<td>{{p1.name}}</td>
           		<td>{{p1.description}}</td>
           		<td>{{p1.quantity}}</td>
           		<td>{{p1.price}}</td>
           		<td>{{p1.brand}}</td>
           		<td>{{p1.cat_Id}}</td>
           		<td>{{p1.supp_Id}}</td>
           		<td><img src="resources/images/products/{{p1.name}}.jpg" style="height:100px;width:100px"></td>
           		
   
       <td><a href="Deleteproduct&{{p1.id}}"><span class="glyphicon glyphicon-trash"></span></a></td>
        <td><a href="Updateprod&{{p1.id}}"><span class="glyphicon glyphicon-pencil"></span></a></td>      		
           	
      </tr>
    </tbody>
    
  </table>
  <a href="ManageProduct"><h1 align="center"><h2><font color="white">Back</a>
</div>
</div>
<br>
</c:if>






<c:if test="${listusers == 0}">
 <c:if test="${!empty userdetailsList}">
<div class="container shadow" style="background-color:white;min-width:1470px">
 <p style="margin-top:10px"><b style="font-size:17px">USER DETAILS LIST</b></p>
<table class="table table-hover" style="width:1400px;margin-top:8px">

<tr style="background-color:#D8D4D4;">
<th>User Name</th>
<th>User Password</th>
<th>User E-Mail</th>
<th>User Contact</th>
<th>User Address</th>
<th>User Role</th>
<th>Edit</th>
<th>Delete</th>
</tr>

<c:forEach items="${userdetailsList}" var="user">
<tr><td>${user.id}</td>
<td>${user.password}</td>
<td>${user.mail}</td>
<td>${user.contact}</td>
<td>${user.address}</td>
<td>${user.role}</td>
<td><a href="<c:url value='Updateuser${user.id}'/>"><span class="glyphicon glyphicon-pencil"></span></a></td>
<td><a href="<c:url value='Deleteuser${user.id}'/>"><span class="glyphicon glyphicon-trash"></span></a></td>
</tr>
</c:forEach>
</table>
</div>
</c:if>
</c:if>
</center>
