function validar(){
	var formulario = document.getElementById('form1'),
	boton = document.getElementById('iniciar'); 
	var dni = formulario.dni.value;
			
	if(isNaN(dni)){
		alert("ERROR:EN DNI SOLO VAN NUMEROS!!!");
		return false;	
	}else if(dni.length != 7 && dni.length != 8){
		alert("ERROR:El DNI DEBE TENER 7 U 8 CARACTERES!!!");
		return false;
	}
	
			
};
		
function validar2(){
	var formulario = document.getElementById('form2'),
	boton = document.getElementById('reg'); 
	var dni = formulario.dni.value;
	var nom = formulario.nom.value;
	var ape = formulario.ape.value;
	var ntar = formulario.ntar.value;
	var saldo = formulario.saldo.value;
			
	if( /[a-z][A-Z]*/.test(formulario.nom.value)==false ){
		alert('EN EL NOMBRE SOLO VAN LETRAS');
		formulario.nom.focus();
		return false;
			
	}else if(/[a-z][A-Z]*/.test(formulario.ape.value)==false ){
		alert('EN EL APELLIDO SOLO VAN LETRAS');
		formulario.ape.focus();
		return false;
			
	}else if(isNaN(dni)){
		alert("ERROR:EN DNI SOLO VAN NUMEROS!!!");
		return false;	
			
	}else if(dni.length != 7 && dni.length != 8){
		alert("ERROR:El DNI DEBE TENER 7 U 8 CARACTERES!!!");
		return false;
				
	}else if(isNaN(ntar)){
		alert("ERROR:EN EL NUMERO DE LA TARJETA SOLO VAN NUMEROS!!!");
		return false;	
				
	}else if(ntar.length != 16){
		alert("ERROR:El NUMERO DE LA TARJETA DEBE TENER 16 CARACTERES!!!");
		return false;
	}else if(isNaN(saldo)){
		alert("ERROR:El NUMERO DE LA TARJETA SOLO VAN NUMEROS!!!");
		return false;
				
	}else{
		alert("REGISTRO EXITOSO");
		return true;	
	}
	
			
};