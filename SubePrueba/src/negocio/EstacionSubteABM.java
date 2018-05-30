package negocio;


import dao.EstacionSubteDao;
import datos.EstacionSubte;
import datos.LineaSubte;
public class EstacionSubteABM {
	private EstacionSubteDao dao = new EstacionSubteDao();

	public int agregarEstacionSubte(String nombre, LineaSubte lineaSubte){
		EstacionSubte c = new EstacionSubte (nombre, lineaSubte);
		return dao.agregar(c);
	}

	public void modificarEstacionSubte(EstacionSubte estacionSubte){
		dao.actualizar(estacionSubte);
	}

	public void eliminarEstacionSubte(long idEstacionSubte){
		EstacionSubte c = dao.traerEstacionSubte(idEstacionSubte);
		dao.eliminar(c);
	}

	public EstacionSubte traerEstacionSubte(long idEstacionSubte){
		return dao.traerEstacionSubte(idEstacionSubte);
	}
	
	

	/*public List<EstacionSubte> traerEstacionSubte(){
		return dao.traerEstacionSubte();
	}*/


	

}


