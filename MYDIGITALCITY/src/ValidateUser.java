import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ValidateUser
 {
     public static boolean checkUser(String email,String password) 
     {
      boolean st =false; 
      try {
    	  Connection con=DB.getConnection();
    	   
    	   PreparedStatement ptmt=con.prepareStatement("select * from USERDB where EMAIL=? and PASSWORD=?");
    	  
    	   ptmt.setString(1,email);
    	   ptmt.setString(2, password);
    	   ResultSet rs=ptmt.executeQuery();
          st = rs.next();
        
      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;                 
  }   
}