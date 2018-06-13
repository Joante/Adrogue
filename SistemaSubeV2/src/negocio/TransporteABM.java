package negocio;


import dao.TransporteDao;
import datos.Transporte;
public class TransporteABM {
	private TransporteDao dao = new TransporteDao();

	public int agregarTransporte(int tipoTransporte, String descripcion){
		Transporte c = new Transporte (tipoTransporte,descripcion);
		return dao.agregar(c);
	}

	public void modificarTransporte(Transporte transporte){
		dao.actualizar(transporte);
	}

	public void eliminarTransporte(long idTransporte){
		Transporte c = dao.traerTransporte(idTransporte);
		dao.eliminar(c);
	}

	public Transporte traerTransporte(long idTransporte){
		return dao.traerTransporte(idTransporte);
	}
	
	

	


	

}
