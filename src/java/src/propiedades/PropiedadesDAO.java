package src.propiedades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import src.usuarios.Usuarios;
import src.usuarios.UsuariosDAO;


public class PropiedadesDAO {
    	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/vendetucasa", "postgres", "password");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	public static List<Propiedades> getTodasPropiedades(String usuario){
		List<Propiedades> list=new ArrayList<Propiedades>();
		
		try{
			Connection con=PropiedadesDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT id, titulo, descripcion, precio, imagen FROM propiedades WHERE usuario =?");
			ps.setString(1,usuario);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
                                Propiedades p = new Propiedades();
				p.setId(rs.getInt(1));
				p.setTitulo(rs.getString(2));
				p.setDescripcion(rs.getString(3));                                
				p.setPrecio(rs.getString(4));                                 
				p.setImagen(rs.getString(5));                                  
				list.add(p);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
 	public static List<Propiedades> getTodasPropiedadesSinLogin(){
		List<Propiedades> list=new ArrayList<Propiedades>();
		
		try{
			Connection con=PropiedadesDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT id, titulo, descripcion, precio, imagen FROM propiedades");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
                                Propiedades p = new Propiedades();
				p.setId(rs.getInt(1));
				p.setTitulo(rs.getString(2));
				p.setDescripcion(rs.getString(3));                                
				p.setPrecio(rs.getString(4));                                 
				p.setImagen(rs.getString(5));                                  
				list.add(p);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
 	public static List<Propiedades> getTodasPropiedadesAdmin(){
		List<Propiedades> list=new ArrayList<Propiedades>();
		
		try{
			Connection con=PropiedadesDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT id, titulo, descripcion, precio, imagen FROM propiedades");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
                                Propiedades p = new Propiedades();
				p.setId(rs.getInt(1));
				p.setTitulo(rs.getString(2));
				p.setDescripcion(rs.getString(3));                                
				p.setPrecio(rs.getString(4));                                 
				p.setImagen(rs.getString(5));                                  
				list.add(p);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}        
 	public static int guardar(Propiedades p, String usuario){
		int status=0;
		try{
			Connection con=UsuariosDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("INSERT INTO propiedades(titulo, descripcion, precio, usuario) VALUES (?,?,?,?)");
			ps.setString(1,p.getTitulo());
			ps.setString(2,p.getDescripcion());
			ps.setString(3,p.getPrecio());
			ps.setString(4,usuario);	                      
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
        
	public static int borrar(int id){
		int status=0;
		try{
			Connection con=PropiedadesDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("DELETE FROM propiedades WHERE id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}
	public static Propiedades getPropiedadPorId(int id){
		Propiedades p =new Propiedades();
		
		try{
			Connection con=UsuariosDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT id, titulo, descripcion, precio FROM propiedades WHERE id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				p.setId(rs.getInt(1));
				p.setTitulo(rs.getString(2));
				p.setDescripcion(rs.getString(3));                                
				p.setPrecio(rs.getString(4));                                 
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return p;
	}
	public static int actualizar(Propiedades p){
		int status=0;
		try{
			Connection con=PropiedadesDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("UPDATE propiedades SET titulo=?,descripcion=?,precio=? WHERE id=?");                       
			ps.setString(1,p.getTitulo());
			ps.setString(2,p.getDescripcion());
			ps.setString(3,p.getPrecio());                        
			ps.setInt(4,p.getId());                         
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}        
	public static int actualizar_foto(String foto, int id){
		int status=0;
		try{
			Connection con=PropiedadesDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("UPDATE propiedades SET imagen=? WHERE id=?");       
			ps.setString(1,foto);                                  
			ps.setInt(2,id);                         
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}           
}