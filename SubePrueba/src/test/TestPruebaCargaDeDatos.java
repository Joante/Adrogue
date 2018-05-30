package test;
import datos.*;
import negocio.EstacionTrenABM;
import negocio.LineaTrenABM;
import negocio.SeccionTrenABM;
import negocio.TarifaTrenABM;
import negocio.TrenABM;
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
		/*
		SeccionSubte secS1=new SeccionSubte(1,20,7.50,3.37);
		seccionSubteDao.agregar(secS1);
		
		SeccionSubte secS2=new SeccionSubte(21,30,6,2.7);
		seccionSubteDao.agregar(secS2);
		
		SeccionSubte secS3=new SeccionSubte(31,40,5.25,2.35);
		seccionSubteDao.agregar(secS3);
		
		SeccionSubte secS4=new SeccionSubte(41,0,4.5,2.02);
		seccionSubteDao.agregar(secS4);
		*/
		//-------------------------------------AGREGAR SECCION TREN-------------------------------------------------
		
		SeccionTrenABM seccionlineaTrenAbm = new SeccionTrenABM();
		/*
		seccionlineaTrenAbm.agregarSeccionTren(2.75,1.24);
		
		seccionlineaTrenAbm.agregarSeccionTren(4,1.8);
		
		seccionlineaTrenAbm.agregarSeccionTren(5.5,2.48);
		*/
		//-------------------------------------AGREGAR LINEA TREN--------------------------------------------
		
		LineaTrenABM lineaTrenAbm = new LineaTrenABM();
		TrenABM trenAbm = new TrenABM();
		//lineaTrenAbm.agregarLineaTren("Linea Roca");
		//trenAbm.agregarTren(1, "Tren", lineaTrenAbm.traerLineaTren(1));
		
		//------------------------------------ AGREGAR ESTACIONES DE TREN-----------------------------
		EstacionTrenABM estacionlineaTrenAbm= new EstacionTrenABM();
		
		estacionlineaTrenAbm.agregarEstacionTren("Plaza Constitucion",lineaTrenAbm.traerLineaTren(1));
		estacionlineaTrenAbm.agregarEstacionTren("Hipolito Yrigoyen",lineaTrenAbm.traerLineaTren(1));
		estacionlineaTrenAbm.agregarEstacionTren("Damian Santillan y Maximiliano Kosteki",lineaTrenAbm.traerLineaTren(1));
		estacionlineaTrenAbm.agregarEstacionTren("Gerli",lineaTrenAbm.traerLineaTren(1));
		estacionlineaTrenAbm.agregarEstacionTren("Lanús",lineaTrenAbm.traerLineaTren(1));
		estacionlineaTrenAbm.agregarEstacionTren("Remedios de Escalada",lineaTrenAbm.traerLineaTren(1));
		estacionlineaTrenAbm.agregarEstacionTren("Banfield",lineaTrenAbm.traerLineaTren(1));
		estacionlineaTrenAbm.agregarEstacionTren("Lomas de Zamora",lineaTrenAbm.traerLineaTren(1));
		estacionlineaTrenAbm.agregarEstacionTren("Temperley",lineaTrenAbm.traerLineaTren(1));
		estacionlineaTrenAbm.agregarEstacionTren("Adrogue",lineaTrenAbm.traerLineaTren(1));
		estacionlineaTrenAbm.agregarEstacionTren("Burzaco",lineaTrenAbm.traerLineaTren(1));
		estacionlineaTrenAbm.agregarEstacionTren("Longchamps",lineaTrenAbm.traerLineaTren(1));
		estacionlineaTrenAbm.agregarEstacionTren("Glew",lineaTrenAbm.traerLineaTren(1));
		
		//------------------------------------ AGREGAR TARIFA TREN------------------------------------
		//------ DESDE CONSTITUCION HASTA GLEW
		TarifaTrenABM tarifaTrenABM= new TarifaTrenABM();
		
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(1),estacionlineaTrenAbm.traerEstacionTren(2),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(1),estacionlineaTrenAbm.traerEstacionTren(3),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(1),estacionlineaTrenAbm.traerEstacionTren(4),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(1),estacionlineaTrenAbm.traerEstacionTren(5),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(1),estacionlineaTrenAbm.traerEstacionTren(6),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(1),estacionlineaTrenAbm.traerEstacionTren(7),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(1),estacionlineaTrenAbm.traerEstacionTren(8),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(1),estacionlineaTrenAbm.traerEstacionTren(9),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(1),estacionlineaTrenAbm.traerEstacionTren(10),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(1),estacionlineaTrenAbm.traerEstacionTren(11),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(1),estacionlineaTrenAbm.traerEstacionTren(12),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(1),estacionlineaTrenAbm.traerEstacionTren(13),seccionlineaTrenAbm.traerSeccionTren(3));
		
		

		//---------DESDE YRIGOYEN HASTA GLEW
		
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(2),estacionlineaTrenAbm.traerEstacionTren(3),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(2),estacionlineaTrenAbm.traerEstacionTren(4),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(2),estacionlineaTrenAbm.traerEstacionTren(5),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(2),estacionlineaTrenAbm.traerEstacionTren(6),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(2),estacionlineaTrenAbm.traerEstacionTren(7),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(2),estacionlineaTrenAbm.traerEstacionTren(8),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(2),estacionlineaTrenAbm.traerEstacionTren(9),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(2),estacionlineaTrenAbm.traerEstacionTren(10),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(2),estacionlineaTrenAbm.traerEstacionTren(11),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(2),estacionlineaTrenAbm.traerEstacionTren(12),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(2),estacionlineaTrenAbm.traerEstacionTren(13),seccionlineaTrenAbm.traerSeccionTren(2));
		
		//-------- DESDE AVELLANEDA HASTA GLEW
		
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(3),estacionlineaTrenAbm.traerEstacionTren(4),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(3),estacionlineaTrenAbm.traerEstacionTren(5),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(3),estacionlineaTrenAbm.traerEstacionTren(6),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(3),estacionlineaTrenAbm.traerEstacionTren(7),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(3),estacionlineaTrenAbm.traerEstacionTren(8),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(3),estacionlineaTrenAbm.traerEstacionTren(9),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(3),estacionlineaTrenAbm.traerEstacionTren(10),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(3),estacionlineaTrenAbm.traerEstacionTren(11),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(3),estacionlineaTrenAbm.traerEstacionTren(12),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(3),estacionlineaTrenAbm.traerEstacionTren(13),seccionlineaTrenAbm.traerSeccionTren(2));
		
		
		//--------DESDE GERLI HASTA GLEW
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(4),estacionlineaTrenAbm.traerEstacionTren(5),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(4),estacionlineaTrenAbm.traerEstacionTren(6),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(4),estacionlineaTrenAbm.traerEstacionTren(7),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(4),estacionlineaTrenAbm.traerEstacionTren(8),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(4),estacionlineaTrenAbm.traerEstacionTren(9),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(4),estacionlineaTrenAbm.traerEstacionTren(10),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(4),estacionlineaTrenAbm.traerEstacionTren(11),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(4),estacionlineaTrenAbm.traerEstacionTren(12),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(4),estacionlineaTrenAbm.traerEstacionTren(13),seccionlineaTrenAbm.traerSeccionTren(2));
		
		
		//-----DESDE LANUS HASTA GLEW
		
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(5),estacionlineaTrenAbm.traerEstacionTren(6),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(5),estacionlineaTrenAbm.traerEstacionTren(7),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(5),estacionlineaTrenAbm.traerEstacionTren(8),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(5),estacionlineaTrenAbm.traerEstacionTren(9),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(5),estacionlineaTrenAbm.traerEstacionTren(10),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(5),estacionlineaTrenAbm.traerEstacionTren(11),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(5),estacionlineaTrenAbm.traerEstacionTren(12),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(5),estacionlineaTrenAbm.traerEstacionTren(13),seccionlineaTrenAbm.traerSeccionTren(2));
	
		
	
		
		//------DESDE ESCALADA HASTA GLEW
		
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(6),estacionlineaTrenAbm.traerEstacionTren(7),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(6),estacionlineaTrenAbm.traerEstacionTren(8),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(6),estacionlineaTrenAbm.traerEstacionTren(9),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(6),estacionlineaTrenAbm.traerEstacionTren(10),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(6),estacionlineaTrenAbm.traerEstacionTren(11),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(6),estacionlineaTrenAbm.traerEstacionTren(12),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(6),estacionlineaTrenAbm.traerEstacionTren(13),seccionlineaTrenAbm.traerSeccionTren(2));
		
		

		//-----DESDE BANFIELD HASTA GLEW
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(7),estacionlineaTrenAbm.traerEstacionTren(8),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(7),estacionlineaTrenAbm.traerEstacionTren(9),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(7),estacionlineaTrenAbm.traerEstacionTren(10),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(7),estacionlineaTrenAbm.traerEstacionTren(11),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(7),estacionlineaTrenAbm.traerEstacionTren(12),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(7),estacionlineaTrenAbm.traerEstacionTren(13),seccionlineaTrenAbm.traerSeccionTren(2));
		
		
		
		//----DESDE LOMAS HASTA GLEW
		
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(8),estacionlineaTrenAbm.traerEstacionTren(9),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(8),estacionlineaTrenAbm.traerEstacionTren(10),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(8),estacionlineaTrenAbm.traerEstacionTren(11),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(8),estacionlineaTrenAbm.traerEstacionTren(12),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(8),estacionlineaTrenAbm.traerEstacionTren(13),seccionlineaTrenAbm.traerSeccionTren(2));
		
		
		//-----DESDE TEMPERLEY HASTA GLEW
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(9),estacionlineaTrenAbm.traerEstacionTren(10),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(9),estacionlineaTrenAbm.traerEstacionTren(11),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(9),estacionlineaTrenAbm.traerEstacionTren(12),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(9),estacionlineaTrenAbm.traerEstacionTren(13),seccionlineaTrenAbm.traerSeccionTren(1));
		
		
		// ------ DESDE ADROGUE HASTA GLEW
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(10),estacionlineaTrenAbm.traerEstacionTren(11),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(10),estacionlineaTrenAbm.traerEstacionTren(12),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(10),estacionlineaTrenAbm.traerEstacionTren(13),seccionlineaTrenAbm.traerSeccionTren(1));
		
		
		//---- DESDE BURZACO HASTA GLEW
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(11),estacionlineaTrenAbm.traerEstacionTren(12),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(11),estacionlineaTrenAbm.traerEstacionTren(13),seccionlineaTrenAbm.traerSeccionTren(1));
		
		
		
		//--- DESDE LONGCHAMPS A GLEW
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(12),estacionlineaTrenAbm.traerEstacionTren(13),seccionlineaTrenAbm.traerSeccionTren(1));
		
		
	
		
		//---------------------------------------------------------------------------
		//---------------------------------------------------------------------------
		
		//----DESDE GLEW A CONSTITUCION
		
		
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(13),estacionlineaTrenAbm.traerEstacionTren(1),seccionlineaTrenAbm.traerSeccionTren(3));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(13),estacionlineaTrenAbm.traerEstacionTren(2),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(13),estacionlineaTrenAbm.traerEstacionTren(3),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(13),estacionlineaTrenAbm.traerEstacionTren(4),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(13),estacionlineaTrenAbm.traerEstacionTren(5),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(13),estacionlineaTrenAbm.traerEstacionTren(6),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(13),estacionlineaTrenAbm.traerEstacionTren(7),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(13),estacionlineaTrenAbm.traerEstacionTren(8),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(13),estacionlineaTrenAbm.traerEstacionTren(9),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(13),estacionlineaTrenAbm.traerEstacionTren(10),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(13),estacionlineaTrenAbm.traerEstacionTren(11),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(13),estacionlineaTrenAbm.traerEstacionTren(12),seccionlineaTrenAbm.traerSeccionTren(1));
		
		

	
		
		//----DESDE LONGCHAMPS A CONSTITUCION
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(12),estacionlineaTrenAbm.traerEstacionTren(1),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(12),estacionlineaTrenAbm.traerEstacionTren(2),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(12),estacionlineaTrenAbm.traerEstacionTren(3),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(12),estacionlineaTrenAbm.traerEstacionTren(4),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(12),estacionlineaTrenAbm.traerEstacionTren(5),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(12),estacionlineaTrenAbm.traerEstacionTren(6),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(12),estacionlineaTrenAbm.traerEstacionTren(7),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(12),estacionlineaTrenAbm.traerEstacionTren(8),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(12),estacionlineaTrenAbm.traerEstacionTren(9),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(12),estacionlineaTrenAbm.traerEstacionTren(10),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(12),estacionlineaTrenAbm.traerEstacionTren(11),seccionlineaTrenAbm.traerSeccionTren(1));
		
		
		
		
		//---DESDE BURZACO A CONSTITUCION
		
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(11),estacionlineaTrenAbm.traerEstacionTren(1),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(11),estacionlineaTrenAbm.traerEstacionTren(2),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(11),estacionlineaTrenAbm.traerEstacionTren(3),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(11),estacionlineaTrenAbm.traerEstacionTren(4),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(11),estacionlineaTrenAbm.traerEstacionTren(5),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(11),estacionlineaTrenAbm.traerEstacionTren(6),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(11),estacionlineaTrenAbm.traerEstacionTren(7),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(11),estacionlineaTrenAbm.traerEstacionTren(8),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(11),estacionlineaTrenAbm.traerEstacionTren(9),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(11),estacionlineaTrenAbm.traerEstacionTren(10),seccionlineaTrenAbm.traerSeccionTren(1));
		
		
		
		//---DESDE ADROGUE A CONSTITUCION
		
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(10),estacionlineaTrenAbm.traerEstacionTren(1),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(10),estacionlineaTrenAbm.traerEstacionTren(2),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(10),estacionlineaTrenAbm.traerEstacionTren(3),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(10),estacionlineaTrenAbm.traerEstacionTren(4),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(10),estacionlineaTrenAbm.traerEstacionTren(5),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(10),estacionlineaTrenAbm.traerEstacionTren(6),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(10),estacionlineaTrenAbm.traerEstacionTren(7),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(10),estacionlineaTrenAbm.traerEstacionTren(8),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(10),estacionlineaTrenAbm.traerEstacionTren(9),seccionlineaTrenAbm.traerSeccionTren(1));
		
		
		
		//---DESDE TEMPERLEY A CONSTITUCION
		
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(9),estacionlineaTrenAbm.traerEstacionTren(1),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(9),estacionlineaTrenAbm.traerEstacionTren(2),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(9),estacionlineaTrenAbm.traerEstacionTren(3),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(9),estacionlineaTrenAbm.traerEstacionTren(4),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(9),estacionlineaTrenAbm.traerEstacionTren(5),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(9),estacionlineaTrenAbm.traerEstacionTren(6),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(9),estacionlineaTrenAbm.traerEstacionTren(7),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(9),estacionlineaTrenAbm.traerEstacionTren(8),seccionlineaTrenAbm.traerSeccionTren(1));
		
		
		//---DESDE LOMAS A CONSTITUCION
		
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(8),estacionlineaTrenAbm.traerEstacionTren(1),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(8),estacionlineaTrenAbm.traerEstacionTren(2),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(8),estacionlineaTrenAbm.traerEstacionTren(3),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(8),estacionlineaTrenAbm.traerEstacionTren(4),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(8),estacionlineaTrenAbm.traerEstacionTren(5),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(8),estacionlineaTrenAbm.traerEstacionTren(6),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(8),estacionlineaTrenAbm.traerEstacionTren(7),seccionlineaTrenAbm.traerSeccionTren(1));
		
		
		
		
		//---DESDE BANFIELD A CONSTITUCION
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(7),estacionlineaTrenAbm.traerEstacionTren(1),seccionlineaTrenAbm.traerSeccionTren(2));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(7),estacionlineaTrenAbm.traerEstacionTren(2),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(7),estacionlineaTrenAbm.traerEstacionTren(3),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(7),estacionlineaTrenAbm.traerEstacionTren(4),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(7),estacionlineaTrenAbm.traerEstacionTren(5),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(7),estacionlineaTrenAbm.traerEstacionTren(6),seccionlineaTrenAbm.traerSeccionTren(1));
		
		//---DESDE ESCALADA A CONSTITUCION
		
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(6),estacionlineaTrenAbm.traerEstacionTren(1),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(6),estacionlineaTrenAbm.traerEstacionTren(2),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(6),estacionlineaTrenAbm.traerEstacionTren(3),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(6),estacionlineaTrenAbm.traerEstacionTren(4),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(6),estacionlineaTrenAbm.traerEstacionTren(5),seccionlineaTrenAbm.traerSeccionTren(1));
		
				
		//---DESDE LANUS A CONSTITUCION
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(5),estacionlineaTrenAbm.traerEstacionTren(1),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(5),estacionlineaTrenAbm.traerEstacionTren(2),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(5),estacionlineaTrenAbm.traerEstacionTren(3),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(5),estacionlineaTrenAbm.traerEstacionTren(4),seccionlineaTrenAbm.traerSeccionTren(1));
		
		
		
		//---DESDE GERLI A CONSTITUCION
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(4),estacionlineaTrenAbm.traerEstacionTren(1),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(4),estacionlineaTrenAbm.traerEstacionTren(2),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(4),estacionlineaTrenAbm.traerEstacionTren(3),seccionlineaTrenAbm.traerSeccionTren(1));
	
		
		//---DESDE AVELLANEDA A CONSTITUCION
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(3),estacionlineaTrenAbm.traerEstacionTren(1),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(3),estacionlineaTrenAbm.traerEstacionTren(2),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(3),estacionlineaTrenAbm.traerEstacionTren(3),seccionlineaTrenAbm.traerSeccionTren(1));
		

		
		//---DESDE YRIGOYEN A CONSTITUCION
		
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(2),estacionlineaTrenAbm.traerEstacionTren(1),seccionlineaTrenAbm.traerSeccionTren(1));
		tarifaTrenABM.agregarTarifaTren(0,estacionlineaTrenAbm.traerEstacionTren(2),estacionlineaTrenAbm.traerEstacionTren(2),seccionlineaTrenAbm.traerSeccionTren(1));
	}
}
