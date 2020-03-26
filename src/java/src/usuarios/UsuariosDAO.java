package src.usuarios;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class UsuariosDAO {
    	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/vendetucasa", "postgres", "password");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	public static int guardar(Usuarios u){
		int status=0;
		try{
			Connection con=UsuariosDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("INSERT INTO usuarios(nombre, apellido_paterno, apellido_materno, email, contrasena) VALUES (?,?,?,?,?)");
			ps.setString(1,u.getNombre());
			ps.setString(2,u.getApellidoPaterno());
			ps.setString(3,u.getApellidoMaterno());
			ps.setString(4,u.getEmail());
			ps.setString(5,u.getContrasena());			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int actualizar(Usuarios u){
		int status=0;
		try{
			Connection con=UsuariosDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("UPDATE usuarios SET nombre=?,apellido_paterno=?,apellido_materno=?,email=?,contrasena=? WHERE id=?");                       
			ps.setString(1,u.getNombre());
			ps.setString(2,u.getApellidoPaterno());
			ps.setString(3,u.getApellidoMaterno());                        
			ps.setString(4,u.getEmail());                        
			ps.setString(5,u.getContrasena());
			ps.setInt(6,u.getId());                         
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int borrar(int id){
		int status=0;
		try{
			Connection con=UsuariosDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("DELETE FROM usuarios WHERE id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}
	public static Usuarios getUsuarioPorId(int id){
		Usuarios u =new Usuarios();
		
		try{
			Connection con=UsuariosDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM usuarios WHERE id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				u.setId(rs.getInt(1));
				u.setNombre(rs.getString(2));
				u.setApellidoPaterno(rs.getString(3));                                
				u.setApellidoMaterno(rs.getString(4));                                 
				u.setEmail(rs.getString(5));
                                u.setContrasena(rs.getString(6));
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return u;
	}
	public static List<Usuarios> getTodosUsuarios(){
		List<Usuarios> list=new ArrayList<Usuarios>();
		
		try{
			Connection con=UsuariosDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM usuarios");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
                                Usuarios u = new Usuarios();
				u.setId(rs.getInt(1));
				u.setNombre(rs.getString(2));
				u.setApellidoPaterno(rs.getString(3));                                
				u.setApellidoMaterno(rs.getString(4));                                 
				u.setEmail(rs.getString(5));
                                u.setContrasena(rs.getString(6));
				list.add(u);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
}
