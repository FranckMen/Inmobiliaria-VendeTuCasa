package src.propiedades;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditPropiedadServletB")
public class EditPropiedadServletB extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                response.setContentType("text/html; charset=UTF-8");
                response.setCharacterEncoding("UTF-8"); 
		PrintWriter out=response.getWriter();
		out.println("<link rel=\"stylesheet\" href=\"css/estilos.css\">");                  
		out.println("<!DOCTYPE html>  <html>  <head>      <title>VendeTuCasa.com</title>    <link rel=\"stylesheet\" href=\"css/estilos.css\">        <meta charset=\"utf-8\">  </head><body><img src='img/logo.jpg' title='VendeTuCasa.com'><br>'<a href=\"ViewServlet\">Administrar Usuarios</a> | <a href=\"ViewServletCasas\">Administrar Casas</a> | <a href=\"LogoutServlet2\">Log out</a><hr> <br>");                                                  
		out.println("<h1>Actualizar Mis Propiedades</h1>");
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);

		Propiedades p = PropiedadesDAO.getPropiedadPorId(id);
                
		out.print("<form action='EditPropiedadServletB2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+p.getId()+"'/></td></tr>");
		out.print("<tr><td>Titulo:</td><td><input type='text' name='titulo' value='"+p.getTitulo()+"'/></td></tr>");
		out.print("<tr><td>Descripcion:</td><td><input type='text' name='descripcion' value='"+p.getDescripcion()+"'/></td></tr>");                
		out.print("<tr><td>Precio:</td><td><input type='text' name='precio' value='"+p.getPrecio()+"'/></td></tr>");                            
		out.print("</td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Guardar '/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		
		out.close();
	}
}
