package datos;

public class TarifaSubte extends Tarifa {
	private long idTarifaSubte;
	private SeccionSubte seccion;
	
	
	public TarifaSubte() {}
	
	public TarifaSubte(double valorTarifa,SeccionSubte seccion) {
		super(valorTarifa);
		this.seccion=seccion;

	}

	public long getIdTarifaSubte() {
		return idTarifaSubte;
	}
	
	public void setIdTarifaSubte(long idTarifaSubte) {
		this.idTarifaSubte = idTarifaSubte;
	}

	public SeccionSubte getSeccion() {
		return seccion;
	}

	public void setSeccion(SeccionSubte seccion) {
		this.seccion = seccion;
	}
	
	
}
