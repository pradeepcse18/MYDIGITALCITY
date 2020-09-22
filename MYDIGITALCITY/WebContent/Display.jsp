<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>


<html>   
        <div id="navbar"> 
          <%@include file="navbar.jsp"%> 
        
        </div>
        
        <%
        response.setContentType("text/html");
       
        String state=request.getParameter("state").toUpperCase();
        String city=request.getParameter("city").toUpperCase();
        String category=request.getParameter("category").toUpperCase();
     	
     	
     	out.println("<div align='center'><h1>LIST OF "+category +"S ARE</h1> </div>");
     	
        try {
        
        	 Class.forName("oracle.jdbc.driver.OracleDriver");
      	  Connection con=DriverManager.getConnection(
      	   "jdbc:oracle:thin:@localhost:1521:ORCL","SYSTEM","PRADEEP");
        PreparedStatement ptmt=con.prepareStatement("select * from STATEDB where STATE=? AND CITY=? AND CATEGORY=? AND STATUS='T'");
        
      	
      	    ptmt.setString(1,state);
      	 	ptmt.setString(2,city);
      	 	ptmt.setString(3,category);
        ResultSet rs=ptmt.executeQuery();

      while(rs.next()){
    	  
    	 
     	 out.println("<div><table border='1' align='center' width='700px' >");
     	 out.println("<tr><th width='100px'>NAME</th>");
     	 out.println("<td style='font-weight:bold;'>"+rs.getString(6)+"</td><td rowspan='6' colspan='8'><img src='getImage.jsp?id="+rs.getString(1)+"' width='500px' height='300px'/></td></tr>");
     	 out.println("<tr><th>WEBSITE</th>");
     	 out.println("<td><a style='text-decoration:none;' href='+rs.getString(7)+'>"+rs.getString(7)+"</a></td></tr>");
     	 out.println("<tr><th>ADDRESS</th>");
     	 out.println("<td>"+rs.getString(8)+"  "+rs.getString(4)+"  "+rs.getString(3)+"</td></tr>");
     	 out.println("<tr><th>CONTACT</th>");
     	 out.println("<td>"+rs.getString(9)+"</td></tr>");
     	 out.println("<tr><th>EMAIL</th>");
     	 out.println("<td>"+rs.getString(10)+"</td></tr>");
     	 out.println("<tr><th>STATE</th>");
     	 out.println("<td>"+rs.getString(3)+"</a></td></tr>");
     	 
     	
     	 
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