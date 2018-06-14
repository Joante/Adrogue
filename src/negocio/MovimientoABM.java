package negocio;
import negocio.*;
import datos.*;

import java.util.ArrayList;
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
	
	//***************************Estadisticas Colectivo*******************************
	public int traerCantidadMovimientosTransporte(int tipoTransporte,GregorianCalendar fechaInicio,GregorianCalendar fechaFin) {
		
		List<Movimiento> lstMovimiento= dao.traerMovimientoTransporte(fechaInicio, fechaFin, tipoTransporte);
		int cantidadMovimientos=lstMovimiento.size();
		return cantidadMovimientos;
		
		}
		public int traerCantidadMovimientosLineaColectivoPorDia(GregorianCalendar fecha,int tipoTransporte,int linea) throws Exception{
			
			GregorianCalendar fechaInicio=new GregorianCalendar();
			fechaInicio.set(Funciones.traerAnio(fecha), Funciones.traerMes(fecha)-1, Funciones.traerDia(fecha), 00, 00,00);
			
			GregorianCalendar fechaFin=new GregorianCalendar();
			fechaFin.set(Funciones.traerAnio(fecha), Funciones.traerMes(fecha)-1, Funciones.traerDia(fecha), 23, 59,59);
			
			return this.traerMovimientoLineaColectivo(fechaInicio, fechaFin, tipoTransporte, linea).size();
		}
		
		public double traerMontoRecaudadoLineaColectivoPorDia(GregorianCalendar fecha,int tipoTransporte,int linea) throws Exception{
			GregorianCalendar fechaInicio=new GregorianCalendar();
			fechaInicio.set(Funciones.traerAnio(fecha), Funciones.traerMes(fecha)-1, Funciones.traerDia(fecha), 00, 00,00);
			
			GregorianCalendar fechaFin=new GregorianCalendar();
			fechaFin.set(Funciones.traerAnio(fecha), Funciones.traerMes(fecha)-1, Funciones.traerDia(fecha), 23, 59,59);
			
			
			double sumador=0;
			for(Movimiento movimiento : this.traerMovimientoLineaColectivo(fechaInicio, fechaFin, tipoTransporte, linea)) {
				 //movimiento=movimientoABM.traerMovimiento(idMovimiento);
				 sumador=+movimiento.getTarifa().getValorTarifa();
			}
			
			return sumador;
		}
//***************************************Estadisticas Transporte******************************************
		public List<Movimiento> traerMovimientoLineaColectivo(GregorianCalendar fechaHoraInicio,GregorianCalendar fechaHoraFinal,int tipoTransporte,int linea) throws Exception{
			List<Movimiento> lstMovimiento= dao.traerMovimientoTransporte(fechaHoraInicio, fechaHoraFinal, tipoTransporte);
			List<Movimiento> lstAux = new ArrayList<Movimiento>();
			ColectivoABM colectivoABM= new ColectivoABM();
			for(Movimiento s: lstMovimiento) {
				Colectivo c= colectivoABM.traerColectivo(s.getTransporte().getIdTransporte());
				if(c.getLinea()==linea) {
					lstAux.add(s);
				}
			}
			
			return lstAux;
			
		}
		public List<Movimiento> traerMovimientoLineaYTramoColectivo(GregorianCalendar fechaHoraInicio,GregorianCalendar fechaHoraFinal,int tipoTransporte,int linea,int interno) throws Exception{
			List<Movimiento> lstMovimiento= dao.traerMovimientoTransporte(fechaHoraInicio, fechaHoraFinal, tipoTransporte);
			List<Movimiento> lstAux = new ArrayList<Movimiento>();
			ColectivoABM colectivoABM= new ColectivoABM();
			for(Movimiento s: lstMovimiento) {
				Colectivo c= colectivoABM.traerColectivo(s.getTransporte().getIdTransporte());
				if(c.getLinea()==linea && c.getInterno()==interno) {
					lstAux.add(s);
				}
			}
			
			return lstAux;
			
		}
		
		public List<Movimiento>  traerMovimientoLineaSubte(GregorianCalendar fechaHoraInicio,GregorianCalendar fechaHoraFinal,int tipoTransporte,char linea) throws Exception{
			List<Movimiento> lstMovimiento= dao.traerMovimientoTransporte(fechaHoraInicio, fechaHoraFinal, tipoTransporte);
			List<Movimiento> lstAux = new ArrayList<Movimiento>();
			SubteABM subteABM= new SubteABM();
			for(Movimiento s: lstMovimiento) {
				Subte c= subteABM.traerSubte(s.getTransporte().getIdTransporte());
				if(c.getLinea()==linea) {
					lstAux.add(s);
				}
			}
			
			return lstAux;

		}
		
		public List<Movimiento> traerMovimientoSubteLineaYEstacionDeSubida(GregorianCalendar fechaHoraInicio,GregorianCalendar fechaHoraFinal,int tipoTransporte,int linea, String estacionDeSubida) throws Exception{
			List<Movimiento> lstMovimiento= dao.traerMovimientoTransporte(fechaHoraInicio, fechaHoraFinal, tipoTransporte);
			List<Movimiento> lstAux = new ArrayList<Movimiento>();
			SubteABM subteABM= new SubteABM();
			for(Movimiento s: lstMovimiento) {
				Subte c= subteABM.traerSubte(s.getTransporte().getIdTransporte());
				if(c.getLinea()==linea) {
					for(EstacionSubte estacion : c.getLstEstaciones()) {
						if(estacionDeSubida.equals(estacion.getNombre()))
						lstAux.add(s);
					}
					
				}
			}
			
			return lstAux;
			
		}
		
		public List<Movimiento>  traerMovimientoLineaTren(GregorianCalendar fechaHoraInicio,GregorianCalendar fechaHoraFinal,int tipoTransporte,String linea) throws Exception{
			List<Movimiento> lstMovimiento= dao.traerMovimientoTransporte(fechaHoraInicio, fechaHoraFinal, tipoTransporte);
			List<Movimiento> lstAux = new ArrayList<Movimiento>();
			TrenABM trenABM= new TrenABM();
			for(Movimiento s: lstMovimiento) {
				Tren c= trenABM.traerTren(s.getTransporte().getIdTransporte());
				if(c.getLineaTren().getNombreLinea().equals(linea)) {
					lstAux.add(s);
				}
			}
			
			return lstAux;

		}
		

		
		public List<Movimiento> traerMovimientoLineaTrenConEstaciones(GregorianCalendar fechaHoraInicio,GregorianCalendar fechaHoraFinal,int tipoTransporte,String linea,String estacionSubida, String estacionBajada) throws Exception{
			List<Movimiento> lstMovimiento= dao.traerMovimientoTransporte(fechaHoraInicio, fechaHoraFinal, tipoTransporte);
			List<Movimiento> lstAux = new ArrayList<Movimiento>();
			TrenABM trenABM= new TrenABM();
			for(Movimiento s: lstMovimiento) {
			
				Tren c= trenABM.traerTren(s.getTransporte().getIdTransporte());
				if(c.getLineaTren().getNombreLinea().equals(linea)) {
					
					
					
					lstAux.add(s);
				}
			}
			
			return lstAux;

		}
}

	


	