package negocio;
import dao.UsuarioDao;



import datos.Usuario;
public class UsuarioABM {
	private UsuarioDao dao = new UsuarioDao();

	public int agregarUsuario(String nombre, String apellido,
			long dni, String password) throws Exception{
		Usuario u= dao.traerUsuario2(dni);
		if(u!=null) {
			throw new Exception("No se puede agregar un usuario con mismo dni");
		}
		u = new Usuario (nombre, apellido,dni,password);
		return dao.agregar(u);
	}

	public void modificarUsuario(Usuario usuario) throws Exception{
		Usuario u= dao.traerUsuario(usuario.getIdUsuario());
		if(u==null) {
			throw new Exception("El usuario a modificar no existe");
		}
		dao.actualizar(usuario);
	}

	public void eliminarUsuario(long idUsuario) throws Exception{
		Usuario u = dao.traerUsuario(idUsuario);
		if(u==null) {
			throw new Exception("El usuario a eliminar no existe");
		}
		dao.eliminar(u);
	}

	public Usuario traerUsuario(long idUsuario) throws Exception{
		Usuario u = dao.traerUsuario(idUsuario);
		if(u==null) {
			throw new Exception("El usuario a traer con el id "+ idUsuario+ " no existe");
		}
		return u;
	}
	
	public Usuario traerUsuario2(long dni){
		return dao.traerUsuario2(dni);
	}
	
	
	public Usuario accesoLogin(String pass,long dni){
		return dao.accesoLogin(pass,dni);
	}
	/*public List<Usuario> traerUsuario(){
		return dao.traerUsuario();
	}*/

}
