package datos;

import java.util.Set;

public class LineaTren {
	private long idLineaTren;
	private String nombreLinea;
	private Set<EstacionTren> lstEstaciones;
	
	public LineaTren() {}

	public LineaTren(String nombreLinea) {
		this.nombreLinea = nombreLinea;
		
	}

	public long getIdLineaTren() {
		return idLineaTren;
	}

	public void setIdLineaTren(long idLineaTren) {
		this.idLineaTren = idLineaTren;
	}

	public String getNombreLinea() {
		return nombreLinea;
	}

	public void setNombreLinea(String nombreLinea) {
		this.nombreLinea = nombreLinea;
	}

	public Set<EstacionTren> getLstEstaciones() {
		return lstEstaciones;
	}

	public void setLstEstaciones(Set<EstacionTren> lstEstaciones) {
		this.lstEstaciones = lstEstaciones;
	}
	
	
	
}
