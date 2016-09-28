<%@ include file="header.jsp"%>
<center>
<div class="container shadow" style="background-color:white;margin:9px 10px 15px;width:1700px">
<c:if test="${empty siteproducts}">
<p style="margin:40px"><b>No Products of This Type are There</b></p>
</c:if>
<div class="row" style="margin:20px 20px">
<c:forEach items="${siteproducts}" var="product">
  <div class="col-md-3">
    <a href="productselect${product.id}" class="thumbnail shadow" style="text-decoration:none;background-color:white;margin:10px 10px;color:black;text-align:left">
      
      <img src="resources/images/products/${product.name}.jpg" style="height:280px;width:320px">
     <button type="button" class="btn btn-warning shadow" style="float:right;height:35px;margin:13px 10px">Buy Now</button>
   <p style="margin:7px 10px 0px">${product.name}</p><p style="margin:0px 10px">${product.brand}</p><p style="font-size:16px;margin:5px 10px 0px">Rs. ${product.price}</p> 
    </a>
  </div>
  </c:forEach>
</div>


</div>
</center>
<%@ include file="footer.jsp"%>