import java.io.*;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.http.Part;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/AInsertNewData")
@MultipartConfig(maxFileSize = 16177215) 
public class AInsertNewData extends HttpServlet {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, HttpServletResponse response)
 throws IOException, ServletException
    {
   response.setContentType("text/html");
   PrintWriter out = response.getWriter();
   String country=request.getParameter("country").toUpperCase();
   String state=request.getParameter("state").toUpperCase();
   String city=request.getParameter("city").toUpperCase();
   String category=request.getParameter("category").toUpperCase();
    String name=request.getParameter("name").toUpperCase();
	String website=request.getParameter("website").toLowerCase();
	String email=request.getParameter("email").toUpperCase();
	String contact=request.getParameter("contact");
	String address=request.getParameter("address").toUpperCase();
	String uploadby=request.getParameter("uploadby").toUpperCase();
	 Part filePart = request.getPart("photo");
	 InputStream inputStream = filePart.getInputStream();
	
	
   try {
	   Connection con=DB.getConnection();
   
   PreparedStatement ptmt=con.prepareStatement("INSERT INTO STATEDB ( COUNTRY, STATE, CITY, CATEGORY, NAME, WEBSITE, ADDRESS , CONTACT, EMAIL,  UPLOADBY, IMAGE,  DOB, STATUS, UACTION) VALUES (?,?,?,?,?,?,?,?,?,?,?,SYSDATE,'F','ADD')");       
   
    ptmt.setString(1,country);
    ptmt.setString(2,state);
 	ptmt.setString(3,city);
 	ptmt.setString(4,category);
 	ptmt.setString(5,name);
 	ptmt.setString(6,website);
 	ptmt.setString(7,address);
 	ptmt.setString(8,contact);
 	ptmt.setString(9,email);
 	ptmt.setString(10,uploadby);
 	ptmt.setBlob(11,inputStream);
 	 int i=ptmt.executeUpdate();
 	  if(i>0){
 		 
 		 out.println("<script language='JavaScript'>");
	       out.println(" alert('DATA INSERTED SUCCESSFULLY')");
	      out.println("top.window.location ='addnewdataadmin.jsp'");
	       out.println("</script>");
 	        	}
 	  else {
 		 
 		
 	  }
        	con.close();
        	}
        	catch(Exception e){
        	e.printStackTrace();
        	}

         out.println("</table>");
    }
 
}