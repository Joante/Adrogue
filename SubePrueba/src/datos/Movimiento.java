package datos;
import java.util.GregorianCalendar;

public class Movimiento {
	private long idMovimiento;
	private GregorianCalendar fechaHora;
	private Tarjeta tarjeta;
	private Tarifa tarifa;
	private Transporte transporte;
	private String descripcionRedSube;
	
	public Movimiento() {}

	public Movimiento(GregorianCalendar fechaHora, Tarjeta tarjeta, Tarifa tarifa,
			Transporte transporte) {
		
		this.fechaHora = fechaHora;
		this.tarjeta = tarjeta;
		this.tarifa = tarifa;
		this.transporte = transporte;
		this.descripcionRedSube="";
	}

	public long getIdMovimiento() {
		return idMovimiento;
	}

	public void setIdMovimiento(long idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public GregorianCalendar getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(GregorianCalendar fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	public Tarifa getTarifa() {
		return tarifa;
	}

	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}

	public Transporte getTransporte() {
		return transporte;
	}

	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}
	
	public String getDescripcionRedSube() {
		return descripcionRedSube;
	}

	public void setDescripcionRedSube(String descripcionRedSube) {
		this.descripcionRedSube = descripcionRedSube;
	}

	@Override
	public String toString() {
		return "Movimiento [idMovimiento=" + idMovimiento + ", tarjeta=" + tarjeta + ", tarifa=" + tarifa
				+ ", transporte=" + transporte + "]";
	}
	
	
	
}
