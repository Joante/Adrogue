package datos;

public class SeccionSubte {
	private long idSeccionSubte;
	private int cantidadViajesMinimo;
	private int cantidadViajesMaximo;
	private double valorSubteNormal;
	private double valorSubteTarifaSocial;
	
	public SeccionSubte() {}

	public SeccionSubte(int cantidadViajesMinimo, int cantidadViajesMaximo, double valorSubteNormal,
			double valorSubteTarifaSocial) {
		
		this.cantidadViajesMinimo = cantidadViajesMinimo;
		this.cantidadViajesMaximo = cantidadViajesMaximo;
		this.valorSubteNormal = valorSubteNormal;
		this.valorSubteTarifaSocial = valorSubteTarifaSocial;
	}

	public long getIdSeccionSubte() {
		return idSeccionSubte;
	}

	public void setIdSeccionSubte(long idSeccionSubte) {
		this.idSeccionSubte = idSeccionSubte;
	}

	public int getCantidadViajesMinimo() {
		return cantidadViajesMinimo;
	}

	public void setCantidadViajesMinimo(int cantidadViajesMinimo) {
		this.cantidadViajesMinimo = cantidadViajesMinimo;
	}

	public int getCantidadViajesMaximo() {
		return cantidadViajesMaximo;
	}

	public void setCantidadViajesMaximo(int cantidadViajesMaximo) {
		this.cantidadViajesMaximo = cantidadViajesMaximo;
	}

	public double getValorSubteNormal() {
		return valorSubteNormal;
	}

	public void setValorSubteNormal(double valorSubteNormal) {
		this.valorSubteNormal = valorSubteNormal;
	}

	public double getValorSubteTarifaSocial() {
		return valorSubteTarifaSocial;
	}

	public void setValorSubteTarifaSocial(double valorSubteTarifaSocial) {
		this.valorSubteTarifaSocial = valorSubteTarifaSocial;
	}
	
	
}
