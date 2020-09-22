import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/EditByAdmin")
public class EditByAdmin extends HttpServlet {
 public void doGet(HttpServletRequest request, HttpServletResponse response)
 throws IOException, ServletException
    {
   response.setContentType("text/html");
   PrintWriter out = response.getWriter();
   String id=request.getParameter("id");
  
   try{
Connection con=DB.getConnection();

String sql="select * from STATEDB where id=?";
PreparedStatement ptmt=con.prepareStatement(sql);
ptmt.setString(1, id);
ResultSet rs=ptmt.executeQuery();
out.println("<form action='UpdateByAdmin' method='post'>");
out.println("<table border='1'>");
out.println("<tr><th>ID</th>");
out.println("<th>Name</th>");
out.println("<th>WEBSITE</th>");
out.println("<th>CONTACT</th>");
out.println("<th>EMAIL</th>");
out.println("<th>ADDRESS</th>");
out.println("<th>Action</th></tr>");
while(rs.next()){
out.println("<tr>");	 
out.println("<td><input type='text' name='id' value="+rs.getString(1)+" autofocus readonly></td>");
out.println("<td><input type='text' name='name' value="+rs.getString(6)+"></td>");
out.println("<td><input type='text' name='website' value="+rs.getString(7)+"></td>");
out.println("<td><input type='text' name='contact' value="+rs.getString(9)+"></td>");
out.println("<td><input type='text' name='email' value="+rs.getString(10)+"></td>");
out.println("<td><input type='text' name='address' value="+rs.getString(8)+"></td>");
out.println("<td><input type='submit' target='_blank' value='UPDATE'></td>");

out.println("</tr>");
   	}
   	con.close();
   	}
   	catch(Exception e){
   	e.printStackTrace();
   	}

   out.println("</table>");
   out.println("</form>");
}

}