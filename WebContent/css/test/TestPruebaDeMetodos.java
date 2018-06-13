package test;
import datos.*;
import negocio.*;

import java.util.GregorianCalendar;
import java.util.Scanner;

import dao.*;


public class TestPruebaDeMetodos {

	public static void main(String[] args) {
		
		UsuarioABM usuarioABM = new UsuarioABM();
		TarjetaABM tarjetaABM = new TarjetaABM();
		LineaTrenABM lineaTrenABM=new LineaTrenABM();
		TrenABM trenABM = new TrenABM();
		MovimientoABM moviABM = new MovimientoABM();
		
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.println("------------------------------------------------------------------------------------------------");
		System.out.println("------------------------------BIENVENIDO AL SISTEMA MI SUBE-------------------------------------");
		System.out.println("------------------------------------------------------------------------------------------------");
		
		long dni=36826344l;
		Usuario usuario1 = new Usuario("Nicolas","Gianni",dni,"123456");
		

		//usuarioABM.agregarUsuario(usuario1.getNombre(), usuario1.getApellido(), usuario1.getDni(), usuario1.getPassword());
		Usuario usuario = usuarioABM.traerUsuario2(dni);
		

		long nroTarjeta=8934892l;
		
		
		//tarjetaABM.agregarTarjeta(nroTarjeta,30,true,usuarioABM.traerUsuario2(dni));
		Tarjeta tarjeta = tarjetaABM.traerTarjeta2(nroTarjeta);
		usuario.setTarjeta(tarjeta);
		usuarioABM.modificarUsuario(usuario);
	
		/*
		GregorianCalendar fecha=new GregorianCalendar();

		trenABM.agregarTren(1,"Tren",lineaTrenABM.traerLineaTren(1));;
		
		moviABM.agregarMovimientoTren(fecha,nroTarjeta, 1, 8);*/
	 
	}

}
