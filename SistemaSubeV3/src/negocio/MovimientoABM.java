package negocio;
import datos.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import dao.MovimientoDao;

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
	public Movimiento traerUltimo() {
		return dao.traerUltimo();
	}
	
	public Movimiento traerUltimo(Tarjeta tarjeta) {
		return dao.traerUltimo(tarjeta);
	}
	
	public void agregarMovimientoTren(GregorianCalendar fecha, long nroTarjeta, int estacion) throws Exception {
		
		TarifaTrenABM tarifaTrenABM = new TarifaTrenABM();
		TarjetaABM tarjetaABM = new TarjetaABM();
		TransporteABM transporteABM = new TransporteABM();
		RedSubeABM redSube = new RedSubeABM();
		
		Tarjeta tarjeta = tarjetaABM.traerTarjeta2(nroTarjeta);
		Transporte transporte = transporteABM.traerTransporte(1);
		Tarifa tarifa=  new TarifaTren();
		TarifaTren tarifaTrenAux=tarifaTrenABM.traerUltima();
		
		if(tarjeta.isCobroOdevolucionTren()) {
			if(tarjeta.isTarifaSocial()) {
				tarifa = tarifaTrenABM.calcularCobroValorTarifaSocial(estacion);
			}
			else{
				tarifa = tarifaTrenABM.calcularCobroValorNormal(estacion);
			}
			tarjeta.setCobroOdevolucionTren(false);
		}
		else {
			Movimiento movimiento = traerUltimo();
			if(movimiento.getTransporte().getTipoTransporte()!=1) {
				if(tarjeta.isTarifaSocial()) {
					tarifa = tarifaTrenABM.calcularCobroValorTarifaSocial(estacion);
				}
				else{
					tarifa = tarifaTrenABM.calcularCobroValorNormal(estacion);
				}
			}
			else {
				int estacionSubida = (int)tarifaTrenAux.getEstacionSubida().getIdEstacionTren();
				if(tarjeta.isTarifaSocial()) {
					tarifa = tarifaTrenABM.calcularDevolucionTarifaSocial(estacionSubida, estacion);
				}
				else{
					tarifa = tarifaTrenABM.calcularDevolucionNormal(estacionSubida,estacion);
				}
			}
			tarjeta.setCobroOdevolucionTren(true);
		}
		Movimiento c= new Movimiento(fecha,tarjeta,tarifa,transporte);
		Movimiento aux = dao.traerUltimoRedSube();
		Transporte ultimo;
		if(aux.getTransporte()==null) {
			ultimo = new Transporte();
		}else {
			ultimo = aux.getTransporte();
		}
		Double valor=redSube.calcularRedSube(c,ultimo);
		double saldo = tarjeta.getSaldo();
		if((saldo-valor)<-20) {
			throw new Exception("Saldo Insuficiente");
		}
		else {
			tarjeta.setSaldo(tarjeta.getSaldo()-valor);
			tarjetaABM.modificarTarjeta(tarjeta);
			tarifa.setValorTarifa(valor);
			c.setTarifa(tarifa);
			dao.agregar(c);
		}
	}
	public void agregarMovimientoColectivo(GregorianCalendar fecha, long nroTarjeta,int idSeccionColectivo, Transporte transpor) throws Exception {
		//////////Busqueda de objetos///////////
		TarjetaABM tarjetaAbm = new TarjetaABM();
		Tarjeta tarjeta = tarjetaAbm.traerTarjeta2(nroTarjeta);
		//TransporteABM transporteAbm = new TransporteABM();
		Transporte transporte = transpor;
		TarifaColectivoABM tarifaColectivo= new TarifaColectivoABM();
		Tarifa tarifa = new TarifaColectivo();
		Movimiento c = null;
		double valor;
		RedSubeABM redSube = new RedSubeABM();
		/////////////Calculo de Tarifa//////////////
		if(tarjeta.isTarifaSocial()) {
			tarifa= tarifaColectivo.calcularTarifaColectivoTarifaSocial(idSeccionColectivo);
		}
		else {
			tarifa = tarifaColectivo.calcularTarifaColectivoComun(idSeccionColectivo);
		}
		/////////Actualizaciones///////////////////
		c= new Movimiento(fecha,tarjeta,tarifa,transporte);
		Movimiento aux = dao.traerUltimoRedSube();
		Transporte ultimo;
		if(aux.getTransporte()==null) {
			ultimo = new Transporte();
		}else {
			ultimo = aux.getTransporte();
		}valor=redSube.calcularRedSube(c,ultimo);
		tarifa.setValorTarifa(valor);
		c.setTarifa(tarifa);
		double saldo = tarjeta.getSaldo();
		if((saldo-valor)<-20) {
			throw new Exception("Saldo Insuficiente");
		}
		else {
			tarjeta.setSaldo(tarjeta.getSaldo()-valor);
			tarjetaAbm.modificarTarjeta(tarjeta);
			tarifa.setValorTarifa(valor);
			c.setTarifa(tarifa);
			dao.agregar(c);
		}
	}
	
	public void agregarMovimientoSubte(GregorianCalendar fecha, long nroTarjeta, Transporte transpor) throws Exception {
		////////Busqueda de Objetos//////////////
		TarjetaABM tarjetaAbm = new TarjetaABM();
		Tarjeta tarjeta = tarjetaAbm.traerTarjeta2(nroTarjeta);
		//TransporteABM transporteAbm = new TransporteABM();
		Transporte transporte = transpor;
		TarifaSubteABM tarifaSubte= new TarifaSubteABM();
		Tarifa tarifa = new TarifaSubte();
		Movimiento c = null;
		double valor;
		RedSubeABM redSube = new RedSubeABM();
		/////////Calculo descuentos Subte mensuales///////////////
		if (tarjeta.getMesDescuentoViajesSubte()!=fecha.get(Calendar.MONTH)){
			tarjeta.setMesDescuentoViajesSubte(fecha.get(Calendar.MONTH));
			tarjeta.setContadorViajesSubte(1);
			tarjetaAbm.modificarTarjeta(tarjeta);
		}
		///////////////Calculo Tarifa/////////////////
		if(tarjeta.isTarifaSocial()) {
			tarifa = tarifaSubte.calcularTarifaSubteTarifaSocal(tarjeta.getContadorViajesSubte());
		}
		else {
			tarifa = tarifaSubte.calcularTarifaSubteComun(tarjeta.getContadorViajesSubte());
		}
		/////////Actualizaciones///////////////
		c= new Movimiento(fecha,tarjeta,tarifa,transporte);
		Movimiento aux = dao.traerUltimoRedSube();
		Transporte ultimo;
		if(aux.getTransporte()==null) {
			ultimo = new Transporte();
		}else {
			ultimo = aux.getTransporte();
		}
		valor=redSube.calcularRedSube(c,ultimo);
		tarifa.setValorTarifa(valor);
		c.setTarifa(tarifa);
		double saldo = tarjeta.getSaldo();
		if((saldo-valor)<-20) {
			throw new Exception("Saldo Insuficiente");
		}
		else {
			int contadorViajesSubte=tarjeta.getContadorViajesSubte()+1;
			tarjeta.setContadorViajesSubte(contadorViajesSubte);
			tarjeta.setSaldo(tarjeta.getSaldo()-valor);
			tarjetaAbm.modificarTarjeta(tarjeta);
			tarifa.setValorTarifa(valor);
			c.setTarifa(tarifa);
			dao.agregar(c);
		}
	}
//*************************************Movimiento Recarga***************************************	
	public void agregarMovimientoRecarga(GregorianCalendar fecha, long nroTarjeta, double valor) throws Exception {
		/////Busqueda de Objetos//////////
		TarjetaABM tarjetaAbm = new TarjetaABM();
		Tarjeta tarjeta = tarjetaAbm.traerTarjeta2(nroTarjeta);
		TransporteABM transporteAbm = new TransporteABM();
		Transporte transporte = transporteAbm.traerTransporte(12);
		double saldo = tarjeta.getSaldo()+valor;
		//////////Calculo de que la recarga sea mayor que el saldo negativo////////////
		if(saldo<0) {
			throw new Exception ("Error. Valor de recarga no supera saldo negativo");
		}
		//////Actualizaciones/////
		tarjeta.setSaldo(saldo);
		tarjetaAbm.modificarTarjeta(tarjeta);
		TarifaABM tarifaAbm = new TarifaABM();
		tarifaAbm.agregarTarifa(valor);
		Tarifa tarifa = tarifaAbm.traerUltima();
		Movimiento movimiento = new Movimiento(fecha, tarjeta, tarifa,transporte);
		dao.agregar(movimiento);
	}
	
	
	//***************************Estadisticas Generales******************************
	
	//
	public List<Movimiento> traerMovimientoTrasporte(GregorianCalendar fechaInicio,GregorianCalendar fechaFin, int tipoTransporte){
		return dao.traerMovimientoTransporte(fechaInicio, fechaFin, tipoTransporte);
	}
	//------------------
	//CHEQUEADO
	public int traerCantidadMovimientosTransporte(long tipoTransporte,GregorianCalendar fechaInicio,GregorianCalendar fechaFin) {
		
		List<Movimiento> lstMovimiento= dao.traerMovimientoIdTransporte(fechaInicio, fechaFin, tipoTransporte);
		int cantidadMovimientos=lstMovimiento.size();
		return cantidadMovimientos;
		
		}
	//--------	
	//********************************************************************************

	//***************************Estadisticas Colectivo*******************************
	
	

	//CHEQUEADO!!! MOVIMIENTOS LINEA COLECTIVO
	public List<Movimiento> traerMovimientoLineaColectivo(GregorianCalendar fechaHoraInicio,GregorianCalendar fechaHoraFinal,int tipoTransporte,long linea) throws Exception{
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
		//--------------
		//CHEQUEADO!!! MOVIMIENTOS DE UN INTERNO Y UNA LINEA							
	}
	//CHEQUEADO!!! CANTIDAD TRAMO COLECTIVO
		public int[] traerMovimientoTramoColectivo(GregorianCalendar fechaHoraInicio,GregorianCalendar fechaHoraFinal,int tipoTransporte) throws Exception{
			List<Movimiento> lstMovimiento= dao.traerMovimientoTransporte(fechaHoraInicio, fechaHoraFinal, tipoTransporte);
			SeccionColectivoABM seccionABM= new SeccionColectivoABM();
			TarifaColectivoABM tarifaABM = new TarifaColectivoABM();
			int[] cantidad = new int[5];
			for(Movimiento s: lstMovimiento) {
				for(int i=1;i<=5;i++) {
					SeccionColectivo seccionC = seccionABM.traerSeccionColectivo(i);
					TarifaColectivo tarifa = tarifaABM.traerTarifaColectivo(s.getTarifa().getIdTarifa());
					if(tarifa.getSeccion().getIdSeccion()==seccionC.getIdSeccion()) {
						cantidad[i-1]=cantidad[i-1]+1;
					}
				}	
			}
			return cantidad;
										
		}
		//CHEQUEADO!!! MONTO TRAMO COLECTIVO
		public double[] traerMontoTramoColectivo(GregorianCalendar fechaHoraInicio,GregorianCalendar fechaHoraFinal,int tipoTransporte) throws Exception{
			List<Movimiento> lstMovimiento= dao.traerMovimientoTransporte(fechaHoraInicio, fechaHoraFinal, tipoTransporte);
			SeccionColectivoABM seccionABM= new SeccionColectivoABM();
			TarifaColectivoABM tarifaABM = new TarifaColectivoABM();
			double[] monto = new double[5];
			for(Movimiento s: lstMovimiento) {
				for(int i=1;i<=5;i++) {
					SeccionColectivo seccionC = seccionABM.traerSeccionColectivo(i);
					TarifaColectivo tarifa = tarifaABM.traerTarifaColectivo(s.getTarifa().getIdTarifa());
					if(tarifa.getSeccion().getIdSeccion()==seccionC.getIdSeccion()) {
						monto[i-1]=monto[i-1]+tarifa.getValorTarifa();
					}
				}	
			}
			return monto;
					//--------------
					//CHEQUEADO!!! MOVIMIENTOS DE UN INTERNO Y UNA LINEA							
				}
	public List<Movimiento> traerMovimientoLineaInterno(GregorianCalendar fechaHoraInicio,GregorianCalendar fechaHoraFinal,int tipoTransporte,int linea,int interno) throws Exception{
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
	//--------------
	//CHEQUEADO!!! MONTO RECAUDADO DE UNA LINEA POR DIA						
	public double traerMontoRecaudadoLineaColectivoPorDia(GregorianCalendar fecha,int tipoTransporte,int linea) throws Exception{
		GregorianCalendar fechaInicio=new GregorianCalendar();
		fechaInicio.set(Funciones.traerAnio(fecha), Funciones.traerMes(fecha)-1, Funciones.traerDia(fecha), 00, 00,00);

		GregorianCalendar fechaFin=new GregorianCalendar();
		fechaFin.set(Funciones.traerAnio(fecha), Funciones.traerMes(fecha)-1, Funciones.traerDia(fecha), 23, 59,59);


		double sumador=0;
		for(Movimiento movimiento : this.traerMovimientoLineaColectivo(fechaInicio, fechaFin, tipoTransporte, linea)) {
			//movimiento=movimientoABM.traerMovimiento(idMovimiento);
			sumador=sumador+movimiento.getTarifa().getValorTarifa();
		}

		return sumador;
	}
	//--------------
	//CHEQUEADO!!! MONTO RECUADADO DE UNA LINEA POR MES
	public double traerMontoRecaudadoLineaColectivo(GregorianCalendar fechaInicio,GregorianCalendar fechaFin, int tipoTransporte,long linea) throws Exception {
		double sumador=0;
		
		for(Movimiento movimiento : this.traerMovimientoLineaColectivo(fechaInicio, fechaFin, tipoTransporte, linea)) {
			//movimiento=movimientoABM.traerMovimiento(idMovimiento);
			sumador=sumador+movimiento.getTarifa().getValorTarifa();
			
			
		}
		return sumador;
	}
	//----------------
	//INFORME GENERAL
	/*public ArrayList<String> informeGeneralColectivoAnio(int anio, int tipoTransporte) throws Exception {
		
		ArrayList<String> informe= new ArrayList<String>();
		GregorianCalendar fechaInicio=new GregorianCalendar(anio,0,1,00,00,00);
		GregorianCalendar fechaFin=new GregorianCalendar(anio,11,31,23,59,59);
		List<Movimiento> lstMovimiento= dao.traerMovimientoTransporte(fechaInicio, fechaFin, tipoTransporte);
		String agregar=null;
		ColectivoABM lineaABM = new ColectivoABM();
		//agregar cantidad viajes bondi
		agregar="Hubo un total de "+ this.traerMovimientoTrasporte(fechaInicio, fechaFin, tipoTransporte);
		informe.add(agregar);
		//for(long linea: lineaABM.tr)
		
		return informe;
	}*/
	//----------------
	//********************************************************************************
	//***************************Estadisticas Subte***********************************
	//MOVIMIENTOS LINEA SUBTE
	public int[] traerMovimientoLineaSubte(GregorianCalendar fechaHoraInicio,GregorianCalendar fechaHoraFinal,int tipoTransporte) throws Exception{
		List<Movimiento> lstMovimiento= dao.traerMovimientoTransporte(fechaHoraInicio, fechaHoraFinal, tipoTransporte);
		int[] cantidad = new int[6];
		SubteABM subteABM= new SubteABM();
		char[] linea = {'A','B','C','D','E','H'};
		
		for(Movimiento s: lstMovimiento) {
			Subte c= subteABM.traerSubte(s.getTransporte().getIdTransporte());
			for(int i=0; i<linea.length;i++) {
				if(c.getLinea()==linea[i]) {
					cantidad[i]=cantidad[i]+1;
				}
			}
		}	
		return cantidad;
	}
		//--------------
	//CHEQUEADO!!! MONTO RECAUDADO DE UNA LINEA POR DIA						
	public double[] traerMontoRecaudadoLineaSubte(GregorianCalendar fechaInicio, GregorianCalendar fechaFin,int tipoTransporte) throws Exception{
		double[] sumador= new double[6];
		SubteABM subteABM= new SubteABM();
		char[] linea = {'A','B','C','D','E','H'};
		
		for(Movimiento movimiento : this.traerMovimientoTrasporte(fechaInicio, fechaFin, tipoTransporte)) {
			Subte c= subteABM.traerSubte(movimiento.getTransporte().getIdTransporte());
			for(int i=0; i<linea.length;i++) {
				if(c.getLinea()==linea[i]) {
					sumador[i]=sumador[i]+movimiento.getTarifa().getValorTarifa();
				}
			}
		}

		return sumador;
	}
	//********************************************************************************
	//***************************Estadisticas Tren***********************************
	//CANTIDAD MOVIMIENTOS LINEA TREN
	public int traerCantidadMovimientosLineaTrenPorDia(GregorianCalendar fecha,int tipoTransporte,int idLinea) throws Exception{

		GregorianCalendar fechaInicio=new GregorianCalendar();
		fechaInicio.set(Funciones.traerAnio(fecha), Funciones.traerMes(fecha)-1, Funciones.traerDia(fecha), 00, 00,00);

		GregorianCalendar fechaFin=new GregorianCalendar();
		fechaFin.set(Funciones.traerAnio(fecha), Funciones.traerMes(fecha)-1, Funciones.traerDia(fecha), 23, 59,59);
		
		return this.traerMovimientoLineaTren(fechaInicio, fechaFin, tipoTransporte, idLinea).size();
	}
	//-----------------------------
	//CHEQUEADO!!!  MOVIMIENTOS LINEA COLECTIVO POR DIA
	public List<Movimiento> traerMovimientosLineaTrenPorDia(GregorianCalendar fecha,int tipoTransporte,int linea) throws Exception{
		List<Movimiento> listAux = new ArrayList<Movimiento>();
		GregorianCalendar fechaInicio=new GregorianCalendar();
		fechaInicio.set(Funciones.traerAnio(fecha), Funciones.traerMes(fecha)-1, Funciones.traerDia(fecha), 00, 00,00);

		GregorianCalendar fechaFin=new GregorianCalendar();
		fechaFin.set(Funciones.traerAnio(fecha), Funciones.traerMes(fecha)-1, Funciones.traerDia(fecha), 23, 59,59);

		
		for(Movimiento movimiento : this.traerMovimientoLineaTren(fechaInicio, fechaFin, tipoTransporte, linea)) {
			listAux.add(movimiento);
		}

		return listAux;
	}
	//------------
	//MOVIMIENTOS LINEA SUBTE
	public List<Movimiento> traerMovimientoLineaTren(GregorianCalendar fechaHoraInicio,GregorianCalendar fechaHoraFinal,int tipoTransporte,int idLinea) throws Exception{
		List<Movimiento> lstMovimiento= dao.traerMovimientoTransporte(fechaHoraInicio, fechaHoraFinal, tipoTransporte);
		List<Movimiento> lstAux = new ArrayList<Movimiento>();
		TrenABM trenABM= new TrenABM();
		
		
			for(Movimiento s: lstMovimiento) {
			Tren c= trenABM.traerTren(s.getTransporte().getIdTransporte());
			if(c.getLineaTren().getIdLineaTren()==idLinea) {
				lstAux.add(s);
			}
		}
		

		return lstAux;
	}
			//--------------
	/*public List<Movimiento> traerMovimientoLineaYTren(GregorianCalendar fechaHoraInicio,GregorianCalendar fechaHoraFinal,int tipoTransporte,int idLinea,int idTren) throws Exception{
		List<Movimiento> lstMovimiento= dao.traerMovimientoTransporte(fechaHoraInicio, fechaHoraFinal, tipoTransporte);
		List<Movimiento> lstAux = new ArrayList<Movimiento>();
		TrenABM trenABM= new TrenABM();
		
		
			for(Movimiento s: lstMovimiento) {
			Tren c= trenABM.traerTren(s.getTransporte().getIdTransporte());
			if(c.getLineaTren().getIdLineaTren()==idLinea) {
				if(c.getIdTren()==idTren) {	
				lstAux.add(s);
			}
			}
		}
		

		return lstAux;
	}*/
			//--------------
	//CHEQUEADO!!! MONTO RECAUDADO DE UNA LINEA					
	public double traerMontoRecaudadoLineaTren(GregorianCalendar fechaInicio,GregorianCalendar fechaFin, int tipoTransporte) throws Exception{
		double sumador=0;
		for(Movimiento movimiento : this.traerMovimientoTrasporte(fechaInicio, fechaFin, tipoTransporte)) {
			//movimiento=movimientoABM.traerMovimiento(idMovimiento);
			sumador=sumador+movimiento.getTarifa().getValorTarifa();
		}
		return sumador;
	}
	//--------------
	//CHEQUEADO!!! MONTO RECUADADO POR TRAMO
	public double[] traerMontoRecaudadoTramoTren(GregorianCalendar fechaInicio, GregorianCalendar fechaFin, int tipoTransporte) throws Exception {
		double[] sumador= new double[3];
		SeccionTrenABM seccionAbm = new SeccionTrenABM();
		List<SeccionTren> secciones = new ArrayList<SeccionTren>();
		TarifaTrenABM tarifaAbm = new TarifaTrenABM();
		double maximoSeccionComun =0;
		double maximoTarifaSocial=0;
		boolean tarifaSocial=false;

		for(int i = 1; i<=3;i++) {

			 secciones.add(seccionAbm.traerSeccionTren(i));
			 if(i==3) {
				 maximoSeccionComun=secciones.get(i-1).getValorSeccionComun();
				 maximoTarifaSocial=secciones.get(i-1).getValorSeccionTarifaSocial();
			 }

		}

		for(Movimiento movimiento : this.traerMovimientoTrasporte(fechaInicio, fechaFin, tipoTransporte)) {
			//movimiento=movimientoABM.traerMovimiento(idMovimiento);
			TarifaTren tarifa = tarifaAbm.traerTarifaTren(movimiento.getTarifa().getIdTarifa());
			if(tarifa.getEstacionSubida().getIdEstacionTren()==tarifa.getEstacionBajada().getIdEstacionTren()) {
				if(tarifa.getValorTarifa()==maximoTarifaSocial) {
					tarifaSocial=true;
				}
			}

			for(int i=0; i<secciones.size();i++) {
				if(tarifa.getSeccion().getIdSeccionTren()==secciones.get(i).getIdSeccionTren()) {
					if(tarifa.getEstacionSubida().getIdEstacionTren()!=tarifa.getEstacionBajada().getIdEstacionTren()) {
						if(tarifaSocial) {
							sumador[i]=sumador[i]+movimiento.getTarifa().getValorTarifa()+maximoTarifaSocial;
						}else {
							sumador[i]=sumador[i]+movimiento.getTarifa().getValorTarifa()+maximoSeccionComun;						
						}
					}
				}
			}
		}
		return sumador;
	}
	//----------------
	//CHEQUEADO!!! CANTIDAD MOVIMIENTOS LINEA TREN 
	public int traerCantidadMovimientosLineaTren(GregorianCalendar fechaInicio, GregorianCalendar fechaFin, int tipoTransporte) throws Exception{
		int cantidad=0;
		TarifaTrenABM tarifaAbm = new TarifaTrenABM();
		for(Movimiento movimiento : this.traerMovimientoTrasporte(fechaInicio, fechaFin, tipoTransporte)) {
			//movimiento=movimientoABM.traerMovimiento(idMovimiento);
			TarifaTren tarifa = tarifaAbm.traerTarifaTren(movimiento.getTarifa().getIdTarifa());
			if(tarifa.getEstacionSubida().getIdEstacionTren()==tarifa.getEstacionBajada().getIdEstacionTren()) {
				cantidad=cantidad+1;
			}
		}
		return cantidad;
		
	}
	//------------
	public int[] traerCantidadViajesTramoTren(GregorianCalendar fechaInicio, GregorianCalendar fechaFin, int tipoTransporte) throws Exception {
		int[] cantidad= new int[3];
		SeccionTrenABM seccionAbm = new SeccionTrenABM();
		List<SeccionTren> secciones = new ArrayList<SeccionTren>();
		TarifaTrenABM tarifaAbm = new TarifaTrenABM();
		for(int i = 1; i<=3;i++) {
			 secciones.add(seccionAbm.traerSeccionTren(i));				 
		}
		for(Movimiento movimiento : this.traerMovimientoTrasporte(fechaInicio, fechaFin, tipoTransporte)) {
			//movimiento=movimientoABM.traerMovimiento(idMovimiento);
			TarifaTren tarifa = tarifaAbm.traerTarifaTren(movimiento.getTarifa().getIdTarifa());
			if(tarifa.getEstacionSubida().getIdEstacionTren()!=tarifa.getEstacionBajada().getIdEstacionTren()) {
				for(int i=0; i<secciones.size();i++) {
					if(tarifa.getSeccion().getIdSeccionTren()==secciones.get(i).getIdSeccionTren()) {
						cantidad[i]=cantidad[i]+1;
					}
				}
			}
		}
		return cantidad;
	}
	public List<Movimiento> traerMovimientoTrasporteTarjeta(GregorianCalendar fechaInicio,GregorianCalendar fechaFin, int tipoTransporte, long nroTarjeta){
		return dao.traerMovimientoTransporteTarjeta(fechaInicio, fechaFin, tipoTransporte,nroTarjeta);
	}
	public List<Movimiento> traerMovimientosLineaColectivoTarjeta(GregorianCalendar fechaInicio, GregorianCalendar fin ,int tipoTransporte,int linea,long nroTarjeta) throws Exception{
		List<Movimiento> listAux = new ArrayList<Movimiento>();
		ColectivoABM colectivoAbm= new ColectivoABM();
		
		for(Movimiento movimiento : this.traerMovimientoTrasporteTarjeta(fechaInicio, fin, tipoTransporte,nroTarjeta)) {
			Colectivo aux = colectivoAbm.traerColectivo(movimiento.getTransporte().getIdTransporte());
			if(aux.getLinea()==linea) {
				listAux.add(movimiento);
			}
		}
		return listAux;
	}
	public List<Movimiento> traerMovimientosLineaSubteTarjeta(GregorianCalendar fechaInicio, GregorianCalendar fin ,int tipoTransporte,char linea,long nroTarjeta) throws Exception{
		List<Movimiento> listAux = new ArrayList<Movimiento>();
		SubteABM suteAbm= new SubteABM();
		
		for(Movimiento movimiento : this.traerMovimientoTrasporteTarjeta(fechaInicio, fin, tipoTransporte, nroTarjeta)) {
			Subte aux = suteAbm.traerSubte(movimiento.getTransporte().getIdTransporte());
			if(aux.getLinea()==linea) {
				listAux.add(movimiento);
			}
		}

		return listAux;
	}
	}