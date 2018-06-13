package negocio;


import dao.TrenDao;
import datos.Tren;
import datos.LineaTren;

public class TrenABM {
	private TrenDao dao = new TrenDao();

	public int agregarTren(int tipoTransporte, String descripcion, LineaTren lineaTren) throws Exception {
		if(tipoTransporte!=1) {
			throw new Exception("El tipo de transporte es incorrecto");
		}
		Tren c = new Tren (tipoTransporte,descripcion,lineaTren);
		return dao.agregar(c);
	}

	public void modificarTren(Tren tren) throws Exception{
		Tren c = dao.traerTren(tren.getIdTren());
		if(c==null) {
			throw new Exception("El tren a modificar con el id " + tren.getIdTren()+ " no existe");
		}
		dao.actualizar(tren);
	}

	public void eliminarTren(long idTren) throws Exception{
		Tren c = dao.traerTren(idTren);
		if(c==null) {
			throw new Exception("El tren a eliminar con el id "+ idTren+ " no existe");
		}
		dao.eliminar(c);
	}

	public Tren traerTren(long idTren) throws Exception{
		Tren c= dao.traerTren(idTren);
		if(c==null) {
			throw new Exception("El tren a traer con el id " +idTren +" es nulo");
		}
		
		return c;
	}
	
}