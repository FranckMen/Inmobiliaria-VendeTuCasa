
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% if(session!=null){ %>
<!DOCTYPE html>  
<html>  
    <head>      
        <title>VendeTuCasa.com</title>    
        <link rel="stylesheet" href="css/estilos.css">        
        <meta charset="utf-8">  
    </head>
    <img src='img/logo.jpg' title='VendeTuCasa.com' id="logo"><br>'<a href="ViewServlet">Administrar Usuarios</a> | <a href="ViewServletCasas">Administrar Casas</a> | <a href="LogoutServlet2">Log out</a><hr> <br>
<h1>Agregar Nuevo Usuario</h1>  
<form action="SaveServlet" method="post">  
<table>  
<tr><td>Nombre:</td><td><input type="text" name="nombre"/></td></tr>  
<tr><td>Apellido Paterno:</td><td><input type="text" name="apellido_paterno"/></td></tr> 
<tr><td>Apellido Materno:</td><td><input type="text" name="apellido_materno"/></td></tr> 
<tr><td>Email:</td><td><input type="text" name="email"/></td></tr> 
<tr><td>Contraseña</td><td><input type="password" name="contrasena"/></td></tr>     
<tr><td colspan="2"><input type="submit" value="Guardar Usuario"/></td></tr>  
</table>  
</form>  
  
<br/>  
<a href="ViewServlet">Ver todos los usuarios</a>  
  
</body>  
</html> 
<% }  
        else{  
            out.print("Debe iniciar sesión");  
            request.getRequestDispatcher("login.html").include(request, response);  
        } %>