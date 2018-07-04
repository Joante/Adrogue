package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.HibernateException;
import datos.*;
import negocio.*;

public class ControladorIniciarSecion extends HttpServlet {
	protected void doGet(HttpServletRequest request , HttpServletResponse response )throws ServletException, IOException{
		procesarPeticion(request,response);
	}

	protected void doPost(HttpServletRequest request , HttpServletResponse response )throws ServletException, IOException{
		procesarPeticion( request , response );
	}
	
	protected void procesarPeticion(HttpServletRequest request , HttpServletResponse response)throws ServletException, IOException {
		response .setContentType( "text/html;charset=UTF-8" );
		
		try {
			long dni = Long.parseLong ( request . getParameter ( "dni" ));
			String password= request.getParameter("pass");
			
			UsuarioABM usuarioABM= new UsuarioABM();
			Usuario usuario = usuarioABM.accesoLogin(password,dni);
			
			TarjetaABM tarjetaABM=new TarjetaABM();
			Tarjeta tarjeta = tarjetaABM.traerTarjeta3(usuario.getIdUsuario()); 
			
			usuario.setActivo(true);
			usuarioABM.modificarUsuario(usuario);
			
			request .setAttribute( "usuario" , usuario);
			request .setAttribute( "tarjeta" , tarjeta);
			

			
			System.out.println(password);
			System.out.println(usuario.isAdmin());

			if(usuario.isAdmin()==true) {
				request .getRequestDispatcher( "/PaginaPrincipalAdmin.jsp" ).forward( request ,response );
			}
			else {
				request .getRequestDispatcher( "/PaginaPrincipal.jsp" ).forward( request ,response );
			}
		}
		catch (Exception e) {
			response.sendError(500, "El DNI o PASSWORD Ingresado no existe en la base de datos." );
		}
	
	}
}
