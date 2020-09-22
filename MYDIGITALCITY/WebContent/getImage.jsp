<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%


 String id = request.getParameter("id");
response.setContentType("text/html");








Connection  con=null; 
 
try{
	 Class.forName("oracle.jdbc.driver.OracleDriver");
	   con=DriverManager.getConnection(
	   "jdbc:oracle:thin:@localhost:1521:ORCL","SYSTEM","PRADEEP");
    PreparedStatement ps = con.prepareStatement("select * from STATEDB where ID=?");
    ps.setString(1, id);
  
   
    ResultSet rs = ps.executeQuery();
   
    if(rs.next()){
    	

        Blob blob = rs.getBlob(16);
        byte byteArray[] = blob.getBytes(1, (int)blob.length());
 
        response.setContentType("image/jpg");
        OutputStream os = response.getOutputStream();
    
   os.write(byteArray);
        os.flush();
        os.close();
       
      
    }
}
catch(Exception e){
    e.printStackTrace();
}   
finally{
    if(con != null){
        try{
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
%>