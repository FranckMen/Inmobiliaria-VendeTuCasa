
package src.cuentas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import src.cuentas.Cuentas;
import src.cuentas.CuentasDAO;
import src.usuarios.Usuarios;
import src.usuarios.UsuariosDAO;


public class CuentasDAO {
    	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/vendetucasa", "postgres", "password");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	public static int guardar(Cuentas c){
		int status=0;
		try{
			Connection con=CuentasDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("INSERT INTO usuarios(nombre, apellido_paterno, apellido_materno, email, contrasena, calle, municipio, estado, cp, telefono) VALUES (?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,c.getNombre());
			ps.setString(2,c.getApellidoPaterno());
			ps.setString(3,c.getApellidoMaterno());
			ps.setString(4,c.getEmail());
			ps.setString(5,c.getContrasena());
 			ps.setString(6,c.getCalle());
 			ps.setString(7,c.getMunicipio());
 			ps.setString(8,c.getEstado());	 
                        ps.setString(9,c.getCp());	
			ps.setString(10,c.getTelefono());	                        
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
        
	public static Cuentas getUsuarioPorEmail(String email){
		Cuentas c =new Cuentas();
		
		try{
			Connection con=CuentasDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM usuarios WHERE email=?");
			ps.setString(1,email);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				c.setId(rs.getInt(1));
				c.setNombre(rs.getString(2));
				c.setApellidoPaterno(rs.getString(3));                                
				c.setApellidoMaterno(rs.getString(4));                                 
				c.setEmail(rs.getString(5));
                                c.setContrasena(rs.getString(6));
                                c.setCalle(rs.getString(7));
                                c.setMunicipio(rs.getString(8));
                                c.setEstado(rs.getString(9));
                                c.setCp(rs.getString(10));
                                c.setTelefono(rs.getString(11));
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return c;
	}

	public static int actualizar(Cuentas c){
		int status=0;
		try{
			Connection con=CuentasDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("UPDATE usuarios SET nombre=?,apellido_paterno=?,apellido_materno=?,email=?,contrasena=?,calle=?,municipio=?,estado=?,cp=?,telefono=? WHERE id=?");                       
			ps.setString(1,c.getNombre());
			ps.setString(2,c.getApellidoPaterno());
			ps.setString(3,c.getApellidoMaterno());                        
			ps.setString(4,c.getEmail());                        
			ps.setString(5,c.getContrasena());
                        ps.setString(6,c.getCalle());
                        ps.setString(7,c.getMunicipio());
                        ps.setString(8,c.getEstado());
                        ps.setString(9,c.getCp());
                        ps.setString(10,c.getTelefono());
			ps.setInt(11,c.getId());                         
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}        
}
