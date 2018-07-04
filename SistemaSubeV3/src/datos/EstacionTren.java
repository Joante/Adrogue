package datos;

public class EstacionTren {
	private long idEstacionTren;
	private String nombre;
	private LineaTren lineaTren;
	
	public EstacionTren() {}

	public EstacionTren(String nombre, LineaTren lineaTren) {

		this.nombre = nombre;
		this.lineaTren=lineaTren;
	}

	public long getIdEstacionTren() {
		return idEstacionTren;
	}

	public void setIdEstacionTren(long idEstacionTren) {
		this.idEstacionTren = idEstacionTren;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LineaTren getLineaTren() {
		return lineaTren;
	}

	public void setLineaTren(LineaTren lineaTren) {
		this.lineaTren = lineaTren;
	}
	
	
	
}
