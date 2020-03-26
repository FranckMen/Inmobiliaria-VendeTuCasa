

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% if(session!=null){ %>
<!DOCTYPE html>  
<html>  
<head>  
<meta charset="utf-8">  
<title>VendeTuCasa.com</title>  
<link rel="stylesheet" href="css/estilos.css">    
</head> 
<style>
    #propi{
        background-color: lightblue;
        border-radius: 5%;
        opacity: 9.2;
        text-align: center;
        
    }
</style>
<body>  
    <img src='img/logo.jpg' title='VendeTuCasa.com'><br>'
    <a href="EditCuentaServlet">Mis datos</a> |     
    <a href="ViewPropiedadesServlet">Mis propiedades</a> | 
    <a href="LogoutServlet2">Log out</a> 
    <hr> 
    <div id="propi">
<h1>Agregar Nueva Propiedad</h1>  
<form action="SavePropiedadesServlet" method="post">  
<table >  
<tr><td>Titulo:</td><td><input type="text" name="titulo"/></td></tr>  
<tr><td>Descripcion:</td><td><input type="text" name="descripcion"/></td></tr> 
<tr><td>Precio:</td><td><input type="text" name="precio"/></td></tr>     
<tr><td colspan="2"><input type="submit" value="Guardar Propiedad"/></td></tr>  
</table>  
</form>  
  </div>
<br/>  
<a href="ViewPropiedadesServlet">Ver todas mis propiedades.</a>  
  
</body>  
</html> 
<% }  
        else{  
            out.print("Debe iniciar sesión");  
            request.getRequestDispatcher("login2.html").include(request, response);  
        } %>