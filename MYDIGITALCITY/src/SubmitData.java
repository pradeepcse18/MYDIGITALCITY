import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/SubmitData")

public class SubmitData extends HttpServlet {


public void doPost(HttpServletRequest request, HttpServletResponse response)
 throws IOException, ServletException
    {
   response.setContentType("text/html");
   PrintWriter out = response.getWriter();
   String name=request.getParameter("name");
     String email=request.getParameter("email");
   String dob=request.getParameter("dob");
   String mobile=request.getParameter("mobile");
   
  
	
   try {
	   
	   Class.forName("oracle.jdbc.driver.OracleDriver");
	   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","SYSTEM","PRADEEP");
	  
   PreparedStatement ptmt=con.prepareStatement("INSERT INTO PHONEDATA(NAME, MOBILE, EMAIL, DOB) VALUES (?,?,?,?)");   
   ptmt.setString(1, name);
   ptmt.setString(2, mobile);
   ptmt.setString(3, email);
   ptmt.setString(4, dob);
   
   
   
 	 int i=ptmt.executeUpdate();
 	  if(i>0){
 		 out.println("DATA INSERTED SUCCESFULLY");
 		 out.println("<a href='ViewData'>View");
 	        	}
 	  else {
 		 
 		out.println("Something Wrong");
 	  }
        	con.close();
        	}
        	catch(Exception e){
        	e.printStackTrace();
        	}

        
    }
 
}