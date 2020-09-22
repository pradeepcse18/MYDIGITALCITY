import java.sql.*;

public class Validate
 {
     public static boolean checkUser(String email,String password) 
     {
      boolean st =false; 
      try {
    	  Connection con=DB.getConnection();
    	   PreparedStatement ptmt=con.prepareStatement("select * from ADMINDB where EMAIL=? and PASSWORD=?");
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