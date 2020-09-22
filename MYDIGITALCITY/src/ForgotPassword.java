import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ForgotPassword
 {
	
	   
     public static boolean checkUser(String name,Date dt , String email, long contact) 
     {
      boolean st =false; 
     
      try {
    	  Connection con=DB.getConnection();
    	   
    	   PreparedStatement ptmt=con.prepareStatement("select * from USERDB where NAME=? and DOB=? and EMAIL=? and CONTACT=?");
    	  
    	   ptmt.setString(1,name);
    	   ptmt.setDate(2, dt);
    	   ptmt.setString(3,email);
    	   ptmt.setLong(4,contact);
    	   
    	   ResultSet rs=ptmt.executeQuery();
          st = rs.next();
        
      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;                 
  }   
}