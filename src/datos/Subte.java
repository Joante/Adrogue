package datos;
import java.util.Set;

public class Subte extends Transporte {
	private long idSubte;
	private char linea;
	private Set<EstacionSubte> lstEstaciones;
	
	public Subte() {}
	

	public Subte(int tipoTransporte, String descripcion,char linea) {
		super(tipoTransporte, descripcion);
		this.linea = linea;
	}


	public long getIdSubte() {
		return idSubte;
	}

	public void setIdSubte(long idSubte) {
		this.idSubte = idSubte;
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
