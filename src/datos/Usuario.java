package datos;

import java.util.Set;

public class Usuario {
	private long idUsuario;
	private String nombre;
	private String apellido;
	private long dni;
	private String password;
	private Set<Tarjeta> tarjetas;
	

	public Usuario() {}

	public Usuario(String nombre, String apellido, long dni, String password) {
	
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.password=password;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Tarjeta> getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(Set<Tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", password=" + password + "]";
	}
		
}
