import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/ApprooveByAdmin")
public class ApprooveByAdmin extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response)
 throws IOException, ServletException
    {
   response.setContentType("text/html");
   PrintWriter out = response.getWriter();
   int id= Integer.parseInt(request.getParameter("id"));
   int id1=0;
   out.println("VALIDATING");
   
  
	
    try {
    	 Connection con=DB.getConnection();
    	 PreparedStatement ptmt=con.prepareStatement("SELECT OLDID FROM STATEDB  where ID=?");
    	 ptmt.setInt(1, id);
    	 ResultSet rs=ptmt.executeQuery();
    	
    	 
  	 while(rs.next())
    	 {out.println("PROCESSING");
    		 id1=rs.getInt(1);
    		 PreparedStatement ptmt1=con.prepareStatement("DELETE FROM STATEDB  where ID=?");
        	 ptmt1.setInt(1, id1); 
        	 ptmt1.executeUpdate();
        	 }
    	
        PreparedStatement ptmt2=con.prepareStatement("UPDATE STATEDB SET STATUS='T' , UACTION='OK'  where ID=?");
        ptmt2.setInt(1, id);
        
        out.println("SUCCESSFULL");
   int i= ptmt2.executeUpdate();
   
   if(i>0) {
 	  out.println("<script language='JavaScript'>");
       out.println(" alert('DATA APPROOVED')");
      out.println("top.window.location ='adminsuggest.jsp'");
       out.println("</script>");
   }

        	
        	con.close();
        	}
        	catch(Exception e){
        	e.printStackTrace();
        	}

        
    }
 
}