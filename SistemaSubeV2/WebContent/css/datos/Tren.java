package datos;


public class Tren extends Transporte {
	private long idTren;
	private LineaTren lineaTren;
	
	public Tren() {}

	public Tren(int tipoTransporte, String descripcion, LineaTren lineaTren) {
		super(tipoTransporte, descripcion);
		this.lineaTren=lineaTren;
	}

	public long getIdTren() {
		return idTren;
	}

	public void setIdTren(long idTren) {
		this.idTren = idTren;
	}

	public LineaTren getLineaTren() {
		return lineaTren;
	}

	public void setLineaTren(LineaTren lineaTren) {
		this.lineaTren = lineaTren;
	}
	
	
	
	
}
