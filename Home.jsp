<%@ include file="header.jsp"%>

<center>

<div class="container shadow" style="background-color:white;min-width:950px;width:89%">
  <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">

      <div class="item active">
        <img src="resources/images/cor1.png" style="width:100%;height:300px">
        <div class="carousel-caption" style="text-align:left">
        </div>
      </div>

      <div class="item">
        <img src="resources/images/cor2.jpg" style="width:100%;height:300px">
        <div class="carousel-caption">
        </div>
      </div>
    
      <div class="item">
        <img src="resources/images/cor3.jpg" style="width:100%;height:300px">
        <div class="carousel-caption">
        </div>
      </div>

      <div class="item">
        <img src="resources/images/cor4.png" style="width:100%;height:300px">
        <div class="carousel-caption" style="text-align:right">
        </div>
      </div>
  
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
<br>
<div class="container shadow" style="background-color:white;min-width:950px;width:88%;height:initial">
<table style="width:100%"><tr><td style="text-align:left;font-size:23px;">DEALS OF THE DAY</td>
<td style="text-align:right;font-size:15px">Time Left :</td></tr>
</table>
</div>
<br>
<div class="container shadow" style="background-color:white;width:1700px;height:380px">
<p style="text-align:left;font-size:20px;margin:7px 0px 0px">FEATURED BRANDS</p>
<hr class="style18" style="margin:8px 0px 9px">

   <table style="height:280px;width:1590px;">
   <tr>
   <td style="width:350px">
      <a href = "rolex" class = "thumbnail shadow" style="text-decoration:none;background-color:white;margin:0px 10px;color:black">
         <img src = "resources/images/rolex.jpg" class="img-rounded" style="height:250px;width:100%">
       <button type="button" class="btn btn-warning shadow" style="float:right;height:35px;margin:8px 10px">Buy Now</button>
       <p style="font-size:16px;margin:7px 10px">Rolex</p><p style="margin:0px 10px">Symbol of Royalty</p>
       
      </a>
   </td>
   
   <td style="width:350px">
      <a href = "puma" class = "thumbnail shadow" style="text-decoration:none;background-color:white;margin:0px 10px;color:black">
         <img src = "resources/images/puma.jpg" class="img-rounded" style="height:250px;width:100%">
       <button type="button" class="btn btn-warning shadow" style="float:right;height:35px;margin:8px 10px">Buy Now</button>
    <p style="font-size:16px;margin:7px 10px">PUMA</p><p style="margin:0px 10px">The Nature of Performance</p> 
       
      </a>
   </td>
   
   <td style="width:350px">
      <a href = "lee" class = "thumbnail shadow" style="text-decoration:none;background-color:white;margin:0px 10px;color:black">
         <img src = "resources/images/Lee.jpg" class="img-rounded" style="height:250px;width:100%">
      <button type="button" class="btn btn-warning shadow" style="float:right;height:35px;margin:8px 10px">Buy Now</button>
      <p style="font-size:16px;margin:7px 10px">LeeCooper</p><p style="margin:0px 10px">A Lee Never Dies</p>
       
      </a>
   </td>
   <td style="width:350px">
	<a href = "apple" class = "thumbnail shadow" style="text-decoration:none;background-color:white;margin:0px 10px;color:black">
         <img src = "resources/images/Apple.jpg" class="img-rounded" style="height:250px;width:100%">
      
       <button type="button" class="btn btn-warning shadow" style="float:right;height:35px;margin:8px 10px">Buy Now</button>
      <p style="font-size:16px;margin:7px 10px">Apple</p><p style="margin:0px 10px">Think Different</p>
       
      
      </a>
</td>   </tr>
   </table>

</div>




<br><br><br><br><br><br><br><br><br><br><br>




<br><br><br><br><br><br>












</center>
<%@ include file="footer.jsp"%>