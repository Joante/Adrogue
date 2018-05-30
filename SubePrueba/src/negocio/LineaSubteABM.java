package negocio;



import dao.LineaSubteDao;
import datos.LineaSubte;

public class LineaSubteABM {
	private LineaSubteDao dao = new LineaSubteDao();

	public int agregarSubte(char linea) {
		LineaSubte c = new LineaSubte (linea);
		return dao.agregar(c);
	}

	public void modificarSubte(LineaSubte lineaSubte){
		dao.actualizar(lineaSubte);
	}

	public void eliminarSubte(long idSubte){
		LineaSubte c = dao.traerSubte(idSubte);
		dao.eliminar(c);
	}

	public LineaSubte traerSubte(long idSubte){
		return dao.traerSubte(idSubte);
	}
	
}

	