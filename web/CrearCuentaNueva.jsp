

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>  
<html>  
<head>  
<meta charset="utf-8">  
<title>VendeTuCasa.com</title> 
    <link rel="stylesheet" href="css/estilos.css">    
</head>  
<body> 
     <img src='img/logo.jpg' title='VendeTuCasa.com' id="logo"><br>'
    <a href="index.jsp">Inicio</a> |
    <a href="login2.html">Mi cuenta</a> |     
    <a href="">Ver propiedades</a> | 
    <a href="nosotros.jsp">Acerca de nosotros</a> |
    <a href="#">Contácto</a> |
    <a href="login.html">Acceso Administrador</a>      
    <hr>   
<h1>Crear nueva cuenta</h1>  
<form action="CrearCuentaServlet" method="post">  
    <center><table id="tablaRE">
            <br>
<tr><td>Nombre:</td><td><input type="text" name="nombre" required=""/></td></tr>
 <br>
 <tr><td>Apellido Paterno:</td><td><input type="text" name="apellido_paterno" required=""/></td></tr>
 <br>
 <tr><td>Apellido Materno:</td><td><input type="text" name="apellido_materno" required=""/></td></tr> 
<tr><td>Calle:</td><td><input type="text" name="calle"/></td></tr>
<tr><td>Alcaldía / Municipio:</td><td><input type="text" name="municipio" required=""/></td></tr>
<tr><td>Estado:</td><td><input type="text" name="estado" required/></td></tr>
<tr><td>CP:</td><td><input type="text" name="cp" required=""/></td></tr>
<tr><td>Teléfono:</td><td><input type="tel" name="telefono" required=""/></td></tr>
<tr><td>Email:</td><td><input type="email" name="email" required=""/></td></tr> 
<tr><td>Contraseña:</td><td><input type="password" name="contrasena" required=""/></td></tr>     
<tr><td colspan="2"><input type="submit" value="Crear Cuenta" /></td></tr>  
        </table> </center>
</form>  
</body>  
</html> 