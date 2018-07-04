package negocio;


import java.util.Set;

import dao.SubteDao;
import datos.Colectivo;
import datos.EstacionSubte;
import datos.SeccionTren;
import datos.Subte;

public class SubteABM {
	private SubteDao dao = new SubteDao();

	public int agregarSubte(int tipoTransporte, String descripcion,char linea) throws Exception{
		if(tipoTransporte!=3) {
			throw new Exception("El tipo de transporte es incorrecto");
		}
		Subte c = new Subte (tipoTransporte,descripcion,linea);
		return dao.agregar(c);
	}

	public void modificarSubte(Subte subte)throws Exception{
		Subte c = dao.traerSubte(subte.getIdSubte());
		if(c==null) {
			throw new Exception("El subte a modificar con el id "+ subte.getIdSubte()+ " no existe");
		}
		dao.actualizar(subte);
	}

	public void eliminarSubte(long idSubte)throws Exception{
		Subte c = dao.traerSubte(idSubte);
		if(c==null) {
			throw new Exception("El subte a eliminar con el id "+ idSubte+ " no existe");
		}
		dao.eliminar(c);
	}

	public Subte traerSubte(long idSubte)throws Exception{
		Subte c = dao.traerSubte(idSubte);
		if(c==null) {
			throw new Exception("El subte a traer con el id "+ idSubte+ " no existe");
		}
		return dao.traerSubte(idSubte);
	}
	
}

	