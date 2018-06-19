package datos;

public class ValoresEstacionesTren {
	public long idValores;
	public EstacionTren estacionSubida;
	public EstacionTren estacionBajada;
	public SeccionTren seccion;
	
	public ValoresEstacionesTren() {
	}

	public ValoresEstacionesTren(EstacionTren estacionSubida, EstacionTren estacionBajada, SeccionTren seccion) {
		this.estacionSubida = estacionSubida;
		this.estacionBajada = estacionBajada;
		this.seccion = seccion;
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

	public long getIdValores() {
		return idValores;
	}

	protected void setIdValores(long idValores) {
		this.idValores = idValores;
	}
	
	

}
