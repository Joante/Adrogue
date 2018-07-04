package datos;

import java.util.GregorianCalendar;

public class RedSube {
	
	private long idRedSube;
	private int contadorViajes;
	private int ultimoTipoTransporte;
	private GregorianCalendar fechaHoraRedSube;
	private Tarjeta tarjeta;
	
	public RedSube(int ultimoTipoTransporte, Tarjeta tarjeta) {
		this.ultimoTipoTransporte = ultimoTipoTransporte;
		this.tarjeta = tarjeta;
		this.fechaHoraRedSube = new GregorianCalendar();
		this.contadorViajes=1;
	}

	public RedSube() {}

	
	public long getIdRedSube() {
		return idRedSube;
	}

	public void setIdRedSube(long idRedSube) {
		this.idRedSube = idRedSube;
	}

	public int getContadorViajes() {
		return contadorViajes;
	}

	public void setContadorViajes(int contadorViajes) {
		this.contadorViajes = contadorViajes;
	}

	public int getUltimoTipoTransporte() {
		return ultimoTipoTransporte;
	}

	public void setUltimoTipoTransporte(int ultimoTipoTransporte) {
		this.ultimoTipoTransporte = ultimoTipoTransporte;
	}

	public GregorianCalendar getFechaHoraRedSube() {
		return fechaHoraRedSube;
	}

	public void setFechaHoraRedSube(GregorianCalendar fechaHoraRedSube) {
		this.fechaHoraRedSube = fechaHoraRedSube;
	}

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}
	
	
	
}
