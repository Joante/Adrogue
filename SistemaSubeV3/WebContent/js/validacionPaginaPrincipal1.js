		function validar1(){
			var formulario = document.getElementById('form1');

			var parametro1= formulario.anio.value;
			var parametro2= formulario.mes.value;
			var parametro3= formulario.dia.value;
			var parametro4= formulario.hora.value;
			var parametro5= formulario.min.value;
			var parametro6= formulario.hora2.value;
			var parametro7= formulario.min2.value;
			
			if(isNaN(parametro1) || isNaN(parametro2) || isNaN(parametro3) || isNaN(parametro4) || isNaN(parametro5) ||isNaN(parametro6) || isNaN(parametro7)){
				alert("ERROR:EN LOS CAMPOS DE FECHA SOLO VAN NUMEROS!!!");
				return false;
			}else if(parametro1.length != 4){
				alert("ERROR:EL GATO SOLO PUEDE TENER 4 CIFRAS!!!");
				return false;
			}else if(parametro2.length < 1 || parametro2.length >2){
				alert("ERROR:EL MES SOLO PUEDE CONTENER 1 O 2 CIFRAS!!!");
				return false;
			}else if(parametro2<1 || parametro2>12){
				alert("ERROR: EL MES SOLO PUEDE CONTENER NUMEROS DEL 1 AL 12!!!");
				return false;

			}else if(parametro4<1 || parametro4>23){
				alert("ERROR: LA HORA SUBIDA SOLO PUEDE CONTENER NUMEROS DEL 0 AL 23!!!");
				
				return false;
			
			}else if(parametro5<1 || parametro5>59){
				alert("ERROR: LOS MINUTOS SUBIDA SOLO PUEDE CONTENER NUMEROS DEL 1 AL 59!!!");
				return false;
			
			}else if(parametro6<1 || parametro6>23){
				alert("ERROR: LA HORA BAJADA SOLO PUEDE CONTENER NUMEROS DEL 1 AL 23!!!");
				return false;
			
			}else if(parametro7<1 || parametro7>59){
				alert("ERROR: LOS MINUTOS BAJADA SOLO PUEDE CONTENER NUMEROS DEL 1 AL 59!!!");
				return false;
			}

		};
		


		function validar2(){
			var formulario2 = document.getElementById('form2');

			var parametroB1= formulario2.anio2.value;
			var parametroB2= formulario2.mes2.value;
			var parametroB3= formulario2.dia2.value;
			var parametroB4= formulario2.hoora2.value;
			var parametroB5= formulario2.mmin2.value;
			
			if(isNaN(parametroB1) || isNaN(parametroB2) || isNaN(parametroB3) || isNaN(parametroB4) || isNaN(parametroB5)){
				alert("ERROR:EN LOS CAMPOS2  DE FECHA SOLO VAN NUMEROS!!!");
				return false;
			}else if(parametroB1.length != 4){
				alert("ERROR:EL GATO SOLO PUEDE TENER 4 CIFRAS!!!");
				return false;
			}else if(parametroB2.length < 1 || parametroB2.length >2){
				alert("ERROR:EL MES SOLO PUEDE CONTENER 1 O 2 CIFRAS!!!");
				return false;
			}else if(parametroB2<1 || parametroB2>12){
				alert("ERROR: EL MES SOLO PUEDE CONTENER NUMEROS DEL 1 AL 12!!!");
				return false;

			}else if(parametroB4<1 || parametroB4>23){
				alert("ERROR: LA HORA SUBIDA SOLO PUEDE CONTENER NUMEROS DEL 1 AL 23!!!");
				
				return false;
			
			}else if(parametroB5<1 || parametroB5>60){
				alert("ERROR: LOS MINUTOS SUBIDA SOLO PUEDE CONTENER NUMEROS DEL 1 AL 59!!!");
				return false;
			
			}
		

		};


		function validar3(){
			var formulario3 = document.getElementById('form3');

			var parametroC1= formulario3.anio3.value;
			var parametroC2= formulario3.mes3.value;
			var parametroC3= formulario3.dia3.value;
			var parametroC4= formulario3.hora3.value;
			var parametroC5= formulario3.min3.value;
			
			if(isNaN(parametroC1) || isNaN(parametroC2) || isNaN(parametroC3) || isNaN(parametroC4) || isNaN(parametroC5)){
				alert("ERROR:EN LOS CAMPOS DE FECHA SOLO VAN NUMEROS!!!");
				return false;
			}else if(parametroC1.length != 4){
				alert("ERROR:EL GATO SOLO PUEDE TENER 4 CIFRAS!!!");
				return false;
			}else if(parametroC2.length < 1 || parametroC2.length >2){
				alert("ERROR:EL MES SOLO PUEDE CONTENER 1 O 2 CIFRAS!!!");
				return false;
			}else if(parametroC2<1 || parametroC2>12){
				alert("ERROR: EL MES SOLO PUEDE CONTENER NUMEROS DEL 1 AL 12!!!");
				return false;

			}else if(parametroC4<1 || parametroC4>23){
				alert("ERROR: LA HORA SUBIDA SOLO PUEDE CONTENER NUMEROS DEL 1 AL 23!!!");
				
				return false;
			
			}else if(parametroC5<1 || parametroC5>59){
				alert("ERROR: LOS MINUTOS SUBIDA SOLO PUEDE CONTENER NUMEROS DEL 1 AL 59!!!");
				return false;
			
			}

		};


		function validar4(){
			var formulario4 = document.getElementById('form4');
			
			var parametroD1= formulario4.anio4.value;
			var parametroD2= formulario4.mes4.value;
			var parametroD3= formulario4.dia4.value;
			var parametroD4= formulario4.hora4.value;
			var parametroD5= formulario4.min4.value;
			var parametroD6= formulario4.monto.value
			
			if(isNaN(parametroD1) || isNaN(parametroD2) || isNaN(parametroD3) || isNaN(parametroD4) || isNaN(parametroD5)|| isNaN(parametroD6)){
				alert("ERROR:EN LOS CAMPOS DE FECHA SOLO VAN NUMEROS!!!");
				return false;
			}else if(parametroD1.length != 4){
				alert("ERROR:EL GATO SOLO PUEDE TENER 4 CIFRAS!!!");
				return false;
			}else if(parametroD2.length < 1 || parametroD2.length >2){
				alert("ERROR:EL MES SOLO PUEDE CONTENER 1 O 2 CIFRAS!!!");
				return false;
			}else if(parametroD2<1 || parametroD2>12){
				alert("ERROR: EL MES SOLO PUEDE CONTENER NUMEROS DEL 1 AL 12!!!");
				return false;

			}else if(parametroD4<1 || parametroD4>23){
				alert("ERROR: LA HORA SUBIDA SOLO PUEDE CONTENER NUMEROS DEL 1 AL 23!!!");
				
				return false;
			
			}else if(parametroD5<1 || parametroD5>60){
				alert("ERROR: LOS MINUTOS SUBIDA SOLO PUEDE CONTENER NUMEROS DEL 1 AL 59!!!");
				return false;
			
			}
		 };
