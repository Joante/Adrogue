package negocio;


import dao.LineaTrenDao;
import datos.LineaTren;

public class LineaTrenABM {
	private LineaTrenDao dao = new LineaTrenDao();

	public int agregarLineaTren(String nombreLinea) {
		LineaTren c = new LineaTren (nombreLinea);
		return dao.agregar(c);
	}

	public void modificarLineaTren(LineaTren lineaTren) throws Exception{
		LineaTren c = dao.traerLineaTren(lineaTren.getIdLineaTren());
		if(c==null) {
			throw new Exception("La estacion a eliminar con el id "+ lineaTren.getIdLineaTren()+ " no existe");
		}
		dao.actualizar(lineaTren);
	}

	public void eliminarLineaTren(long idLineaTren)throws Exception{
		LineaTren c = dao.traerLineaTren(idLineaTren);
		if(c==null) {
			throw new Exception("La estacion a eliminar con el id "+ idLineaTren+ " no existe");
		}
		dao.eliminar(c);
	}

	public LineaTren traerLineaTren(long idLineaTren)throws Exception{
		LineaTren c = dao.traerLineaTren(idLineaTren);
		if(c==null) {
			throw new Exception("La estacion a traer con el id "+ idLineaTren+ " no existe");
		}
		return dao.traerLineaTren(idLineaTren);
	}
	
}

	


	