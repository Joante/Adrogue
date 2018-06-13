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

	public void modificarTarifaTren(TarifaTren tarifaTren) throws Exception{
		TarifaTren c = dao.traerTarifaTren(tarifaTren.getIdTarifa());
		if(c==null) {
			throw new Exception("La tarifaTren a modificar con el id "+ tarifaTren.getIdTarifa()+ " no existe");
		}
		dao.actualizar(tarifaTren);
	}

	public void eliminarTarifaTren(long idTarifaTren) throws Exception{
		TarifaTren c = dao.traerTarifaTren(idTarifaTren);
		if(c==null) {
			throw new Exception("La tarifaTren a eliminar con el id "+ idTarifaTren+ " no existe");
		}
		dao.eliminar(c);
	}

	public TarifaTren traerTarifaTren(long idTarifaTren) throws Exception{
		TarifaTren c = dao.traerTarifaTren(idTarifaTren);
		if(c==null) {
			throw new Exception("La tarifaTren a traer con el id "+ idTarifaTren+ " no existe");
		}
		return c;
	}
	
	public TarifaTren traerTarifaTren(int estacionSubida, int estacionBajada) throws Exception{
		TarifaTren c = dao.traerTarifaTren(estacionSubida, estacionBajada);
		if(c==null) {
			throw new Exception("La tarifaTren con la estacionSubida "+ estacionSubida+ " estacionBajada " +estacionBajada+" no existe");
		}
		return c;
	}
}