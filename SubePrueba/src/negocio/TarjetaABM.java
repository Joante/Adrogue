package negocio;


import java.util.Set;

import dao.TarjetaDao;
import datos.Tarjeta;
import datos.Usuario;
public class TarjetaABM {
	private TarjetaDao dao = new TarjetaDao();

	public int agregarTarjeta(long nroTarjeta, double saldo, boolean tarifaSocial,Usuario usuario){
		Tarjeta c = new Tarjeta (nroTarjeta,saldo,tarifaSocial,usuario);
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
	public Tarjeta traerTarjetaNro(long nroTarjeta) throws Exception{
		if (dao.traerTarjetaNro(nroTarjeta)==null) {
			throw new Exception("Error tarjeta no existente");
		} else {
			return dao.traerTarjetaNro(nroTarjeta);
		}
	}
	public void descontarSaldo(long nroTarjeta, double valor)throws Exception {
		Tarjeta tarjeta= dao.traerTarjetaNro(nroTarjeta);
		double saldo=tarjeta.getSaldo();
		if((saldo-valor)<-20.0) {
			throw new Exception("Saldo Insuficiente");
		}
		else {
			saldo=saldo-valor;
			tarjeta.setSaldo(saldo);
			dao.actualizar(tarjeta);
		}
	}
	public void agregarSaldo(long nroTarjeta, double valor, boolean recarga)throws Exception {
		Tarjeta tarjeta= dao.traerTarjetaNro(nroTarjeta);
		double saldo=tarjeta.getSaldo();
		if(recarga) {
			if((saldo+valor)<-20.0) {
				throw new Exception("Recarga Insuficiente");
			}
		}
		saldo=saldo+valor;
		tarjeta.setSaldo(saldo);
		dao.actualizarSaldo(tarjeta);
	}
}
