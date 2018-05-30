package negocio;
import dao.UsuarioDao;
import java.util.List;


import datos.Usuario;
public class UsuarioABM {
	private UsuarioDao dao = new UsuarioDao();

	public int agregarUsuario(String nombre, String apellido,long dni)throws Exception{
		if(dao.traerUsuarioDni(dni)!=null) {
			throw new Exception ("Error. Usuario ya ingresado");
		}
		Usuario u = new Usuario (nombre, apellido,dni);
		return dao.agregarUsuario(u);
	}

	public void modificarUsuario(Usuario usuario){
		dao.actualizarUsuario(usuario);
	}

	public void eliminarUsuario(long idUsuario){
		Usuario u = dao.traerUsuario(idUsuario);
		dao.eliminarUsuario(u);
	}

	public Usuario traerUsuario(long idUsuario){
		return dao.traerUsuario(idUsuario);
	}
	
	public Usuario traerUsuarioDni(long dni) {
		return dao.traerUsuarioDni(dni);
	}
	
	/*public List<Usuario> traerUsuario(){
		return dao.traerUsuario();
	}*/

}
