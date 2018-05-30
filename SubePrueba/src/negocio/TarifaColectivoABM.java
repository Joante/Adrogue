package negocio;



import dao.TarifaColectivoDao;
import datos.SeccionColectivo;
import datos.TarifaColectivo;


public class TarifaColectivoABM {
	private TarifaColectivoDao dao = new TarifaColectivoDao();

	public int agregarTarifaColectivo(double valorTarifa, SeccionColectivo seccion) {
		TarifaColectivo c = new TarifaColectivo (valorTarifa,seccion);
		return dao.agregar(c);
	}

	public void modificarTarifaColectivo(TarifaColectivo tarifaColectivo){
		dao.actualizar(tarifaColectivo);
	}

	public void eliminarTarifaColectivo(long idTarifaColectivo){
		TarifaColectivo c = dao.traerTarifaColectivo(idTarifaColectivo);
		dao.eliminar(c);
	}

	public TarifaColectivo traerTarifaColectivo(long idTarifaColectivo){
		return dao.traerTarifaColectivo(idTarifaColectivo);
	}
	public TarifaColectivo calcularTarifaColectivoComun(int seccion) {
		SeccionColectivoABM seccionAbm = new SeccionColectivoABM();
		TarifaColectivo tarifa= new TarifaColectivo();
		tarifa.setSeccion(seccionAbm.traerSeccionColectivo(seccion));
		tarifa.setValorTarifa(tarifa.getSeccion().getValorSeccionComun());
		
		return tarifa;
	}
	public TarifaColectivo calcularTarifaColectivoTarifaSocial(int seccion) {
		SeccionColectivoABM seccionAbm = new SeccionColectivoABM();
		TarifaColectivo tarifa= new TarifaColectivo();
		tarifa.setSeccion(seccionAbm.traerSeccionColectivo(seccion));
		tarifa.setValorTarifa(tarifa.getSeccion().getValorSeccionTarifaSocial());
		
		return tarifa;
	}
	
}