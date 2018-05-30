package test;

import java.util.GregorianCalendar;

import datos.Colectivo;
import negocio.ColectivoABM;
import negocio.EstacionTrenABM;
import negocio.LineaColectivoABM;
import negocio.LineaSubteABM;
import negocio.LineaTrenABM;
import negocio.TrenABM;
import negocio.MovimientoABM;
import negocio.SubteABM;
import negocio.TarjetaABM;
import negocio.UsuarioABM;

public class TestAgregarMovimiento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UsuarioABM usuario = new UsuarioABM();
		GregorianCalendar fecha = new GregorianCalendar();
		
		//usuario.agregarUsuario("Joan", "Teich", 39429876);
		LineaTrenABM lineaTren = new LineaTrenABM();
		EstacionTrenABM estacionTren = new EstacionTrenABM();
		//estacionTren.agregarEstacionTren("nula", lineaTren.traerLineaTren(1));
		TarjetaABM tarjeta = new TarjetaABM();
		//tarjeta.agregarTarjeta(6061268125294963l, 30.0, false, usuario.traerUsuario(1));
		
		MovimientoABM movimiento = new MovimientoABM();
		LineaColectivoABM lineaColectivoAbm = new LineaColectivoABM();
		ColectivoABM colectivoAbm = new ColectivoABM();
		LineaSubteABM lineaSubteAbm = new LineaSubteABM();
		SubteABM subte = new SubteABM();
		//lineaSubteAbm.agregarSubte('A');
		//subte.agregarSubte(3, "Subte", lineaSubteAbm.traerSubte(1));
		
		//lineaColectivoAbm.agregarColectivo("Talp", 308);
		//colectivoAbm.agregarColectivo(2, "Colectivo", 1, lineaColectivoAbm.traerLineaColectivo(1));
		try {
		//	movimiento.agregarMovimiento(fecha,6061268125294963l, 1, 1, 6 );
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			movimiento.agregarMovimiento(fecha, 6061268125294963l, 2, 2,0);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			System.out.println(""+e.getMessage());
		}
		try {
			//movimiento.agregarMovimiento(fecha, 6061268125294963l, 1, 0,0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			System.out.println(""+e.getMessage());
		}
		
	}

}
