package negocio;


import dao.ColectivoDao;
import dao.LineaColectivoDao;
import datos.Colectivo;
import datos.LineaColectivo;
import datos.LineaTren;
import datos.Tren;

public class ColectivoABM {
	private ColectivoDao dao = new ColectivoDao();

	public int agregarColectivo(int tipoTransporte, String descripcion,long interno, LineaColectivo lineaColectivo) {
		Colectivo c = new Colectivo (tipoTransporte, descripcion,interno,lineaColectivo);
		return dao.agregar(c);
	}

	public void modificarColectivo(Colectivo Colectivo){
		dao.actualizar(Colectivo);
	}

	public void eliminarColectivo(long idColectivo){
		Colectivo c = dao.traerColectivo(idColectivo);
		dao.eliminar(c);
	}

	public Colectivo traerColectivo(long idColectivo){
		return dao.traerColectivo(idColectivo);
	}
	
}