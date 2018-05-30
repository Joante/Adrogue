package negocio;


import dao.LineaColectivoDao;
import datos.LineaColectivo;

public class LineaColectivoABM {
	private LineaColectivoDao dao = new LineaColectivoDao();

	public int agregarColectivo(String empresa, int linea) {
		LineaColectivo c = new LineaColectivo (empresa,linea);
		return dao.agregar(c);
	}

	public void modificarLineaColectivo(LineaColectivo LineaColectivo){
		dao.actualizar(LineaColectivo);
	}

	public void eliminarLineaColectivo(long idLineaColectivo){
		LineaColectivo c = dao.traerLineaColectivo(idLineaColectivo);
		dao.eliminar(c);
	}

	public LineaColectivo traerLineaColectivo(long idLineaColectivo){
		return dao.traerLineaColectivo(idLineaColectivo);
	}
	
}