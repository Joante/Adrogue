package negocio;


import dao.EstacionTrenDao;
import datos.EstacionTren;
import datos.LineaTren;
public class EstacionTrenABM {
	private EstacionTrenDao dao = new EstacionTrenDao();

	public int agregarEstacionTren(String nombre, LineaTren lineaTren){
		EstacionTren c= new EstacionTren(nombre,lineaTren);
		return dao.agregar(c);
	}

	public void modificarEstacionTren(EstacionTren estacionTren){
		dao.actualizar(estacionTren);
	}

	public void eliminarEstacionTren(long idEstacionTren)throws Exception{
		EstacionTren c = dao.traerEstacionTren(idEstacionTren);
		if(c==null) {
			throw new Exception("La estacion a eliminar con el id "+idEstacionTren+" no existe");
		}
		dao.eliminar(c);
	}

	public EstacionTren traerEstacionTren(long idEstacionTren)throws Exception{
		EstacionTren c = dao.traerEstacionTren(idEstacionTren);
		if(c==null) {
			throw new Exception("La estacion a traer con el id "+idEstacionTren+" no existe");
		}
		return dao.traerEstacionTren(idEstacionTren);
	}
	
	

	/*public List<EstacionTren> traerEstacionTren(){
		return dao.traerEstacionTren();
	}*/


	

}


