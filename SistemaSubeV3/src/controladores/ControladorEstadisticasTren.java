package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Tren;
import datos.Funciones;
import datos.Movimiento;
import negocio.TrenABM;
import negocio.MovimientoABM;

public class ControladorEstadisticasTren extends HttpServlet {
	protected void doGet(HttpServletRequest request , HttpServletResponse response )throws ServletException, IOException{
		procesarPeticion(request,response);
	}

	protected void doPost(HttpServletRequest request , HttpServletResponse response )throws ServletException, IOException{
		procesarPeticion( request , response );
	}
	
	protected void procesarPeticion(HttpServletRequest request , HttpServletResponse response)throws ServletException, IOException {
		response .setContentType( "text/html;charset=UTF-8" );
		
		try {
			MovimientoABM movimientoAbm = new MovimientoABM();
			int añoD = Integer.parseInt ( request.getParameter ( "anioD" ));  
			int mesD = Integer.parseInt ( request.getParameter ( "mesD" ));  
			int diaD = Integer.parseInt ( request.getParameter ( "diaD" ));  
			int horaD = Integer.parseInt(request.getParameter("horaD"));
			int minutosD = Integer.parseInt(request.getParameter("minutosD"));
			int añoH = Integer.parseInt ( request.getParameter ( "anioH" ));  
			int mesH = Integer.parseInt ( request.getParameter ( "mesH" ));  
			int diaH = Integer.parseInt ( request.getParameter ( "diaH" ));  
			int horaH = Integer.parseInt(request.getParameter("horaH"));
			int minutosH = Integer.parseInt(request.getParameter("minutosH"));
			GregorianCalendar desde = new GregorianCalendar(añoD,mesD,diaD,horaD,minutosD);  
			GregorianCalendar hasta = new GregorianCalendar(añoH,mesH,diaH,horaH,minutosH);  
			
			String nombres="'Roca'";
			int[] cantidadDeViajes = new int [2];
			cantidadDeViajes[0]=movimientoAbm.traerCantidadMovimientosLineaTren(desde, hasta, 1); 
			double[] montoLinea = new double[2];
			montoLinea[0]=movimientoAbm.traerMontoRecaudadoLineaTren(desde, hasta, 1);
			int[] cantidadViajeTramo = new int[3];
			double [] montoTramos = new double[3];
			String nombresTramo ="'Seccion 1' , 'Seccion 2' , 'Seccion 3'";
			cantidadViajeTramo= movimientoAbm.traerCantidadViajesTramoTren(desde, hasta, 1);
			montoTramos = movimientoAbm.traerMontoRecaudadoTramoTren(desde, hasta, 1);
			request.setAttribute("CantidadViajesLineas", cantidadDeViajes);
			request.setAttribute("CantidadMontoLinea", montoLinea);
			request.setAttribute("NombresLineas", nombres);
			request.setAttribute("CantidadViajeTramo", cantidadViajeTramo);
			request.setAttribute("NombresTramo", nombresTramo);
			request.setAttribute("MontoTramos", montoTramos);
			request.getRequestDispatcher("/EstadisticasTren.jsp").forward(request, response);
			
			
			
		}catch (Exception e) {
			
		}
	}
}
