package negocio;


import dao.RedSubeDao;
import datos.RedSube;
import datos.Tarjeta;

public class RedSubeABM {
	private RedSubeDao dao = new RedSubeDao();

	public int agregarRedSube(int ultimoTipoTransporte, Tarjeta tarjeta) {
		RedSube c = new RedSube (ultimoTipoTransporte, tarjeta);
		return dao.agregar(c);
	}

	public void modificarRedSube(RedSube seccionColectivo){
		dao.actualizar(seccionColectivo);
	}

	public void eliminarRedSube(long idRedSube){
		RedSube c = dao.traerRedSubeNro(idRedSube);
		dao.eliminar(c);
	}

	public RedSube traerRedSube(long idTarjeta){
		return dao.traerRedSubeNro(idTarjeta);
	}
	
}
