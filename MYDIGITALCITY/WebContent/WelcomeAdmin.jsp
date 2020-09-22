<html>
<div id="navbar"> 
          <%@include file="anavbar.jsp"%> 
             </div>
        
                 <h4 align="right">ADMIN:  <%= ((String)session.getAttribute("email"))%> </h4>
    <div id="footer1"  style="margin-top:500px;">
 <%@include file="footer.jsp" %> 

 </div>
 <div id="footer">
               
       <%@include file="footer1.jsp" %>
</div>

</body>
</html>