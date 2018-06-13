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

	public void modificarSeccionSubte(SeccionSubte seccionSubte)throws Exception{
		SeccionSubte c = dao.traerSeccionSubte(seccionSubte.getIdSeccionSubte());
		if(c==null) {
			throw new Exception("La seccion a modificar con el id "+ seccionSubte.getIdSeccionSubte()+ " no existe");
		}
		
		dao.actualizar(seccionSubte);
	}

	public void eliminarSeccionSubte(long idSeccionSubte)throws Exception{
		SeccionSubte c = dao.traerSeccionSubte(idSeccionSubte);
		if(c==null) {
			throw new Exception("La seccion a eliminar con el id "+ idSeccionSubte+ " no existe");
		}
		dao.eliminar(c);
	}

	public SeccionSubte traerSeccionSubte(long idSeccionSubte)throws Exception{
		SeccionSubte c = dao.traerSeccionSubte(idSeccionSubte);
		if(c==null) {
			throw new Exception("La seccion a traer con el id "+ idSeccionSubte+ " no existe");
		}
		return dao.traerSeccionSubte(idSeccionSubte);
	}
	public SeccionSubte traerSeccionSubte(int cantViajes) {
		return dao.traerSeccionSubte(cantViajes);
	}
	
}

	


	