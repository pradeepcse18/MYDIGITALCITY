<html>
<div id="navbar"> 
          <%@include file="anavbar.jsp"%> 
             </div>
 

<body>

     <h4 align="right">ADMIN: <%= ((String)session.getAttribute("email"))%> </h4>
<div class="left">
<div class="vertical-menu" style="margin-left: 150px; margin-top: 100px">
  <a href="#" class="active">DASHBOARD</a>
  <a href="ViewProfileAdmin.jsp?email=<%=(String)session.getAttribute("email")%>">VIEW PROFILE</a>
  <a href="editadminprofile.jsp">EDIT PROFILE</a>
  <a href="changepassworda.jsp">CHANGE PASSWORD</a>
  
</div>
</div>

         
        
        
         
    <div id="footer1"  style="margin-top:150px;">
 <%@include file="footer.jsp" %> 

 </div>
 <div id="footer">
               
       <%@include file="footer1.jsp" %>
</div>

</body>
</html>