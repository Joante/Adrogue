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

public class ControladorMostrarTabla extends HttpServlet {
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
			System.out.println(usuario);
			TarjetaABM tarjetaABM = new TarjetaABM();
			Tarjeta tarjeta=tarjetaABM.traerTarjeta3(usuario.getIdUsuario());

			
			MovimientoABM movimientoAbm = new MovimientoABM();
			List<Movimiento> movimientos = movimientoAbm.traerMovimientos(tarjeta.getIdTarjeta());
			
			request .setAttribute( "usuario" , usuario);
			request .setAttribute( "tarjeta" , tarjeta);
			request .setAttribute( "movimientos" , movimientos);

			
			request .getRequestDispatcher( "/InformacionTarjeta.jsp" ).forward( request ,response );
			
		}
		catch (Exception e) {
			response.sendError(500, "PEDAZO DE GATO" );
		}
	
	}
}
