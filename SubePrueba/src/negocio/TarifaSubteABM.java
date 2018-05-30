package negocio;




import dao.TarifaSubteDao;
import datos.SeccionSubte;
import datos.TarifaSubte;


public class TarifaSubteABM {
	private TarifaSubteDao dao = new TarifaSubteDao();

	public int agregarTarifaSubte(double valorTarifa,SeccionSubte seccion) {
		TarifaSubte c = new TarifaSubte (valorTarifa,seccion);
		return dao.agregar(c);
	}

	public void modificarTarifaSubte(TarifaSubte tarifaSubte){
		dao.actualizar(tarifaSubte);
	}

	public void eliminarTarifaSubte(long idTarifaSubte){
		TarifaSubte c = dao.traerTarifaSubte(idTarifaSubte);
		dao.eliminar(c);
	}

	public TarifaSubte traerTarifaSubte(long idTarifaSubte){
		return dao.traerTarifaSubte(idTarifaSubte);
	}
	public TarifaSubte calcularTarifaSubteComun(int cantViajes) {
		SeccionSubteABM seccionSubteAbm = new SeccionSubteABM();
		SeccionSubte seccion = seccionSubteAbm.traerSeccionSubte(cantViajes);
		TarifaSubte tarifa=new TarifaSubte();
		tarifa.setSeccion(seccion);
		tarifa.setValorTarifa(seccion.getValorSubteNormal());
		return tarifa;
	}
	public TarifaSubte calcularTarifaSubteTarifaSocal(int cantViajes) {
		SeccionSubteABM seccionSubteAbm = new SeccionSubteABM();
		SeccionSubte seccion = seccionSubteAbm.traerSeccionSubte(cantViajes);
		TarifaSubte tarifa=new TarifaSubte();
		tarifa.setSeccion(seccion);
		tarifa.setValorTarifa(seccion.getValorSubteTarifaSocial());
		return tarifa;
	}
}