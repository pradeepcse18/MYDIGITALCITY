import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/UserForgot")
public class UserForgot extends HttpServlet {
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String name = request.getParameter("Name").toUpperCase();
        String dob = request.getParameter("Dob");
        String email = request.getParameter("Email").toUpperCase();
        long contact = Long.parseLong(request.getParameter("Contact"));
        java.sql.Date dt = (java.sql.Date.valueOf(dob)); 
 	   
        
        if(ForgotPassword.checkUser(name, dt, email, contact))
        {
        	 try {
        		 Connection con=DB.getConnection();
          	   
          	   PreparedStatement ptmt=con.prepareStatement("select * from USERDB where NAME=? and DOB=? and EMAIL=? and CONTACT=?");
          	  
          	   ptmt.setString(1,name);
          	   ptmt.setDate(2, dt);
          	   ptmt.setString(3,email);
          	   ptmt.setLong(4,contact);
          	   
          	   ResultSet rs=ptmt.executeQuery();
               while(rs.next())
               {
            	  String mail=rs.getString(4);
            	  String pass=rs.getString(6);
            	  request.setAttribute("email",mail );
				  request.setAttribute("password", pass);
            	   RequestDispatcher rd = request.getRequestDispatcher("getpassword.jsp");
            	  
                   rd.forward(request, response);
               }
              
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        	
        }
        else
        {
        	 out.println("<script language='JavaScript'>");
             out.println(" alert('NO DATA FOUND')");
             out.println("top.window.location ='forgot.jsp'");
             out.println("</script>");
        }
    }  
}