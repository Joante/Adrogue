package negocio;
import dao.UsuarioDao;
import java.util.List;


import datos.Usuario;
public class UsuarioABM {
	private UsuarioDao dao = new UsuarioDao();

	public int agregarUsuario(String nombre, String apellido,
			long dni){
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
	
	
	
	/*public List<Usuario> traerUsuario(){
		return dao.traerUsuario();
	}*/

}
