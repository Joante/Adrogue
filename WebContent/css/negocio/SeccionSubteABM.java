package negocio;


import dao.SeccionSubteDao;
import datos.SeccionSubte;

public class SeccionSubteABM {
	private SeccionSubteDao dao = new SeccionSubteDao();

	public int agregarSeccionSubte(int cantidadViajesMinimo, int cantidadViajesMaximo, double valorSubteNormal,
			double valorSubteTarifaSocial) {
		SeccionSubte c = new SeccionSubte (cantidadViajesMinimo,cantidadViajesMaximo,valorSubteNormal,valorSubteTarifaSocial);
		return dao.agregar(c);
	}

	public void modificarSeccionSubte(SeccionSubte seccionSubte){
		dao.actualizar(seccionSubte);
	}

	public void eliminarSeccionSubte(long idSeccionSubte){
		SeccionSubte c = dao.traerSeccionSubte(idSeccionSubte);
		dao.eliminar(c);
	}

	public SeccionSubte traerSeccionSubte(long idSeccionSubte){
		return dao.traerSeccionSubte(idSeccionSubte);
	}
	
}

	


	