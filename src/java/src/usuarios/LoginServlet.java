package src.usuarios;

import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.RequestDispatcher;
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
public class LoginServlet extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
                    throws ServletException, IOException {  
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();  
          
        String email=request.getParameter("email");  
        String contrasena=request.getParameter("contrasena");  
        
        if(LoginDAO.validate(email, contrasena)){  
            /*Si el email y contraseña son correctos, se creará un objeto de sesión */
            HttpSession session=request.getSession(); 
            /*Al objeto de sesión se le agrega la variable email, pudise ser un ID o otro valor.*/
            session.setAttribute("email",email);             
            RequestDispatcher rd=request.getRequestDispatcher("link.html");  
            rd.forward(request,response);               
        }  
        else{  
            out.print("Su email o password no validos.");  
            request.getRequestDispatcher("login.html").include(request, response);  
        }          
        
        out.close();  
    }  
}  
