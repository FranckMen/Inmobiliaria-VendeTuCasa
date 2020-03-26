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

@WebServlet("/ViewPropiedadesTodasServlet")
public class ViewPropiedadesTodasServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
                response.setContentType("text/html; charset=UTF-8");
                response.setCharacterEncoding("UTF-8"); 
		PrintWriter out=response.getWriter();
                out.print("<h1>Propiedades disponibles</h1>");
		List<Propiedades> list=PropiedadesDAO.getTodasPropiedadesSinLogin();
		
		for(Propiedades p:list){
			out.print("<div><h3>"+p.getTitulo()+"</h3><br>"+p.getDescripcion()+"<br><br><b>"+p.getPrecio()+"</b><br><img class='foto' src='upload/"+p.getImagen()+"'></div>");
		}
	}
}
