package controladores;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Tarjeta;
import datos.Transporte;
import datos.Usuario;
import negocio.MovimientoABM;
import negocio.TarjetaABM;
import negocio.TransporteABM;
import negocio.UsuarioABM;

public class ControladorMovimientoRecarga extends HttpServlet {
	protected void doGet(HttpServletRequest request , HttpServletResponse response )throws ServletException, IOException{
		procesarPeticion(request,response);
	}

	protected void doPost(HttpServletRequest request , HttpServletResponse response )throws ServletException, IOException{
		procesarPeticion( request , response );
	}
	
	protected void procesarPeticion(HttpServletRequest request , HttpServletResponse response)throws ServletException, IOException {
		response .setContentType( "text/html;charset=UTF-8" );
		
		try {

			int año = Integer.parseInt ( request . getParameter ( "anio4" ));
			int mes = Integer.parseInt ( request . getParameter ( "mes4" ));
			int dia = Integer.parseInt ( request . getParameter ( "dia4" ));
			int hora = Integer.parseInt ( request . getParameter ( "hora4" ));
			int minutos = Integer.parseInt ( request . getParameter ( "minutos4" ));
			
			double monto = Integer.parseInt ( request . getParameter ( "monto" ));

			
			GregorianCalendar fecha = new GregorianCalendar(año,mes,dia,hora,minutos);
			
			MovimientoABM movimientoABM = new MovimientoABM();
			UsuarioABM usuarioABM = new UsuarioABM();
			
			Usuario usuario = usuarioABM.traerUsuario3(true);
			System.out.println(usuario);
			TarjetaABM tarjetaABM = new TarjetaABM();
			Tarjeta tarjeta=tarjetaABM.traerTarjeta3(usuario.getIdUsuario());

			movimientoABM.agregarMovimientoRecarga(fecha, tarjeta.getNroTarjeta(), monto);
				
			
			if(usuario.isAdmin()) {
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
