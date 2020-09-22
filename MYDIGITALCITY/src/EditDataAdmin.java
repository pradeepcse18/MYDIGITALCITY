import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/EditDataAdmin")
public class EditDataAdmin extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)
 throws IOException, ServletException
    {
   response.setContentType("text/html");
   PrintWriter out = response.getWriter();
   
	String state=request.getParameter("state").toUpperCase();
	String city=request.getParameter("city").toUpperCase();
	String category=request.getParameter("category").toUpperCase();
	out.println("<div align='center'><h1 >LIST OF "+category +" ARE</h1></div>");
	
   

        try {
        	 Connection con=DB.getConnection();
       PreparedStatement ptmt=con.prepareStatement("select * from STATEDB where STATE=? AND CITY=? AND CATEGORY=?");
     	ptmt.setString(1, state);
     	ptmt.setString(2, city);
     	ptmt.setString(3, category);
     	
       ResultSet rs=ptmt.executeQuery();
       out.println("<table align='center' border='1' width='600px' style='border-collapse:collapse;'>");
       out.println("<tr><th>ID</th>");
       out.println("<th >NAME</th>");
       out.println("<th>WEBSITE</th>");
       out.println("<th>CONTACT</th>");
       out.println("<th>EMAIL</th>");
       out.println("<th>ADDRESS</th>");
    	 
    	 out.println("<th width='100px' >ACTION</th></tr>");
     while(rs.next()){

    	 out.println("<tr><td style=' text-align:center;'>"+rs.getString(1)+"</td>");
    	 out.println("<td style='text-align:center;'>"+rs.getString(6)+"</td>");
    	 out.println("<td style=' text-align:center;'>"+rs.getString(7)+"</td>");
    	 out.println("<td style=' text-align:center;'>"+rs.getString(9)+"</td>");
    	 out.println("<td style=' text-align:center;'>"+rs.getString(10)+"</td>");
    	 out.println("<td style='text-align:center;'>"+rs.getString(8)+"</td>");
    	 
    	 out.println("<td style='text-align:center;'><a target='_blank' href='EditByAdmin?id="+rs.getString(1)+"'><button style='font-weight: bold; color:green;'><i>EDIT</i></button></td></tr>");
    	 
    	 
    	
            	}
            	con.close();
            	}
            	catch(Exception e){
            	e.printStackTrace();
            	}

             out.println("</table>");
        }
     
    }