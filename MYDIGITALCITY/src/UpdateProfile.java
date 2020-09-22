import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/UpdateProfile") 
public class UpdateProfile extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)
 throws IOException, ServletException
    {
   response.setContentType("text/html");
   PrintWriter out = response.getWriter();
  
    String name=request.getParameter("name").toUpperCase();
    String dob=request.getParameter("dob");
	String email=request.getParameter("email").toUpperCase();
	String contact=request.getParameter("contact");
	 String mail = request.getParameter("mail").toUpperCase();
	
	java.sql.Date dt = (java.sql.Date.valueOf(dob)); 
	  
   try {
	   Connection con=DB.getConnection();
   
   PreparedStatement ptmt=con.prepareStatement(" UPDATE USERDB SET NAME=? , DOB=?, CONTACT=?, EMAIL=? WHERE EMAIL=?");       
   
   
 	ptmt.setString(1,name);
 	ptmt.setDate(2,dt);
 	ptmt.setString(3,contact);
 	ptmt.setString(4,email);
 	ptmt.setString(5,mail);
 	
 	 int i=ptmt.executeUpdate();
 	  if(i>0){
 		 
 		 out.println("<script language='JavaScript'>");
	       out.println(" alert('PROFILE UPDATED')");
	      out.println("top.window.location ='edituserprofile.jsp'");
	       out.println("</script>");
 	        	}
 	  else {
 		 
 		
 	  }
        	con.close();
        	}
        	catch(Exception e){
        	e.printStackTrace();
        	}

         out.println("</table>");
    }
 
}