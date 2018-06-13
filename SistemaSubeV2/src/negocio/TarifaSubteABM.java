package negocio;




import java.util.List;

import dao.TarifaSubteDao;
import datos.SeccionSubte;
import datos.TarifaColectivo;
import datos.TarifaSubte;


public class TarifaSubteABM {
	private TarifaSubteDao dao = new TarifaSubteDao();

	public int agregarTarifaSubte(double valorTarifa,SeccionSubte seccion) {
		TarifaSubte c = new TarifaSubte (valorTarifa,seccion);
		return dao.agregar(c);
	}

	public void modificarTarifaSubte(TarifaSubte tarifaSubte) throws Exception{
		TarifaSubte c = dao.traerTarifaSubte(tarifaSubte.getIdTarifa());
		if(c==null) {
			throw new Exception("La tarifaSubte a modificar con el id "+ tarifaSubte.getIdTarifa()+ " no existe");
		}
		dao.actualizar(tarifaSubte);
	}

	public void eliminarTarifaSubte(long idTarifaSubte) throws Exception{
		TarifaSubte c = dao.traerTarifaSubte(idTarifaSubte);
		if(c==null) {
			throw new Exception("La tarifaSubte a eliminar con el id "+ idTarifaSubte+ " no existe");
		}
		dao.eliminar(c);
	}

	public TarifaSubte traerTarifaSubte(long idTarifaSubte)throws Exception{
		TarifaSubte c = dao.traerTarifaSubte(idTarifaSubte);
		if(c==null) {
			throw new Exception("La tarifaSubte a eliminar con el id "+ idTarifaSubte+ " no existe");
		}
		return c;
	}

	
	public List<TarifaSubte> traerTarifaSubte() throws Exception{
		List<TarifaSubte> lstTarifas= dao.traerTarifaSubte();
		if(lstTarifas==null) {
			throw new Exception("No hay ninguna tarifaSubte agregada");
		}
		return lstTarifas;
		
	}
	public TarifaSubte calcularTarifaSubteComun(int cantViajes) throws Exception {
		SeccionSubteABM seccionSubteAbm = new SeccionSubteABM();
		SeccionSubte seccion = seccionSubteAbm.traerSeccionSubte(cantViajes);
		TarifaSubte tarifa=new TarifaSubte();
		tarifa.setSeccion(seccion);
		tarifa.setValorTarifa(seccion.getValorSubteNormal());
		dao.agregar(tarifa);
		return tarifa;
	}
	public TarifaSubte calcularTarifaSubteTarifaSocal(int cantViajes) throws Exception {
		SeccionSubteABM seccionSubteAbm = new SeccionSubteABM();
		SeccionSubte seccion = seccionSubteAbm.traerSeccionSubte(cantViajes);
		TarifaSubte tarifa=new TarifaSubte();
		tarifa.setSeccion(seccion);
		tarifa.setValorTarifa(seccion.getValorSubteTarifaSocial());
		dao.agregar(tarifa);
		return tarifa;
	}
	
}