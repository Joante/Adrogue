package negocio;


import java.util.Calendar;
import java.util.GregorianCalendar;

import dao.RedSubeDao;
import datos.Colectivo;
import datos.Movimiento;
import datos.RedSube;
import datos.Subte;
import datos.Tarjeta;
import datos.Transporte;
import datos.Tren;

public class RedSubeABM {
	private RedSubeDao dao = new RedSubeDao();

	public int agregarRedSube(int ultimoTipoTransporte, long nroTarjeta) throws Exception {
		TarjetaABM tarjetaAbm = new TarjetaABM();
		Tarjeta tarjeta = tarjetaAbm.traerTarjeta2(nroTarjeta);
		RedSube c = new RedSube (ultimoTipoTransporte, tarjeta);
		return dao.agregar(c);
	}

	public void modificarRedSube(RedSube seccionColectivo){
		dao.actualizar(seccionColectivo);
	}

	public void eliminarRedSube(long idRedSube){
		RedSube c = dao.traerRedSubeNro(idRedSube);
		dao.eliminar(c);
	}

	public RedSube traerRedSube(long idTarjeta){
		return dao.traerRedSubeNro(idTarjeta);
	}
	public double calcularRedSube(Movimiento movimiento, Transporte ultViaje) throws Exception {
		double valor=movimiento.getTarifa().getValorTarifa();
		RedSube redSube = dao.traerRedSubeNro(movimiento.getTarjeta().getIdTarjeta());
		int contador=redSube.getContadorViajes();
		boolean valido = false;
		if(redSube.getUltimoTipoTransporte()==0) {
			redSube.setUltimoTipoTransporte(movimiento.getTransporte().getTipoTransporte());
		}
		if(ultViaje.getTipoTransporte()==4) {
			
		}else {
			if(redSube.getFechaHoraRedSube().after(movimiento.getFechaHora()) && movimiento.getTransporte().getTipoTransporte()==ultViaje.getTipoTransporte()) {
				switch (movimiento.getTransporte().getTipoTransporte()) {
				case 1: 
					TrenABM trenAbm = new TrenABM();
					Tren tren = trenAbm.traerTren(movimiento.getTransporte().getIdTransporte());
					Tren trenAux = trenAbm.traerTren(ultViaje.getIdTransporte());
					if(trenAux.getLineaTren().getIdLineaTren()!=tren.getLineaTren().getIdLineaTren()) {
						valido=true;
					}
					break;
				case 2:
					ColectivoABM colectivoAbm = new ColectivoABM();
					Colectivo colectivo = colectivoAbm.traerColectivo(movimiento.getTransporte().getIdTransporte());
					Colectivo colectivoAux = colectivoAbm.traerColectivo(movimiento.getTransporte().getIdTransporte());
					if(colectivo.getIdColectivo()!=colectivoAux.getIdColectivo()) {
						valido=true;
					}
					break;
				case 3:
					SubteABM subteAbm = new SubteABM();
					Subte subte = subteAbm.traerSubte(movimiento.getTransporte().getIdTransporte());
					Subte subteAux = subteAbm.traerSubte(movimiento.getTransporte().getIdTransporte());
					if(subte.getIdSubte()!=subteAux.getIdSubte()) {
						valido=true;
					}
					break;
				}
			}
		}
				
		if(valido==true || redSube.getUltimoTipoTransporte()!=movimiento.getTransporte().getTipoTransporte()) {
			if(redSube.getFechaHoraRedSube().after(movimiento.getFechaHora()) && redSube.getContadorViajes()<=5) {
				switch (redSube.getContadorViajes()) {
				case 1:
					contador++;
					redSube.setContadorViajes(contador);
					redSube.setUltimoTipoTransporte(movimiento.getTransporte().getTipoTransporte());
					dao.actualizar(redSube);
					break;
				case 2:
					valor=valor*0.50;
					contador++;
					redSube.setContadorViajes(contador);
					redSube.setUltimoTipoTransporte(movimiento.getTransporte().getTipoTransporte());
					dao.actualizar(redSube);
					break;
				case 3:
					valor=valor*0.25;
					contador++;
					redSube.setContadorViajes(contador);
					redSube.setUltimoTipoTransporte(movimiento.getTransporte().getTipoTransporte());
					dao.actualizar(redSube);
					break;
				case 4:
					valor=valor*0.25;
					contador++;
					redSube.setContadorViajes(contador);
					redSube.setUltimoTipoTransporte(movimiento.getTransporte().getTipoTransporte());
					dao.actualizar(redSube);
					break;
				case 5:
					valor=valor*0.25;
					redSube.setContadorViajes(1);
					redSube.setUltimoTipoTransporte(movimiento.getTransporte().getTipoTransporte());
					dao.actualizar(redSube);
					break;
				}
			}
		}
		else if(redSube.getFechaHoraRedSube().before(movimiento.getFechaHora())) {
			GregorianCalendar fechaHoraMaxima = new GregorianCalendar();
			fechaHoraMaxima=movimiento.getFechaHora();
			fechaHoraMaxima.add(Calendar.HOUR_OF_DAY, 2);
			redSube.setFechaHoraRedSube(fechaHoraMaxima);
			dao.actualizar(redSube);
		}
		return valor;
	}
}
