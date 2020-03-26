package src.cuentas;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/EditCuentaServlet")
public class EditCuentaServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                response.setContentType("text/html; charset=UTF-8");
                response.setCharacterEncoding("UTF-8"); 
		PrintWriter out=response.getWriter();
		out.println("<link rel=\"stylesheet\" href=\"css/estilos.css\">");                
		out.println("<img src='img/logo.jpg' title='VendeTuCasa.com'><br>'<a href=\"EditCuentaServlet\">Mis datos</a> |     <a href=\"ViewPropiedadesServlet\">Mis propiedades</a> | <a href=\"LogoutServlet2\">Log out</a><hr>");                
		out.println("<h1>Actualizar Mis datos</h1>");
                
                HttpSession session=request.getSession(); 
            
                String email = session.getAttribute("email").toString();
                        
		Cuentas c = CuentasDAO.getUsuarioPorEmail(email);
                
		out.print("<form action='EditCuentaServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+c.getId()+"'/></td></tr>");
		out.print("<tr><td>Nombre:</td><td><input type='text' name='nombre' value='"+c.getNombre()+"'/></td></tr>");
		out.print("<tr><td>Apellido Paterno:</td><td><input type='text' name='apellido_paterno' value='"+c.getApellidoPaterno()+"'/></td></tr>");                
		out.print("<tr><td>Apellido Materno:</td><td><input type='text' name='apellido_materno' value='"+c.getApellidoMaterno()+"'/></td></tr>");                
		out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+c.getEmail()+"'/></td></tr>");
		out.print("<tr><td>Contraseña:</td><td><input type='text' name='contrasena' value='"+c.getContrasena()+"'/></td></tr>"); 
		out.print("<tr><td>Calle:</td><td><input type='text' name='calle' value='"+c.getCalle()+"'/></td></tr>");    
		out.print("<tr><td>Alcaldía / Municipio:</td><td><input type='text' name='municipio' value='"+c.getMunicipio()+"'/></td></tr>"); 
              	out.print("<tr><td>Estado:</td><td><input type='text' name='estado' value='"+c.getEstado()+"'/></td></tr>");  
		out.print("<tr><td>CP:</td><td><input type='text' name='cp' value='"+c.getCp()+"'/></td></tr>"); 
                out.print("<tr><td>Telefono:</td><td><input type='text' name='telefono' value='"+c.getTelefono()+"'/></td></tr>");
		out.print("</td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Actualizar Datos '/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		
		out.close();
	}
}