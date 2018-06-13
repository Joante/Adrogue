package negocio;


import dao.EstacionSubteDao;
import datos.Colectivo;
import datos.EstacionSubte;
public class EstacionSubteABM {
	private EstacionSubteDao dao = new EstacionSubteDao();

	public int agregarEstacionSubte(String nombre) throws Exception{
		EstacionSubte c = dao.traerEstacionSubte(nombre);
		if(c!=null) {
			throw new Exception("Ya hay una estacion con el nombre "+ nombre);
		}
		c= new EstacionSubte(nombre);
		return dao.agregar(c);
	}

	public void modificarEstacionSubte(EstacionSubte estacionSubte){
		dao.actualizar(estacionSubte);
	}

	public void eliminarEstacionSubte(long idEstacionSubte)throws Exception{
		EstacionSubte c = dao.traerEstacionSubte(idEstacionSubte);
		if(c==null) {
			throw new Exception("La estacion a eliminar con el id "+idEstacionSubte+ " no existe");
		}
		dao.eliminar(c);
	}

	public EstacionSubte traerEstacionSubte(long idEstacionSubte)throws Exception{
		EstacionSubte c= dao.traerEstacionSubte(idEstacionSubte);
		if(c==null) {
			throw new Exception("La estacion a traer con el id "+ idEstacionSubte+ " no existe");
		}
		
		return dao.traerEstacionSubte(idEstacionSubte);
	}
	
	

	/*public List<EstacionSubte> traerEstacionSubte(){
		return dao.traerEstacionSubte();
	}*/


	

}


