package negocio;
import negocio.*;
import datos.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import dao.MovimientoDao;
import dao.TarifaTrenDao;
import dao.TarjetaDao;
import dao.TransporteDao;

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
	public List<Movimiento> traerMovimientos(long idTarjeta){
		return dao.traerMovimientos(idTarjeta);
	}
	public List<Movimiento> traerMasMovimientos(long idTarjeta,long id){
		return dao.traerMasMovimientos(idTarjeta,id);
	}
	public void agregarMovimientoTren(GregorianCalendar fecha, long nroTarjeta, int estacionSubida, int estacionBajada) throws Exception {
		
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
public void agregarMovimientoColectivo(GregorianCalendar fecha, long nroTarjeta,int idSeccionColectivo) throws Exception {
	TarjetaABM tarjetaAbm = new TarjetaABM();
	Tarjeta tarjeta = tarjetaAbm.traerTarjeta2(nroTarjeta);
	TransporteABM transporteAbm = new TransporteABM();
	Transporte transporte = transporteAbm.traerTransporte(4);
	TarifaColectivoABM tarifaColectivo= new TarifaColectivoABM();
	Tarifa tarifa = new Tarifa();
	Movimiento c = null;
	double valor;
	RedSubeABM redSube = new RedSubeABM();
	if(tarjeta.isTarifaSocial()) {
		tarifa= (Tarifa) tarifaColectivo.calcularTarifaColectivoTarifaSocial(idSeccionColectivo);
	}
	else {
		tarifa = (Tarifa) tarifaColectivo.calcularTarifaColectivoComun(idSeccionColectivo);
	}
	c= new Movimiento(fecha,tarjeta,tarifa,transporte);
	valor=redSube.calcularRedSube(c);
	tarifa.setValorTarifa(valor);
	c.setTarifa(tarifa);
	dao.agregar(c);

}

public void agregarMovimientoSubte(GregorianCalendar fecha, long nroTarjeta) throws Exception {
	TarjetaABM tarjetaAbm = new TarjetaABM();
	Tarjeta tarjeta = tarjetaAbm.traerTarjeta2(nroTarjeta);
	TransporteABM transporteAbm = new TransporteABM();
	Transporte transporte = transporteAbm.traerTransporte(3);
	TarifaSubteABM tarifaSubte= new TarifaSubteABM();
	Tarifa tarifa = new Tarifa();
	Movimiento c = null;
	double valor;
	RedSubeABM redSube = new RedSubeABM();
	if (tarjeta.getMesDescuentoViajesSubte()!=fecha.get(Calendar.MONTH)){
		tarjeta.setMesDescuentoViajesSubte(fecha.get(Calendar.MONTH));
		tarjeta.setContadorViajesSubte(1);
		tarjetaAbm.modificarTarjeta(tarjeta);
	}
	if(tarjeta.isTarifaSocial()) {
		tarifa = (Tarifa) tarifaSubte.calcularTarifaSubteTarifaSocal(tarjeta.getContadorViajesSubte());
	}
	else {
		tarifa = (Tarifa) tarifaSubte.calcularTarifaSubteComun(tarjeta.getContadorViajesSubte());
	}
	c= new Movimiento(fecha,tarjeta,tarifa,transporte);
	valor=redSube.calcularRedSube(c);
	tarifa.setValorTarifa(valor);
	c.setTarifa(tarifa);
	int contadorViajesSubte=tarjeta.getContadorViajesSubte()+1;
	tarjeta.setContadorViajesSubte(contadorViajesSubte);
	tarjetaAbm.modificarTarjeta(tarjeta);
	dao.agregar(c);
}
public void agregarMovimientoRecarga(GregorianCalendar fecha, long nroTarjeta, double valor) throws Exception {
	TarjetaABM tarjetaAbm = new TarjetaABM();
	Tarjeta tarjeta = tarjetaAbm.traerTarjeta2(nroTarjeta);
	TransporteABM transporteAbm = new TransporteABM();
	Transporte transporte = transporteAbm.traerTransporte(5);
	double saldo = tarjeta.getSaldo()+valor;
	if(saldo<0) {
		throw new Exception ("Error. Valor de recarga no supera saldo negativo");
	}
	tarjeta.setSaldo(saldo);
	tarjetaAbm.modificarTarjeta(tarjeta);
	TarifaABM tarifaAbm = new TarifaABM();
	tarifaAbm.agregarTarifa(valor);
	Tarifa tarifa = tarifaAbm.traerUltima();
	Movimiento movimiento = new Movimiento(fecha, tarjeta, tarifa,transporte);
	dao.agregar(movimiento);
}
}

	


	