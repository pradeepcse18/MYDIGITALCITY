<html>
<div id="navbar"> 
          <%@include file="unavbar.jsp"%> 
        
        </div>



   
      <h4 align="right">USER:  <%= ((String)session.getAttribute("email"))%> </h4>
      
       <div class="wrap" style="text-align:center">
<div class="left" style=" float: left;" >
     <div class="vertical-menu"  style="margin-left: 100px; margin-top:0px" >
       <a href="#" class="active">DASHBOARD</a>
       <a href="ViewProfile.jsp?email=<%=(String)session.getAttribute("email")%>">VIEW PROFILE</a>
       <a href="edituserprofile.jsp">EDIT PROFILE</a>
       <a href="changepassword.jsp">CHANGE PASSWORD</a>
      </div>
</div>
      

<div class="center" align="center" style="margin-top:50px;">
<form action="UpdatePassword" method="post">
<table >
<caption>CHANGE PASSWORD</caption>
<tr><th>OLD PASSWORD</th><td><input type="text" name="oldpassword" required="required"></td></tr>
<tr><th>NEW PASSWORD</th><td><input type="password" id="Password" name="newpassword" required="required"></td></tr>
<tr><th>CONFIRM PASSWORD</th><td><input type="password" id="CPassword" name="cpassword" required="required"></td></tr>

</table>
<br><input type="hidden" name="mail" value=<%=(String)session.getAttribute("email")%> required="required">
<input type="submit"  value="UPDATE PASSWORD" onclick="return Validate()" />
</form>
</div>
</div>
	<script type="text/javascript">
    function Validate() {
        var password = document.getElementById("Password").value;
        var confirmPassword = document.getElementById("CPassword").value;
        var pass=password.length;
            
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
    
   </script>      
        
        
          
    <div id="footer1"  style="margin-top:80px;">
 <%@include file="footer.jsp" %> 

 </div>
 <div id="footer">
               
       <%@include file="footer1.jsp" %>
</div>

</body>
</html>