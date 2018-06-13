package negocio;


import dao.TarjetaDao;
import datos.Tarjeta;
import datos.Usuario;
public class TarjetaABM {
	private TarjetaDao dao = new TarjetaDao();

	public int agregarTarjeta(long nroTarjeta, double saldo, boolean tarifaSocial,Usuario usuario) throws Exception{
		Tarjeta c= dao.traerTarjeta2(nroTarjeta);
		if(c!=null) {
			throw new Exception("Error ya existe una tarjeta con el numero "+ nroTarjeta);
		}
		
		c = new Tarjeta (nroTarjeta,saldo,tarifaSocial,usuario);
		return dao.agregar(c);
	}

	public void modificarTarjeta(Tarjeta tarjeta) throws Exception{
		Tarjeta c = dao.traerTarjeta2(tarjeta.getNroTarjeta());
		if(c==null) {
			throw new Exception("La tarjeta "+ tarjeta.getNroTarjeta()+ " a modificar no existe");
		}
		dao.actualizar(tarjeta);
	}

	public void eliminarTarjeta(long idTarjeta) throws Exception{
		Tarjeta c = dao.traerTarjeta(idTarjeta);
		if(c==null) {
			throw new Exception("La tarjeta a eliminar con el id"+ idTarjeta+ " no existe");
		}
		dao.eliminar(c);
	}

	public Tarjeta traerTarjeta(long idTarjeta) throws Exception{
		Tarjeta c = dao.traerTarjeta(idTarjeta);
		if(c==null) {
			throw new Exception("La tarjeta a traer con el id "+ idTarjeta+ " no existe");
		}
		return c;
	}
	
	public Tarjeta traerTarjeta2(long nroTarjeta) throws Exception{
		Tarjeta c = dao.traerTarjeta2(nroTarjeta);
		if(c==null) {
			throw new Exception("La tarjeta "+ nroTarjeta+ " a eliminar no existe");
		}
		return c;
	}
	public Tarjeta traerTarjeta3(long idUsuario) {
		return dao.traerTarjeta3(idUsuario);
	}
	public double consultarSaldo(long nroTarjeta)throws Exception{
		double saldo;
		Tarjeta tarjeta = traerTarjeta2(nroTarjeta);
		saldo=tarjeta.getSaldo();
		return saldo;
	}
	
	

	


	

}
