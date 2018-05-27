package negocio;


import dao.SeccionColectivoDao;
import datos.SeccionColectivo;

public class SeccionColectivoABM {
	private SeccionColectivoDao dao = new SeccionColectivoDao();

	public int agregarSeccionColectivo(String descripcion,double valorSeccionComun, double valorSeccionTarifaSocial) {
		SeccionColectivo c = new SeccionColectivo (descripcion,valorSeccionComun,valorSeccionTarifaSocial);
		return dao.agregar(c);
	}

	public void modificarSeccionColectivo(SeccionColectivo seccionColectivo){
		dao.actualizar(seccionColectivo);
	}

	public void eliminarSeccionColectivo(long idSeccionColectivo){
		SeccionColectivo c = dao.traerSeccionColectivo(idSeccionColectivo);
		dao.eliminar(c);
	}

	public SeccionColectivo traerSeccionColectivo(long idSeccionColectivo){
		return dao.traerSeccionColectivo(idSeccionColectivo);
	}
	
}

	


	