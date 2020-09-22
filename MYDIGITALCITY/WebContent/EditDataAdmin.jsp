<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>


<html>   
        <div id="anavbar"> 
          <%@include file="navbar.jsp"%> 
        
        </div>
        
        <%
        
        
        response.setContentType("text/html");
       // PrintWriter out = response.getWriter();
        String state=request.getParameter("state").toUpperCase();
        String city=request.getParameter("city").toUpperCase();
        String category=request.getParameter("category").toUpperCase();
        out.println("<div align='center'><h1>EDIT THE  DATA </h1> </div>");
     	
     	
         try { Class.forName("oracle.jdbc.driver.OracleDriver");
     	  Connection con=DriverManager.getConnection(
     	      	   "jdbc:oracle:thin:@localhost:1521:ORCL","SYSTEM","PRADEEP");
        PreparedStatement ptmt=con.prepareStatement("select * from STATEDB where STATE=? AND CITY=? AND CATEGORY=?");
      	ptmt.setString(1, state);
      	ptmt.setString(2, city);
      	ptmt.setString(3, category);
      	
        ResultSet rs=ptmt.executeQuery();
        out.println("<table align='center' border='1' width='600px' style='border-collapse:collapse;'>");
        out.println("<tr><th>ID</th>");
        out.println("<th >NAME</th>");
        out.println("<th>WEBSITE</th>");
        out.println("<th>CONTACT</th>");
        out.println("<th>EMAIL</th>");
        out.println("<th>ADDRESS</th>");
     	 
     	 out.println("<th width='200px' colspan='2'>ACTION</th></tr>");
      while(rs.next()){

     	 out.println("<tr><td style=' text-align:center;'>"+rs.getString(1)+"</td>");
     	 out.println("<td style='text-align:center;'>"+rs.getString(6)+"</td>");
     	 out.println("<td style=' text-align:center;'>"+rs.getString(7)+"</td>");
     	 out.println("<td style=' text-align:center;'>"+rs.getString(9)+"</td>");
     	 out.println("<td style=' text-align:center;'>"+rs.getString(10)+"</td>");
     	 out.println("<td style='text-align:center;'>"+rs.getString(8)+"</td>");
     	 
     	 out.println("<td style='text-align:center;'><a target='_blank' href='EditByAdmin.jsp?id="+rs.getString(1)+"'><button style='font-weight: bold; color:green;'><i>EDIT</i></button></td>");
     	 out.println("<td style='text-align:center;'><a target='_blank' href='DeleteAdmin?id="+rs.getString(1)+"'><button style='font-weight: bold; color:green;'><i>DELETE</i></button></td></tr>");
     	 
     	 
     	
             	}
             	con.close();
             	}
             	catch(Exception e){
             	e.printStackTrace();
             	}

              out.println("</table>");
        
      
     
        
        
        
        
        
             
        %>
        
  
        
        
         <div id="footer1">
 <%@include file="footer.jsp" %> 

 </div>
 <div id="footer">
               
       <%@include file="footer1.jsp" %>
</div>

</body>
</html>