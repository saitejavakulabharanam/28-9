<%@ include file="header.jsp"%>
<center>

<div class="container shadow" style="background-color:white;margin:9px auto 15px;min-width:950px">

<table style="margin:15px;float:left">
<tr style="text-align:left">
<td>
<img src="resources/images/products/${oneproduct.name}.jpg" style="height:450px;width:400px">
</td>
<td>
<div style="margin:0px 70px">
<p style="font-size:16px">${oneproduct.name}</p>
<h3>Rs. ${oneproduct.price}</h3>
${oneproduct.brand}<br>
Description:&nbsp;&nbsp;&nbsp;&nbsp;${oneproduct.description}</div></td>
<td>
<form method="POST" action="buy${username}&${oneproduct.id}">
Quantity:<input type="number" name="quantity" value=1 style="width:33px"/><br>
<input type="submit" value="Buy" class="btn btn-warning shadow" style="font-size:19px;margin:30px 30px"/>
</form>
</td>
</tr>
</table>

</div>

</center>
<%@ include file="footer.jsp"%>
