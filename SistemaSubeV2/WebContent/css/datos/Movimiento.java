package datos;
import java.util.GregorianCalendar;

public class Movimiento {
	private long idMovimiento;
	private GregorianCalendar fechaHora;
	private Tarjeta tarjeta;
	private Tarifa tarifa;
	private Transporte transporte;
	
	public Movimiento() {}

	public Movimiento(GregorianCalendar fechaHora, Tarjeta tarjeta, Tarifa tarifa,
			Transporte transporte) {
		
		this.fechaHora = fechaHora;
		this.tarjeta = tarjeta;
		this.tarifa = tarifa;
		this.transporte = transporte;
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
	
	
	
}
