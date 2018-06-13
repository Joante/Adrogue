package negocio;


import java.util.Set;

import dao.TarjetaDao;
import datos.Movimiento;
import datos.Tarjeta;
import datos.Usuario;
public class TarjetaABM {
	private TarjetaDao dao = new TarjetaDao();

	public int agregarTarjeta(long nroTarjeta, double saldo, boolean tarifaSocial,Usuario usuario){
		Tarjeta c = new Tarjeta (nroTarjeta,saldo,tarifaSocial,usuario);
		return dao.agregar(c);
	}

	public void modificarTarjeta(Tarjeta tarjeta){
		dao.actualizar(tarjeta);
	}

	public void eliminarTarjeta(long idTarjeta){
		Tarjeta c = dao.traerTarjeta(idTarjeta);
		dao.eliminar(c);
	}

	public Tarjeta traerTarjeta(long idTarjeta){
		return dao.traerTarjeta(idTarjeta);
	}
	
	public Tarjeta traerTarjeta2(long nroTarjeta){
		return dao.traerTarjeta2(nroTarjeta);
	}

	
	

	


	

}
