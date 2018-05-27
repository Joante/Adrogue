package negocio;


import dao.EstacionTrenDao;
import datos.EstacionTren;
import datos.LineaTren;
public class EstacionTrenABM {
	private EstacionTrenDao dao = new EstacionTrenDao();

	public int agregarEstacionTren(String nombre, LineaTren lineaTren){
		EstacionTren c = new EstacionTren(nombre,lineaTren);
		return dao.agregar(c);
	}

	public void modificarEstacionTren(EstacionTren estacionTren){
		dao.actualizar(estacionTren);
	}

	public void eliminarEstacionTren(long idEstacionTren){
		EstacionTren c = dao.traerEstacionTren(idEstacionTren);
		dao.eliminar(c);
	}

	public EstacionTren traerEstacionTren(long idEstacionTren){
		return dao.traerEstacionTren(idEstacionTren);
	}
	
	

	/*public List<EstacionTren> traerEstacionTren(){
		return dao.traerEstacionTren();
	}*/


	

}


