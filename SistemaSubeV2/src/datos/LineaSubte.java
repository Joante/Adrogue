package datos;

import java.util.Set;

public class LineaSubte {
	private long idLineaSubte;
	private long linea;
	private Set<EstacionSubte> lstEstaciones;
	public LineaSubte() {
		super();
	}
	public LineaSubte(long linea) {
		super();
		this.linea = linea;
	}
	public long getIdLineaSubte() {
		return idLineaSubte;
	}
	protected void setIdLineaSubte(long idLineaSubte) {
		this.idLineaSubte = idLineaSubte;
	}
	public long getLinea() {
		return linea;
	}
	public void setLinea(long linea) {
		this.linea = linea;
	}
	public Set<EstacionSubte> getLstEstaciones() {
		return lstEstaciones;
	}
	public void setLstEstaciones(Set<EstacionSubte> lstEstaciones) {
		this.lstEstaciones = lstEstaciones;
	}
	@Override
	public String toString() {
		return "LineaSubte [idLineaSubte=" + idLineaSubte + ", linea=" + linea + ", lstEstaciones=" + lstEstaciones
				+ "]";
	}
	
	
	
	
}
