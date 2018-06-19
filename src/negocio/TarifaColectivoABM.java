package negocio;



import java.util.List;

import dao.TarifaColectivoDao;
import datos.SeccionColectivo;
import datos.TarifaColectivo;


public class TarifaColectivoABM {
	private TarifaColectivoDao dao = new TarifaColectivoDao();

	public int agregarTarifaColectivo(double valorTarifa, SeccionColectivo seccion) {
		TarifaColectivo c = new TarifaColectivo (valorTarifa,seccion);
		return dao.agregar(c);
	}

	public void modificarTarifaColectivo(TarifaColectivo tarifaColectivo) throws Exception{
		TarifaColectivo c = dao.traerTarifaColectivo(tarifaColectivo.getIdTarifa());
		if(c==null) {
			throw new Exception("La tarifa a modificar con el id "+ tarifaColectivo.getIdTarifa()+ " no existe");
		}
		dao.actualizar(tarifaColectivo);
	}

	public void eliminarTarifaColectivo(long idTarifaColectivo)throws Exception{
		TarifaColectivo c = dao.traerTarifaColectivo(idTarifaColectivo);
		if(c==null) {
			throw new Exception("La tarifa a eliminar con el id "+ idTarifaColectivo+ " no existe");
		}
		dao.eliminar(c);
	}

	public TarifaColectivo traerTarifaColectivo(long idTarifaColectivo)throws Exception{
		TarifaColectivo c = dao.traerTarifaColectivo(idTarifaColectivo);
		if(c==null) {
			throw new Exception("La tarifa a traer con el id "+ idTarifaColectivo+ " no existe");
		}
		return dao.traerTarifaColectivo(idTarifaColectivo);
	}
	public List<TarifaColectivo> traerTarifaColectivo()throws Exception{
		List<TarifaColectivo> lstTarifas= dao.traerTarifaColectivo();
		if(lstTarifas==null) {
			throw new Exception("No hay ninguna tarifaColecito agregada");
		}
		return lstTarifas;
	}
	public TarifaColectivo calcularTarifaColectivoComun(int seccion) throws Exception {
		SeccionColectivoABM seccionAbm = new SeccionColectivoABM();
		TarifaColectivo tarifa= new TarifaColectivo();
		tarifa.setSeccion(seccionAbm.traerSeccionColectivo(seccion));
		tarifa.setValorTarifa(tarifa.getSeccion().getValorSeccionComun());
		dao.agregar(tarifa);
		return tarifa;
	}
	public TarifaColectivo calcularTarifaColectivoTarifaSocial(int seccion) throws Exception {
		SeccionColectivoABM seccionAbm = new SeccionColectivoABM();
		TarifaColectivo tarifa= new TarifaColectivo();
		tarifa.setSeccion(seccionAbm.traerSeccionColectivo(seccion));
		tarifa.setValorTarifa(tarifa.getSeccion().getValorSeccionTarifaSocial());
		dao.agregar(tarifa);
		return tarifa;
	}
}