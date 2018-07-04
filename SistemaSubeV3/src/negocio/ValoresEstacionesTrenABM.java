package negocio;

import dao.ValoresEstacionesTrenDao;
import datos.EstacionTren;
import datos.SeccionTren;
import datos.ValoresEstacionesTren;


public class ValoresEstacionesTrenABM {
	private ValoresEstacionesTrenDao dao = new ValoresEstacionesTrenDao();

	public int agregarValoresEstacionesTren(EstacionTren estacionSubida, EstacionTren estacionBajada, SeccionTren seccion) {
		ValoresEstacionesTren c = new ValoresEstacionesTren (estacionSubida,estacionBajada,seccion);
		return dao.agregar(c);
	}

	public void modificarValoresEstacionesTren(ValoresEstacionesTren valoresEstacionesTren) throws Exception{
		ValoresEstacionesTren c = dao.traerValoresEstacionesTren(valoresEstacionesTren.getIdValores());
		if(c==null) {
			throw new Exception("La valoresEstacionesTren a modificar con el id "+ valoresEstacionesTren.getIdValores()+ " no existe");
		}
		dao.actualizar(valoresEstacionesTren);
	}

	public void eliminarValoresEstacionesTren(long idValores) throws Exception{
		ValoresEstacionesTren c = dao.traerValoresEstacionesTren(idValores);
		if(c==null) {
			throw new Exception("La valoresEstacionesTren a eliminar con el id "+ idValores+ " no existe");
		}
		dao.eliminar(c);
	}

	public ValoresEstacionesTren traerValoresEstacionesTren(long idValores) throws Exception{
		ValoresEstacionesTren c = dao.traerValoresEstacionesTren(idValores);
		if(c==null) {
			throw new Exception("La valoresEstacionesTren a traer con el id "+ idValores+ " no existe");
		}
		return c;
	}
	
	public ValoresEstacionesTren traerValoresEstacionesTren(int estacionSubida, int estacionBajada) throws Exception{
		ValoresEstacionesTren c = dao.traerValoresEstacionesTren(estacionSubida, estacionBajada);
		if(c==null) {
			throw new Exception("La valoresEstacionesTren con la estacionSubida "+ estacionSubida+ " estacionBajada " +estacionBajada+" no existe");
		}
		return c;
	}
}