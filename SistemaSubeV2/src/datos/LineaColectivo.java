package datos;

import java.util.Set;

public class LineaColectivo {
	private long idLineaColectivo;
	private long linea;
	private Set<Colectivo> lstEstaciones;
	
	
	
	
	public LineaColectivo(long linea) {
		super();
		this.linea = linea;
	}

	public LineaColectivo() {
		super();
	}

	public long getIdLineaColectivo() {
		return idLineaColectivo;
	}
	
	protected void setIdLineaColectivo(long idLineaColectivo) {
		this.idLineaColectivo = idLineaColectivo;
	}
	public long getLinea() {
		return linea;
	}
	public void setLinea(long linea) {
		this.linea = linea;
	}
	public Set<Colectivo> getLstEstaciones() {
		return lstEstaciones;
	}
	public void setLstEstaciones(Set<Colectivo> lstEstaciones) {
		this.lstEstaciones = lstEstaciones;
	}

	@Override
	public String toString() {
		return "LineaColectivo [idLineaColectivo=" + idLineaColectivo + ", linea=" + linea + ", lstEstaciones="
				+ lstEstaciones + "]";
	}
	
	

}
