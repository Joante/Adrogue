package negocio;

import dao.TarifaDao;

import datos.Tarifa;

public class TarifaABM {
	private TarifaDao dao = new TarifaDao();

	public int agregarTarifa(double valorTarifa){
		Tarifa c = new Tarifa (valorTarifa);
		return dao.agregar(c);
	}

	public void modificarTarifa(Tarifa tarifa)throws Exception{
		Tarifa c = dao.traerTarifa(tarifa.getIdTarifa());
		if(c==null) {
			throw new Exception("La tarifa a modificar con el id "+ tarifa.getIdTarifa()+ " no existe");
		}
		
		dao.actualizar(tarifa);
	}

	public void eliminarTarifa(long idTarifa)throws Exception{
		Tarifa c = dao.traerTarifa(idTarifa);
		if(c==null) {
			throw new Exception("La tarifa a eliminar con el id "+ idTarifa+ " no existe");
		}
		
		dao.eliminar(c);
	}

	public Tarifa traerTarifa(long idTarifa)throws Exception{
		Tarifa c = dao.traerTarifa(idTarifa);
		if(c==null) {
			throw new Exception("La tarifa a traer con el id "+ idTarifa+ " no existe");
		}
		return dao.traerTarifa(idTarifa);
	}
	public Tarifa traerUltima() {
		return dao.traerUltima();
	}
	
	
}
	


	
