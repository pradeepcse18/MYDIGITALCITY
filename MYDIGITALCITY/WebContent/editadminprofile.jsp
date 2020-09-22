<html>
<div id="navbar"> 
          <%@include file="anavbar.jsp"%> 
        
        </div>



     
 <h4 align="right">ADMIN:  <%= ((String)session.getAttribute("email"))%> </h4>
       
 <div class="wrap" style="text-align:center">
<div class="left" style=" float: left;" >
     <div class="vertical-menu"  style="margin-left: 100px; margin-top:0px" >
     <a href="#" class="active">DASHBOARD</a>
       <a href="ViewProfileAdmin.jsp?email=<%=(String)session.getAttribute("email")%>">VIEW PROFILE</a>
       <a href="editadminprofile.jsp">EDIT PROFILE</a>
       <a href="changepassworda.jsp">CHANGE PASSWORD</a>
      </div>
</div>


<div class="center" align="center" style="margin-top:50px;">
<form action="UpdateProfileA" method="post">
<table >
<caption>EDIT PROFILE</caption>
<tr><th>NAME</th><td><input type="text" name="name" id="caps1" required="required"></td></tr>
<tr><th>DOB</th><td><input type="date"  id="Dob" name="dob" required="required" max="2015-12-31" min="1900-01-01"></td></tr>
<tr><th>CONTACT</th><td><input type="number" name="contact"  id="Contact" required="required"></td></tr>
<tr><th>EMAIL</th><td><input type="email" name="email" id="caps2" required="required"></td></tr>
</table>
<br>
<input type="hidden" name="mail" value=<%=(String)session.getAttribute("email")%> required="required">
<input style="margin-left:300px" type="submit"  value="UPDATE PROFILE" onclick="return Validate()" />
</form>
</div>
</div>
	
	     	<script type="text/javascript">
    function Validate() {
       
        
        var Contact = document.getElementById("Contact").value.toString().length;
       
       if((Contact<10) ||(Contact>10))
    	   {
    	   alert("Please enter the correct Contact No(without (+91)) ");
    	   return false;
    	   }
       
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
        
        
          
    <div id="footer1"  style="margin-top:100px;">
 <%@include file="footer.jsp" %> 

 </div>
 <div id="footer">
               
       <%@include file="footer1.jsp" %>
</div>

</body>
</html>