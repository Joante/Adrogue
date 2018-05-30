package negocio;


import java.util.Calendar;
import java.util.GregorianCalendar;

import dao.MovimientoDao;
import datos.Movimiento;
import datos.Tarifa;
import datos.Tarjeta;
import datos.Transporte;

public class MovimientoABM {
	private MovimientoDao dao = new MovimientoDao();
	private TransporteABM transporteAbm = new TransporteABM();
	private TarjetaABM tarjetaAbm = new TarjetaABM();
	private Transporte transporte = new Transporte();
	private Tarjeta tarjeta= new Tarjeta();
	private RedSubeABM redSube = new RedSubeABM();
	
	public int agregarMovimiento(GregorianCalendar fechaHora, long nrotarjeta, long idTransporte, int estacionOseccion,int estacionBajada) throws Exception {
		transporte=transporteAbm.traerTransporte(idTransporte);
		Movimiento c = null;
		tarjeta= tarjetaAbm.traerTarjetaNro(nrotarjeta);
		switch (transporte.getTipoTransporte()) {
			case 1:
				double saldo=tarjeta.getSaldo();
				c=movimientoTren(fechaHora,tarjeta,transporte,estacionOseccion,estacionBajada);
				/*if(tarjeta.isCobroOdevolucionTren()) {
					tarjeta.setCobroOdevolucionTren(false);
					saldo=saldo-c.getTarifa().getValorTarifa();
					tarjeta.setSaldo(saldo);
					tarjetaAbm.modificarTarjeta(tarjeta);
					dao.agregar(c);
				}
				else {
					if(c.getTarifa().getValorTarifa()<5.5) {
						saldo=c.getTarifa().getValorTarifa()+saldo;
					}
					tarjeta.setSaldo(saldo);
					tarjeta.setCobroOdevolucionTren(true);
					tarjetaAbm.modificarTarjeta(tarjeta);
				}*/
				tarjetaAbm.descontarSaldo(tarjeta.getNroTarjeta(), c.getTarifa().getValorTarifa());
				break;
			case 2:
				c=movimientoColectivo(fechaHora,tarjeta,transporte,estacionOseccion);
				dao.agregar(c);
				tarjetaAbm.descontarSaldo(tarjeta.getNroTarjeta(),c.getTarifa().getValorTarifa());
				break;
			case 3:
				c=movimientoSubte(fechaHora,tarjeta,transporte);
				dao.agregar(c);
				tarjetaAbm.descontarSaldo(tarjeta.getNroTarjeta(),c.getTarifa().getValorTarifa());
				break;
		}
		return 1;
	}
	public Movimiento movimientoTren(GregorianCalendar fechaHora, Tarjeta tarjeta, Transporte transporte, int estacionSubida, int estacionBajada) throws Exception {
		TarifaTrenABM tarifaTren =new TarifaTrenABM();
		Tarifa tarifa ;
		Movimiento c=null;
		double valor;
		if(tarjeta.isTarifaSocial()) {
			tarifa=(Tarifa) tarifaTren.calcularTarifaTrenTarifaSocial(estacionSubida,tarjeta,estacionBajada);
		} else {
			tarifa= (Tarifa) tarifaTren.calcularTarifaTrenComun(estacionSubida,tarjeta,estacionBajada);
		}
		valor=redSube.calcularRedSube(c);
		tarifa.setValorTarifa(valor);
		c= new Movimiento(fechaHora,tarjeta,tarifa,transporte);
		return c;
	}
	public Movimiento movimientoColectivo(GregorianCalendar fechaHora, Tarjeta tarjeta, Transporte transporte, int seccion) throws Exception {
		TarifaColectivoABM tarifaColectivo = new TarifaColectivoABM();
		Tarifa tarifa = new Tarifa();
		Movimiento c = null;
		double valor;

		if(tarjeta.isTarifaSocial()) {
			tarifa= (Tarifa) tarifaColectivo.calcularTarifaColectivoTarifaSocial(seccion);
		}
		else {
			tarifa = (Tarifa) tarifaColectivo.calcularTarifaColectivoComun(seccion);
		}
		c= new Movimiento(fechaHora,tarjeta,tarifa,transporte);
		valor=redSube.calcularRedSube(c);
		tarifa.setValorTarifa(valor);
		c.setTarifa(tarifa);
		return c;
	}
	public Movimiento movimientoSubte(GregorianCalendar fechaHora, Tarjeta tarjeta, Transporte transporte) throws Exception {
		TarifaSubteABM tarifaSubte = new TarifaSubteABM();
		Tarifa tarifa;
		Movimiento c = null;
		double valor;
		if (tarjeta.getMesDescuentoViajesSubte()!=fechaHora.get(Calendar.MONTH)){
			tarjeta.setMesDescuentoViajesSubte(fechaHora.get(Calendar.MONTH));
			tarjeta.setContadorViajesSubte(1);
			tarjetaAbm.modificarTarjeta(tarjeta);
		}
		if(tarjeta.isTarifaSocial()) {
			tarifa = (Tarifa) tarifaSubte.calcularTarifaSubteTarifaSocal(tarjeta.getContadorViajesSubte());
		}
		else {
			tarifa = (Tarifa) tarifaSubte.calcularTarifaSubteComun(tarjeta.getContadorViajesSubte());
		}
		c= new Movimiento(fechaHora,tarjeta,tarifa,transporte);
		valor=redSube.calcularRedSube(c);
		tarifa.setValorTarifa(valor);
		c.setTarifa(tarifa);
		int contadorViajesSubte=tarjeta.getContadorViajesSubte()+1;
		tarjeta.setContadorViajesSubte(contadorViajesSubte);
		tarjetaAbm.modificarTarjeta(tarjeta);
		return c;
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
	
}

	


	