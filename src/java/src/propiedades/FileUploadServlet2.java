package src.propiedades;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class FileUploadServlet2 extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
                response.setContentType("text/html; charset=UTF-8");
                response.setCharacterEncoding("UTF-8"); 
		PrintWriter out=response.getWriter();
                
		//get the file chosen by the user
		Part filePart = request.getPart("fileToUpload");
		
		//get the InputStream to store the file somewhere
	    InputStream fileInputStream = filePart.getInputStream();
	    
	    //for example, you can copy the uploaded file to the server
	    //note that you probably don't want to do this in real life!
	    //upload it to a file host like S3 or GCS instead
	    File fileToSave = new File("C:\\Users\\frank\\Desktop\\VendeTuCasa\\web\\upload\\" + filePart.getSubmittedFileName());
		Files.copy(fileInputStream, fileToSave.toPath(), StandardCopyOption.REPLACE_EXISTING);
		
		//create output HTML that uses the 
		out.print("<script>alert('Su fotografía se ha cargado con éxito.')</script>");	
                
                String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
                
		int status=PropiedadesDAO.actualizar_foto(filePart.getSubmittedFileName(),id);
		if(status>0){
			response.sendRedirect("ViewServletCasas");
		}else{
			out.println("Algo ha salido mal :(");
		}	
		out.close();             
	}
}