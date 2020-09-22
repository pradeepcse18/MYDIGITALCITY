import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/DeleteAdmin")
public class DeleteAdmin extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response)
 throws IOException, ServletException
    {
   response.setContentType("text/html");
   PrintWriter out = response.getWriter();
   int id= Integer.parseInt(request.getParameter("id"));
   
  
	
    try {
    	 Connection con=DB.getConnection();
   PreparedStatement ptmt=con.prepareStatement("delete from STATEDB where ID=?");
   ptmt.setInt(1, id);
  
  int i=ptmt.executeUpdate();
      if(i>0) {
    	  out.println("<script language='JavaScript'>");
          out.println(" alert('DATA DELETED')");
         out.println("top.window.location ='editadmin.jsp'");
          out.println("</script>");
      }
   
        	con.close();
        	}
        	catch(Exception e){
        	e.printStackTrace();
        	}

        
    }
 
}