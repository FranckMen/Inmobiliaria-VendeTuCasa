package src.propiedades;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditPropiedadServletB2")
public class EditPropiedadServletB2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                response.setContentType("text/html; charset=UTF-8");
                response.setCharacterEncoding("UTF-8"); 
		PrintWriter out=response.getWriter();
		
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String titulo=request.getParameter("titulo");
		String descripcion=request.getParameter("descripcion");                
		String precio=request.getParameter("precio");                    

                Propiedades p = new Propiedades();
		p.setId(id);
		p.setTitulo(titulo);
 		p.setDescripcion(descripcion);
                p.setPrecio(precio);
		
		int status=PropiedadesDAO.actualizar(p);
		if(status>0){
			response.sendRedirect("ViewServletCasas");
		}else{
			out.println("Algo ha salido mal :(");
		}	
		out.close();
	}

}