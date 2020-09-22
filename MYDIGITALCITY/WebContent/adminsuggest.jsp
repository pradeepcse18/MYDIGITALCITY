<html>
<div id="navbar"> 
          <%@include file="anavbar.jsp"%> 
             </div>
       
        
        
      
     <p>  EMAIL : <%= ((String)session.getAttribute("email"))%> 
       
       <div align="center" style="margin-top: 100px;">
       <form  method="post">
       <table border="none">
     <tr><th>FROM DATE :</th>
                 <td> <input type="date" id="Dob1" name="Dob1" value="" size="10" max="2018-12-31" min="01-01-2018" required></td>
          <th>  TO DATE : </th>
                <td> <input type="date" id="Dob2" name="Dob2" value="" size="10"   max="2018-12-31" min="01-01-2018"  required></td>
           
      </table>
      <br><br>
       <input type="submit" value="VIEW SUGGESTION" style="text-align:center" onclick="javascript: form.action='AAdminSuggest.jsp';"/>
       <input type="submit" value="CONTACT FORM" style="text-align:center" onclick="javascript: form.action='AdminContact.jsp';"/>
        <input type="submit" value="ADD/EDIT REQUEST" style="text-align:center" onclick="javascript: form.action='AdminApproove.jsp';"/>
      
     
    </form>
    </div>
        
        
  
        
        
           
    <div id="footer1"  style="margin-top:100px;">
 <%@include file="footer.jsp" %> 

 </div>
 <div id="footer">
               
       <%@include file="footer1.jsp" %>
</div>

</body>
</html>