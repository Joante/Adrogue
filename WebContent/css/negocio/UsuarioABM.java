package negocio;
import dao.UsuarioDao;



import datos.Usuario;
public class UsuarioABM {
	private UsuarioDao dao = new UsuarioDao();

	public int agregarUsuario(String nombre, String apellido,
			long dni, String password){
		Usuario u = new Usuario (nombre, apellido,dni,password);
		return dao.agregar(u);
	}

	public void modificarUsuario(Usuario usuario){
		dao.actualizar(usuario);
	}

	public void eliminarUsuario(long idUsuario){
		Usuario u = dao.traerUsuario(idUsuario);
		dao.eliminar(u);
	}

	public Usuario traerUsuario(long idUsuario){
		return dao.traerUsuario(idUsuario);
	}
	
	public Usuario traerUsuario2(long dni){
		return dao.traerUsuario2(dni);
	}
	
	
	public Usuario traerUsuario3(String pass){
		return dao.traerUsuario3(pass);
	}
	/*public List<Usuario> traerUsuario(){
		return dao.traerUsuario();
	}*/

}
