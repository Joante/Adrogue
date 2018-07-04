package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Colectivo;
import datos.Funciones;
import datos.Movimiento;
import negocio.ColectivoABM;
import negocio.MovimientoABM;

public class ControladorEstadisticasColectivo extends HttpServlet {
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
			List<Movimiento> movimientos = movimientoAbm.traerMovimientoTrasporte(desde, hasta, 2);  
			List<Integer> idLineas = new ArrayList<Integer>();  
			int x = 0; 
			for(Movimiento m : movimientos) {
				x=(int) m.getTransporte().getIdTransporte();
				idLineas.add(x);
			}
			
			List<Colectivo> colectivos = new ArrayList<Colectivo>();
			ColectivoABM colectivoAbm = new ColectivoABM();
			for(Integer i : idLineas) {
				colectivos.add(colectivoAbm.traerColectivo(i));
			}
			String nombres="";
			 for(int i=0;i<colectivos.size();i++){
					Colectivo aux = colectivos.get(i);
					for(int j=0;j<colectivos.size();j++) {
						if(i!=j) {
							if(aux.getLinea()==colectivos.get(j).getLinea()) {
								colectivos.remove(j);
							}
						}
					}
					nombres=nombres+"'"+aux.getLinea()+"'"+", "; 
			 }

				
			 int[] cantidadDeViajes = new int[colectivos.size()]; 
			 for(int i=0;i<colectivos.size();i++){ 
					Colectivo aux = colectivos.get(i); 
					cantidadDeViajes[i]= movimientoAbm.traerCantidadMovimientosTransporte(aux.getIdTransporte(), desde, hasta);
			}
			double[] montoLinea = new double[colectivos.size()];
			for(int i=0;i<colectivos.size();i++) {
				montoLinea[i]=movimientoAbm.traerMontoRecaudadoLineaColectivo(desde, hasta, 2, colectivos.get(i).getLinea());
				
			}
			
			int[] cantidadViajeTramo = new int[5];
			double [] montoTramos = new double[5];
			String nombresTramo ="'0 a 3 KM' , '3 a 6 KM' , '6 a 12 KM' , '12 a 30 KM' , 'Mas de 30 KM'";
			cantidadViajeTramo= movimientoAbm.traerMovimientoTramoColectivo(desde, hasta, 2);
			montoTramos = movimientoAbm.traerMontoTramoColectivo(desde, hasta, 2);
			request.setAttribute("CantidadViajesLineas", cantidadDeViajes);
			request.setAttribute("CantidadMontoLinea", montoLinea);
			request.setAttribute("NombresLineas", nombres);
			request.setAttribute("CantidadViajeTramo", cantidadViajeTramo);
			request.setAttribute("NombresTramo", nombresTramo);
			request.setAttribute("MontoTramos", montoTramos);
			request.getRequestDispatcher("/EstadisticasColectivo.jsp").forward(request, response);
			
			
			
		}catch (Exception e2) {
			// TODO Auto-generated catch block
			System.out.println(""+e2.getMessage());
		}
	}
}
