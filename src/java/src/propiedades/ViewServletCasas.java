package src.propiedades;



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

@WebServlet("/ViewServletCasas")
public class ViewServletCasas extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
        HttpSession session=request.getSession(false);  
        
        if(session!=null){              
                response.setContentType("text/html; charset=UTF-8");
                response.setCharacterEncoding("UTF-8"); 
		PrintWriter out=response.getWriter();
		out.println("<link rel=\"stylesheet\" href=\"css/estilos.css\">");                  
		out.println("<!DOCTYPE html>  <html>  <head>      <title>VendeTuCasa.com</title>    <link rel=\"stylesheet\" href=\"css/estilos.css\">        <meta charset=\"utf-8\">  </head><body><img src='img/logo.jpg' title='VendeTuCasa.com'><br>'<a href=\"ViewServlet\">Administrar Usuarios</a> | <a href=\"ViewServletCasas\">Administrar Casas</a> | <a href=\"LogoutServlet2\">Log out</a><hr> <br>");                              
		out.println("<h1>Propiedades</h1>");
                
		List<Propiedades> list=PropiedadesDAO.getTodasPropiedadesAdmin();
		
		out.print("<table border='1' width='100%' class='paleBlueRows'>");
		out.print("<thead><tr><th>ID</th><th>Titulo</th><th>Descripción</th><th>Precio</th><th>Foto Actual</th><th>Agregar Foto</th><th>Editar</th><th>Eliminar</th></tr></thead>");
		for(Propiedades p:list){
			out.print("<tr><td>"+p.getId()+"</td><td>"+p.getTitulo()+"</td><td>"+p.getDescripcion()+"</td><td>"+p.getPrecio()+"</td><td><img class='foto' src='upload/"+p.getImagen()+"'></td><td><a href='Upload2.jsp?id="+p.getId()+"'>Agregar</a></td><td><a href='EditPropiedadServletB?id="+p.getId()+"'>Editar</a></td><td><a href='DeletePropiedadServlet2?id="+p.getId()+"'>Eliminar</a></td></tr>");
		}
		out.print("</table>");
		
		out.close(); 
        }  
        else{  
            out.print("Debe iniciar sesión");  
            request.getRequestDispatcher("login2.html").include(request, response);  
        }  
       
	}
}