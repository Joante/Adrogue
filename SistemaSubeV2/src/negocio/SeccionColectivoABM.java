package negocio;


import dao.SeccionColectivoDao;
import datos.SeccionColectivo;

public class SeccionColectivoABM {
	private SeccionColectivoDao dao = new SeccionColectivoDao();

	public int agregarSeccionColectivo(String descripcion,double valorSeccionComun, double valorSeccionTarifaSocial) {
		SeccionColectivo c = new SeccionColectivo (descripcion,valorSeccionComun,valorSeccionTarifaSocial);
		return dao.agregar(c);
	}

	public void modificarSeccionColectivo(SeccionColectivo seccionColectivo)throws Exception{
		SeccionColectivo c = dao.traerSeccionColectivo(seccionColectivo.getIdSeccion());
		if(c==null) {
			throw new Exception("La seccion a modifcar con el id "+ seccionColectivo.getIdSeccion()+ " no existe");
		}
		dao.actualizar(seccionColectivo);
	}

	public void eliminarSeccionColectivo(long idSeccionColectivo)throws Exception{
		SeccionColectivo c = dao.traerSeccionColectivo(idSeccionColectivo);
		if(c==null) {
			throw new Exception("La seccion a eliminar con el id "+ idSeccionColectivo+ " no existe");
		}
		dao.eliminar(c);
	}

	public SeccionColectivo traerSeccionColectivo(long idSeccionColectivo)throws Exception{
		SeccionColectivo c = dao.traerSeccionColectivo(idSeccionColectivo);
		if(c==null) {
			throw new Exception("La seccion a traer con el id "+ idSeccionColectivo+ " no existe");
		}
		
		return dao.traerSeccionColectivo(idSeccionColectivo);
	}
	
}

	


	