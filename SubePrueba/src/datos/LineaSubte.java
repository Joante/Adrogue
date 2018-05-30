package datos;
import java.util.Set;

public class LineaSubte {
	private long idLineaSubte;
	private char linea;
	private Set<EstacionSubte> lstEstaciones;
	
	public LineaSubte() {}
	

	public LineaSubte(char linea) {
		this.linea = linea;
	}


	public long getIdLineaSubte() {
		return idLineaSubte;
	}

	public void setIdLineaSubte(long idSubte) {
		this.idLineaSubte = idSubte;
	}

	public char getLinea() {
		return linea;
	}

	public void setLinea(char linea) {
		this.linea = linea;
	}

	public Set<EstacionSubte> getLstEstaciones() {
		return lstEstaciones;
	}

	public void setLstEstaciones(Set<EstacionSubte> lstEstaciones) {
		this.lstEstaciones = lstEstaciones;
	}
	
	
	
	
}
