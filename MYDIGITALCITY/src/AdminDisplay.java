import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/AdminDisplay")
public class AdminDisplay extends HttpServlet {
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String email = request.getParameter("email").toUpperCase();
        String password = request.getParameter("password");
        
        if(Validate.checkUser(email , password))
        {
        	 out.println(email);
        	 HttpSession session = request.getSession();
             session.setAttribute("email", email);
            RequestDispatcher rs = request.getRequestDispatcher("WelcomeAdmin.jsp");
            rs.forward(request, response);
        }
        else
        {
        	 out.println("<script language='JavaScript'>");
             out.println(" alert('Invalid Username or Password')");
             out.println("top.window.location ='adminlogin.jsp'");
             out.println("</script>");
        }
    }  
}