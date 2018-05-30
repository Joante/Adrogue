package negocio;


import dao.SeccionTrenDao;
import datos.SeccionTren;

public class SeccionTrenABM {
	private SeccionTrenDao dao = new SeccionTrenDao();

	public int agregarSeccionTren(double valorSeccionComun, double valorSeccionTarifaSocial) {
		SeccionTren c = new SeccionTren (valorSeccionComun,valorSeccionTarifaSocial);
		return dao.agregar(c);
	}

	public void modificarSeccionTren(SeccionTren seccionTren){
		dao.actualizar(seccionTren);
	}

	public void eliminarSeccionTren(long idSeccionTren){
		SeccionTren c = dao.traerSeccionTren(idSeccionTren);
		dao.eliminar(c);
	}

	public SeccionTren traerSeccionTren(long idSeccionTren){
		return dao.traerSeccionTren(idSeccionTren);
	}
	public double traerValorSeccionComun(long idSeccionTren) {
		return dao.traerValorSeccionNormal(idSeccionTren);
	}
	public double traerValorSeccionTarifaSocial(long idSeccionTren) {
		return dao.traerValorSeccionTarifaSocial(idSeccionTren);
	}
}
