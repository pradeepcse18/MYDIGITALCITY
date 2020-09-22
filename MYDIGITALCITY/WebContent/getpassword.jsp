<html>
<div id="navbar"> 
          <%@include file="navbar.jsp"%> 
        
        </div>
        
        
        
        
        <table  border="1px solid green" align="center" style="margin:200px 500px">
        <caption>PASSWORD RETRIEVED</caption>
            <tr>
            <th>USERNAME</th>
            <td> <%=request.getAttribute("email")%></td>
            </tr>
            <tr>
            <th>PASSWORD</th>
            <td>  <%=request.getAttribute("password")%></td>
       </table>
       
        
  
        
        
         
    <div id="footer1"  style="margin-top:000px;">
 <%@include file="footer.jsp" %> 

 </div>
 <div id="footer">
               
       <%@include file="footer1.jsp" %>
</div>

</body>
</html>