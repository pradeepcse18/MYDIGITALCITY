import java.io.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)
 throws IOException, ServletException
    {
	
	
   response.setContentType("text/html");
   PrintWriter out = response.getWriter();
    String name=request.getParameter("Name").toUpperCase();
	String dob= request.getParameter("Dob");
	
	String email=request.getParameter("Email").toUpperCase();
	String contact=request.getParameter("Contact");
	String password=request.getParameter("Password");
	
	
   try {
	  
	   java.sql.Date dt = (java.sql.Date.valueOf(dob)); 
	   out.println(dt);
	   
	   
	  
	   
	   Connection con=DB.getConnection();
   
   PreparedStatement ptmt=con.prepareStatement("INSERT INTO USERDB (NAME, DOB, EMAIL, CONTACT, PASSWORD) VALUES(?,?,?,?,?)");
 	ptmt.setString(1,name);
 	ptmt.setDate(2, dt);
 	ptmt.setString(3,email);
 	ptmt.setString(4,contact);
 	ptmt.setString(5,password);
 	 int i=ptmt.executeUpdate();
 	  if(i>0){
 	    	response.sendRedirect("userregistersuccess.jsp");
 	        	}
 	  else {
 		 response.sendRedirect("userregisterunsuccess.jsp");
 	  }
        	con.close();
        	}
        	catch(Exception e){
        	e.printStackTrace();
        	}

         out.println("</table>");
    }
 
}