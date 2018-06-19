package negocio;


import java.util.Calendar;
import java.util.GregorianCalendar;

import dao.RedSubeDao;
import datos.Movimiento;
import datos.RedSube;
import datos.Tarjeta;

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
	public double calcularRedSube(Movimiento movimiento) {
		double valor=movimiento.getTarifa().getValorTarifa();;
		RedSube redSube = dao.traerRedSubeNro(movimiento.getTarjeta().getIdTarjeta());
		int contador=redSube.getContadorViajes();
		if(redSube.getUltimoTipoTransporte()==0) {
			redSube.setUltimoTipoTransporte(movimiento.getTransporte().getTipoTransporte());
		}
		if(redSube.getFechaHoraRedSube().after(movimiento.getFechaHora()) && redSube.getUltimoTipoTransporte()!=movimiento.getTransporte().getTipoTransporte() && redSube.getContadorViajes()<=5) {
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
		}else if(redSube.getFechaHoraRedSube().before(movimiento.getFechaHora())) {
			GregorianCalendar fechaHoraMaxima = new GregorianCalendar();
			fechaHoraMaxima=movimiento.getFechaHora();
			fechaHoraMaxima.add(Calendar.HOUR_OF_DAY, 2);
			redSube.setFechaHoraRedSube(fechaHoraMaxima);
			dao.actualizar(redSube);
		}
		return valor;
	}
}
