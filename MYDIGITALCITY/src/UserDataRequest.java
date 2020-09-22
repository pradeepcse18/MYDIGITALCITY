import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/UserDataRequest")
public class UserDataRequest extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)
 throws IOException, ServletException
    {
   response.setContentType("text/html");
   PrintWriter out = response.getWriter();
   
	String category=request.getParameter("category");
	out.println("<h1 >LIST OF "+category +" ARE</h1>");
	
    try {
    	 Connection con=DB.getConnection();
   
   PreparedStatement ptmt=con.prepareStatement("select * from STATEUSER where CATEGORY=?");
 	
 	ptmt.setString(1,category);
   ResultSet rs=ptmt.executeQuery();
  out.println("<table border='1' width='600px' style='border-collapse:collapse;'>");
   out.println("<tr><th>NAME</th>");
	 out.println("<th>ADDRESS</th>");
	 out.println("<th colspan='2' >ACTION</th></tr>");
 while(rs.next()){

	  out.println("<tr><td>"+rs.getString(1)+"</td>");
	  out.println("<td>"+rs.getString(2)+"</td>");
	 out.println("<td ><a style='text-decoration:none; font-weight: bold;'  href='edit?id="+rs.getString(1)+"'><i>EDIT</i></td>");
	 out.println("<td ><a style='text-decoration:none; font-weight: bold;'  href='edit?id="+rs.getString(2)+"'><i>DELETE</i></td></tr>");
	
	 
	
        	}
        	con.close();
        	}
        	catch(Exception e){
        	e.printStackTrace();
        	}

         out.println("</table>");
    }
 
}