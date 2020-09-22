import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/UpdateData")

public class UpdateData extends HttpServlet {


public void doGet(HttpServletRequest request, HttpServletResponse response)
 throws IOException, ServletException
    {
   response.setContentType("text/html");
   PrintWriter out = response.getWriter();
   String id=request.getParameter("id");
   String name=request.getParameter("name");
   String mobile=request.getParameter("mobile");
   String email=request.getParameter("email");
   String dob=request.getParameter("dob");
   
  
	
   try {
	   Class.forName("oracle.jdbc.driver.OracleDriver");
	   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","SYSTEM","PRADEEP");
   
   PreparedStatement ptmt=con.prepareStatement("UPDATE PHONEDATA SET NAME=? , MOBILE=?  , EMAIL=? , DOB=? WHERE ID=?");   
   ptmt.setString(1, name);
   ptmt.setString(2, mobile);
   ptmt.setString(3, email);
   ptmt.setString(4, dob);
   ptmt.setString(5, id);
   
   
   
 	 int i=ptmt.executeUpdate();
 	  if(i>0){
 		 out.println("data updated");
 		 out.println("<br><a href='ViewData'>View");
 		
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