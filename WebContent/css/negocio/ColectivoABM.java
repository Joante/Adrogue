package negocio;


import dao.ColectivoDao;
import datos.Colectivo;

public class ColectivoABM {
	private ColectivoDao dao = new ColectivoDao();

	public int agregarColectivo(int tipoTransporte, String descripcion,String empresa, long linea, long interno) {
		Colectivo c = new Colectivo (tipoTransporte,descripcion,empresa,linea,interno);
		return dao.agregar(c);
	}

	public void modificarColectivo(Colectivo colectivo){
		dao.actualizar(colectivo);
	}

	public void eliminarColectivo(long idColectivo){
		Colectivo c = dao.traerColectivo(idColectivo);
		dao.eliminar(c);
	}

	public Colectivo traerColectivo(long idColectivo){
		return dao.traerColectivo(idColectivo);
	}
	
}

	


	