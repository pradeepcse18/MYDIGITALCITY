<!DOCTYPE html>
<html>     
     
       <div id="navbar"> 
          <%@include file="navbar.jsp"%> 
        
        </div>
        
        
          <div style="margin: 50px;">
        <h1 style="text-align: center;color: white; font-size: 40px" >CONTACT US</h1>
         <p class="w3-center w3-large">Lets get in touch. Send us a message:</p>
        </div>
        <div class="w3-container " style="padding:128px 16px" id="contact">
  
  <div class="w3-row-padding" style="margin-top:0px">
    <div class="w3-half">
      <p><i class="fa fa-map-marker fa-fw w3-xxlarge w3-margin-right"></i>Bhabha Institute Of Technology <br> 
         &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;   Kanpur Dehat 209204 UP India</p>
      <p><i class="fa fa-phone fa-fw w3-xxlarge w3-margin-right"></i> MO: +91-8756863642</p>
      <p><i class="fa fa-envelope fa-fw w3-xxlarge w3-margin-right"> </i> Email: pk4699332@mail.com</p>
      <br>
      <form action="ContactRequest"  method="post">
        <p><input class="w3-input w3-border" type="text" placeholder="Name" required name="Name"></p>
        <p><input class="w3-input w3-border" type="number" placeholder="Contact No" id="Contact" required name="Contact" maxlength="12" minlength="10"></p>
        <p><input class="w3-input w3-border" type="email" placeholder="Email" required name="Email"></p>
        <p><input class="w3-input w3-border" type="text" placeholder="Subject" required name="Subject"></p>
        <p><textarea class="w3-input w3-border"  placeholder="Message" required name="Message"></textarea></p>
        <p>
          <button class="w3-button w3-black"  type="submit" onclick="return Validate()">
         
          <script type="text/javascript">
          function Validate() {          
                            var Contact = document.getElementById("Contact").value.toString().length;
             
                                if((Contact<10) ||(Contact>10))
          	                 {
          	                  alert("Please enter the correct Contact No ");
          	                   return false;
          	                 }
                                return true;
          }
          
          
          </script><i class="fa fa-paper-plane" ></i> SEND MESSAGE
          </button>
        </p>
      </form>
    </div>
    <div class="w3-half">
      
      
      
      <div id="map" class="w3-greyscale-max" style="width:100%;height:510px;"></div>
    </div>
  </div>
</div>


 
<!-- Add Google Maps -->

<script>
function myMap() {
	  var mapCanvas = document.getElementById("map");
	  var myCenter = new google.maps.LatLng(26.6305969,79.9341443); 
	  var mapOptions = {center: myCenter, zoom: 12};
	  var map = new google.maps.Map(mapCanvas,mapOptions);
	  var marker = new google.maps.Marker({
	    position: myCenter,
	    animation: google.maps.Animation.BOUNCE
	  });
	  marker.setMap(map);
	}
</script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyChqq_ATOCSWjHSIhTiusEqCvZPbwTSBsQ&callback=myMap"></script>


<div style="text-align: center;"><a  href="http://localhost:8282/MYDIGITALCITY/index.jsp" class="w3-button w3-green">
<i class="fa fa-arrow-up w3-hover-blue w3-margin-right"></i>Goto top</a></div>
        
    <div id="footer1">
 <%@include file="footer.jsp" %> 

 </div>
 <div id="footer">
               
       <%@include file="footer1.jsp" %>
</div>

</body>
</html>