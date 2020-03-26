package src.propiedades;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/SavePropiedadesServlet")
public class SavePropiedadesServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                response.setContentType("text/html; charset=UTF-8");
                response.setCharacterEncoding("UTF-8"); 
		PrintWriter out=response.getWriter();
		
		String titulo=request.getParameter("titulo");
		String descripcion=request.getParameter("descripcion");                
		String precio=request.getParameter("precio");                               
                
                Propiedades p = new Propiedades();
		p.setTitulo(titulo);
		p.setDescripcion(descripcion);                                
		p.setPrecio(precio);             
                
                HttpSession session=request.getSession(false);  
        
                String usuario = session.getAttribute("email").toString();           
                                
		int status=PropiedadesDAO.guardar(p, usuario);
                
		if(status>0){
			out.print("<p>¡La propiedad ha sido guardado correctamente!</p>");
			request.getRequestDispatcher("AgregarPropiedad.jsp").include(request, response);
		}else{
			out.println("Algo ha salido mal :(");
		}		
		out.close();
	}

}
