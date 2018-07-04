package controladores;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Tarjeta;
import datos.Usuario;
import negocio.MovimientoABM;
import negocio.TarjetaABM;
import negocio.UsuarioABM;

public class ControladorMovimientoTren extends HttpServlet {
	protected void doGet(HttpServletRequest request , HttpServletResponse response )throws ServletException, IOException{
		procesarPeticion(request,response);
	}

	protected void doPost(HttpServletRequest request , HttpServletResponse response )throws ServletException, IOException{
		procesarPeticion( request , response );
	}
	
	protected void procesarPeticion(HttpServletRequest request , HttpServletResponse response)throws ServletException, IOException {
		response .setContentType( "text/html;charset=UTF-8" );
		
		try {
			int estacionS = Integer.parseInt ( request . getParameter ( "estacionS" ));
			int estacionB = Integer.parseInt ( request . getParameter ( "estacionB" ));
			int año = Integer.parseInt ( request . getParameter ( "anio" ));
			int mes = Integer.parseInt ( request . getParameter ( "mes" ));
			int dia = Integer.parseInt ( request . getParameter ( "dia" ));
			
			

			
			MovimientoABM movimientoABM = new MovimientoABM();
			UsuarioABM usuarioABM = new UsuarioABM();
			
			Usuario usuario = usuarioABM.traerUsuario3(true);
			System.out.println(usuario);
			TarjetaABM tarjetaABM = new TarjetaABM();
			Tarjeta tarjeta=tarjetaABM.traerTarjeta3(usuario.getIdUsuario());

			if(estacionB==14) {
				int horaS = Integer.parseInt ( request . getParameter ( "horaS" ));
				int minutosS = Integer.parseInt ( request . getParameter ( "minutosS" ));
				GregorianCalendar fecha = new GregorianCalendar(año,mes,dia,horaS,minutosS);
				
				
				movimientoABM.agregarMovimientoTren(fecha,tarjeta.getNroTarjeta(),estacionS);
				tarjeta.setCobroOdevolucionTren(true);
				tarjetaABM.modificarTarjeta(tarjeta);
			}
			else {
				System.out.println("Hola");
				int horaS = Integer.parseInt ( request . getParameter ( "horaS" ));
				int minutosS = Integer.parseInt ( request . getParameter ( "minutosS" ));
				int horaB = Integer.parseInt ( request . getParameter ( "horaB" ));
				int minutosB = Integer.parseInt ( request . getParameter ( "minutosB" ));
				GregorianCalendar fechaS = new GregorianCalendar(año,mes,dia,horaS,minutosS);
				GregorianCalendar fechaB = new GregorianCalendar(año,mes,dia,horaB,minutosB);
				
				movimientoABM.agregarMovimientoTren(fechaS,tarjeta.getNroTarjeta(),estacionS);
				movimientoABM.agregarMovimientoTren(fechaB,tarjeta.getNroTarjeta(),estacionB);
			}
				
			
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
