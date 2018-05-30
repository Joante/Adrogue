package test;

import negocio.EstacionTrenABM;
import negocio.LineaTrenABM;
import negocio.TrenABM;
import negocio.SeccionColectivoABM;
import negocio.SeccionSubteABM;
import negocio.SeccionTrenABM;
import negocio.TarifaTrenABM;

public class TestAgregarObjeto {

	public static void main(String[] args) {
		//--------------------------------AGREGAR SECCION COLECTIVO----------------------------------------------------
				SeccionColectivoABM seccionColectivoABM= new SeccionColectivoABM();
				
				String descripcion ="De 0 a 3 Kilometros";
				String descripcion2 ="De 3 a 6 Kilometros";
				String descripcion3 ="De 6 a 12 Kilometros";
				String descripcion4 ="De 12 a 30 Kilometros";
				String descripcion5 ="Mas de 30 Kilometros";
				
				seccionColectivoABM.agregarSeccionColectivo(descripcion,10,4.5);
				seccionColectivoABM.agregarSeccionColectivo(descripcion,10,4.73);
				seccionColectivoABM.agregarSeccionColectivo(descripcion,10,4.84);
				seccionColectivoABM.agregarSeccionColectivo(descripcion,10,5.07);
				seccionColectivoABM.agregarSeccionColectivo(descripcion,10,5.3);
				
				 //---------------------------------AGREGAR SECCION SUBTE-------------------------------------------------------
				   
				SeccionSubteABM seccionSubteABM= new SeccionSubteABM();
				
				seccionSubteABM.agregarSeccionSubte(1,20,7.50,3.37);
				seccionSubteABM.agregarSeccionSubte(21,30,6,2.7);
				seccionSubteABM.agregarSeccionSubte(31,40,5.25,2.35);
				seccionSubteABM.agregarSeccionSubte(41,0,4.5,2.02);
	
				
				//-------------------------------------AGREGAR SECCION TREN-------------------------------------------------
				
				SeccionTrenABM seccionTrenABM= new SeccionTrenABM();
				
				seccionTrenABM.agregarSeccionTren(2.75,1.24);
				seccionTrenABM.agregarSeccionTren(4,1.8);
				seccionTrenABM.agregarSeccionTren(5.5,2.48);
				
				//-------------------------------------AGREGAR LINEA TREN--------------------------------------------
				
				LineaTrenABM lineatrenABM = new LineaTrenABM();
				
				lineatrenABM.agregarLineaTren("Linea General Roca");
				TrenABM trenABM = new TrenABM();
				trenABM.agregarTren(1, "Tren", lineatrenABM.traerLineaTren(1));
				//------------------------------------ AGREGAR ESTACIONES DE TREN-----------------------------
				EstacionTrenABM estacionTrenABM= new EstacionTrenABM();
				
				
				estacionTrenABM.agregarEstacionTren("Plaza Constitucion",lineatrenABM.traerLineaTren(1));
				estacionTrenABM.agregarEstacionTren("Hipolito Yrigoyen",lineatrenABM.traerLineaTren(1));
				estacionTrenABM.agregarEstacionTren("Damian Santillan y Maximiliano Kosteki",lineatrenABM.traerLineaTren(1));
				estacionTrenABM.agregarEstacionTren("Gerli",lineatrenABM.traerLineaTren(1));
				estacionTrenABM.agregarEstacionTren("Lanús",lineatrenABM.traerLineaTren(1));
				estacionTrenABM.agregarEstacionTren("Remedios de Escalada",lineatrenABM.traerLineaTren(1));
				estacionTrenABM.agregarEstacionTren("Banfield",lineatrenABM.traerLineaTren(1));
				estacionTrenABM.agregarEstacionTren("Lomas de Zamora",lineatrenABM.traerLineaTren(1));
				estacionTrenABM.agregarEstacionTren("Temperley",lineatrenABM.traerLineaTren(1));
				estacionTrenABM.agregarEstacionTren("Adrogue",lineatrenABM.traerLineaTren(1));
				estacionTrenABM.agregarEstacionTren("Burzaco",lineatrenABM.traerLineaTren(1));
				estacionTrenABM.agregarEstacionTren("Longchamps",lineatrenABM.traerLineaTren(1));
				estacionTrenABM.agregarEstacionTren("Glew",lineatrenABM.traerLineaTren(1));
			
				
				//------------------------------------ AGREGAR TARIFA TREN------------------------------------
				//------ DESDE CONSTITUCION HASTA GLEW
				TarifaTrenABM tarifaTrenABM= new TarifaTrenABM();
				
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(1),estacionTrenABM.traerEstacionTren(2),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(1),estacionTrenABM.traerEstacionTren(3),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(1),estacionTrenABM.traerEstacionTren(4),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(1),estacionTrenABM.traerEstacionTren(5),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(1),estacionTrenABM.traerEstacionTren(6),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(1),estacionTrenABM.traerEstacionTren(7),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(1),estacionTrenABM.traerEstacionTren(8),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(1),estacionTrenABM.traerEstacionTren(9),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(1),estacionTrenABM.traerEstacionTren(10),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(1),estacionTrenABM.traerEstacionTren(11),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(1),estacionTrenABM.traerEstacionTren(12),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(1),estacionTrenABM.traerEstacionTren(13),seccionTrenABM.traerSeccionTren(3));
				
				
	
				//---------DESDE YRIGOYEN HASTA GLEW
				
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(2),estacionTrenABM.traerEstacionTren(3),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(2),estacionTrenABM.traerEstacionTren(4),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(2),estacionTrenABM.traerEstacionTren(5),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(2),estacionTrenABM.traerEstacionTren(6),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(2),estacionTrenABM.traerEstacionTren(7),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(2),estacionTrenABM.traerEstacionTren(8),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(2),estacionTrenABM.traerEstacionTren(9),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(2),estacionTrenABM.traerEstacionTren(10),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(2),estacionTrenABM.traerEstacionTren(11),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(2),estacionTrenABM.traerEstacionTren(12),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(2),estacionTrenABM.traerEstacionTren(13),seccionTrenABM.traerSeccionTren(2));
				
				//-------- DESDE AVELLANEDA HASTA GLEW
				
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(3),estacionTrenABM.traerEstacionTren(4),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(3),estacionTrenABM.traerEstacionTren(5),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(3),estacionTrenABM.traerEstacionTren(6),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(3),estacionTrenABM.traerEstacionTren(7),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(3),estacionTrenABM.traerEstacionTren(8),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(3),estacionTrenABM.traerEstacionTren(9),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(3),estacionTrenABM.traerEstacionTren(10),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(3),estacionTrenABM.traerEstacionTren(11),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(3),estacionTrenABM.traerEstacionTren(12),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(3),estacionTrenABM.traerEstacionTren(13),seccionTrenABM.traerSeccionTren(2));
				
				
				//--------DESDE GERLI HASTA GLEW
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(4),estacionTrenABM.traerEstacionTren(5),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(4),estacionTrenABM.traerEstacionTren(6),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(4),estacionTrenABM.traerEstacionTren(7),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(4),estacionTrenABM.traerEstacionTren(8),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(4),estacionTrenABM.traerEstacionTren(9),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(4),estacionTrenABM.traerEstacionTren(10),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(4),estacionTrenABM.traerEstacionTren(11),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(4),estacionTrenABM.traerEstacionTren(12),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(4),estacionTrenABM.traerEstacionTren(13),seccionTrenABM.traerSeccionTren(2));
				
				
				//-----DESDE LANUS HASTA GLEW
				
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(5),estacionTrenABM.traerEstacionTren(6),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(5),estacionTrenABM.traerEstacionTren(7),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(5),estacionTrenABM.traerEstacionTren(8),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(5),estacionTrenABM.traerEstacionTren(9),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(5),estacionTrenABM.traerEstacionTren(10),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(5),estacionTrenABM.traerEstacionTren(11),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(5),estacionTrenABM.traerEstacionTren(12),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(5),estacionTrenABM.traerEstacionTren(13),seccionTrenABM.traerSeccionTren(2));
			
				
			
				
				//------DESDE ESCALADA HASTA GLEW
				
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(6),estacionTrenABM.traerEstacionTren(7),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(6),estacionTrenABM.traerEstacionTren(8),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(6),estacionTrenABM.traerEstacionTren(9),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(6),estacionTrenABM.traerEstacionTren(10),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(6),estacionTrenABM.traerEstacionTren(11),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(6),estacionTrenABM.traerEstacionTren(12),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(6),estacionTrenABM.traerEstacionTren(13),seccionTrenABM.traerSeccionTren(2));
				
				

				//-----DESDE BANFIELD HASTA GLEW
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(7),estacionTrenABM.traerEstacionTren(8),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(7),estacionTrenABM.traerEstacionTren(9),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(7),estacionTrenABM.traerEstacionTren(10),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(7),estacionTrenABM.traerEstacionTren(11),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(7),estacionTrenABM.traerEstacionTren(12),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(7),estacionTrenABM.traerEstacionTren(13),seccionTrenABM.traerSeccionTren(2));
				
				
				
				//----DESDE LOMAS HASTA GLEW
				
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(8),estacionTrenABM.traerEstacionTren(9),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(8),estacionTrenABM.traerEstacionTren(10),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(8),estacionTrenABM.traerEstacionTren(11),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(8),estacionTrenABM.traerEstacionTren(12),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(8),estacionTrenABM.traerEstacionTren(13),seccionTrenABM.traerSeccionTren(2));
				
				
				//-----DESDE TEMPERLEY HASTA GLEW
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(9),estacionTrenABM.traerEstacionTren(10),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(9),estacionTrenABM.traerEstacionTren(11),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(9),estacionTrenABM.traerEstacionTren(12),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(9),estacionTrenABM.traerEstacionTren(13),seccionTrenABM.traerSeccionTren(1));
				
				
				// ------ DESDE ADROGUE HASTA GLEW
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(10),estacionTrenABM.traerEstacionTren(11),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(10),estacionTrenABM.traerEstacionTren(12),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(10),estacionTrenABM.traerEstacionTren(13),seccionTrenABM.traerSeccionTren(1));
				
				
				//---- DESDE BURZACO HASTA GLEW
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(11),estacionTrenABM.traerEstacionTren(12),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(11),estacionTrenABM.traerEstacionTren(13),seccionTrenABM.traerSeccionTren(1));
				
				
				
				//--- DESDE LONGCHAMPS A GLEW
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(12),estacionTrenABM.traerEstacionTren(13),seccionTrenABM.traerSeccionTren(1));
				
				
			
				
				//---------------------------------------------------------------------------
				//---------------------------------------------------------------------------
				
				//----DESDE GLEW A CONSTITUCION
				
				
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(13),estacionTrenABM.traerEstacionTren(1),seccionTrenABM.traerSeccionTren(3));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(13),estacionTrenABM.traerEstacionTren(2),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(13),estacionTrenABM.traerEstacionTren(3),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(13),estacionTrenABM.traerEstacionTren(4),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(13),estacionTrenABM.traerEstacionTren(5),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(13),estacionTrenABM.traerEstacionTren(6),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(13),estacionTrenABM.traerEstacionTren(7),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(13),estacionTrenABM.traerEstacionTren(8),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(13),estacionTrenABM.traerEstacionTren(9),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(13),estacionTrenABM.traerEstacionTren(10),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(13),estacionTrenABM.traerEstacionTren(11),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(13),estacionTrenABM.traerEstacionTren(12),seccionTrenABM.traerSeccionTren(1));
				
				
	
			
				
				//----DESDE LONGCHAMPS A CONSTITUCION
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(12),estacionTrenABM.traerEstacionTren(1),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(12),estacionTrenABM.traerEstacionTren(2),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(12),estacionTrenABM.traerEstacionTren(3),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(12),estacionTrenABM.traerEstacionTren(4),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(12),estacionTrenABM.traerEstacionTren(5),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(12),estacionTrenABM.traerEstacionTren(6),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(12),estacionTrenABM.traerEstacionTren(7),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(12),estacionTrenABM.traerEstacionTren(8),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(12),estacionTrenABM.traerEstacionTren(9),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(12),estacionTrenABM.traerEstacionTren(10),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(12),estacionTrenABM.traerEstacionTren(11),seccionTrenABM.traerSeccionTren(1));
				
				
				
				
				//---DESDE BURZACO A CONSTITUCION
				
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(11),estacionTrenABM.traerEstacionTren(1),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(11),estacionTrenABM.traerEstacionTren(2),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(11),estacionTrenABM.traerEstacionTren(3),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(11),estacionTrenABM.traerEstacionTren(4),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(11),estacionTrenABM.traerEstacionTren(5),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(11),estacionTrenABM.traerEstacionTren(6),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(11),estacionTrenABM.traerEstacionTren(7),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(11),estacionTrenABM.traerEstacionTren(8),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(11),estacionTrenABM.traerEstacionTren(9),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(11),estacionTrenABM.traerEstacionTren(10),seccionTrenABM.traerSeccionTren(1));
				
				
				
				//---DESDE ADROGUE A CONSTITUCION
				
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(10),estacionTrenABM.traerEstacionTren(1),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(10),estacionTrenABM.traerEstacionTren(2),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(10),estacionTrenABM.traerEstacionTren(3),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(10),estacionTrenABM.traerEstacionTren(4),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(10),estacionTrenABM.traerEstacionTren(5),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(10),estacionTrenABM.traerEstacionTren(6),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(10),estacionTrenABM.traerEstacionTren(7),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(10),estacionTrenABM.traerEstacionTren(8),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(10),estacionTrenABM.traerEstacionTren(9),seccionTrenABM.traerSeccionTren(1));
				
				
				
				//---DESDE TEMPERLEY A CONSTITUCION
				
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(9),estacionTrenABM.traerEstacionTren(1),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(9),estacionTrenABM.traerEstacionTren(2),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(9),estacionTrenABM.traerEstacionTren(3),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(9),estacionTrenABM.traerEstacionTren(4),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(9),estacionTrenABM.traerEstacionTren(5),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(9),estacionTrenABM.traerEstacionTren(6),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(9),estacionTrenABM.traerEstacionTren(7),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(9),estacionTrenABM.traerEstacionTren(8),seccionTrenABM.traerSeccionTren(1));
				
				
				//---DESDE LOMAS A CONSTITUCION
				
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(8),estacionTrenABM.traerEstacionTren(1),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(8),estacionTrenABM.traerEstacionTren(2),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(8),estacionTrenABM.traerEstacionTren(3),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(8),estacionTrenABM.traerEstacionTren(4),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(8),estacionTrenABM.traerEstacionTren(5),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(8),estacionTrenABM.traerEstacionTren(6),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(8),estacionTrenABM.traerEstacionTren(7),seccionTrenABM.traerSeccionTren(1));
				
				
				
				
				//---DESDE BANFIELD A CONSTITUCION
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(7),estacionTrenABM.traerEstacionTren(1),seccionTrenABM.traerSeccionTren(2));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(7),estacionTrenABM.traerEstacionTren(2),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(7),estacionTrenABM.traerEstacionTren(3),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(7),estacionTrenABM.traerEstacionTren(4),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(7),estacionTrenABM.traerEstacionTren(5),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(7),estacionTrenABM.traerEstacionTren(6),seccionTrenABM.traerSeccionTren(1));
				
				//---DESDE ESCALADA A CONSTITUCION
				
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(6),estacionTrenABM.traerEstacionTren(1),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(6),estacionTrenABM.traerEstacionTren(2),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(6),estacionTrenABM.traerEstacionTren(3),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(6),estacionTrenABM.traerEstacionTren(4),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(6),estacionTrenABM.traerEstacionTren(5),seccionTrenABM.traerSeccionTren(1));
				
						
				//---DESDE LANUS A CONSTITUCION
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(5),estacionTrenABM.traerEstacionTren(1),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(5),estacionTrenABM.traerEstacionTren(2),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(5),estacionTrenABM.traerEstacionTren(3),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(5),estacionTrenABM.traerEstacionTren(4),seccionTrenABM.traerSeccionTren(1));
				
				
				
				//---DESDE GERLI A CONSTITUCION
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(4),estacionTrenABM.traerEstacionTren(1),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(4),estacionTrenABM.traerEstacionTren(2),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(4),estacionTrenABM.traerEstacionTren(3),seccionTrenABM.traerSeccionTren(1));
			
				
				//---DESDE AVELLANEDA A CONSTITUCION
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(3),estacionTrenABM.traerEstacionTren(1),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(3),estacionTrenABM.traerEstacionTren(2),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(3),estacionTrenABM.traerEstacionTren(3),seccionTrenABM.traerSeccionTren(1));
				
		
				
				//---DESDE YRIGOYEN A CONSTITUCION
				
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(2),estacionTrenABM.traerEstacionTren(1),seccionTrenABM.traerSeccionTren(1));
				tarifaTrenABM.agregarTarifaTren(0,estacionTrenABM.traerEstacionTren(2),estacionTrenABM.traerEstacionTren(2),seccionTrenABM.traerSeccionTren(1));
			
			}
						
			
	}

