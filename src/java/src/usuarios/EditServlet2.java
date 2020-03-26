package src.usuarios;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                response.setContentType("text/html; charset=UTF-8");
                response.setCharacterEncoding("UTF-8"); 
		PrintWriter out=response.getWriter();
		
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String nombre=request.getParameter("nombre");
		String apellido_paterno=request.getParameter("apellido_paterno");                
		String apellido_materno=request.getParameter("apellido_materno");                    
		String email=request.getParameter("email");
		String contrasena=request.getParameter("contrasena");

                Usuarios u = new Usuarios();
		u.setId(id);
		u.setNombre(nombre);
 		u.setApellidoPaterno(apellido_paterno);
		u.setApellidoMaterno(apellido_materno);                
		u.setEmail(email);
		u.setContrasena(contrasena);
		
		int status=UsuariosDAO.actualizar(u);
		if(status>0){
			response.sendRedirect("ViewServlet");
		}else{
			out.println("Algo ha salido mal :(");
		}	
		out.close();
	}

}
