package negocio;



import dao.TarifaTrenDao;
import datos.EstacionTren;
import datos.SeccionTren;
import datos.TarifaTren;
import datos.ValoresEstacionesTren;


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
	public TarifaTren traerUltima () {
		return dao.traerUltima();
	}
	public TarifaTren calcularCobroValorNormal(long EstacionSubida) throws Exception {
		
		SeccionTrenABM seccionTrenAbm = new SeccionTrenABM();
		SeccionTren seccion = seccionTrenAbm.traerMaxima();
		EstacionTrenABM estacionTren = new EstacionTrenABM();
		EstacionTren estacion = estacionTren.traerEstacionTren(EstacionSubida);
		TarifaTren tarifa = new TarifaTren(seccion.getValorSeccionComun(),estacion,estacion,seccion);
		dao.agregar(tarifa);
		return tarifa;
	}
	
	public TarifaTren calcularCobroValorTarifaSocial(long EstacionSubida) throws Exception {
		
		SeccionTrenABM seccionTrenAbm = new SeccionTrenABM();
		SeccionTren seccion = seccionTrenAbm.traerMaxima();
		EstacionTrenABM estacionTren = new EstacionTrenABM();
		EstacionTren estacion = estacionTren.traerEstacionTren(EstacionSubida);
		TarifaTren tarifa = new TarifaTren(seccion.getValorSeccionTarifaSocial(),estacion,estacion,seccion);
		dao.agregar(tarifa);
		return tarifa;
	}
	
	public TarifaTren calcularDevolucionNormal (int estacionSubida,int estacionBajada) throws Exception{
		
		SeccionTrenABM seccionTrenAbm = new SeccionTrenABM();
		SeccionTren seccionMaxima = seccionTrenAbm.traerMaxima();
		ValoresEstacionesTrenABM valoresAbm = new ValoresEstacionesTrenABM();
		ValoresEstacionesTren valores = valoresAbm.traerValoresEstacionesTren(estacionSubida, estacionBajada);
		SeccionTren seccionDevolucion = seccionTrenAbm.traerSeccionTren(valores.getSeccion().getIdSeccionTren());
		double valorDevolucion = (seccionMaxima.getValorSeccionComun()-seccionDevolucion.getValorSeccionComun())*-1;
		EstacionTrenABM estacionTrenAbm = new EstacionTrenABM();
		EstacionTren estacionSubida1 = estacionTrenAbm.traerEstacionTren(estacionSubida);
		EstacionTren estacionBajada1 = estacionTrenAbm.traerEstacionTren(estacionBajada);
		TarifaTren tarifa = new TarifaTren(valorDevolucion, estacionSubida1,estacionBajada1,seccionDevolucion);
		dao.agregar(tarifa);
		return tarifa;
	}
	public TarifaTren calcularDevolucionTarifaSocial (int estacionSubida, int estacionBajada) throws Exception{
		
		SeccionTrenABM seccionTrenAbm = new SeccionTrenABM();
		SeccionTren seccionMaxima = seccionTrenAbm.traerMaxima();
		ValoresEstacionesTrenABM valoresAbm = new ValoresEstacionesTrenABM();
		ValoresEstacionesTren valores = valoresAbm.traerValoresEstacionesTren(estacionSubida, estacionBajada);
		SeccionTren seccionDevolucion = seccionTrenAbm.traerSeccionTren(valores.getSeccion().getIdSeccionTren());
		double valorDevolucion = (seccionMaxima.getValorSeccionTarifaSocial()-seccionDevolucion.getValorSeccionTarifaSocial())*-1;
		EstacionTrenABM estacionTrenAbm = new EstacionTrenABM();
		EstacionTren estacionSubida1 = estacionTrenAbm.traerEstacionTren(estacionSubida);
		EstacionTren estacionBajada1 = estacionTrenAbm.traerEstacionTren(estacionBajada);
		TarifaTren tarifa = new TarifaTren(valorDevolucion, estacionSubida1,estacionBajada1,seccionDevolucion);
		dao.agregar(tarifa);
		return tarifa;
	}
}