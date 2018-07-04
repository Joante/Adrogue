package datos;

public class Transporte {
	private long idTransporte;
	private int tipoTransporte;
	private String descripcion;
	
	public Transporte() {}

	public Transporte(int tipoTransporte, String descripcion) {
		this.tipoTransporte = tipoTransporte;
		this.descripcion = descripcion;
	}

	public long getIdTransporte() {
		return idTransporte;
	}

	public void setIdTransporte(long idTransporte) {
		this.idTransporte = idTransporte;
	}

	public int getTipoTransporte() {
		return tipoTransporte;
	}

	public void setTipoTransporte(int tipoTransporte) {
		this.tipoTransporte = tipoTransporte;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Transporte [idTransporte=" + idTransporte + ", tipoTransporte=" + tipoTransporte + ", descripcion="
				+ descripcion + "]";
	}
	
	
	
	
}
