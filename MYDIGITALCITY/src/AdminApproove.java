import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/AdminApproove")
public class AdminApproove extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)
 throws IOException, ServletException
    {
   response.setContentType("text/html");
   PrintWriter out = response.getWriter();
   String dob1= request.getParameter("Dob1");
   String dob2= request.getParameter("Dob2");
   java.sql.Date dt1 = (java.sql.Date.valueOf(dob1)); 
   
   java.sql.Date dt2 = (java.sql.Date.valueOf(dob2)); 
   out.println("<div align='center'><h1>LIST OF ADD/EDIT DATA REQUEST </h1> </div>");
	
    try {
    	 Connection con=DB.getConnection();
   PreparedStatement ptmt=con.prepareStatement("select * from STATEDB where DOB>=? and DOB<=?  AND STATUS='F'");
   ptmt.setDate(1, dt1);
   ptmt.setDate(2, dt2);
 
     ResultSet rs=ptmt.executeQuery();
     out.println("<div align='center'><table border='1' width='600px' style='border-collapse:collapse;'>");
     out.println("<tr><th>ID</th>");
     out.println("<th>CATEGORY</th>");
     out.println("<th >NAME</th>");
     out.println("<th>WEBSITE</th>");
     out.println("<th>CONTACT</th>");
     out.println("<th>EMAIL</th>");
	 out.println("<th>ADDRESS</th>");
	 out.println("<th>STATUS</th>");
	 out.println("<th>CITY</th>");
	 out.println("<th>STATE</th>");
 	 out.println("<th colspan='2' width='200px' >PERFORM ACTION</th></tr>");
     while(rs.next()){

	 out.println("<tr><td style=' text-align:center;'>"+rs.getString(1)+"</td>");
	 out.println("<td style=' text-align:center;'>"+rs.getString(5)+"</td>");
	 out.println("<td style='text-align:center;'>"+rs.getString(6)+"</td>");
	 out.println("<td style=' text-align:center;'>"+rs.getString(7)+"</td>");
	 out.println("<td style=' text-align:center;'>"+rs.getString(9)+"</td>");
	 out.println("<td style=' text-align:center;'>"+rs.getString(10)+"</td>");
	 out.println("<td style='text-align:center;'>"+rs.getString(8)+"</td>");
	 out.println("<td style='text-align:center;'>"+rs.getString(13)+"</td>");
	 out.println("<td style=' text-align:center;'>"+rs.getString(4)+"</td>");
	 out.println("<td style=' text-align:center;'>"+rs.getString(3)+"</td>");
	
	 out.println("<td style=' text-align:center;'><a target='_blank'  href='ApprooveByAdmin?id="+rs.getString(1)+"'><button style='font-weight: bold; color:green;'><i>APPROOVE</i></button></td>");
  	out.println("<td style=' text-align:center;'><a  target='_blank' href='DeleteAdmin?id="+rs.getString(1)+"'><button style='font-weight: bold; color:red; ' ><i>DELETE</i></button></td></tr>");
   
	
        	}
        	con.close();
        	}
        	catch(Exception e){
        	e.printStackTrace();
        	}

         out.println("</table></div>");
    }
 
}