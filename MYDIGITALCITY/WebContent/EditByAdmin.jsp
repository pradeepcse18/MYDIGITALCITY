<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>


<html>   
        <div id="navbar"> 
          <%@include file="anavbar.jsp"%> 
        
        </div>
        
        <%
        
        
        response.setContentType("text/html");
        String id=request.getParameter("id");
       
             try{

            	 Class.forName("oracle.jdbc.driver.OracleDriver");
          	  Connection con=DriverManager.getConnection(
          	   "jdbc:oracle:thin:@localhost:1521:ORCL","SYSTEM","PRADEEP");
        
     String sql="select * from STATEDB where id=?";
     PreparedStatement ptmt=con.prepareStatement(sql);
     ptmt.setString(1, id);
     ResultSet rs=ptmt.executeQuery();
     out.println("<form action='UpdateByAdmin' method='post'>");
     out.println("<div align='center' ><h1 >UPDATE THE DETAILS</h1></div>");
     out.println("<table align='center' border='1'>");
    
      while(rs.next()){
     
      out.println("<input type='hidden' name='id' value="+rs.getString(1)+" autofocus readonly>");
      out.println("<tr><th>Name</th><td><input type='text' name='name' value="+rs.getString(6)+"></td></tr>");
      out.println("<tr><th>WEBSITE</th><td><input type='text' name='website' value="+rs.getString(7)+"></td></tr>");
      out.println("<tr><th>CONTACT</th><td><input type='text' name='contact' value="+rs.getString(9)+"></td></tr>");
      out.println("<tr><th>EMAIL</th><td><input type='text' name='email' value="+rs.getString(10)+"></td></tr>");
      out.println("<tr><th>ADDRESS</th><td><input type='text' name='address' value="+rs.getString(8)+"></td></tr>");
     

     
             	}
             	con.close();
             	}
             	catch(Exception e){
             	e.printStackTrace();
             	}

             out.println("</table><br>");
             out.println("<div align='center'><input type='submit' target='_blank' value='UPDATE' style='font-weight: bold; color:green;'></div>");
             out.println("</form>");
  
          
        %>
  
        
         <div id="footer1">
 <%@include file="footer.jsp" %> 

 </div>
 <div id="footer">
               
       <%@include file="footer1.jsp" %>
</div>

</body>
</html>