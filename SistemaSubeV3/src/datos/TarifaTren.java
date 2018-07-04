package datos;

public class TarifaTren extends Tarifa {
	private long idTarifaTren;
	private EstacionTren estacionSubida;
	private EstacionTren estacionBajada;
	private SeccionTren seccion;
	
	
	public TarifaTren() {}

	public TarifaTren(double valorTarifa,EstacionTren estacionSubida, EstacionTren estacionBajada, SeccionTren seccion) {
		super(valorTarifa);
		this.estacionSubida = estacionSubida;
		this.estacionBajada = estacionBajada;
		this.seccion = seccion;
	}


	public long getIdTarifaTren() {
		return idTarifaTren;
	}


	public void setIdTarifaTren(long idTarifaTren) {
		this.idTarifaTren = idTarifaTren;
	}


	public EstacionTren getEstacionSubida() {
		return estacionSubida;
	}


	public void setEstacionSubida(EstacionTren estacionSubida) {
		this.estacionSubida = estacionSubida;
	}


	public EstacionTren getEstacionBajada() {
		return estacionBajada;
	}


	public void setEstacionBajada(EstacionTren estacionBajada) {
		this.estacionBajada = estacionBajada;
	}


	public SeccionTren getSeccion() {
		return seccion;
	}


	public void setSeccion(SeccionTren seccion) {
		this.seccion = seccion;
	}

	
	
	
}
