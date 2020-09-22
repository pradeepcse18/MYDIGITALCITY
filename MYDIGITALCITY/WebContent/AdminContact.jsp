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
        String dob1= request.getParameter("Dob1");
        String dob2= request.getParameter("Dob2");
        java.sql.Date dt1 = (java.sql.Date.valueOf(dob1)); 
        
        java.sql.Date dt2 = (java.sql.Date.valueOf(dob2)); 
        out.println("<div align='center'><h1>CONTACT REQUEST </h1> </div>");
        try{

       	 Class.forName("oracle.jdbc.driver.OracleDriver");
     	  Connection con=DriverManager.getConnection(
     	   "jdbc:oracle:thin:@localhost:1521:ORCL","SYSTEM","PRADEEP");
     	  

     	   PreparedStatement ptmt=con.prepareStatement("select * from CONTACT where DOB>=? and DOB<=?");
     	   ptmt.setDate(1, dt1);
     	   ptmt.setDate(2, dt2);
     	 	
     	   ResultSet rs=ptmt.executeQuery();

     	 while(rs.next()){
     		 out.println("<div align='center'><table border='1' width='500px'>");
     		 out.println("<tr ><th '>REQ. NO</th>");
     		 out.println("<td>"+rs.getString(1)+"</td></tr>");
     		 out.println("<tr><th>NAME</th>");
     		 out.println("<td>"+rs.getString(2)+"</td></tr>");
     		 out.println("<tr><th>CONTACT</th>");
     		 out.println("<td>"+rs.getString(3)+"</a></td></tr>");
     		 out.println("<tr><th>EMAIL</th>");
     		 out.println("<td>"+rs.getString(4)+"</td></tr>");
     		 out.println("<tr><th>SUBJECT</th>");
     		 out.println("<td>"+rs.getString(5)+"</td></tr>");
     		 out.println("<tr><th>MESSAGE</th>");
     		 out.println("<td>"+rs.getString(6)+"</td></tr>"); 
     		 out.println("</table>");
     		 out.println("<br>");out.println("<br>");
     	 

     	        	}
     	        	con.close();
     	        	}
     	        	catch(Exception e){
     	        	e.printStackTrace();
     	        	}

     	         out.println("</table></div>");
     	  
     	  
     	  
    	  
          %>
    
          
           <div id="footer1">
   <%@include file="footer.jsp" %> 

   </div>
   <div id="footer">
                 
         <%@include file="footer1.jsp" %>
  </div>

  </body>
  </html>
        
        
        
        
        