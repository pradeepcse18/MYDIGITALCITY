<html>
 <div id="navbar"> 
          <%@include file="unavbar.jsp"%> 
        
        </div>
        
        <p > WELCOME <%= ((String)session.getAttribute("email"))%> 
        
   
        
        
        
            
    <div id="footer1"  style="margin-top:500px;">
 <%@include file="footer.jsp" %> 

 </div>
 <div id="footer">
               
       <%@include file="footer1.jsp" %>
</div>

</body>
</html>