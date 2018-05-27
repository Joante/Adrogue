package test;
import datos.*;
import dao.*;


public abstract class TestPruebaCargaDeDatos {

	public static void main(String[] args) {
		
		//--------------------------------AGREGAR SECCION COLECTIVO----------------------------------------------------
		
		SeccionColectivoDao seccionColectivoDao = new SeccionColectivoDao();
		
		String descripcion ="De 0 a 3 Kilometros";
		SeccionColectivo sec1= new SeccionColectivo(descripcion,10,4.5);	   
		seccionColectivoDao.agregar(sec1);
		
		String descripcion2 ="De 3 a 6 Kilometros";
		SeccionColectivo sec2= new SeccionColectivo(descripcion2,10.5,4.73);	   
		seccionColectivoDao.agregar(sec2);
		
		String descripcion3 ="De 6 a 12 Kilometros";
		SeccionColectivo sec3= new SeccionColectivo(descripcion3,10.75,4.84);	   
		seccionColectivoDao.agregar(sec3);
		
		String descripcion4 ="De 12 a 30 Kilometros";
		SeccionColectivo sec4= new SeccionColectivo(descripcion4,11.25,5.07);	   
		seccionColectivoDao.agregar(sec4);
	    
		String descripcion5 ="Mas de 30 Kilometros";
		SeccionColectivo sec5= new SeccionColectivo(descripcion5,11.75,5.3);	   
		seccionColectivoDao.agregar(sec5);
	    //---------------------------------AGREGAR SECCION SUBTE-------------------------------------------------------
	   
		SeccionSubteDao seccionSubteDao = new SeccionSubteDao();
		
		SeccionSubte secS1=new SeccionSubte(1,20,7.50,3.37);
		seccionSubteDao.agregar(secS1);
		
		SeccionSubte secS2=new SeccionSubte(21,30,6,2.7);
		seccionSubteDao.agregar(secS2);
		
		SeccionSubte secS3=new SeccionSubte(31,40,5.25,2.35);
		seccionSubteDao.agregar(secS3);
		
		SeccionSubte secS4=new SeccionSubte(41,0,4.5,2.02);
		seccionSubteDao.agregar(secS4);
		
		//-------------------------------------AGREGAR SECCION TREN-------------------------------------------------
		
		SeccionTrenDao seccionTrenDao = new SeccionTrenDao();
		
		SeccionTren secT1 = new SeccionTren(2.75,1.24);
		seccionTrenDao.agregar(secT1);
		
		SeccionTren secT2 = new SeccionTren(4,1.8);
		seccionTrenDao.agregar(secT2);
		
		SeccionTren secT3 = new SeccionTren(5.5,2.48);
		seccionTrenDao.agregar(secT3);
		
		//-------------------------------------AGREGAR LINEA TREN--------------------------------------------
		
		LineaTrenDao lineaTrenDao = new LineaTrenDao();
		
		LineaTren lineaTren1 = new LineaTren("Linea General Roca");
		lineaTrenDao.agregar(lineaTren1);
		
		//------------------------------------ AGREGAR ESTACIONES DE TREN-----------------------------
		EstacionTrenDao estacionTrenDao= new EstacionTrenDao();
		
		EstacionTren estacionTren1 = new EstacionTren("Plaza Constitucion",lineaTrenDao.traerLineaTren(1));
		estacionTrenDao.agregar(estacionTren1);
		
		EstacionTren estacionTren2 = new EstacionTren("Hipolito Yrigoyen",lineaTrenDao.traerLineaTren(1));
		estacionTrenDao.agregar(estacionTren2);
		
		EstacionTren estacionTren3 = new EstacionTren("Damian Santillan y Maximiliano Kosteki",lineaTrenDao.traerLineaTren(1));
		estacionTrenDao.agregar(estacionTren3);
		
		EstacionTren estacionTren4 = new EstacionTren("Gerli",lineaTrenDao.traerLineaTren(1));
		estacionTrenDao.agregar(estacionTren4);
		
		EstacionTren estacionTren5 = new EstacionTren("Lanus",lineaTrenDao.traerLineaTren(1));
		estacionTrenDao.agregar(estacionTren5);
		
		EstacionTren estacionTren6 = new EstacionTren("Remedios de Escalda",lineaTrenDao.traerLineaTren(1));
		estacionTrenDao.agregar(estacionTren6);
		
		EstacionTren estacionTren7 = new EstacionTren("Banfield",lineaTrenDao.traerLineaTren(1));
		estacionTrenDao.agregar(estacionTren7);
		
		EstacionTren estacionTren8 = new EstacionTren("Lomas de Zamora",lineaTrenDao.traerLineaTren(1));
		estacionTrenDao.agregar(estacionTren8);
		
		EstacionTren estacionTren9 = new EstacionTren("Temperley",lineaTrenDao.traerLineaTren(1));
		estacionTrenDao.agregar(estacionTren9);
		
		EstacionTren estacionTren10 = new EstacionTren("Adrogue",lineaTrenDao.traerLineaTren(1));
		estacionTrenDao.agregar(estacionTren10);
		
		EstacionTren estacionTren11 = new EstacionTren("Burzaco",lineaTrenDao.traerLineaTren(1));
		estacionTrenDao.agregar(estacionTren11);
		
		EstacionTren estacionTren12 = new EstacionTren("LongChamps",lineaTrenDao.traerLineaTren(1));
		estacionTrenDao.agregar(estacionTren12);
		
		EstacionTren estacionTren13 = new EstacionTren("Glew",lineaTrenDao.traerLineaTren(1));
		estacionTrenDao.agregar(estacionTren13);
		
		//------------------------------------ AGREGAR TARIFA TREN------------------------------------
		//------ DESDE CONSTITUCION HASTA GLEW
		TarifaTrenDao tarifaTrenDao= new TarifaTrenDao();
		
		TarifaTren tarifaTren1= new TarifaTren(0,estacionTrenDao.traerEstacionTren(1),estacionTrenDao.traerEstacionTren(2),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren1);
		
		TarifaTren tarifaTren2= new TarifaTren(0,estacionTrenDao.traerEstacionTren(1),estacionTrenDao.traerEstacionTren(3),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren2);
		
		TarifaTren tarifaTren3= new TarifaTren(0,estacionTrenDao.traerEstacionTren(1),estacionTrenDao.traerEstacionTren(4),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren3);
		
		TarifaTren tarifaTren4= new TarifaTren(0,estacionTrenDao.traerEstacionTren(1),estacionTrenDao.traerEstacionTren(5),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren4);
		
		TarifaTren tarifaTren5= new TarifaTren(0,estacionTrenDao.traerEstacionTren(1),estacionTrenDao.traerEstacionTren(6),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren5);
		
		TarifaTren tarifaTren6= new TarifaTren(0,estacionTrenDao.traerEstacionTren(1),estacionTrenDao.traerEstacionTren(7),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren6);
		
		TarifaTren tarifaTren7= new TarifaTren(0,estacionTrenDao.traerEstacionTren(1),estacionTrenDao.traerEstacionTren(8),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren7);
		
		TarifaTren tarifaTren8= new TarifaTren(0,estacionTrenDao.traerEstacionTren(1),estacionTrenDao.traerEstacionTren(9),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren8);
		
		TarifaTren tarifaTren9= new TarifaTren(0,estacionTrenDao.traerEstacionTren(1),estacionTrenDao.traerEstacionTren(10),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren9);
		
		TarifaTren tarifaTren10= new TarifaTren(0,estacionTrenDao.traerEstacionTren(1),estacionTrenDao.traerEstacionTren(11),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren10);
		
		TarifaTren tarifaTren11= new TarifaTren(0,estacionTrenDao.traerEstacionTren(1),estacionTrenDao.traerEstacionTren(12),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren11);
		
		TarifaTren tarifaTren12= new TarifaTren(0,estacionTrenDao.traerEstacionTren(1),estacionTrenDao.traerEstacionTren(13),seccionTrenDao.traerSeccionTren(3));
		tarifaTrenDao.agregar(tarifaTren12);
		
		
		//---------DESDE YRIGOYEN HASTA GLEW
		
		TarifaTren tarifaTren13= new TarifaTren(0,estacionTrenDao.traerEstacionTren(2),estacionTrenDao.traerEstacionTren(3),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren13);
		
		TarifaTren tarifaTren14= new TarifaTren(0,estacionTrenDao.traerEstacionTren(2),estacionTrenDao.traerEstacionTren(4),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren14);
		
		TarifaTren tarifaTren15= new TarifaTren(0,estacionTrenDao.traerEstacionTren(2),estacionTrenDao.traerEstacionTren(5),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren15);
		
		TarifaTren tarifaTren16= new TarifaTren(0,estacionTrenDao.traerEstacionTren(2),estacionTrenDao.traerEstacionTren(6),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren16);
		
		TarifaTren tarifaTren17= new TarifaTren(0,estacionTrenDao.traerEstacionTren(2),estacionTrenDao.traerEstacionTren(7),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren17);
		
		TarifaTren tarifaTren18= new TarifaTren(0,estacionTrenDao.traerEstacionTren(2),estacionTrenDao.traerEstacionTren(8),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren18);
		
		TarifaTren tarifaTren19= new TarifaTren(0,estacionTrenDao.traerEstacionTren(2),estacionTrenDao.traerEstacionTren(9),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren19);
		
		TarifaTren tarifaTren20= new TarifaTren(0,estacionTrenDao.traerEstacionTren(2),estacionTrenDao.traerEstacionTren(10),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren20);
		
		TarifaTren tarifaTren21= new TarifaTren(0,estacionTrenDao.traerEstacionTren(2),estacionTrenDao.traerEstacionTren(11),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren21);
		
		TarifaTren tarifaTren22= new TarifaTren(0,estacionTrenDao.traerEstacionTren(2),estacionTrenDao.traerEstacionTren(12),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren22);
		
		TarifaTren tarifaTren23= new TarifaTren(0,estacionTrenDao.traerEstacionTren(2),estacionTrenDao.traerEstacionTren(13),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren23);
		
		//-------- DESDE AVELLANEDA HASTA GLEW
		
		TarifaTren tarifaTren24= new TarifaTren(0,estacionTrenDao.traerEstacionTren(3),estacionTrenDao.traerEstacionTren(4),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren24);
		
		TarifaTren tarifaTren25= new TarifaTren(0,estacionTrenDao.traerEstacionTren(3),estacionTrenDao.traerEstacionTren(5),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren25);
		
		TarifaTren tarifaTren26= new TarifaTren(0,estacionTrenDao.traerEstacionTren(3),estacionTrenDao.traerEstacionTren(6),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren26);
		
		TarifaTren tarifaTren27= new TarifaTren(0,estacionTrenDao.traerEstacionTren(3),estacionTrenDao.traerEstacionTren(7),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren27);
		
		TarifaTren tarifaTren28= new TarifaTren(0,estacionTrenDao.traerEstacionTren(3),estacionTrenDao.traerEstacionTren(8),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren28);
		
		TarifaTren tarifaTren29= new TarifaTren(0,estacionTrenDao.traerEstacionTren(3),estacionTrenDao.traerEstacionTren(9),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren29);
		
		TarifaTren tarifaTren30= new TarifaTren(0,estacionTrenDao.traerEstacionTren(3),estacionTrenDao.traerEstacionTren(10),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren30);
		
		TarifaTren tarifaTren31= new TarifaTren(0,estacionTrenDao.traerEstacionTren(3),estacionTrenDao.traerEstacionTren(11),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren31);
		
		TarifaTren tarifaTren32= new TarifaTren(0,estacionTrenDao.traerEstacionTren(3),estacionTrenDao.traerEstacionTren(12),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren32);
		
		TarifaTren tarifaTren33= new TarifaTren(0,estacionTrenDao.traerEstacionTren(3),estacionTrenDao.traerEstacionTren(13),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren33);
		
		//--------DESDE GERLI HASTA GLEW
		TarifaTren tarifaTren34= new TarifaTren(0,estacionTrenDao.traerEstacionTren(4),estacionTrenDao.traerEstacionTren(5),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren34);
		
		TarifaTren tarifaTren35= new TarifaTren(0,estacionTrenDao.traerEstacionTren(4),estacionTrenDao.traerEstacionTren(6),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren35);
		
		TarifaTren tarifaTren36= new TarifaTren(0,estacionTrenDao.traerEstacionTren(4),estacionTrenDao.traerEstacionTren(7),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren36);
		
		TarifaTren tarifaTren37= new TarifaTren(0,estacionTrenDao.traerEstacionTren(4),estacionTrenDao.traerEstacionTren(8),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren37);
		
		TarifaTren tarifaTren38= new TarifaTren(0,estacionTrenDao.traerEstacionTren(4),estacionTrenDao.traerEstacionTren(9),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren38);
		
		TarifaTren tarifaTren39= new TarifaTren(0,estacionTrenDao.traerEstacionTren(4),estacionTrenDao.traerEstacionTren(10),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren39);
		
		TarifaTren tarifaTren40= new TarifaTren(0,estacionTrenDao.traerEstacionTren(4),estacionTrenDao.traerEstacionTren(11),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren40);
		
		TarifaTren tarifaTren41= new TarifaTren(0,estacionTrenDao.traerEstacionTren(4),estacionTrenDao.traerEstacionTren(12),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren41);
		
		TarifaTren tarifaTren42= new TarifaTren(0,estacionTrenDao.traerEstacionTren(4),estacionTrenDao.traerEstacionTren(13),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren42);
		
		//-----DESDE LANUS HASTA GLEW
		
		TarifaTren tarifaTren43= new TarifaTren(0,estacionTrenDao.traerEstacionTren(5),estacionTrenDao.traerEstacionTren(6),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren43);
		
		TarifaTren tarifaTren44= new TarifaTren(0,estacionTrenDao.traerEstacionTren(5),estacionTrenDao.traerEstacionTren(7),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren44);
		
		TarifaTren tarifaTren45= new TarifaTren(0,estacionTrenDao.traerEstacionTren(5),estacionTrenDao.traerEstacionTren(8),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren45);
		
		TarifaTren tarifaTren46= new TarifaTren(0,estacionTrenDao.traerEstacionTren(5),estacionTrenDao.traerEstacionTren(9),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren46);
		
		TarifaTren tarifaTren47= new TarifaTren(0,estacionTrenDao.traerEstacionTren(5),estacionTrenDao.traerEstacionTren(10),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren47);
		
		TarifaTren tarifaTren48= new TarifaTren(0,estacionTrenDao.traerEstacionTren(5),estacionTrenDao.traerEstacionTren(11),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren48);
		
		TarifaTren tarifaTren49= new TarifaTren(0,estacionTrenDao.traerEstacionTren(5),estacionTrenDao.traerEstacionTren(12),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren49);
		
		TarifaTren tarifaTren50= new TarifaTren(0,estacionTrenDao.traerEstacionTren(5),estacionTrenDao.traerEstacionTren(13),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren50);
		
		//------DESDE ESCALADA HASTA GLEW
		TarifaTren tarifaTren51= new TarifaTren(0,estacionTrenDao.traerEstacionTren(6),estacionTrenDao.traerEstacionTren(7),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren51);
		
		TarifaTren tarifaTren52= new TarifaTren(0,estacionTrenDao.traerEstacionTren(6),estacionTrenDao.traerEstacionTren(8),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren52);
		
		TarifaTren tarifaTren53= new TarifaTren(0,estacionTrenDao.traerEstacionTren(6),estacionTrenDao.traerEstacionTren(9),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren53);
		
		TarifaTren tarifaTren54= new TarifaTren(0,estacionTrenDao.traerEstacionTren(6),estacionTrenDao.traerEstacionTren(10),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren54);
		
		TarifaTren tarifaTren55= new TarifaTren(0,estacionTrenDao.traerEstacionTren(6),estacionTrenDao.traerEstacionTren(11),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren55);
		
		TarifaTren tarifaTren56= new TarifaTren(0,estacionTrenDao.traerEstacionTren(6),estacionTrenDao.traerEstacionTren(12),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren56);
		
		TarifaTren tarifaTren57= new TarifaTren(0,estacionTrenDao.traerEstacionTren(6),estacionTrenDao.traerEstacionTren(13),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren57);

		//-----DESDE BANFIELD HASTA GLEW
		
		TarifaTren tarifaTren58= new TarifaTren(0,estacionTrenDao.traerEstacionTren(7),estacionTrenDao.traerEstacionTren(8),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren58);
		
		TarifaTren tarifaTren59= new TarifaTren(0,estacionTrenDao.traerEstacionTren(7),estacionTrenDao.traerEstacionTren(9),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren59);
		
		TarifaTren tarifaTren60= new TarifaTren(0,estacionTrenDao.traerEstacionTren(7),estacionTrenDao.traerEstacionTren(10),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren60);
		
		TarifaTren tarifaTren61= new TarifaTren(0,estacionTrenDao.traerEstacionTren(7),estacionTrenDao.traerEstacionTren(11),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren61);
		
		TarifaTren tarifaTren62= new TarifaTren(0,estacionTrenDao.traerEstacionTren(7),estacionTrenDao.traerEstacionTren(12),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren62);
		
		TarifaTren tarifaTren63= new TarifaTren(0,estacionTrenDao.traerEstacionTren(7),estacionTrenDao.traerEstacionTren(13),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren63);
		
		//----DESDE LOMAS HASTA GLEW
		
		TarifaTren tarifaTren64= new TarifaTren(0,estacionTrenDao.traerEstacionTren(8),estacionTrenDao.traerEstacionTren(9),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren64);
		
		TarifaTren tarifaTren65= new TarifaTren(0,estacionTrenDao.traerEstacionTren(8),estacionTrenDao.traerEstacionTren(10),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren65);
		
		TarifaTren tarifaTren66= new TarifaTren(0,estacionTrenDao.traerEstacionTren(8),estacionTrenDao.traerEstacionTren(11),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren66);
		
		TarifaTren tarifaTren67= new TarifaTren(0,estacionTrenDao.traerEstacionTren(8),estacionTrenDao.traerEstacionTren(12),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren67);
		
		TarifaTren tarifaTren68= new TarifaTren(0,estacionTrenDao.traerEstacionTren(8),estacionTrenDao.traerEstacionTren(13),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren68);
		
		//-----DESDE TEMPERLEY HASTA GLEW
		TarifaTren tarifaTren69= new TarifaTren(0,estacionTrenDao.traerEstacionTren(9),estacionTrenDao.traerEstacionTren(10),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren69);
		
		TarifaTren tarifaTren70= new TarifaTren(0,estacionTrenDao.traerEstacionTren(9),estacionTrenDao.traerEstacionTren(11),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren70);
		
		TarifaTren tarifaTren71= new TarifaTren(0,estacionTrenDao.traerEstacionTren(9),estacionTrenDao.traerEstacionTren(12),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren71);
		
		TarifaTren tarifaTren72= new TarifaTren(0,estacionTrenDao.traerEstacionTren(9),estacionTrenDao.traerEstacionTren(13),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren72);
		
		// ------ DESDE ADROGUE HASTA GLEW
		TarifaTren tarifaTren73= new TarifaTren(0,estacionTrenDao.traerEstacionTren(10),estacionTrenDao.traerEstacionTren(11),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren73);
		
		TarifaTren tarifaTren74= new TarifaTren(0,estacionTrenDao.traerEstacionTren(10),estacionTrenDao.traerEstacionTren(12),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren74);
		
		TarifaTren tarifaTren75= new TarifaTren(0,estacionTrenDao.traerEstacionTren(10),estacionTrenDao.traerEstacionTren(13),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren75);
		
		//---- DESDE BURZACO HASTA GLEW
		TarifaTren tarifaTren76= new TarifaTren(0,estacionTrenDao.traerEstacionTren(11),estacionTrenDao.traerEstacionTren(12),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren76);
		
		TarifaTren tarifaTren77= new TarifaTren(0,estacionTrenDao.traerEstacionTren(11),estacionTrenDao.traerEstacionTren(13),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren77);
		
		//--- DESDE LONGCHAMPS A GLEW
		TarifaTren tarifaTren78= new TarifaTren(0,estacionTrenDao.traerEstacionTren(12),estacionTrenDao.traerEstacionTren(13),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren78);
		
		//---------------------------------------------------------------------------
		//---------------------------------------------------------------------------
		
		//----DESDE GLEW A CONSTITUCION
		TarifaTren tarifaTren79= new TarifaTren(0,estacionTrenDao.traerEstacionTren(13),estacionTrenDao.traerEstacionTren(1),seccionTrenDao.traerSeccionTren(3));
		tarifaTrenDao.agregar(tarifaTren79);
		
		TarifaTren tarifaTren80= new TarifaTren(0,estacionTrenDao.traerEstacionTren(13),estacionTrenDao.traerEstacionTren(2),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren80);
		
		TarifaTren tarifaTren81= new TarifaTren(0,estacionTrenDao.traerEstacionTren(13),estacionTrenDao.traerEstacionTren(3),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren81);
		
		TarifaTren tarifaTren82= new TarifaTren(0,estacionTrenDao.traerEstacionTren(13),estacionTrenDao.traerEstacionTren(4),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren82);
		
		TarifaTren tarifaTren83= new TarifaTren(0,estacionTrenDao.traerEstacionTren(13),estacionTrenDao.traerEstacionTren(5),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren83);
		
		TarifaTren tarifaTren84= new TarifaTren(0,estacionTrenDao.traerEstacionTren(13),estacionTrenDao.traerEstacionTren(6),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren84);
		
		TarifaTren tarifaTren85= new TarifaTren(0,estacionTrenDao.traerEstacionTren(13),estacionTrenDao.traerEstacionTren(7),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren85);
		
		TarifaTren tarifaTren86= new TarifaTren(0,estacionTrenDao.traerEstacionTren(13),estacionTrenDao.traerEstacionTren(8),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren86);
		
		TarifaTren tarifaTren87= new TarifaTren(0,estacionTrenDao.traerEstacionTren(13),estacionTrenDao.traerEstacionTren(9),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren87);
		
		TarifaTren tarifaTren88= new TarifaTren(0,estacionTrenDao.traerEstacionTren(13),estacionTrenDao.traerEstacionTren(10),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren88);
		
		TarifaTren tarifaTren89= new TarifaTren(0,estacionTrenDao.traerEstacionTren(13),estacionTrenDao.traerEstacionTren(11),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren89);
		
		TarifaTren tarifaTren90= new TarifaTren(0,estacionTrenDao.traerEstacionTren(13),estacionTrenDao.traerEstacionTren(12),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren90);
		
		//----DESDE LONGCHAMPS A CONSTITUCION
		TarifaTren tarifaTren91= new TarifaTren(0,estacionTrenDao.traerEstacionTren(12),estacionTrenDao.traerEstacionTren(1),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren91);
		
		TarifaTren tarifaTren92= new TarifaTren(0,estacionTrenDao.traerEstacionTren(12),estacionTrenDao.traerEstacionTren(2),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren92);
		
		TarifaTren tarifaTren93= new TarifaTren(0,estacionTrenDao.traerEstacionTren(12),estacionTrenDao.traerEstacionTren(3),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren93);
		
		TarifaTren tarifaTren94= new TarifaTren(0,estacionTrenDao.traerEstacionTren(12),estacionTrenDao.traerEstacionTren(4),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren94);
		
		TarifaTren tarifaTren95= new TarifaTren(0,estacionTrenDao.traerEstacionTren(12),estacionTrenDao.traerEstacionTren(5),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren95);
		
		TarifaTren tarifaTren96= new TarifaTren(0,estacionTrenDao.traerEstacionTren(12),estacionTrenDao.traerEstacionTren(6),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren96);
		
		TarifaTren tarifaTren97= new TarifaTren(0,estacionTrenDao.traerEstacionTren(12),estacionTrenDao.traerEstacionTren(7),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren97);
		
		TarifaTren tarifaTren98= new TarifaTren(0,estacionTrenDao.traerEstacionTren(12),estacionTrenDao.traerEstacionTren(8),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren98);
		
		TarifaTren tarifaTren99= new TarifaTren(0,estacionTrenDao.traerEstacionTren(12),estacionTrenDao.traerEstacionTren(9),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren99);
		
		TarifaTren tarifaTren100= new TarifaTren(0,estacionTrenDao.traerEstacionTren(12),estacionTrenDao.traerEstacionTren(10),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren100);
		
		TarifaTren tarifaTren101= new TarifaTren(0,estacionTrenDao.traerEstacionTren(12),estacionTrenDao.traerEstacionTren(11),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren101);
		
		
		//---DESDE BURZACO A CONSTITUCION
		TarifaTren tarifaTren102= new TarifaTren(0,estacionTrenDao.traerEstacionTren(11),estacionTrenDao.traerEstacionTren(1),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren102);
		
		TarifaTren tarifaTren103= new TarifaTren(0,estacionTrenDao.traerEstacionTren(11),estacionTrenDao.traerEstacionTren(2),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren103);
		
		TarifaTren tarifaTren104= new TarifaTren(0,estacionTrenDao.traerEstacionTren(11),estacionTrenDao.traerEstacionTren(3),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren104);
		
		TarifaTren tarifaTren105= new TarifaTren(0,estacionTrenDao.traerEstacionTren(11),estacionTrenDao.traerEstacionTren(4),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren105);
		
		TarifaTren tarifaTren106= new TarifaTren(0,estacionTrenDao.traerEstacionTren(11),estacionTrenDao.traerEstacionTren(5),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren106);
		
		TarifaTren tarifaTren107= new TarifaTren(0,estacionTrenDao.traerEstacionTren(11),estacionTrenDao.traerEstacionTren(6),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren107);
		
		TarifaTren tarifaTren108= new TarifaTren(0,estacionTrenDao.traerEstacionTren(11),estacionTrenDao.traerEstacionTren(7),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren108);
		
		TarifaTren tarifaTren109= new TarifaTren(0,estacionTrenDao.traerEstacionTren(11),estacionTrenDao.traerEstacionTren(8),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren109);
		
		TarifaTren tarifaTren110= new TarifaTren(0,estacionTrenDao.traerEstacionTren(11),estacionTrenDao.traerEstacionTren(9),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren110);
		
		TarifaTren tarifaTren111= new TarifaTren(0,estacionTrenDao.traerEstacionTren(11),estacionTrenDao.traerEstacionTren(10),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren111);
		
		//---DESDE ADROGUE A CONSTITUCION
		TarifaTren tarifaTren112= new TarifaTren(0,estacionTrenDao.traerEstacionTren(10),estacionTrenDao.traerEstacionTren(1),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren112);
		
		TarifaTren tarifaTren113= new TarifaTren(0,estacionTrenDao.traerEstacionTren(10),estacionTrenDao.traerEstacionTren(2),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren113);
		
		TarifaTren tarifaTren114= new TarifaTren(0,estacionTrenDao.traerEstacionTren(10),estacionTrenDao.traerEstacionTren(3),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren114);
		
		TarifaTren tarifaTren115= new TarifaTren(0,estacionTrenDao.traerEstacionTren(10),estacionTrenDao.traerEstacionTren(4),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren115);
		
		TarifaTren tarifaTren116= new TarifaTren(0,estacionTrenDao.traerEstacionTren(10),estacionTrenDao.traerEstacionTren(5),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren116);
		
		TarifaTren tarifaTren117= new TarifaTren(0,estacionTrenDao.traerEstacionTren(10),estacionTrenDao.traerEstacionTren(6),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren117);
		
		TarifaTren tarifaTren118= new TarifaTren(0,estacionTrenDao.traerEstacionTren(10),estacionTrenDao.traerEstacionTren(7),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren118);
		
		TarifaTren tarifaTren119= new TarifaTren(0,estacionTrenDao.traerEstacionTren(10),estacionTrenDao.traerEstacionTren(8),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren119);
		
		TarifaTren tarifaTren120= new TarifaTren(0,estacionTrenDao.traerEstacionTren(10),estacionTrenDao.traerEstacionTren(9),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren120);
		
		//---DESDE TEMPERLEY A CONSTITUCION
		TarifaTren tarifaTren121= new TarifaTren(0,estacionTrenDao.traerEstacionTren(9),estacionTrenDao.traerEstacionTren(1),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren121);
		
		TarifaTren tarifaTren122= new TarifaTren(0,estacionTrenDao.traerEstacionTren(9),estacionTrenDao.traerEstacionTren(2),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren122);
		
		TarifaTren tarifaTren123= new TarifaTren(0,estacionTrenDao.traerEstacionTren(9),estacionTrenDao.traerEstacionTren(3),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren123);
		
		TarifaTren tarifaTren124= new TarifaTren(0,estacionTrenDao.traerEstacionTren(9),estacionTrenDao.traerEstacionTren(4),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren124);
		
		TarifaTren tarifaTren125= new TarifaTren(0,estacionTrenDao.traerEstacionTren(9),estacionTrenDao.traerEstacionTren(5),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren125);
		
		TarifaTren tarifaTren126= new TarifaTren(0,estacionTrenDao.traerEstacionTren(9),estacionTrenDao.traerEstacionTren(6),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren126);
		
		TarifaTren tarifaTren127= new TarifaTren(0,estacionTrenDao.traerEstacionTren(9),estacionTrenDao.traerEstacionTren(7),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren127);
		
		TarifaTren tarifaTren128= new TarifaTren(0,estacionTrenDao.traerEstacionTren(9),estacionTrenDao.traerEstacionTren(8),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren128);
		
		//---DESDE LOMAS A CONSTITUCION
		TarifaTren tarifaTren129= new TarifaTren(0,estacionTrenDao.traerEstacionTren(8),estacionTrenDao.traerEstacionTren(1),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren129);
		
		TarifaTren tarifaTren130= new TarifaTren(0,estacionTrenDao.traerEstacionTren(8),estacionTrenDao.traerEstacionTren(2),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren130);
		
		TarifaTren tarifaTren131= new TarifaTren(0,estacionTrenDao.traerEstacionTren(8),estacionTrenDao.traerEstacionTren(3),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren131);
		
		TarifaTren tarifaTren132= new TarifaTren(0,estacionTrenDao.traerEstacionTren(8),estacionTrenDao.traerEstacionTren(4),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren132);
		
		TarifaTren tarifaTren133= new TarifaTren(0,estacionTrenDao.traerEstacionTren(8),estacionTrenDao.traerEstacionTren(5),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren133);
		
		TarifaTren tarifaTren134= new TarifaTren(0,estacionTrenDao.traerEstacionTren(8),estacionTrenDao.traerEstacionTren(6),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren134);
		
		TarifaTren tarifaTren135= new TarifaTren(0,estacionTrenDao.traerEstacionTren(8),estacionTrenDao.traerEstacionTren(7),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren135);
		
		//---DESDE BANFIELD A CONSTITUCION
		TarifaTren tarifaTren136= new TarifaTren(0,estacionTrenDao.traerEstacionTren(7),estacionTrenDao.traerEstacionTren(1),seccionTrenDao.traerSeccionTren(2));
		tarifaTrenDao.agregar(tarifaTren136);
		
		TarifaTren tarifaTren137= new TarifaTren(0,estacionTrenDao.traerEstacionTren(7),estacionTrenDao.traerEstacionTren(2),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren137);
		
		TarifaTren tarifaTren138= new TarifaTren(0,estacionTrenDao.traerEstacionTren(7),estacionTrenDao.traerEstacionTren(3),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren138);
		
		TarifaTren tarifaTren139= new TarifaTren(0,estacionTrenDao.traerEstacionTren(7),estacionTrenDao.traerEstacionTren(4),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren139);
		
		TarifaTren tarifaTren140= new TarifaTren(0,estacionTrenDao.traerEstacionTren(7),estacionTrenDao.traerEstacionTren(5),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren140);
		
		TarifaTren tarifaTren141= new TarifaTren(0,estacionTrenDao.traerEstacionTren(7),estacionTrenDao.traerEstacionTren(6),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren141);

		//---DESDE ESCALADA A CONSTITUCION
		TarifaTren tarifaTren142= new TarifaTren(0,estacionTrenDao.traerEstacionTren(6),estacionTrenDao.traerEstacionTren(1),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren142);
		
		TarifaTren tarifaTren143= new TarifaTren(0,estacionTrenDao.traerEstacionTren(6),estacionTrenDao.traerEstacionTren(2),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren143);
		
		TarifaTren tarifaTren144= new TarifaTren(0,estacionTrenDao.traerEstacionTren(6),estacionTrenDao.traerEstacionTren(3),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren144);
		
		TarifaTren tarifaTren145= new TarifaTren(0,estacionTrenDao.traerEstacionTren(6),estacionTrenDao.traerEstacionTren(4),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren145);
		
		TarifaTren tarifaTren146= new TarifaTren(0,estacionTrenDao.traerEstacionTren(6),estacionTrenDao.traerEstacionTren(5),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren146);
		
		//---DESDE LANUS A CONSTITUCION
		TarifaTren tarifaTren147= new TarifaTren(0,estacionTrenDao.traerEstacionTren(5),estacionTrenDao.traerEstacionTren(1),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren147);
		
		TarifaTren tarifaTren148= new TarifaTren(0,estacionTrenDao.traerEstacionTren(5),estacionTrenDao.traerEstacionTren(2),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren148);
		
		TarifaTren tarifaTren149= new TarifaTren(0,estacionTrenDao.traerEstacionTren(5),estacionTrenDao.traerEstacionTren(3),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren149);
		
		TarifaTren tarifaTren150= new TarifaTren(0,estacionTrenDao.traerEstacionTren(5),estacionTrenDao.traerEstacionTren(4),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren150);
		
		//---DESDE GERLI A CONSTITUCION
		TarifaTren tarifaTren151= new TarifaTren(0,estacionTrenDao.traerEstacionTren(4),estacionTrenDao.traerEstacionTren(1),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren151);
		
		TarifaTren tarifaTren152= new TarifaTren(0,estacionTrenDao.traerEstacionTren(4),estacionTrenDao.traerEstacionTren(2),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren152);
		
		TarifaTren tarifaTren153= new TarifaTren(0,estacionTrenDao.traerEstacionTren(4),estacionTrenDao.traerEstacionTren(3),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren153);
		
		//---DESDE AVELLANEDA A CONSTITUCION
		TarifaTren tarifaTren154= new TarifaTren(0,estacionTrenDao.traerEstacionTren(3),estacionTrenDao.traerEstacionTren(1),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren154);
		
		TarifaTren tarifaTren155= new TarifaTren(0,estacionTrenDao.traerEstacionTren(3),estacionTrenDao.traerEstacionTren(2),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren155);
		
		TarifaTren tarifaTren156= new TarifaTren(0,estacionTrenDao.traerEstacionTren(3),estacionTrenDao.traerEstacionTren(3),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren156);
		
		//---DESDE YRIGOYEN A CONSTITUCION
		TarifaTren tarifaTren157= new TarifaTren(0,estacionTrenDao.traerEstacionTren(2),estacionTrenDao.traerEstacionTren(1),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren157);
		
		TarifaTren tarifaTren158= new TarifaTren(0,estacionTrenDao.traerEstacionTren(2),estacionTrenDao.traerEstacionTren(2),seccionTrenDao.traerSeccionTren(1));
		tarifaTrenDao.agregar(tarifaTren158);
	
	}
}
