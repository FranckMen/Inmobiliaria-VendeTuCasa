
package src.cuentas;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CrearCuentaServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                response.setContentType("text/html; charset=UTF-8");
                response.setCharacterEncoding("UTF-8"); 
		PrintWriter out=response.getWriter();
		
		String nombre=request.getParameter("nombre");
		String apellido_paterno=request.getParameter("apellido_paterno");                
		String apellido_materno=request.getParameter("apellido_materno");                
		String email =request.getParameter("email"); 
		String contrasena=request.getParameter("contrasena");                 
		String calle=request.getParameter("calle");     
     		String municipio=request.getParameter("municipio");      
     		String estado=request.getParameter("estado");  
     		String cp=request.getParameter("cp");       
     		String telefono=request.getParameter("telefono");                
                Cuentas c = new Cuentas();
		c.setNombre(nombre);
		c.setApellidoPaterno(apellido_paterno);                                
		c.setApellidoMaterno(apellido_materno);                                 
		c.setEmail(email);
                c.setContrasena(contrasena);
                c.setCalle(calle);
                c.setMunicipio(municipio);
                c.setEstado(estado);
                c.setCp(cp);
                c.setTelefono(telefono);
                                
		int status=CuentasDAO.guardar(c);
                
		if(status>0){
			out.print("<script>alert('¡Su cuenta se ha guardado correctamente!');</script>");
			request.getRequestDispatcher("login2.html").include(request, response);
		}else{
			out.println("Algo ha salido mal :(");
		}		
		out.close();
	}

}
