package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Tarjeta;
import datos.Usuario;
import negocio.TarjetaABM;
import negocio.UsuarioABM;

public class ControladorCerrarSesion extends HttpServlet {
	protected void doGet(HttpServletRequest request , HttpServletResponse response )throws ServletException, IOException{
		procesarPeticion(request,response);
	}

	protected void doPost(HttpServletRequest request , HttpServletResponse response )throws ServletException, IOException{
		procesarPeticion( request , response );
	}
	
	protected void procesarPeticion(HttpServletRequest request , HttpServletResponse response)throws ServletException, IOException {
		response .setContentType( "text/html;charset=UTF-8" );
		
		try {


			UsuarioABM usuarioABM= new UsuarioABM();
			
			Usuario usuarioAux = usuarioABM.traerUsuario3(true);
			
			usuarioAux.setActivo(false);
			usuarioABM.modificarUsuario(usuarioAux);


			
			request .getRequestDispatcher( "/Login.jsp" ).forward( request ,response );
			
		}
		catch (Exception e) {
			response.sendError(500, "El DNI o PASSWORD Ingresado no existe en la base de datos." );
		}
	
	}
}
