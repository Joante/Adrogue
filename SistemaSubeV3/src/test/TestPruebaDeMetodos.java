package test;
import datos.*;
import negocio.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import dao.*;


public class TestPruebaDeMetodos {

	public static void main(String[] args) {
		
		UsuarioABM usuarioABM = new UsuarioABM();
		TarjetaABM tarjetaABM = new TarjetaABM();
		LineaTrenABM lineaTrenABM=new LineaTrenABM();
		TrenABM trenABM = new TrenABM();
		MovimientoABM moviABM = new MovimientoABM();
		ColectivoABM colectivoABM= new ColectivoABM();
		TarifaColectivoABM tarifaColectivoABM= new TarifaColectivoABM();
		SeccionColectivoABM seccionColectivo= new SeccionColectivoABM();
		SeccionSubteABM seccionSubte= new SeccionSubteABM();
		SubteABM subteABM= new SubteABM();
		TarifaSubteABM tarifaSubteABM= new TarifaSubteABM();
		Tarjeta tarjeta = new Tarjeta();
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.println("------------------------------------------------------------------------------------------------");
		System.out.println("------------------------------BIENVENIDO AL SISTEMA MI SUBE-------------------------------------");
		System.out.println("------------------------------------------------------------------------------------------------");
		
		
		//***************************** AgregarMovimientoColectivo      ********
		/*
		GregorianCalendar fechaColectivo = new GregorianCalendar();
		try {
			tarjeta= tarjetaABM.traerTarjeta(1);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			System.out.println(""+e2.getMessage());
		}
		try {
			moviABM.agregarMovimientoColectivo(fechaColectivo, tarjeta.getNroTarjeta(),5);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println(""+e1.getMessage());
		}	
		*/
		
		
		
		//    **********AgregarMovimientoTren******
		GregorianCalendar fechaTren =new GregorianCalendar();
		//fechaTren.add(Calendar.HOUR_OF_DAY, 1);
		try {
			tarjeta= tarjetaABM.traerTarjeta(1);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			System.out.println(""+e2.getMessage());
		}
		try {
			moviABM.agregarMovimientoTren(fechaTren,tarjeta.getNroTarjeta(), 13);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println(""+e1.getMessage());
		}
				
		
		//**************** AgregarMovimientoSubte ************** 
		/*
		GregorianCalendar fechaSubte=new GregorianCalendar();
		
		try {
			tarjeta= tarjetaABM.traerTarjeta(1);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			System.out.println(""+e2.getMessage());
		}
		
		try {
			moviABM.agregarMovimientoSubte(fechaSubte, tarjeta.getNroTarjeta());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 */
		//***********Recarga de Saldo************
		/*
		try {
			tarjeta= tarjetaABM.traerTarjeta(1);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			System.out.println(""+e2.getMessage());
		}
		try {
			//moviABM.agregarMovimientoRecarga(fecha2, tarjeta.getNroTarjeta(), 120);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		//****************************************************************************
		MovimientoABM movAbm = new MovimientoABM();
		GregorianCalendar ini =new GregorianCalendar(2017,1,1);
		GregorianCalendar fin = new GregorianCalendar(2019,1,1);
		try {
			List<Movimiento> movi = movAbm.traerMovimientosLineaColectivoTarjeta(ini,fin,2,160,4521123665899874l);
			for(Movimiento movis : movi) {
				System.out.println(""+movis);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(""+e.getMessage());
		}
		
 	}

}
