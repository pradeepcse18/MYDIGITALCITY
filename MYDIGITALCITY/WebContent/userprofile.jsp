<html>
<div id="navbar"> 
          <%@include file="unavbar.jsp"%> 
        
        </div>

       
   
 <div class="wrap" style="text-align:center">
<div class="left" style=" float: left;" >
     <div class="vertical-menu"  style="margin-left: 100px; margin-top:50px" >
       <a href="#" class="active">DASHBOARD</a>
       <a href="ViewProfile.jsp?email=<%=(String)session.getAttribute("email")%>">VIEW PROFILE</a>
       <a href="edituserprofile.jsp">EDIT PROFILE</a>
       <a href="changepassword.jsp">CHANGE PASSWORD</a>
      </div>
</div>

<div class="center" style="text-align:left; margin-right:250px;
       display:inline-block">
   <h4 style="margin-top: 100px;"> Dear user "<%= ((String)session.getAttribute("email"))%>"" welcome to our website.  </h4>
</div>
    </div>

  
          
    <div id="footer1"  style="margin-top:250px;">
 <%@include file="footer.jsp" %> 

 </div>
 <div id="footer">
               
       <%@include file="footer1.jsp" %>
</div>

</body>
</html>