package test;

import datos.*;
import negocio.*;


import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

import org.hibernate.mapping.Set;

import dao.*;


public class TestEstadisticas {

	public static void main(String[] args) throws Exception {
		try {
		
		MovimientoABM moviABM = new MovimientoABM();
		
		//TEST ESTADISITCAS--------------------------------------------
		GregorianCalendar fecha=new GregorianCalendar();
		GregorianCalendar fechaSeteada=new GregorianCalendar();
		fechaSeteada.set(2018, 05, 10);
		GregorianCalendar fechaInicio=new GregorianCalendar();
		fechaInicio.set(2000, 1, 1);
		
		moviABM.traerCantidadMovimientosTransporte(2, fechaInicio, fecha);
		
		System.out.println("Cantidad de movimientos de colectivos: "+ moviABM.traerCantidadMovimientosTransporte(2, fechaInicio, fecha));
		System.out.println("Cantidad de movimientos de colectivos LINEA 160 dia "+Funciones.traerFechaCorta(fechaSeteada)+" : "+moviABM.traerCantidadMovimientosLineaColectivoPorDia(fechaSeteada, 2, 160));
		System.out.println("Cantidad de movimientos de colectivos LINEA 160 dia "+Funciones.traerFechaCorta(fecha)+" : "+ moviABM.traerCantidadMovimientosLineaColectivoPorDia(fecha, 2, 160));
		System.out.println("Monto recaudado en el dia"+Funciones.traerFechaCorta(fecha)+" por la linea 160: "+moviABM.traerMontoRecaudadoLineaColectivoPorDia(fecha, 2, 160));
		//------------------------------------------
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	
	

}