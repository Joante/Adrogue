package datos;
import java.util.Set;

public class LineaColectivo  { 
	private long idLineaColectivo;
	private String empresa;
	private int linea;
	private Set<Colectivo> lstColectivo;
	
	public LineaColectivo() {}
	

	public LineaColectivo(String nombre, int linea) {
		this.empresa = nombre;
		this.linea = linea;
	}



	public long getIdLineaColectivo() {
		return idLineaColectivo;
	}

	public void setIdLineaColectivo(long idLineaColectivo) {
		this.idLineaColectivo = idLineaColectivo;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String nombre) {
		this.empresa = nombre;
	}
	
	public int getLinea() {
		return linea;
	}

	public void setLinea(int linea) {
		this.linea = linea;
	}

	public Set<Colectivo> getLstColectivo() {
		return lstColectivo;
	}

	public void setLstColectivo(Set<Colectivo> lstColectivo) {
		this.lstColectivo = lstColectivo;
	}


	@Override
	public String toString() {
		return "LineaColectivo [idLineaColectivo=" + idLineaColectivo + ", empresa=" + empresa + ", linea=" + linea
				+ "]";
	}
	
}
