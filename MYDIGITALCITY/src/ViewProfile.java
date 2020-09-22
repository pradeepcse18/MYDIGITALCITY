import java.io.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ViewProfile")
public class ViewProfile extends HttpServlet {
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       
        String email = request.getParameter("email").toUpperCase();
      
        	 try {
        		 Connection con=DB.getConnection();
          	   
          	   PreparedStatement ptmt=con.prepareStatement("select * from USERDB where  EMAIL=? ");
          	  
          	   ptmt.setString(1,email);
          	  
          	   ResultSet rs=ptmt.executeQuery();
               while(rs.next())
               {
            	         	 
            	  out.println("<div align='center'>"); 
            	  out.println("<table border='1px solid black'><caption>MY PROFILE</caption><tr><th>NAME</th><td>"+rs.getString(2)+"</th></tr>");
            	  out.println("<tr><th>DOB</th><td>"+rs.getDate(3)+"</th></tr>"); 
            	  out.println("<tr><th>CONTACT</th><td>"+rs.getString(5)+"</th></tr>");
            	  out.println("<tr><th>EMAIL</th><td>"+rs.getString(4)+"</th></tr>"); 
            	   
               }
              
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        	
        }
      
    }  
