import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/Edit")
public class Edit extends HttpServlet {
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
  	  out.println("<form action='UpdateData' method='get'><table >");
  	   out.println("<tr><th>ID</th>");
  	   out.println("<th >NAME</th>");
  	   out.println("<th>MOBILE</th>");
  	   out.println("<th>EMAIL</th>");
  	   out.println("<th>DOB</th></tr>");
  		 
  	 while(rs.next()){

  		 out.println("<tr><td><input type='text' name='id' value="+rs.getString(1)+" autofocus readonly></td>");
  		 out.println("<td><input type='text' name='name' value="+rs.getString(2)+"></td>");
  		 out.println("<td><input type='text' name='mobile' value="+rs.getString(3)+"></td>");
  		 out.println("<td><input type='text' name='email' value="+rs.getString(4)+"></td>");
  		 out.println("<td><input type='text' name='dob' value="+rs.getString(5)+"></td>");
  		
  		out.println("<td><input type='submit' value='update'></td></tr>");
  		
  	   	 out.println("</table>");

  		
  	        	}
  	        	con.close();
  	        	}
  	        	catch(Exception e){
  	        	e.printStackTrace();
  	        	}

  	         out.println("</table><form>");
  	    }
  	 
  	}