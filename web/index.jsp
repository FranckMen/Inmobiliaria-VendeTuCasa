<%-- 
   
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>  
<html>  
<head>  
    <title>VendeTuCasa.com</title>
    <link rel="stylesheet" href="css/estilos.css">    
<meta charset="utf-8">  
</head>

<style>
    #menu{
        text-align: center;
        color: black;
        background-color:lavender;
        
       
        
        
    }
</style> 
<body>
<div id="fb-root"></div>
<script async defer crossorigin="anonymous" src="https://connect.facebook.net/es_ES/sdk.js#xfbml=1&version=v6.0&appId=282591615272109&autoLogAppEvents=1"></script>    
    <img src='img/logo.jpg' title='VendeTuCasa.com'id="logo"><br>'
    <div id="menu">
    <a href="index.jsp">Inicio</a> |
    <a href="login2.html">Mi cuenta</a> |     
    <a href="">Ver propiedades</a> | 
    <a href="nosotros.jsp">Acerca de nosotros</a> |
    <a href="#">Contácto</a> |
    <a href="login.html">Acceso Administrador</a> 
    </div>
    <hr> 
    <div class="casas">
        <jsp:include page="/ViewPropiedadesTodasServlet" />
    </div>
    <div style="float:right">
        <form action="https://www.paypal.com/cgi-bin/webscr" method="post" target="_top">
        <input type="hidden" name="cmd" value="_donations" />
        <input type="hidden" name="business" value="frank.men@hotmail.es" />
        <input type="hidden" name="item_name" value="Mantenimiento Web" />
        <input type="hidden" name="currency_code" value="MXN" />
        <input type="image" src="https://www.paypalobjects.com/es_XC/MX/i/btn/btn_donateCC_LG.gif" border="0" name="submit" title="PayPal - The safer, easier way to pay online!" alt="Donar con el botón PayPal" />
        <img alt="" border="0" src="https://www.paypal.com/es_MX/i/scr/pixel.gif" width="1" height="1" />
        </form>      
    </div>
    <div style="float:left">
        <div class="fb-like" data-href="https://developers.facebook.com/docs/plugins/" data-width="" data-layout="standard" data-action="like" data-size="small" data-share="true"></div>        
    </div>
</body> 
</html>