package negocio;



import dao.TarifaTrenDao;
import datos.EstacionTren;
import datos.SeccionTren;
import datos.TarifaTren;


public class TarifaTrenABM {
	private TarifaTrenDao dao = new TarifaTrenDao();

	public int agregarTarifaTren(double valorTarifa,EstacionTren estacionSubida, EstacionTren estacionBajada, SeccionTren seccion) {
		TarifaTren c = new TarifaTren (valorTarifa,estacionSubida,estacionBajada,seccion);
		return dao.agregar(c);
	}

	public void modificarTarifaTren(TarifaTren tarifaTren){
		dao.actualizar(tarifaTren);
	}

	public void eliminarTarifaTren(long idTarifaColectivo){
		TarifaTren c = dao.traerTarifaTren(idTarifaColectivo);
		dao.eliminar(c);
	}

	public TarifaTren traerTarifaTren(long idTarifaColectivo){
		return dao.traerTarifaTren(idTarifaColectivo);
	}
	
}