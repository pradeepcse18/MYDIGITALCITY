import java.sql.Connection;
import java.sql.DriverManager;

public class DB{
	  public static Connection con=null;
	public static Connection getConnection(){
try{
	
	 Class.forName("oracle.jdbc.driver.OracleDriver");
	   con=DriverManager.getConnection(
	   "jdbc:oracle:thin:@localhost:1521:ORCL","SYSTEM","PRADEEP");
		}catch(Exception e){	}
		return con;
	}
	
}