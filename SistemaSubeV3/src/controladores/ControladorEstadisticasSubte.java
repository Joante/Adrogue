package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Subte;
import datos.Funciones;
import datos.Movimiento;
import negocio.SubteABM;
import negocio.MovimientoABM;

public class ControladorEstadisticasSubte extends HttpServlet {
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
			
			int[] cantidad = movimientoAbm.traerMovimientoLineaSubte(desde, hasta, 3);
			double[] monto = movimientoAbm.traerMontoRecaudadoLineaSubte(desde, hasta, 3);
			String nombre = "'A','B','C','D','E','H'";
			request.setAttribute("Cantidad", cantidad);
			request.setAttribute("Monto", monto);
			request.setAttribute("Nombres", nombre);
			request.getRequestDispatcher("/EstadisticasSubte.jsp").forward(request, response);
		}catch (Exception e) {
			
		}
	}
			
}
