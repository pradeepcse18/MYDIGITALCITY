import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/Display")
public class Display extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)
 throws IOException, ServletException
    {
   response.setContentType("text/html");
   PrintWriter out = response.getWriter();
  
   String state=request.getParameter("state").toUpperCase();
   String city=request.getParameter("city").toUpperCase();
   String category=request.getParameter("category").toUpperCase();
	
	
	out.println("<div align='center'><h1>LIST OF "+category +"S ARE</h1> </div>");
	
   try {
   
   Connection con=DB.getConnection();
   
   PreparedStatement ptmt=con.prepareStatement("select * from STATEDB where STATE=? AND CITY=? AND CATEGORY=? AND STATUS='T'");
   
 	
 	    ptmt.setString(1,state);
 	 	ptmt.setString(2,city);
 	 	ptmt.setString(3,category);
   ResultSet rs=ptmt.executeQuery();

 while(rs.next()){
	 out.println("<div><table border='1' align='center' width='700px' >");
	 out.println("<tr><th width='100px'>NAME</th>");
	 out.println("<td style='font-weight:bold;'>"+rs.getString(6)+"</td><td rowspan='5'></td></tr>");
	 out.println("<tr><th>WEBSITE</th>");
	 out.println("<td><a style='text-decoration:none;' href='+rs.getString(7)+'>"+rs.getString(7)+"</a></td></tr>");
	 out.println("<tr><th>ADDRESS</th>");
	 out.println("<td>"+rs.getString(8)+"  "+rs.getString(4)+"  "+rs.getString(3)+"</td></tr>");
	 out.println("<tr><th>CONTACT</th>");
	 out.println("<td>"+rs.getString(9)+"</td></tr>");
	 out.println("<tr><th>EMAIL</th>");
	 out.println("<td>"+rs.getString(10)+"</td></tr>");
	 out.println("<tr><th>STATE</th>");
	 out.println("<td>"+rs.getString(3)+"</a></td></tr>");
	 
	
	 
	 out.println("<br>");out.println("<br>");
 

        	}
        	con.close();
        	}
        	catch(Exception e){
        	e.printStackTrace();
        	}

         out.println("</table></div>");
       
    }
 
}