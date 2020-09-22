<!DOCTYPE html>
<html>

          <div id="navbar"> 
          <%@include file="navbar.jsp"%> 
        
        </div>
        
       
        
        
         <div class="loginBox" style="height:750px;margin-top:350px;  width: 500px;">
	     	<img class="user" src="images/pic.jpg "/>
	     	<h2>REGISTER HERE</h2>
	     	<form method="post" action=UserRegister> 
	     NAME :	<input type="text" name="Name" id="caps1" value="" size="40" placeholder="Your Name*" required> <br>
	     DOB :	<input type="date" id="Dob" name="Dob" value="" size="40"  max="2015-12-31" min="1900-01-01"  required><br>
         EMAIL :   <input type="email"  name="Email" id="caps2" value="" size="40" placeholder="Your Email*" required> <br>
         CONTACT :   <input type="number" id="Contact" name="Contact" value="" size="40"  placeholder="Contact No Only 10 Digits*"  required><br>
         PASSWORD :  <input type="password" id="Password" name="Password"  size="40"placeholder="Enter Password *" required >
         CONFIRM PASSWORD :  <input type="password" id="CPassword" name="CPassword"  size="40"placeholder="Confirm Password *" required>
	     	
	     	
	     	 <br />
	     	<input type="submit" name="" value="Register" onclick="return Validate()" />
	     	<a href="login.jsp"> <i style="color:white;"> Already Registerd ?</i> <i> Login Here </i></a>  
	     	</form>
	     	
	     	<script type="text/javascript">
    function Validate() {
        var password = document.getElementById("Password").value;
        var confirmPassword = document.getElementById("CPassword").value;
        var pass=password.length;
        var Dob = document.getElementById("Dob").value.toString().length;
        var Contact = document.getElementById("Contact").value.toString().length;
       
       if((Contact<10) ||(Contact>10))
    	   {
    	   alert("Please enter the correct Contact No ");
    	   return false;
    	   }
       
       if((pass<8))
    	   {
    	   alert("password is too short ");
    	   return false;
    	   }
       if(pass>16)
    	   {
    	   alert("password is too large ");
    	   return false;
    	   }
        
       if (password != confirmPassword) {
            alert("Passwords do not match.");
            return false;
        }
        return true;
    }
    
    document.getElementById("caps1").onchange = function() {myFunction1()};
    function myFunction1() {
                            var x = document.getElementById("caps1");
                            x.value = x.value.toUpperCase();
                           }
    
    document.getElementById("caps2").onchange = function() {myFunction2()};
    function myFunction2() {
                               var x = document.getElementById("caps2");
                              x.value = x.value.toUpperCase();
                             }
    
</script>
	     </div>
        
        
        
        
        
        
        
        
        
        
        
            
    <div id="footer1"  style="margin-top:900px;">
 <%@include file="footer.jsp" %> 

 </div>
 <div id="footer">
               
       <%@include file="footer1.jsp" %>
</div>

</body>
</html>