package negocio;



import dao.TarifaTrenDao;
import datos.EstacionTren;
import datos.SeccionTren;
import datos.Tarifa;
import datos.TarifaTren;
import datos.Tarjeta;


public class TarifaTrenABM {
	private TarifaTrenDao dao = new TarifaTrenDao();
	private SeccionTrenABM seccionTrenAbm = new SeccionTrenABM();
	private EstacionTrenABM estacionTrenAbm = new EstacionTrenABM();
	private TarifaTren tarifaTren = new TarifaTren();
	private TarjetaABM tarjetaAbm = new TarjetaABM();

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
	public Tarifa calcularTarifaTrenComun (long estacionSubida, Tarjeta tarjeta,int estacionBajada) throws Exception {
		Tarifa c = null;
		//if(tarjeta.isCobroOdevolucionTren()) {
			tarifaTren=dao.traerSeccion(estacionSubida, estacionBajada);
			tarifaTren.setValorTarifa(seccionTrenAbm.traerValorSeccionComun((long) tarifaTren.getSeccion().getValorSeccionComun()));
			
			
		/*} else
		{
			tarifaTren=dao.traerUltima();
			tarifaTren.setEstacionBajada(estacionTrenAbm.traerEstacionTren(estacion));
			tarifa=dao.traerSeccion(tarifaTren.getEstacionSubida(), tarifaTren.getEstacionBajada());
			tarifaTren.setValorTarifa(seccionTrenAbm.traerValorSeccionComun(tarifa.getSeccion().getIdSeccionTren()));
		}*/
		c = (Tarifa) tarifaTren;
		return c;
	}
	public Tarifa calcularTarifaTrenTarifaSocial (long estacionSubida,Tarjeta tarjeta,int estacionBajada) throws Exception {
		Tarifa c = null;
		//TarifaTren tarifa;
		//if(tarifaTren.isCobroViaje()) {
			tarifaTren=dao.traerSeccion(estacionSubida, estacionBajada);
			tarifaTren.setValorTarifa(tarifaTren.getSeccion().getValorSeccionTarifaSocial());
		//} else
		/*{
			tarifaTren.setEstacionBajada(estacionTrenAbm.traerEstacionTren(estacion));
			tarifa=dao.traerSeccion(tarifaTren.getEstacionSubida(), tarifaTren.getEstacionBajada());
			tarifaTren.setValorTarifa(seccionTrenAbm.traerValorSeccionTarifaSocial(tarifa.getSeccion().getIdSeccionTren()));
			tarifaTren.setCobroViaje(false);
		}*/
		c = (Tarifa) tarifaTren;
		return c;
	}
}