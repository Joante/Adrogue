package negocio;


import dao.SeccionTrenDao;
import datos.SeccionTren;

public class SeccionTrenABM {
	private SeccionTrenDao dao = new SeccionTrenDao();

	public int agregarSeccionTren(double valorSeccionComun, double valorSeccionTarifaSocial) {
		SeccionTren c = new SeccionTren (valorSeccionComun,valorSeccionTarifaSocial);
		return dao.agregar(c);
	}

	public void modificarSeccionTren(SeccionTren seccionTren)throws Exception{
		SeccionTren c = dao.traerSeccionTren(seccionTren.getIdSeccionTren());
		if(c==null) {
			throw new Exception("La seccion a modificar con el id "+ seccionTren.getIdSeccionTren()+ " no existe");
		}
		dao.actualizar(seccionTren);
	}

	public void eliminarSeccionTren(long idSeccionTren)throws Exception{
		SeccionTren c = dao.traerSeccionTren(idSeccionTren);
		if(c==null) {
			throw new Exception("La seccion a eliminar con el id "+ idSeccionTren+ " no existe");
		}
		dao.eliminar(c);
	}

	public SeccionTren traerSeccionTren(long idSeccionTren)throws Exception{
		SeccionTren c = dao.traerSeccionTren(idSeccionTren);
		if(c==null) {
			throw new Exception("La seccion a modificar con el id "+ idSeccionTren+ " no existe");
		}
		return dao.traerSeccionTren(idSeccionTren);
	}
	
	

	


	

}
