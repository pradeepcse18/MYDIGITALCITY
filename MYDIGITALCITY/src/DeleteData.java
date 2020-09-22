import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/DeleteData")
public class DeleteData extends HttpServlet {
 public void doGet(HttpServletRequest request, HttpServletResponse response)
 throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String id=request.getParameter("id");
 
        try{
        	
        	 Class.forName("oracle.jdbc.driver.OracleDriver");
      	   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","SYSTEM","PRADEEP");
         
  	String sql="DELETE FROM PHONEDATA WHERE ID=?";
  	PreparedStatement ptmt=con.prepareStatement(sql);
  	ptmt.setString(1, id);
    int i=ptmt.executeUpdate();
        	if(i>0){
        		 out.println("data deleted successfully");
         		 out.println("<a href='ViewData'>VIEW  DATA");
        	}
        	con.close();
        	}
        	catch(Exception e){
        	e.printStackTrace();
        	}

       
    }
}