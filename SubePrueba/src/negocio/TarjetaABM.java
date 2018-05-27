package negocio;


import java.util.Set;

import dao.TarjetaDao;
import datos.Movimiento;
import datos.Tarjeta;
import datos.Usuario;
public class TarjetaABM {
	private TarjetaDao dao = new TarjetaDao();

	public int agregarTarjeta(long nroTarjeta, double saldo, boolean tarifaSocial,Usuario usuario,Set<Movimiento> lstMovimientos){
		Tarjeta c = new Tarjeta (nroTarjeta,saldo,tarifaSocial,usuario,lstMovimientos);
		return dao.agregar(c);
	}

	public void modificarTarjeta(Tarjeta transporte){
		dao.actualizar(transporte);
	}

	public void eliminarTarjeta(long idTarjeta){
		Tarjeta c = dao.traerTarjeta(idTarjeta);
		dao.eliminar(c);
	}

	public Tarjeta traerTarjeta(long idTarjeta){
		return dao.traerTarjeta(idTarjeta);
	}
	
	

	


	

}
