
package src.login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "LoginServlet2", urlPatterns = {"/LoginServlet2"})
public class LoginServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
                    throws ServletException, IOException {  
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();  
          
        String email=request.getParameter("email");  
        String contrasena=request.getParameter("contrasena");  
        
        if(LoginDAO2.validate(email, contrasena)){  
            /*Si el email y contraseña son correctos, se creará un objeto de sesión */
            HttpSession session=request.getSession(); 
            /*Al objeto de sesión se le agrega la variable email, pudise ser un ID o otro valor.*/
            session.setAttribute("email",email);             
            RequestDispatcher rd=request.getRequestDispatcher("link2.html");  
            rd.forward(request,response);               
        }  
        else{  
            out.print("Su email o contraseña no son válidos.");  
            request.getRequestDispatcher("login2.html").include(request, response);  
        }          
        
        out.close();  
    }  

}
