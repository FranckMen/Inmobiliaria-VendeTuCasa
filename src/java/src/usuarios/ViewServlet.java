package src.usuarios;



import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
        HttpSession session=request.getSession(false);  
        
        if(session!=null){              
                response.setContentType("text/html; charset=UTF-8");
                response.setCharacterEncoding("UTF-8"); 
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>  <html>  <head>      <title>VendeTuCasa.com</title>    <link rel=\"stylesheet\" href=\"css/estilos.css\">        <meta charset=\"utf-8\">  </head><body><img src='img/logo.jpg' title='VendeTuCasa.com'><br>'<a href=\"ViewServlet\">Administrar Usuarios</a> | <a href=\"ViewServletCasas\">Administrar Casas</a> | <a href=\"LogoutServlet2\">Log out</a><hr> <br>");                
		out.println("<a href='AgregarUsuario.jsp'>Agregar un nuevo usuario</a>");
		out.println("<h1>Usuarios</h1>");
		
		List<Usuarios> list=UsuariosDAO.getTodosUsuarios();
		
		out.print("<table border='1' width='100%'  class='paleBlueRows'>");
		out.print("<thead><tr><th>ID</th><th>Nombre</th><th>Apellido Paterno</th><th>Apellido Materno</th><th>Email</th><th>Contrasseña</th><th>Editar</th><th>Eliminar</th></tr></thead>");
		for(Usuarios u:list){
			out.print("<tr><td>"+u.getId()+"</td><td>"+u.getNombre()+"</td><td>"+u.getApellidoPaterno()+"</td><td>"+u.getApellidoMaterno()+"</td><td>"+u.getEmail()+"</td><td>"+u.getContrasena()+"</td><td><a href='EditServlet?id="+u.getId()+"'>Editar</a></td><td><a href='DeleteServlet?id="+u.getId()+"'>Eliminar</a></td></tr>");
		}
		out.print("</table>");
		
		out.close(); 
        }  
        else{  
            out.print("Debe iniciar sesión");  
            request.getRequestDispatcher("login.html").include(request, response);  
        }  
       
	}
}
