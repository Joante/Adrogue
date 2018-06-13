package datos;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Funciones {

	public static boolean esBisiesto(int anio){
		boolean resultado = false;
		if(anio%4==0){
			if ((anio%100 ==0)&& (anio%400!=0)){
				}
			else{
				resultado= true;
			}
		}
		return resultado;
	}
	public static int traerAnio (GregorianCalendar fecha){
		return fecha.get(Calendar.YEAR);
	}
	public static int traerMes (GregorianCalendar fecha){
		return (fecha.get(Calendar.MONTH))+1;
	}
	public static int traerDia (GregorianCalendar fecha){
		return fecha.get(Calendar.DAY_OF_MONTH);
	}
	public static boolean esFechaValida (int anio, int mes, int dia){
		boolean resultado= false;
		boolean bis=false;
		if(anio%4==0){
			if ((anio%100 ==0)&& (anio%400!=0)){
				}
			else{
				bis=true;
			}
		}
		if(mes>=1 && mes<=12){
				switch(mes){
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					if(dia>0 && dia<32){
						resultado=true;
					}
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					if (dia>0 && dia<=30){
						resultado=true;
					}
					break;
				case 2:
					if(bis==true && dia<=29){
						resultado=true;
					}
					
					else if (dia>0&&dia<=28){
					}
					break;
				}
			}
		return resultado;
	}
	public static GregorianCalendar traerFecha (int anio, int mes, int dia){
		GregorianCalendar fecha= new GregorianCalendar();		
		if(esFechaValida(anio,mes,dia)){
			fecha.set(anio, mes, dia);
		}
		return fecha;
	}
	public static GregorianCalendar traerFechaCortaG (String fecha){
		GregorianCalendar fechaaux = new GregorianCalendar();
		SimpleDateFormat fechacorta= new SimpleDateFormat("dd/MM/yyyy");
		Date fechacor = new Date();
			try {
				fechacor = fechacorta.parse(fecha);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			fechaaux.setTime(fechacor);
		return fechaaux;
		
}
	public static String traerFechaCorta (GregorianCalendar fecha){
		SimpleDateFormat fechacorta= new SimpleDateFormat ("dd/MM/yyyy");
		fechacorta.setCalendar(fecha);
	    String dateFormatted = fechacorta.format(fecha.getTime());
	    return dateFormatted;
		
}
	public static String traerFechaCortaHora(GregorianCalendar fecha){
	SimpleDateFormat fechacorta = new SimpleDateFormat ("dd/MM/yyyy HH:mm:ss");
	fechacorta.setCalendar(fecha);
	String fechad = fechacorta.format(fecha.getTime());
	return fechad;
}
	public static GregorianCalendar traerFechaProximo(GregorianCalendar fecha, int cantdias){
	fecha.add(Calendar.DAY_OF_MONTH, cantdias);
	return fecha;
}
	public static boolean esDiaHabil(GregorianCalendar fecha){
	boolean resultado = false;
		if(fecha.get(Calendar.DAY_OF_WEEK)>1 && fecha.get(Calendar.DAY_OF_WEEK)<7){
			resultado= true;
		}
		return resultado;
	}
	public static String traerDiaDeLaSemana(GregorianCalendar fecha){
	String dia=" ";
	switch (fecha.get(Calendar.DAY_OF_WEEK)){
	case 1:
		dia="Domingo";
		break;
	case 2:
		dia="Lunes";
		break;
	case 3:
		dia="Martes";
		break;
	case 4:
		dia="Miercoles";
		break;
	case 5:
		dia="Jueves";
		break;
	case 6:
		dia="Viernes";
		break;
	case 7:
		dia="Sabado";
		break;
	}
	return dia;
}
	public static String traerMesEnLetras (GregorianCalendar fecha){
	String mes=" ";
	switch (fecha.get(Calendar.MONTH)+1){
	case 1:
		mes="Enero";
		break;
	case 2:
		mes="Febrero";
		break;
	case 3:
		mes="Marzo";
		break;
	case 4:
		mes="Abril";
		break;
	case 5:
		mes="Mayo";
		break;
	case 6:
		mes="Junio";
		break;
	case 7:
		mes="Julio";
		break;
	case 8:
		mes="Agosto";
		break;
	case 9:
		mes="Septiembre";
		break;
	case 10:
		mes="Octubre";
		break;
	case 11:
		mes="Noviembre";
		break;
	case 12:
		mes="Diciembre";
		break;
	}
	return mes;
}
	public static String traerFechaLarga (GregorianCalendar fecha){
	String resultado=Funciones.traerDiaDeLaSemana(fecha)+" "+fecha.get(Calendar.DAY_OF_MONTH)+" de "+Funciones.traerMesEnLetras(fecha)+" del "+fecha.get(Calendar.YEAR);
	return resultado;
}
	public static boolean sonIguales(GregorianCalendar fecha1, GregorianCalendar fecha){
	boolean resultado = false;
	if(fecha.equals(fecha1)){
		resultado=true;
	}
	return resultado;
	
}
	public static int cantDiasMes(int anio, int mes){	
	int cant=0;
	boolean bis=false;
	if(anio%4==0){
		if ((anio%100 ==0)&& (anio%400!=0)){
			}
		else{
			bis=true;
		}
	}
	if(mes>=1 && mes<=12){
		switch(mes){
		case 1:
			cant=31;
			break;
		case 3:
			cant=31;
			break;
		case 5:
			cant=31;
			break;
		case 7:
			cant=31;
			break;
		case 8:
			cant=31;
			break;
		case 10:
			cant=31;
			break;
		case 12:
			cant=31;
			break;
		case 4:
			cant=30;
			break;
		case 6:
			cant=30;
			break;
		case 9:
			cant=30;
			break;
		case 11:
			cant=30;
			break;
		case 2:
			if(bis==true){
				cant=29;
			}
			else{
				cant=28;
			}
			break;
		}
	}
	return cant;
}
	public static double aproximarDecimal(double valor){
	return Math.rint(valor*100)/100;
}
	public static boolean esNumero (char c){
	return Character.isDigit(c);
}
	public static boolean esLetra (char c){
	return Character.isLetter(c);
}
	@SuppressWarnings("unused")
	public static boolean esCadenaNros(String cadena){
	int numero;
	boolean resultado= false;
	try{
		numero= Integer.parseInt(cadena);
		resultado=true;
	}
	catch (Exception e){
		
	}
	return resultado; 
}
	@SuppressWarnings("unused")
	public static boolean esCandenaLetras(String cadena){
	int numero;
	boolean resultado= false;
	try{
		numero= Integer.parseInt(cadena);
	}
	catch (Exception e){
		resultado=true;
	}
	return resultado;
	}
	public static double convertirADoble(int n){
	return ((double) n);
	}
}