import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/ContactRequest")

public class ContactRequest extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)
 throws IOException, ServletException
     {
   response.setContentType("text/html");
   PrintWriter out = response.getWriter();
    String name=request.getParameter("Name").toUpperCase();
	String email=request.getParameter("Email").toUpperCase();
	String contact=request.getParameter("Contact");
	String subject=request.getParameter("Subject").toUpperCase();
	String message=request.getParameter("Message");
	try {
	
	 Connection con=DB.getConnection();
   
   PreparedStatement ptmt=con.prepareStatement("INSERT INTO CONTACT (NAME ,CONTACT , EMAIL, SUBJECT, MESSAGE , DOB) VALUES(?,?,?,?,?,SYSDATE)");
 	ptmt.setString(1,name);
 	ptmt.setString(2,contact);
 	ptmt.setString(3,email);
 	ptmt.setString(4,subject);
 	ptmt.setString(5,message);
 	 int i=ptmt.executeUpdate();
 	
 	  if(i>0){
 		 out.println("<script language='JavaScript'>");
         out.println(" alert('YOUR REQUEST HAS BEEN SUBMITTED')");
         out.println("top.window.location ='contactus.jsp'");
         out.println("</script>");
 	    	
 	        	}
 	  else {
 		 out.println("<script language='JavaScript'>");
         out.println(" alert('REQUEST NOT SUBMITTED')");
         out.println("top.window.location ='contactus.jsp'");
         out.println("</script>");
 	   }
        	con.close();
	}
        	catch(Exception e){
        	 e.printStackTrace();
        	}


    }
 
}