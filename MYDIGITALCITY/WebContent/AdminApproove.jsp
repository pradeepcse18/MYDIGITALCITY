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
        out.println("<div align='center'><h1>LIST OF ADD/EDIT DATA REQUEST </h1> </div>");
     	
         try {

        	 Class.forName("oracle.jdbc.driver.OracleDriver");
      	  Connection con=DriverManager.getConnection(
      	   "jdbc:oracle:thin:@localhost:1521:ORCL","SYSTEM","PRADEEP");
        PreparedStatement ptmt=con.prepareStatement("select * from STATEDB where DOB>=? and DOB<=?  AND STATUS='F'");
        ptmt.setDate(1, dt1);
        ptmt.setDate(2, dt2);
      
          ResultSet rs=ptmt.executeQuery();
          out.println("<div align='center'><table border='1' width='600px' style='border-collapse:collapse;'>");
          
         
          out.println("<th >NAME</th>");
          out.println("<th>WEBSITE</th>");
          out.println("<th>CONTACT</th>");
          out.println("<th>EMAIL</th>");
     	 out.println("<th>ADDRESS</th>");
     	 out.println("<th>CITY</th>");
     	 out.println("<th>STATE</th>");
      	 out.println("<th colspan='2' width='100px' >PERFORM ACTION</th></tr>");
          while(rs.next()){

     	
     	
     	 out.println("<tr><td style='text-align:center;'>"+rs.getString(6)+"</td>");
     	 out.println("<td style=' text-align:center;'>"+rs.getString(7)+"</td>");
     	 out.println("<td style=' text-align:center;'>"+rs.getString(9)+"</td>");
     	 out.println("<td style=' text-align:center; width:50px;'>"+rs.getString(10)+"</td>");
     	 out.println("<td style='text-align:center;'>"+rs.getString(8)+"</td>");
     	 out.println("<td style=' text-align:center;'>"+rs.getString(4)+"</td>");
     	
     	
     	 out.println("<td style=' text-align:center;'><a target='_blank'  href='ApprooveByAdmin?id="+rs.getString(1)+"'><button style='font-weight: bold; color:green;'><i>APPROVE</i></button></td>");
       	out.println("<td style=' text-align:center;'><a  target='_blank' href='ADeleteAdmin?id="+rs.getString(1)+"'><button style='font-weight: bold; color:red; ' ><i>DELETE</i></button></td></tr>");
        
     	
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