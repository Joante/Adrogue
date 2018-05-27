package negocio;


import java.util.Set;

import dao.SubteDao;
import datos.Colectivo;
import datos.EstacionSubte;
import datos.Subte;

public class SubteABM {
	private SubteDao dao = new SubteDao();

	public int agregarSubte(int tipoTransporte, String descripcion,char linea, Set<EstacionSubte> lstEstaciones) {
		Subte c = new Subte (tipoTransporte,descripcion,linea,lstEstaciones);
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

	