package datos;

public class Colectivo extends Transporte {
	private long idColectivo;
	private String empresa;
	private long linea;
	private long interno;
	
	public Colectivo() {}
	
	
	public Colectivo(int tipoTransporte, String descripcion,String empresa, long linea, long interno) {
		super(tipoTransporte, descripcion);
		this.empresa = empresa;
		this.linea = linea;
		this.interno = interno;
	}

	

	public long getIdColectivo() {
		return idColectivo;
	}



	public void setIdColectivo(long idColectivo) {
		this.idColectivo = idColectivo;
	}



	public String getEmpresa() {
		return empresa;
	}


	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}


	public long getLinea() {
		return linea;
	}


	public void setLinea(long linea) {
		this.linea = linea;
	}


	public long getInterno() {
		return interno;
	}


	public void setInterno(long interno) {
		this.interno = interno;
	}


	@Override
	public String toString() {
		return "Colectivo [idColectivo=" + idColectivo + ", empresa=" + empresa + ", linea=" + linea + ", interno="
				+ interno + "]";
	}
	
	
}
