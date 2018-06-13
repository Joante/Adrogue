package negocio;


import dao.ColectivoDao;
import datos.Colectivo;
import datos.Subte;

public class ColectivoABM {
	private ColectivoDao dao = new ColectivoDao();

	public int agregarColectivo(int tipoTransporte, String descripcion,String empresa, long linea, long interno) throws Exception{
		if(tipoTransporte!=2) {
			throw new Exception("El tipo de transporte es incorrecto");
		}
		Colectivo c = new Colectivo (tipoTransporte,descripcion,empresa,linea,interno);
		return dao.agregar(c);
	}

	public void modificarColectivo(Colectivo colectivo)throws Exception{
		Colectivo c = dao.traerColectivo(colectivo.getIdColectivo());
		if(c==null) {
			throw new Exception("El colectivo a modificar con el id "+ colectivo.getIdColectivo()+ " no existe");
		}
		dao.actualizar(colectivo);
	}

	public void eliminarColectivo(long idColectivo)throws Exception{
		Colectivo c = dao.traerColectivo(idColectivo);
		if(c==null) {
			throw new Exception("El Colectivo a eliminar con el id "+ idColectivo+ " no existe");
		}
		dao.eliminar(c);
	}

	public Colectivo traerColectivo(long idColectivo)throws Exception{
		Colectivo c= dao.traerColectivo(idColectivo);
		if(c==null) {
			throw new Exception("El Colectivo a traer con el id " +idColectivo +" es nulo");
		}
		
		return c;
	}
	
}

	


	