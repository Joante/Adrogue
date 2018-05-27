package datos;

public class SeccionTren {
	private long idSeccionTren;
	private double valorSeccionComun;
	private double valorSeccionTarifaSocial;
	
	public SeccionTren() {}

	public SeccionTren(double valorSeccionComun, double valorSeccionTarifaSocial) {
		
		this.valorSeccionComun = valorSeccionComun;
		this.valorSeccionTarifaSocial = valorSeccionTarifaSocial;
	}

	public long getIdSeccionTren() {
		return idSeccionTren;
	}

	public void setIdSeccionTren(long idSeccionTren) {
		this.idSeccionTren = idSeccionTren;
	}

	public double getValorSeccionComun() {
		return valorSeccionComun;
	}

	public void setValorSeccionComun(double valorSeccionComun) {
		this.valorSeccionComun = valorSeccionComun;
	}

	public double getValorSeccionTarifaSocial() {
		return valorSeccionTarifaSocial;
	}

	public void setValorSeccionTarifaSocial(double valorSeccionTarifaSocial) {
		this.valorSeccionTarifaSocial = valorSeccionTarifaSocial;
	}
	
	
	
}
