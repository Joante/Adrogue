package negocio;


import dao.TrenDao;
import datos.LineaTren;
import datos.Tren;

public class TrenABM {
	private TrenDao dao = new TrenDao();

	public int agregarTren(int tipoTransporte, String descripcion, LineaTren lineaTren) {
		Tren c = new Tren (tipoTransporte,descripcion,lineaTren);
		return dao.agregar(c);
	}

	public void modificarTren(Tren tren){
		dao.actualizar(tren);
	}

	public void eliminarTren(long idTren){
		Tren c = dao.traerTren(idTren);
		dao.eliminar(c);
	}

	public Tren traerTren(long idTren){
		return dao.traerTren(idTren);
	}
	
}

	


	