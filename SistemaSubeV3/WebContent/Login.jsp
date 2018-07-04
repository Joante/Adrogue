<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.List" %>
<%@ page import = "datos.*" %>
<%@ page import = "negocio.*" %>
<% UsuarioABM usuABM = new UsuarioABM();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" >
<head>
<meta  http-equiv = "Content-Type" content = "text/html; charset=ISO-8859-1">
<title>SUBE</title>
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="shortcut icon" type="image/x-icon" href="imagenes/icono.ico">
	<link rel="stylesheet" type="text/css" href="css/estilos.css">



</head>
<header>
		<div class="logotipo"><!-- etiqueta para poner imagens o videos-->
			<img src="imagenes/subeLogo.png" align="left" alt="sube imagen" title="Sube" width="10%"/>
		</div>
		<div class="container">

			

		</div>

		
	</header>

	<div class="divGeneral container">
		<section class="main row">
			<article class="col-xs-12 col-sm-8 col-md-9 col-lg-9" >
				<h1>BIENVENIDOS A MI SUBE</h1>
				<p class=" inicio text-uppercase">
					Ingresando podrás consultar tu saldo y tus viajes realizados, actualizar tus datos de contacto, denunciar un Punto SUBE, iniciar gestiones para recuperar tu saldo en caso de robo, pérdida o rotura y saber si te corresponde Tarifa Social Federal.
				</p>
				<div class="contenedor-form">
					<div class="toggle">
						<span>Registrarse</span>
					</div> 

					<div class="formulario">
						<h2>INGRESAR A MI SUBE</h2>
						<form id="form1" action="/SistemaSubeV3/MostrarSube" method="POST" onsubmit="return validar();">
							<input type="text" placeholder="Ingresar DNI" name="dni" id="dni" required>
							<input type="password" placeholder="Contraseña" name="pass" id="pass" required>
							<input type="submit" value="Iniciar Sesion" name="iniciar" id="iniciar" >
						</form>
					</div>

					<div class="formulario">
						<h2>REGISTRARSE</h2>
						<form id="form2" action="/SistemaSubeV3/RegistrarUsuario" method="POST" name="registro" onsubmit="return validar2();">
							<input type="text" placeholder="Nombre" name="nom" id="nom" required>
							<input type="text" placeholder="Apellido" name="ape" id="ape" required>
							<input type="text" placeholder="DNI" name="doc" id="dni" required>
							<input type="password" placeholder="Password" name="contra" id="pass" required>
							
							<h4>Informacion sobre tu tarjeta</h4>
							<input type="text" placeholder="Numero Tarjeta" name="ntar" id="ntar" required>
							<input type="text" placeholder="Saldo" name="saldo" id="saldo" required>

							<div class="form-group">
								<h4>Es beneficiario de la tarifa social?</h4>
								<select class="" name="tarifaSocial" id="option">
									<option value="true">Si</option>
									<option value="false">No</option>
								</select>
							</div>
							<br>
							<!--<input type="button" value="Registrarse" onclick="registrar()">-->
							<input type="submit" value="Registrarse" id="reg">
						</form>
					</div>
				</div>
			</article>
			<aside class="aside col-xs-12 col-sm-4 col-md-3  col-lg-3">
				<h3><strong>RED SUBE</strong></h3>
				<br>
				<br>
				<p>
				¿Qué es RED SUBE?
				Es un nuevo sistema que integra todos los modos de transporte público (colectivos, metrobus, trenes y subtes) del Área Metropolitana de Buenos Aires (AMBA) para poder ofrecer descuentos a quienes realizan una o más combinaciones.
				</p>

				<p>
				¿Cómo va a funcionar?
				El descuento se aplicará de forma automática y sin hacer ningún trámite con tu tarjeta SUBE en el momento del viaje. En 2 horas podés hacer hasta 5 combinaciones de transporte.
				En el siguiente gráfico podés ver cómo funciona el sistema, a modo de ejemplo:
				</p>

				<p class="sub"><strong>Primer viaje</strong></p>
				<p>Pagás el valor total del pasaje.</p>
				
				<p class="sub"><strong>Segundo viaje</strong></p>
				<p>Pagás un 50% menos.</p>

				<p class="sub"><strong>A partir del tercer viaje</strong></p>
				<p>Pagás un 75% menos.</p>	
								<br>
				<br>
								<br>
				<br>
								<br>
				<br>
								<br>
				<br>
								<br>
				<br>
								<br>
				<br>

			</aside>
		</section>


	</div>
	
		<div class="container ">
			<div class="row">
				<br>
				<div class="galeria col-md-9">
					<div id="galeria1" class="carousel slide" data-ride="carousel">
						<!-- INDICADORES -->
						<ol class="carousel-indicators">
							<li data-target="#galeria1" data-slide-to="0" class="active"></li>
							<li data-target="#galeria1" data-slide-to="1"></li>
							<li data-target="#galeria1" data-slide-to="2"></li>
						</ol>

						<!-- CONTENEDORES DE LOS SLIDE -->
						<div class="carousel-inner" role="listbox">
							<div class="item active">
								<img src="imagenes/Sube1.jpg" class="img-responsive">
								<div class="carousel-caption">
									<!--Texto en las imagenes -->
								</div>
							</div>

							<div class="item">
								<img src="imagenes/Sube2.jpg" class="img-responsive">
								<div class="carousel-caption">
									<!--Texto en las imagenes -->
								</div>
							</div>

							<div class="item">
								<img src="imagenes/Sube3.jpg" class="img-responsive">
								<div class="carousel-caption">
									<!--Texto en las imagenes -->
								</div>
							</div>


						</div>

						<!-- CONTROLES -->
						<a href="#galeria1" class="left carousel-control" role="button" data-slide="prev">
							<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
							<span class="sr-only">Anterior</span>
						</a>
						<a href="#galeria1" class="right carousel-control" role="button" data-slide="next">
							<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
							<span class="sr-only">Siguiente</span>
						</a>
					</div>			
				</div>
				<img src="imagenes/Sube4.jpg" class="hola" width="25%" height="280">
			</div>
		</div>



	<footer>
		<div class="logotipo2"><!-- etiqueta para poner imagens o videos-->
			<img src="imagenes/logoMinisterio.png" align="left" alt="" title="" width="15%"/>
		</div>
		<div class="container">

		</div>
	</footer>

	
	<script src="js/jquery.js"></script>

	<script src="js/main.js"></script>
	<!-- Latest compiled and minified JavaScript -->
	<script src="js/bootstrap.min.js"></script>
	
	<script src="js/validacionLogin.js"></script>
</body>
</html>