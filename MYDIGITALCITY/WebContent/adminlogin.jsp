<html>
<div id="navbar"> 
          <%@include file="navbar.jsp"%> 
                </div>
       
         <div class="loginBox" style="height: 420px">
	     	<img class="user" src="images/pic.jpg "/>
	     	<h2>ADMIN LOGIN</h2>
	     	<form action="AdminDisplay" method="post"> 
	     	<p>Email</p>
	     	<input type="email" name="email" id="caps1" placeholder="Enter Email" required />
	     	<p>Password</p>
	     	<input type="password" name="password" placeholder="Enter Password"  required /> <br />
	     	<input type="submit" name="" value="Sign In" />
	     	<a href="login.jsp"> <i style="color:white;"> Are You User ?</i> <i> Login Here </i></a>
	     	</form>
	     </div>
        
         <script type="text/javascript">
         document.getElementById("caps1").onchange = function() {myFunction1()};

       function myFunction1() {
        var x = document.getElementById("caps1");
        x.value = x.value.toUpperCase();
    }
    </script>
        
        
              
    <div id="footer1"  style="margin-top:600px;">
 <%@include file="footer.jsp" %> 

 </div>
 <div id="footer">
               
       <%@include file="footer1.jsp" %>
</div>

</body>
</html>