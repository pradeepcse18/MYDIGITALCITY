import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/UserDisplay")
public class UserDisplay extends HttpServlet {
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String email = request.getParameter("username").toUpperCase();
        String password = request.getParameter("password");
        
        if(ValidateUser.checkUser(email , password))
        {
        	 out.println(email);
        	 HttpSession session = request.getSession();
             session.setAttribute("email",email);        
             RequestDispatcher rs = request.getRequestDispatcher("welcomeuser.jsp");
             rs.forward(request, response);
        }
        else
        {
        		
        out.println("<script language='JavaScript'>");
        out.println(" alert('Invalid Username or Password')");
        out.println("top.window.location ='login.jsp'");
        out.println("</script>");
        }
    }  
}