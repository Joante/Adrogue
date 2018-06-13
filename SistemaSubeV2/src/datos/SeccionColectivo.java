package datos;

public class SeccionColectivo {
	private long idSeccion;
	private String descripcion;
	private double valorSeccionComun;
	private double valorSeccionTarifaSocial;
	
	public SeccionColectivo() {}

	public SeccionColectivo(String descripcion,double valorSeccionComun, double valorSeccionTarifaSocial) {
		this.descripcion=descripcion;
		this.valorSeccionComun = valorSeccionComun;
		this.valorSeccionTarifaSocial = valorSeccionTarifaSocial;
	}


	public long getIdSeccion() {
		return idSeccion;
	}

	public void setIdSeccion(long idSeccion) {
		this.idSeccion = idSeccion;
	}
	
	

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getValorSeccionComun() {
		return valorSeccionComun;
	}

	public void setValorSeccionComun(double valorSeccionComun) {
		this.valorSeccionComun = valorSeccionComun;
	}

	public double getValorSeccionTarifaSocial() {
		return valorSeccionTarifaSocial;
	}

	public void setValorSeccionTarifaSocial(double valorSeccionTarifaSocial) {
		this.valorSeccionTarifaSocial = valorSeccionTarifaSocial;
	}

	@Override
	public String toString() {
		return "SeccionColectivo [idSeccion=" + idSeccion + ", descripcion=" + descripcion + ", valorSeccionComun="
				+ valorSeccionComun + ", valorSeccionTarifaSocial=" + valorSeccionTarifaSocial + "]";
	}
	
	
	
	
}
