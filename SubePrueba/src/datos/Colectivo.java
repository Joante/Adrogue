package datos;

public class Colectivo extends Transporte {
	private long idColectivo;
	private long interno;
	private LineaColectivo lineaColectivo;
	
	public Colectivo() {}

	
	
	public Colectivo(int tipoTransporte, String descripcion, long interno, LineaColectivo lineaColectivo) {
		super(tipoTransporte, descripcion);
		this.interno = interno;
		this.lineaColectivo = lineaColectivo;
	}



	protected long getIdColectivo() {
		return idColectivo;
	}

	protected void setIdColectivo(long idColectivo) {
		this.idColectivo = idColectivo;
	}

	protected long getInterno() {
		return interno;
	}

	protected void setInterno(long interno) {
		this.interno = interno;
	}

	protected LineaColectivo getLineaColectivo() {
		return lineaColectivo;
	}

	protected void setLineaColectivo(LineaColectivo lineaColectivo) {
		this.lineaColectivo = lineaColectivo;
	}



	@Override
	public String toString() {
		return "Colectivo [idColectivo=" + idColectivo + ", interno=" + interno + ", lineaColectivo=" + lineaColectivo
				+ "]";
	}
	
	
}
