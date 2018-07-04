package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.HibernateException;
import datos.*;
import negocio.*;

public class ControladorAgregarUsuario extends HttpServlet {
	protected void doGet(HttpServletRequest request , HttpServletResponse response )throws ServletException, IOException{
		procesarPeticion(request,response);
	}

	protected void doPost(HttpServletRequest request , HttpServletResponse response )throws ServletException, IOException{
		procesarPeticion( request , response );
	}
	
	protected void procesarPeticion(HttpServletRequest request , HttpServletResponse response)throws ServletException, IOException {
		response .setContentType( "text/html;charset=UTF-8" );
		
		try {
			String nombre = request .getParameter("nom");
			String apellido = request .getParameter("ape");
			long dni = Long . parseLong ( request . getParameter ( "doc" ));
			String password= request .getParameter("contra");
			
			
			UsuarioABM usuarioABM= new UsuarioABM();
			usuarioABM.agregarUsuario(nombre, apellido, dni, password);
			
			Usuario usuarioAux = usuarioABM.traerUsuario2(dni);
			
			
			long numTarjeta = Long.parseLong ( request.getParameter ( "ntar" ));
			
			
			double saldo = Double.parseDouble( request.getParameter ( "saldo" )); 
			boolean tarifaS = false;
			
			String tarifaSocial = request .getParameter("tarifaSocial");
			if(tarifaSocial == "true") {
				tarifaS=true;
			}
			else if(tarifaSocial == "false"){
				tarifaS=false;
			}
			
			TarjetaABM tarjetaABM= new TarjetaABM();
			tarjetaABM.agregarTarjeta(numTarjeta, saldo, tarifaS,usuarioAux);
			RedSubeABM redSube = new RedSubeABM();
			Tarjeta tarjeta = new Tarjeta(numTarjeta,saldo,tarifaS,usuarioAux);
			redSube.agregarRedSube(0, tarjeta.getNroTarjeta());
			
			request .getRequestDispatcher( "/Login.jsp" ).forward( request ,response );

			
		}
		catch (Exception e) {
			response.sendError(500, "LALA El DNI o PASSWORD Ingresado no existe en la base de datos." );
		}
	
	}
}
