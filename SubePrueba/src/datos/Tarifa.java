package datos;

public class Tarifa {
	private long idTarifa;
	private double valorTarifa;
	
	public Tarifa() {}

	public Tarifa(double valorTarifa) {

		this.valorTarifa = valorTarifa;
	}

	public long getIdTarifa() {
		return idTarifa;
	}

	public void setIdTarifa(long idTarifa) {
		this.idTarifa = idTarifa;
	}

	public double getValorTarifa() {
		return valorTarifa;
	}

	public void setValorTarifa(double valorTarifa) {
		this.valorTarifa = valorTarifa;
	}

	@Override
	public String toString() {
		return "Tarifa [idTarifa=" + idTarifa + ", valorTarifa=" + valorTarifa + "]";
	}
	
	
	
	
	
}
