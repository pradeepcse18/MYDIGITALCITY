<html>
          <div id="navbar"> 
          <%@include file="navbar.jsp"%> 
        
        </div>
        
       
         
        
         <div class="loginBox">
	     	<img class="user" src="images/pic.jpg "/>
	     	<h2>LOGIN HERE</h2>
	     	<form method="post" action="UserDisplay"> 
	     	<p>Username</p>
	     	<input type="email" id="caps1" name="username" placeholder="Enter Username"  required />
	     	<p>Password</p>
	     	<input type="password" name="password" placeholder="Enter Password"  required /> <br />
	     	<input type="submit" name="" value="Sign In" />
	     	<a href="adminlogin.jsp"> <i style="color:white;"> Are You Admin ?</i> <i> Login Here </i></a> 
	     	<a href="forgot.jsp"><i>Forget Password</i></a>
	        <a href="register.jsp"> <i style="color:white;"> New User ?</i> <i> Register Here </i></a> 
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