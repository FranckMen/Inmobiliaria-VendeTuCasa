<!DOCTYPE html>  
<html>  
<head>  
    <title>VendeTuCasa.com</title>
    <link rel="stylesheet" href="css/estilos.css">        
<meta charset="utf-8">  
</head>
<body>
    <img src='img/logo.jpg' title='VendeTuCasa.com' id="logo"><br>'
    <a href="ViewServlet">Administrar Usuarios</a> |
    <a href="ViewServletCasas">Administrar Casas</a> |
    <a href="LogoutServlet2">Salir</a>
    <hr> 
    <br>         
            <h3>Agregar Fotografía</h3>
		<form action="FileUploadServlet2" method="POST" enctype="multipart/form-data">
                        <input type='hidden' id="id" name='id'/>                    
			<p>Seleccione un archivo:</p>
			<input type="file" name="fileToUpload">
			<br/><br/>
			<input type="submit" value="Cargar foto">
		</form>
	</body>
<script>
    function gup(name) {
    name = name.replace(/[\[]/, "\\\[").replace(/[\]]/, "\\\]");
    var regexS = "[\\?&]" + name + "=([^&#]*)";
    var regex = new RegExp(regexS);
    var results = regex.exec(window.location.href);
    return results == null ? null : results[1];
    }
    
    var id = gup('id');
    
    document.getElementById("id").value = id;
</script>        
</html>