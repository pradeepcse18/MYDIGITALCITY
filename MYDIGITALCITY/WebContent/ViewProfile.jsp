<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>


<html>   
        <div id="navbar"> 
          <%@include file="unavbar.jsp"%> 
        
        </div>
         
        <%
        response.setContentType("text/html");
        String email = request.getParameter("email").toUpperCase();
        
   	 try {
   		 Class.forName("oracle.jdbc.driver.OracleDriver");
     	  Connection con=DriverManager.getConnection(
     	   "jdbc:oracle:thin:@localhost:1521:ORCL","SYSTEM","PRADEEP");
     	   PreparedStatement ptmt=con.prepareStatement("select * from USERDB where  EMAIL=? ");
     	  
     	   ptmt.setString(1,email);
     	  
     	   ResultSet rs=ptmt.executeQuery();
          while(rs.next())
          {
       	     %>
       	      <div class="wrap" style="text-align:center">
<div class="left" style=" float: left;" >
     <div class="vertical-menu"  style="margin-left: 100px; margin-top:0px" >
       <a href="#" class="active">DASHBOARD</a>
       <a href="ViewProfile.jsp?email=<%=(String)session.getAttribute("email")%>">VIEW PROFILE</a>
       <a href="edituserprofile.jsp">EDIT PROFILE</a>
       <a href="changepassword.jsp">CHANGE PASSWORD</a>
      </div>
</div>
       	<%
        	  out.println("<div class='center' align='center' style='margin-top:100px'>"); 
           	  out.println("<table border='1px solid black'><caption>MY PROFILE</caption><tr><th>NAME</th><td>"+rs.getString(2)+"</th></tr>");
           	  out.println("<tr><th>DOB</th><td>"+rs.getDate(3)+"</th></tr>"); 
           	  out.println("<tr><th>CONTACT</th><td>"+rs.getString(5)+"</th></tr>");
           	  out.println("<tr><th>EMAIL</th><td>"+rs.getString(4)+"</th></tr></table></div>"); 
       	   
          }
          %>
          </div>
          <%
         
       }catch(Exception e)
       {
           e.printStackTrace();
       }
   	
     %>
        
      
        
         <div id="footer1" style="margin-top:100px;">
 <%@include file="footer.jsp" %> 

 </div>
 <div id="footer">
               
       <%@include file="footer1.jsp" %>
</div>

</body>
</html>