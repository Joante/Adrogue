package datos;

public class EstacionSubte {
	private long idEstacionSubte;
	private String nombre;
	private LineaSubte lineaSubte;
	
	public EstacionSubte() {}

	public EstacionSubte(String nombre, LineaSubte lineaSubte) {
		this.nombre = nombre;
		this.lineaSubte= lineaSubte;
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

	protected LineaSubte getLineaSubte() {
		return lineaSubte;
	}

	protected void setLineaSubte(LineaSubte lineaSubte) {
		this.lineaSubte = lineaSubte;
	}
	
	
}
