import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/ViewData")
public class ViewData extends HttpServlet {
 public void doGet(HttpServletRequest request, HttpServletResponse response)
 throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
       
 
        try{
        	
        	 Class.forName("oracle.jdbc.driver.OracleDriver");
      	    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","SYSTEM","PRADEEP");
         
     	PreparedStatement ptmt=con.prepareStatement("SELECT * FROM PHONEDATA");
  	 ResultSet rs=ptmt.executeQuery();
     while(rs.next())
     {
    	 out.println("<table border='1px solid black'> <tr><th>NAME</th><td>"+rs.getString(2)+"</th></tr>");
   	  out.println("<tr><th>MOBILE</th><td>"+rs.getString(3)+"</th></tr>"); 
   	  out.println("<tr><th>EMAIL</th><td>"+rs.getString(4)+"</th></tr>");
   	  out.println("<tr><th>DOB</th><td>"+rs.getString(5)+"</th></tr>"); 
  	out.println("<tr><th>ACTION</th><td><a style='text-decoration:none' href='Edit?id="+rs.getString(1)+"'>EDIT &nbsp;&nbsp; ");
  	out.println("<a style='text-decoration:none' href='DeleteData?id="+rs.getString(1)+"'>  DELETE</td></tr><br>");
   	 out.println("</table>");
  
        	}
        	con.close();
        	}
        	catch(Exception e){
        	e.printStackTrace();
        	}

       
    }
}