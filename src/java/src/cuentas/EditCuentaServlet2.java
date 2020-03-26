package src.cuentas;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditCuentaServlet2")
public class EditCuentaServlet2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                response.setContentType("text/html; charset=UTF-8");
                response.setCharacterEncoding("UTF-8"); 
		PrintWriter out=response.getWriter();
		
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String nombre=request.getParameter("nombre");
		String apellido_paterno=request.getParameter("apellido_paterno");                
		String apellido_materno=request.getParameter("apellido_materno");                    
		String email=request.getParameter("email");
		String contrasena=request.getParameter("contrasena");
		String calle=request.getParameter("calle");
		String municipio=request.getParameter("municipio");
		String estado=request.getParameter("estado");
		String cp=request.getParameter("cp");
		String telefono=request.getParameter("telefono");                
                
                Cuentas c = new Cuentas();
		c.setId(id);
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
		
		int status=CuentasDAO.actualizar(c);
		if(status>0){
			out.println("<script>alert('Tus datos han sido actualizados.');</script>");                    
			response.sendRedirect("EditCuentaServlet");
		}else{
			out.println("Algo ha salido mal :(");
		}	
		out.close();
	}

}
