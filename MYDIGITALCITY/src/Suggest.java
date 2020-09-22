import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/Suggest")

public class Suggest extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)
 throws IOException, ServletException
    {
   response.setContentType("text/html");
   PrintWriter out = response.getWriter();
    String name=request.getParameter("Name").toUpperCase();
	String email=request.getParameter("Email").toUpperCase();
	String subject=request.getParameter("Subject");
	String message=request.getParameter("Message");
	
	
   try {
	   Connection con=DB.getConnection();
   
   PreparedStatement ptmt=con.prepareStatement("INSERT INTO SUGGEST (NAME , EMAIL, SUBJECT, MESSAGE , DOB) VALUES(?,?,?,?,SYSDATE)");
 	ptmt.setString(1,name);
 	ptmt.setString(2,email);
 	ptmt.setString(3,subject);
 	ptmt.setString(4,message);
 	 int i=ptmt.executeUpdate();
 	
 	  if(i>0){
 		   out.println("<script type='text/javascript'>");
 	       out.println("alert('YOUR REQUEST HAS BEEN SUBMITTED');");
 	      out.println("top.window.location ='suggestion.jsp'");
 	       out.println("</script>");
 	       
 	    	
 	        	}
 	  else {
 		 response.sendRedirect("suggestion.jsp");
 	  }
        	con.close();
        	}
        	catch(Exception e){
        	e.printStackTrace();
        	}

         out.println("</table>");
        
    }
 
}