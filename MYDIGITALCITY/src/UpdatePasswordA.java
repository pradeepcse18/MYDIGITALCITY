import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/UpdatePasswordA") 
public class UpdatePasswordA extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)
 throws IOException, ServletException
    {
   response.setContentType("text/html");
   PrintWriter out = response.getWriter();
  
    String opassword=request.getParameter("oldpassword");
    String password=request.getParameter("newpassword");
	 String mail = request.getParameter("mail").toUpperCase();
	
	  
   try {
	   Connection con=DB.getConnection();
   
	   PreparedStatement ptmt=con.prepareStatement(" select * from ADMINDB WHERE EMAIL=?");       
	   ptmt.setString(1,mail);
	   ResultSet rs=ptmt.executeQuery();
	  
	   while(rs.next())
	   {  
		   if(opassword.equals(rs.getString(3)))
		   {
			   PreparedStatement ptmt1=con.prepareStatement(" UPDATE ADMINDB SET PASSWORD=? WHERE EMAIL=?");       
		    	ptmt1.setString(1,password);
		 	   ptmt1.setString(2,mail);
		 	
		 	 int i=ptmt1.executeUpdate();
		 	  if(i>0){
		 		 out.print(mail);
		 		  out.println("<script language='JavaScript'>");
			       out.println(" alert('PASSWORD UPDATED')");
			      out.println("top.window.location ='changepassworda.jsp'");
			       out.println("</script>");
		 	        	}
		 	  else {
		 		  out.println("<script language='JavaScript'>");
			       out.println(" alert('SOMETHING WRONG !')");
			      out.println("top.window.location ='changepassworda.jsp'");
			       out.println("</script>");
		 		
		 	  }
			   
		   }
		   else { out.println("<script language='JavaScript'>");
	       out.println(" alert('OLD PASSWORD NOT MATCH')");
	      out.println("top.window.location ='changepassword.jsp'");
	       out.println("</script>");
 		
			   
		   }
	   }
	 
	   
	 
        	con.close();
        	}
        	catch(Exception e){
        	e.printStackTrace();
        	}
    }
 
}