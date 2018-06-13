package negocio;
import negocio.*;
import datos.*;

import java.util.GregorianCalendar;

import dao.MovimientoDao;
import dao.TarifaTrenDao;
import dao.TarjetaDao;
import dao.TransporteDao;
import datos.Movimiento;
import datos.Tarifa;
import datos.TarifaTren;
import datos.Tarjeta;
import datos.Transporte;

public class MovimientoABM {
	private MovimientoDao dao = new MovimientoDao();

	public int agregarMovimiento(GregorianCalendar fechaHora, Tarjeta tarjeta, Tarifa tarifa,
			Transporte transporte) {
		Movimiento c = new Movimiento (fechaHora,tarjeta,tarifa,transporte);
		return dao.agregar(c);
	}

	public void modificarMovimiento(Movimiento movimiento){
		dao.actualizar(movimiento);
	}

	public void eliminarMovimiento(long idMovimiento){
		Movimiento c = dao.traerMovimiento(idMovimiento);
		dao.eliminar(c);
	}

	public Movimiento traerMovimiento(long idMovimiento){
		return dao.traerMovimiento(idMovimiento);
	}
	
	public void agregarMovimientoTren(GregorianCalendar fecha, long nroTarjeta, int estacionSubida, int estacionBajada) {
		
		TarifaTrenABM tarifaTrenABM = new TarifaTrenABM();
		TarjetaABM tarjetaABM = new TarjetaABM();
		TransporteABM transporteABM = new TransporteABM();
		RedSubeABM redSubeABM = new RedSubeABM();

		
		TarifaTren tarifaTren =  tarifaTrenABM.traerTarifaTren(estacionSubida, estacionBajada);
		double valorTarifaSocial = tarifaTren.getSeccion().getValorSeccionTarifaSocial();
		double valorComun = tarifaTren.getSeccion().getValorSeccionComun(); 
		Tarjeta tarjeta = tarjetaABM.traerTarjeta2(nroTarjeta);
		Transporte transporte = transporteABM.traerTransporte(1);
		Tarifa tarifa=  new Tarifa();
		tarifa = null;

		
		
		if(tarjeta.isTarifaSocial()==true) {
			tarifaTren.setValorTarifa(valorTarifaSocial);
			tarifa = (Tarifa) tarifaTren;
			tarjeta.setSaldo(tarjeta.getSaldo()-valorTarifaSocial);
			tarjetaABM.modificarTarjeta(tarjeta);
			
		
		}
		else{
			tarifaTren.setValorTarifa(valorComun);
			tarifa = (Tarifa) tarifaTren;	
			tarjeta.setSaldo(tarjeta.getSaldo()-valorComun);
			tarjetaABM.modificarTarjeta(tarjeta);
		}

		
		Movimiento movimiento = new Movimiento(fecha,tarjeta,tarifa,transporte);
		dao.agregar(movimiento);

	}
}

	


	