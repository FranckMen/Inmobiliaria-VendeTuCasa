
package src.usuarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class LoginDAO {
   public static boolean validate(String email, String contrasena){  
        boolean status=false;  
        try{  
        Class.forName("org.postgresql.Driver");
        Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/vendetucasa", "postgres", "password");  

        PreparedStatement ps=con.prepareStatement(  
        "SELECT * FROM usuarios WHERE email =? AND contrasena=? AND admin = true");  
        ps.setString(1,email);  
        ps.setString(2,contrasena);  

        ResultSet rs=ps.executeQuery();  
        status=rs.next();  

        }catch(Exception e){System.out.println(e);}  
        return status;  
        } 
}
