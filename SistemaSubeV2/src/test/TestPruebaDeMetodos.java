package test;
import datos.*;
import negocio.*;

import java.util.ArrayList;
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
		
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.println("------------------------------------------------------------------------------------------------");
		System.out.println("------------------------------BIENVENIDO AL SISTEMA MI SUBE-------------------------------------");
		System.out.println("------------------------------------------------------------------------------------------------");
		
		long dni=36826344l;
		Usuario usuario1 = new Usuario("Nicolas","Gianni",dni,"123456");
//		
//
		try {
			//usuarioABM.agregarUsuario(usuario1.getNombre(), usuario1.getApellido(), usuario1.getDni(), usuario1.getPassword());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Usuario usuario = usuarioABM.traerUsuario2(dni);
//		
//
		long nroTarjeta=8934892l;
		GregorianCalendar fecha2=new GregorianCalendar(2018,7,5-1,18,00,44);
		try {
			//tarjetaABM.agregarTarjeta(nroTarjeta, 30.0, true, usuario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		
//		
//		tarjetaABM.agregarTarjeta(nroTarjeta,30,true,usuarioABM.traerUsuario2(dni));
		Tarjeta tarjeta = tarjetaABM.traerTarjeta3(4);
//		usuario.setTarjeta(tarjeta);
//		usuarioABM.modificarUsuario(usuario);
		
		
		//***************************** AgregarMovimientoColectivo      ********
		
		
		
		try {
			//colectivoABM.agregarColectivo(2, "Colectivo","Micro Ómnibus Sur S.A.C." , 160, 1);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			//moviABM.agregarMovimientoColectivo(fecha2, tarjeta.getNroTarjeta(),5);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		
		
		
		
		//    **********AgregarMovimientoTren******
		//GregorianCalendar fecha=new GregorianCalendar();

		try {
			//trenABM.agregarTren(1,"Tren",lineaTrenABM.traerLineaTren(1));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		};
		
		try {
			//moviABM.agregarMovimientoTren(fecha,tarjeta.getNroTarjeta(), 1, 8);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		//**************** AgregarMovimientoSubte ************** 
		
		GregorianCalendar fecha3=new GregorianCalendar(2017,5-1,4,10,10,10);
		
		try {
			//subteABM.agregarSubte(3, "Subte", 'H');
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			//moviABM.agregarMovimientoSubte(fecha3, tarjeta.getNroTarjeta());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		//***********Recarga de Saldo************
		try {
			//moviABM.agregarMovimientoRecarga(fecha2, tarjeta.getNroTarjeta(), 120);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			//System.out.println(""+usuarioABM.traerUsuario2(39429876));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TransporteABM transporte = new TransporteABM();
		//transporte.agregarTransporte(0, "Carga");
		//System.out.println(""+tarjetaABM.traerTarjeta3(4));
		List<Movimiento> movimientos = moviABM.traerMovimientos(tarjeta.getIdTarjeta());
		Movimiento movimiento = movimientos.get(1);
		ColectivoABM colectivoAbm = new ColectivoABM();
		try {
			Colectivo colectivo = colectivoAbm.traerColectivo(movimiento.getTransporte().getIdTransporte());
			System.out.println(""+colectivo.getEmpresa());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	}

}
