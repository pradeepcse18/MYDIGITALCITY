import java.io.*;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/UpdateByAdmin")
public class UpdateByAdmin extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)
 throws IOException, ServletException
    {
   response.setContentType("text/html");
   PrintWriter out = response.getWriter();
   int id= Integer.parseInt(request.getParameter("id"));
   String name=request.getParameter("name");
   String website=request.getParameter("website");
   String contact=(request.getParameter("contact"));
   String email=request.getParameter("email");
   String address=request.getParameter("address");

   
    try {
   	String uploadby=null;
   	String country=null;
   	String state=null;
   	String city=null;
   	String category=null;
   	Blob blob=null;
   	 Connection con=DB.getConnection();
   	  PreparedStatement ptmt1=con.prepareStatement("select * from statedb where id=?");
   	  ptmt1.setInt(1, id);
   	  ResultSet rs=ptmt1.executeQuery();

   	   while(rs.next()) { 
   		 country=rs.getString(2);  
   	     state=rs.getString(3);
   	     city=rs.getString(4);
   	     category=rs.getString(5);	
   	     uploadby=rs.getString(11);
   	    blob=rs.getBlob(16);
   	     
   	   }
   	   PreparedStatement ptmt=con.prepareStatement("INSERT INTO STATEDB ( COUNTRY, STATE, CITY, CATEGORY, NAME, WEBSITE, CONTACT, EMAIL,  ADDRESS , UPLOADBY, OLDID, IMAGE, DOB, STATUS, UACTION) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,'F','ADIT')");                               
       
       ptmt.setString(1,country);
       ptmt.setString(2,state);
       ptmt.setString(3,city);
       ptmt.setString(4,category);
       ptmt.setString(5,name);
       ptmt.setString(6,website);
       ptmt.setString(7,contact);
       ptmt.setString(8,email);
       ptmt.setString(9,address);
       ptmt.setString(10,uploadby);
       ptmt.setInt(11, id);
       ptmt.setBlob(12, blob);
       
 
  int i= ptmt.executeUpdate();
  if(i>0) {
	   
	   out.println("<script language='JavaScript'>");
      out.println(" alert('YOUR REQUEST SUCCESSFULL')");
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