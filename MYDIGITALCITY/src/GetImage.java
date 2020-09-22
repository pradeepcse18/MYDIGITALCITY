import java.io.*;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/GetImage")
public class GetImage extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response)
 throws IOException, ServletException
    {
   response.setContentType("text/html");
   PrintWriter out = response.getWriter();
   String id = request.getParameter("id");
   
   
   out.println("hii");
   try {
   	 Connection con=DB.getConnection();
   
     PreparedStatement ps = con.prepareStatement("select * from contacts");
    
     ResultSet rs = ps.executeQuery();
    
     if(rs.next()){
     	

         Blob blob = rs.getBlob(4);
         byte byteArray[] = blob.getBytes(1, (int)blob.length());
         response.setContentType("image/jpg");
         OutputStream os = response.getOutputStream();
       
        // os.write(byteArray);
         os.flush();
         os.close();
        
       
     }
 }
 catch(Exception e){
     e.printStackTrace();
 }   
   
   
    } 
   
}