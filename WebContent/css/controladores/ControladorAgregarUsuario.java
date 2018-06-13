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
			int dni = Integer . parseInt ( request . getParameter ( "doc" ));
			String password= request .getParameter("contra");
			
			long dni2= (long) dni;
			UsuarioABM usuarioABM= new UsuarioABM();
			usuarioABM.agregarUsuario(nombre, apellido, dni2, password);
			Usuario usuarioAux = usuarioABM.traerUsuario2(dni2);
			
			System.out.println("1");
			int numTarjeta = Integer . parseInt ( request . getParameter ( "ntar" ));
			long numTarjeta2=(long) numTarjeta;
			System.out.println("1");
			double saldo = Double.parseDouble( request . getParameter ( "saldo" )); 
			boolean tarifaS = false;
			System.out.println("1");
			String tarifaSocial = request .getParameter("tarifaSocial");
			if(tarifaSocial == "true") {
				tarifaS=true;
			}
			else if(tarifaSocial == "false"){
				tarifaS=false;
			}
			
			System.out.println("1");
			TarjetaABM tarjetaABM=new TarjetaABM();
			System.out.println("1");
			tarjetaABM.agregarTarjeta(numTarjeta2, saldo, tarifaS,usuarioAux);
			System.out.println("1");
			Tarjeta tarjeta = tarjetaABM.traerTarjeta2(numTarjeta2);
			System.out.println("1");
			usuarioAux.setTarjeta(tarjeta);
			System.out.println("1");
			usuarioABM.modificarUsuario(usuarioAux);
			System.out.println("1");
			response.setStatus(200);
			//PrintWriter salida = response.getWriter();
			
		}
		catch (Exception e) {
			response.sendError(500, "El DNI o PASSWORD Ingresado no existe en la base de datos." );
		}
	
	}
}
