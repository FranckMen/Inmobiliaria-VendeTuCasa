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

@WebServlet("/ViewPropiedadesServlet")
public class ViewPropiedadesServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
        HttpSession session=request.getSession(false);  
        
        if(session!=null){              
                response.setContentType("text/html; charset=UTF-8");
                response.setCharacterEncoding("UTF-8"); 
		PrintWriter out=response.getWriter();
		out.println("<link rel=\"stylesheet\" href=\"css/estilos.css\">");                  
		out.println("<img src='img/logo.jpg' title='VendeTuCasa.com'><br>'<a href=\"EditCuentaServlet\">Mis datos</a> |     <a href=\"ViewPropiedadesServlet\">Mis propiedades</a> | <a href=\"LogoutServlet2\">Log out</a><hr>");                            
		out.println("<a href='AgregarPropiedad.jsp'>Agregar una nueva propiedad.</a>");
		out.println("<h1>Mis propiedades</h1>");
		
                String usuario = session.getAttribute("email").toString();
                
		List<Propiedades> list=PropiedadesDAO.getTodasPropiedades(usuario);
		
		out.print("<table border='1' width='100%' class='paleBlueRows'>");
		out.print("<thead><tr><th>Titulo</th><th>Descripción</th><th>Precio</th><th>Foto Actual</th><th>Agregar Foto</th><th>Editar</th><th>Eliminar</th></tr></thead>");
		for(Propiedades p:list){
			out.print("<tr><td>"+p.getTitulo()+"</td><td>"+p.getDescripcion()+"</td><td>"+p.getPrecio()+"</td><td><img class='foto' src='upload/"+p.getImagen()+"'></td><td><a href='Upload.jsp?id="+p.getId()+"'>Agregar</a></td><td><a href='EditPropiedadServlet?id="+p.getId()+"'>Editar</a></td><td><a href='DeletePropiedadServlet?id="+p.getId()+"'>Eliminar</a></td></tr>");
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
