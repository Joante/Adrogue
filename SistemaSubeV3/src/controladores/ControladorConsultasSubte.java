package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Movimiento;
import datos.Tarjeta;
import datos.Usuario;
import negocio.MovimientoABM;
import negocio.TarjetaABM;
import negocio.UsuarioABM;

public class ControladorConsultasSubte extends HttpServlet {
	protected void doGet(HttpServletRequest request , HttpServletResponse response )throws ServletException, IOException{
		procesarPeticion(request,response);
	}

	protected void doPost(HttpServletRequest request , HttpServletResponse response )throws ServletException, IOException{
		procesarPeticion( request , response );
	}
	
	protected void procesarPeticion(HttpServletRequest request , HttpServletResponse response)throws ServletException, IOException {
		response .setContentType( "text/html;charset=UTF-8" );
		
		try {
			UsuarioABM usuarioABM = new UsuarioABM();
			Usuario usuario = usuarioABM.traerUsuario3(true);
			TarjetaABM tarjetaABM = new TarjetaABM();
			Tarjeta tarjeta=tarjetaABM.traerTarjeta3(usuario.getIdUsuario());
			int a�oD = Integer.parseInt ( request.getParameter ( "anioD" ));  
			int mesD = Integer.parseInt ( request.getParameter ( "mesD" ));  
			int diaD = Integer.parseInt ( request.getParameter ( "diaD" ));  
			int horaD = Integer.parseInt(request.getParameter("horaD"));
			int minutosD = Integer.parseInt(request.getParameter("minutosD"));
			int a�oH = Integer.parseInt ( request.getParameter ( "anioH" ));  
			int mesH = Integer.parseInt ( request.getParameter ( "mesH" ));  
			int diaH = Integer.parseInt ( request.getParameter ( "diaH" ));  
			int horaH = Integer.parseInt(request.getParameter("horaH"));
			int minutosH = Integer.parseInt(request.getParameter("minutosH"));
			String auxi = request.getParameter("Linea");
			char linea = auxi.charAt(0);
			GregorianCalendar desde = new GregorianCalendar(a�oD,mesD,diaD,horaD,minutosD);  
			GregorianCalendar hasta = new GregorianCalendar(a�oH,mesH,diaH,horaH,minutosH);  
			MovimientoABM movimientoAbm = new MovimientoABM();
			List<Movimiento> movimientos= new ArrayList<Movimiento>();
			if(linea=='0') {
				movimientos = movimientoAbm.traerMovimientoTrasporteTarjeta(desde, hasta, 3, tarjeta.getNroTarjeta());  
			}
			else {
				movimientos = movimientoAbm.traerMovimientosLineaSubteTarjeta(desde, hasta, 3, linea, tarjeta.getNroTarjeta());
			}
			
			request .setAttribute( "usuario" , usuario);
			request .setAttribute( "tarjeta" , tarjeta);
			request .setAttribute( "movimientos" , movimientos);

			
			request .getRequestDispatcher( "/ConsultasSubte.jsp" ).forward( request ,response );
			
		}
		catch (Exception e) {
			response.sendError(500, "PEDAZO DE GATO" );
		}
	}
}
