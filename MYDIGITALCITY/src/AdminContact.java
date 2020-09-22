import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/AdminContact")
public class AdminContact extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)
 throws IOException, ServletException
    {
   response.setContentType("text/html");
   PrintWriter out = response.getWriter();
 
   String dob1= request.getParameter("Dob1");
   String dob2= request.getParameter("Dob2");
   java.sql.Date dt1 = (java.sql.Date.valueOf(dob1)); 
   
   java.sql.Date dt2 = (java.sql.Date.valueOf(dob2)); 
   
	
	
   try {
	   Connection con=DB.getConnection();
   
   PreparedStatement ptmt=con.prepareStatement("select * from CONTACT where DOB>=? and DOB<=?");
   ptmt.setDate(1, dt1);
   ptmt.setDate(2, dt2);
 	
   ResultSet rs=ptmt.executeQuery();

 while(rs.next()){
	 out.println("<table border='1' width='500px'>");
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

         out.println("</table>");
    }
 
}