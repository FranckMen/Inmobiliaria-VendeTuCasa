package src.usuarios;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                response.setContentType("text/html; charset=UTF-8");
                response.setCharacterEncoding("UTF-8"); 
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>  <html>  <head>      <title>VendeTuCasa.com</title>    <link rel=\"stylesheet\" href=\"css/estilos.css\">        <meta charset=\"utf-8\">  </head><body><img src='img/logo.jpg' title='VendeTuCasa.com'><br>'<a href=\"ViewServlet\">Administrar Usuarios</a> | <a href=\"ViewServletCasas\">Administrar Casas</a> | <a href=\"LogoutServlet2\">Log out</a><hr> <br>");                
		out.println("<a href='AgregarUsuario.jsp'>Agregar un nuevo usuario</a>");
		out.println("<h1>Actualizar usuario</h1>");
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);

		Usuarios u = UsuariosDAO.getUsuarioPorId(id);
                
		out.print("<form action='EditServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+u.getId()+"'/></td></tr>");
		out.print("<tr><td>Nombre:</td><td><input type='text' name='nombre' value='"+u.getNombre()+"'/></td></tr>");
		out.print("<tr><td>Apellido Paterno:</td><td><input type='text' name='apellido_paterno' value='"+u.getApellidoPaterno()+"'/></td></tr>");                
		out.print("<tr><td>Apellido Materno:</td><td><input type='text' name='apellido_materno' value='"+u.getApellidoMaterno()+"'/></td></tr>");                
		out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+u.getEmail()+"'/></td></tr>");
		out.print("<tr><td>Contraseña:</td><td><input type='text' name='contrasena' value='"+u.getContrasena()+"'/></td></tr>");                
		out.print("</td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Guardar '/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		
		out.close();
	}
}
