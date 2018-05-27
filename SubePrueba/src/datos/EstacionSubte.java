package datos;

public class EstacionSubte {
	private long idEstacionSubte;
	private String nombre;
	
	public EstacionSubte() {}

	public EstacionSubte(String nombre) {
		this.nombre = nombre;
	}

	public long getIdEstacionSubte() {
		return idEstacionSubte;
	}

	public void setIdEstacionSubte(long idEstacionSubte) {
		this.idEstacionSubte = idEstacionSubte;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
