package datos;

public class TarifaColectivo extends Tarifa {
	private long idTarifaColectivo;
	private SeccionColectivo seccion;
	
	public TarifaColectivo() {}

	public TarifaColectivo(double valorTarifa, SeccionColectivo seccion) {
		super(valorTarifa);
		this.seccion=seccion;
		
	}

	public long getIdTarifaColectivo() {
		return idTarifaColectivo;
	}

	protected void setIdTarifaColectivo(long idTarifaColectivo) {
		this.idTarifaColectivo = idTarifaColectivo;
	}

	public SeccionColectivo getSeccion() {
		return seccion;
	}

	public void setSeccion(SeccionColectivo seccion) {
		this.seccion = seccion;
	}

	@Override
	public String toString() {
		return "TarifaColectivo [idTarifaColectivo=" + idTarifaColectivo + ", seccion=" + seccion + "]";
	}
	
	
	
}
