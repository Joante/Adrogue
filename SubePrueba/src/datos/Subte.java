package datos;

import java.util.Set;

public class Subte extends Transporte{
	
	private long idLineaSubte;
	private LineaSubte lineaSubte;
	private Set<EstacionSubte> lstEstacion;
	
	public Subte() {}

	public Subte(int tipoTransporte, String descripcion, LineaSubte lineaSubte) {
		super(tipoTransporte, descripcion);
		this.lineaSubte = lineaSubte;
	}



	public long getIdLineaSubte() {
		return idLineaSubte;
	}

	public void setIdLineaSubte(long idLineaSubte) {
		this.idLineaSubte = idLineaSubte;
	}

	public LineaSubte getLineaSubte() {
		return lineaSubte;
	}

	public void setLineaSubte(LineaSubte lineaSubte) {
		this.lineaSubte = lineaSubte;
	}

	public Set<EstacionSubte> getLstEstacion() {
		return lstEstacion;
	}

	public void setLstEstacion(Set<EstacionSubte> lstEstacion) {
		this.lstEstacion = lstEstacion;
	}
	
	
	
}
