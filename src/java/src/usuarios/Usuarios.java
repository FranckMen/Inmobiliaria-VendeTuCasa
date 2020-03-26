package src.usuarios;

public class Usuarios {
private int id;
private String nombre, apellido_paterno, apellido_materno, email, contrasena;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellidoPaterno() {
	return apellido_paterno;
}
public void setApellidoPaterno(String apellido_paterno) {
	this.apellido_paterno = apellido_paterno;
}
public String getApellidoMaterno() {
	return apellido_materno;
}
public void setApellidoMaterno(String apellido_materno) {
	this.apellido_materno = apellido_materno;
}
public String getContrasena() {
	return contrasena;
}
public void setContrasena(String contrasena) {
	this.contrasena = contrasena;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

}

