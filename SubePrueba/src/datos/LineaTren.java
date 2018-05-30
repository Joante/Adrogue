package datos;

import java.util.Set;

public class LineaTren {
	private long idLineaTren;
	private String nombreLinea;
	private Set<EstacionTren> lstEstaciones;
	private Set<Tren> lstTrenes;
	
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
	public Set<Tren> getLstTrenes() {
		return lstTrenes;
	}

	public void setLstTrenes(Set<Tren> lstTrenes) {
		this.lstTrenes = lstTrenes;
	}

	@Override
	public String toString() {
		return "LineaTren [idLineaTren=" + idLineaTren + ", nombreLinea=" + nombreLinea + "]";
	}
	
	
	
}
