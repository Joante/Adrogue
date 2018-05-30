package negocio;


import dao.SubteDao;
import datos.LineaSubte;
import datos.Subte;

public class SubteABM {
	private SubteDao dao = new SubteDao();

	public int agregarSubte(int tipoTransporte, String descripcion, LineaSubte lineaSubte) {
		Subte c = new Subte (tipoTransporte,descripcion,lineaSubte);
		return dao.agregar(c);
	}

	public void modificarSubte(Subte subte){
		dao.actualizar(subte);
	}

	public void eliminarSubte(long idSubte){
		Subte c = dao.traerSubte(idSubte);
		dao.eliminar(c);
	}

	public Subte traerSubte(long idSubte){
		return dao.traerSubte(idSubte);
	}
	
}
