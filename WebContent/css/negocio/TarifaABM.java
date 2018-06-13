package negocio;

import dao.TarifaDao;
import datos.Tarifa;

public class TarifaABM {
	private TarifaDao dao = new TarifaDao();

	public int agregarTarifa(double valorTarifa){
		Tarifa c = new Tarifa (valorTarifa);
		return dao.agregar(c);
	}

	public void modificarTarifa(Tarifa transporte){
		dao.actualizar(transporte);
	}

	public void eliminarTarifa(long idTarifa){
		Tarifa c = dao.traerTarifa(idTarifa);
		dao.eliminar(c);
	}

	public Tarifa traerTarjeta(long idTarifa){
		return dao.traerTarifa(idTarifa);
	}
	
	
}
	


	
