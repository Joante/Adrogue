<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.util.List" %>
    <%@ page import = "datos.*" %>
    <%@ page import = "negocio.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% Usuario usuario=(Usuario)request.getAttribute( "usuario" );%>
<% Tarjeta tarjeta=(Tarjeta)request.getAttribute( "tarjeta" );%>
<% EstacionTrenABM estacionABM = new EstacionTrenABM();%>
<% SeccionColectivoABM seccionColectivoABM = new SeccionColectivoABM();%>
<% ColectivoABM colectivoABM = new ColectivoABM();%>
<% SubteABM subteABM = new SubteABM();
%>

<html lang="en">
<head>
	<meta charset="utf-8">
	<title>SUBE</title>
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="shortcut icon" type="image/x-icon" href="imagenes/icono.ico">
	<link rel="stylesheet" type="text/css" href="css/estilosPaginaPricipal.css">
</head>
<body>
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
				<br>
				<br>
				<a href="#ventana1" class="btn btn-primary btn-md" data-toggle="modal">SIMULAR MOVIMIENTO TREN</a>
				<br>
				<br>
				<br>
				<a href="#ventana2" class="btn btn-primary btn-md" data-toggle="modal">SIMULAR MOVIMIENTO COLECTIVO</a>
				<br>
				<br>
				<br>
				<a href="#ventana3" class="btn btn-primary btn-md" data-toggle="modal">SIMULAR MOVIMIENTO SUBTE</a>
				<br>
				<br>
				<br>
				<a href="#ventana4" class="btn btn-primary btn-md" data-toggle="modal">CARGAR TARJETA</a>
				<br>
				<br>
				<br>
				<a href="/SistemaSubeV3/MostrarTabla" class="btn btn-primary btn-md" data-toggle="modal">INFORMACION TARJETA</a>
				<br>
				<br>
				<br>
				<a href="#ventana5" class="btn btn-primary btn-lg" data-toggle="modal">CONSULTAS TRANSPORTE</a>
				<br>
				<br>
				<br>
				<a href="#ventana6" class="btn btn-primary btn-lg" data-toggle="modal">CONSULTAS COLECTIVO</a>
				<br>
				<br>
				<br>
				<a href="#ventana7" class="btn btn-primary btn-lg" data-toggle="modal">CONSULTAS TREN</a>
				<br>
				<br>
				<br>
				<a href="#ventana8" class="btn btn-primary btn-lg" data-toggle="modal">CONSULTAS SUBTE</a>
				<br>
				<br>
				<br>
				<a href="/SistemaSubeV3/CerrarSesion" class="btn btn-primary btn-md" data-toggle="modal">CERRAR SESION</a>

			<div class="modal fade" id="ventana1">
				<div class="modal-dialog">
					<div class="modal-content">
						<!-- header de la ventana-->
						<div class="modal-header">
							<button title="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							<h3 class="modal-tittle">MOVIMIENTO TREN</h3>
						</div>
						<!-- body de la ventana-->
						<div class="modal-body">
							<div class="formulario container">
								<form action="/SistemaSubeV3/MovimientoTren" id="form1" onsubmit="return validar1();">
									<div class="form-group">
										<h4>Seleccione Estacion Subida</h4>
										<select class="" name="estacionS" id="option">
											<option value="1"><%= estacionABM.traerEstacionTren(1).getNombre() %></option>
											<option value="2"><%= estacionABM.traerEstacionTren(2).getNombre() %></option>
											<option value="3"><%= estacionABM.traerEstacionTren(3).getNombre() %></option>
											<option value="4"><%= estacionABM.traerEstacionTren(4).getNombre() %></option>
											<option value="5"><%= estacionABM.traerEstacionTren(5).getNombre() %></option>
											<option value="6"><%= estacionABM.traerEstacionTren(6).getNombre() %></option>
											<option value="7"><%= estacionABM.traerEstacionTren(7).getNombre() %></option>
											<option value="8"><%= estacionABM.traerEstacionTren(8).getNombre() %></option>
											<option value="9"><%= estacionABM.traerEstacionTren(9).getNombre() %></option>
											<option value="10"><%= estacionABM.traerEstacionTren(10).getNombre() %></option>
											<option value="11"><%= estacionABM.traerEstacionTren(11).getNombre() %></option>
											<option value="12"><%= estacionABM.traerEstacionTren(12).getNombre() %></option>
											<option value="13"><%= estacionABM.traerEstacionTren(13).getNombre() %></option>
										
										</select>
									</div>
									<div class="form-group">
										<h4>Seleccione Estacion Bajada</h4>
										<select class="" name="estacionB" id="option1">
											<option value="1"><%= estacionABM.traerEstacionTren(1).getNombre() %></option>
											<option value="2"><%= estacionABM.traerEstacionTren(2).getNombre() %></option>
											<option value="3"><%= estacionABM.traerEstacionTren(3).getNombre() %></option>
											<option value="4"><%= estacionABM.traerEstacionTren(4).getNombre() %></option>
											<option value="5"><%= estacionABM.traerEstacionTren(5).getNombre() %></option>
											<option value="6"><%= estacionABM.traerEstacionTren(6).getNombre() %></option>
											<option value="7"><%= estacionABM.traerEstacionTren(7).getNombre() %></option>
											<option value="8"><%= estacionABM.traerEstacionTren(8).getNombre() %></option>
											<option value="9"><%= estacionABM.traerEstacionTren(9).getNombre() %></option>
											<option value="10"><%= estacionABM.traerEstacionTren(10).getNombre() %></option>
											<option value="11"><%= estacionABM.traerEstacionTren(11).getNombre() %></option>
											<option value="12"><%= estacionABM.traerEstacionTren(12).getNombre() %></option>
											<option value="13"><%= estacionABM.traerEstacionTren(13).getNombre() %></option>
											<option value="14">No elegir estacion bajada</option>
										</select>
									</div>

									<h4>Ingrese la fecha del Viaje</h4><br>
									<input type="text" placeholder="Año" name="anio" id="anio" required>
									<input type="text" placeholder="Mes" name="mes" id="mes"required>
									<input type="text" placeholder="Dia" name="dia" id="dia" required>
									<br>
									<br>
									<br>
									<h4>Hora subida</h4>
									<input type="text" placeholder="Hora" name="horaS" id="hora" required>
									<input type="text" placeholder="Minutos" name="minutosS" id="min" required>
									<br>
									<br>
									<br>

									<h4>Hora bajada</h4>
									<input type="text" placeholder="Hora" id="hora2" name="horaB">
									<input type="text" placeholder="Minutos" id="min2" name="minutosB">

									<input type="submit" value="Iniciar Viaje" name="iniciar">
								</form>
							</div>
						</div>

						<!-- footer de la ventana-->
					</div>
				</div>
			</div>

			<div class="modal fade" id="ventana2">
				<div class="modal-dialog">
					<div class="modal-content">
						<!-- header de la ventana-->
						<div class="modal-header">
							<button title="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							<h3 class="modal-tittle">MOVIMIENTO COLECTIVO</h3>
						</div>
						<!-- body de la ventana-->
						<div class="modal-body">
							<div class="formulario container">
								<form action="/SistemaSubeV3/MovimientoColectivo" id="form2" onsubmit="return validar2();">
									<div class="form-group">
										<h4>Seleccione Colectivo</h4>
										<select class="" name="colectivo" id="option2">
											<option value="2"><%= colectivoABM.traerColectivo(2).getLinea() %></option>
											<option value="3"><%= colectivoABM.traerColectivo(3).getLinea() %></option>
											<option value="4"><%= colectivoABM.traerColectivo(4).getLinea() %></option>
											<option value="5"><%= colectivoABM.traerColectivo(5).getLinea() %></option>
										</select>
									</div>
									<div class="form-group">
										<h4>Seleccione Seccion</h4>
										<select class="" name="seccionC" id="option22">
											<option value="1"><%= seccionColectivoABM.traerSeccionColectivo(1).getDescripcion() %></option>
											<option value="2"><%= seccionColectivoABM.traerSeccionColectivo(2).getDescripcion() %></option>
											<option value="3"><%= seccionColectivoABM.traerSeccionColectivo(3).getDescripcion() %></option>
											<option value="4"><%= seccionColectivoABM.traerSeccionColectivo(4).getDescripcion() %></option>
											<option value="5"><%= seccionColectivoABM.traerSeccionColectivo(5).getDescripcion() %></option>
										</select>
									</div>
									<h4>Ingrese la fecha del Viaje</h4>
									<input type="text" placeholder="Año" name="anio2" id="anio2" required>
									<input type="text" placeholder="Mes" name="mes2" id="mes2" required>
									<input type="text" placeholder="Dia" name="dia2" id="dia2" required>
									<input type="text" placeholder="Hora" name="hora2" id="hoora2" required>
									<input type="text" placeholder="Minutos" name="minutos2" id="mmin2" required>

									<input type="submit" value="Iniciar Viaje" name="iniciar2">
								</form>
							</div>
						</div>

						<!-- footer de la ventana-->
					</div>
				</div>
			</div>

			<div class="modal fade" id="ventana3">
				<div class="modal-dialog">
					<div class="modal-content">
						<!-- header de la ventana-->
						<div class="modal-header">
							<button title="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							<h3 class="modal-tittle">MOVIMIENTO SUBTE</h3>
						</div>
						<!-- body de la ventana-->
						<div class="modal-body">
							<div class="formulario container">
								<form action="/SistemaSubeV3/MovimientoSubte" id="form3" onsubmit="return validar3();">
									<div class="form-group">
										<h4>Seleccione Linea</h4>
										<select class="" name="Linea" id="option3">
											<option value="6"><%= subteABM.traerSubte(6).getLinea() %></option>
											<option value="7"><%= subteABM.traerSubte(7).getLinea() %></option>
											<option value="8"><%= subteABM.traerSubte(8).getLinea() %></option>
											<option value="9"><%= subteABM.traerSubte(9).getLinea() %></option>
											<option value="10"><%= subteABM.traerSubte(10).getLinea() %></option>
											<option value="11"><%= subteABM.traerSubte(11).getLinea() %></option>

										</select>
									</div>
									<h4>Ingrese la fecha del Viaje</h4>
									<input type="text" placeholder="Año" name="anio3" id="anio3" required>
									<input type="text" placeholder="Mes" name="mes3" id="mes3" required>
									<input type="text" placeholder="Dia" name="dia3" id="dia3" required>
									<input type="text" placeholder="Hora" name="hora3" id="hora3" required>
									<input type="text" placeholder="Minutos" name="minutos3" id="min3" required>

									<input type="submit" value="Iniciar Viaje" name="iniciar3">
								</form>
							</div>
						</div>

						<!-- footer de la ventana-->
					</div>
				</div>
			</div>

			<div class="modal fade" id="ventana4">
				<div class="modal-dialog">
					<div class="modal-content">
						<!-- header de la ventana-->
						<div class="modal-header">
							<button title="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							<h3 class="modal-tittle">CARGAR TARJETA</h3>
						</div>
						<!-- body de la ventana-->
						<div class="modal-body">
							<div class="formulario container">
								<form action="/SistemaSubeV3/MovimientoRecarga" id="form4" onsubmit="return validar4();">

									<h4>Seleccione el monto a cargar en la tarjeta</h4>
									<input type="text" placeholder="Monto" name="monto" id="monto" required>
									<br>
									<br>
									<h4>Ingrese la fecha del Viaje</h4>
									<input type="text" placeholder="Año" name="anio4" id="anio4" required>
									<input type="text" placeholder="Mes" name="mes4" id="mes4" required>
									<input type="text" placeholder="Dia" name="dia4" id="dia4" required>
									<input type="text" placeholder="Hora" name="hora4" id="hora4" required>
									<input type="text" placeholder="Minutos" name="minutos4" id="min4" required>
									
									<input type="submit" value="Realizar Carga" name="carga">
								</form>
							</div>
						</div>

						<!-- footer de la ventana-->
					</div>
				</div>
			</div>
			<div class="modal fade" id="ventana5">
				<div class="modal-dialog">
					<div class="modal-content">
						<!-- header de la ventana-->
						<div class="modal-header">
							<button title="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							<h3 class="modal-tittle">CONSULTAS TRANSPORTES</h3>
						</div>
						<!-- body de la ventana-->
						<div class="modal-body">
							<div class="formulario container">
								<form action="/SistemaSubeV3/ConsultasTransporte">
								<h4>Ingrese la fecha desde</h4>
									<input type="text" placeholder="Año" name="anioD" required>
									<input type="text" placeholder="Mes" name="mesD" required>
									<input type="text" placeholder="Dia" name="diaD" required>
									<input type="text" placeholder="Hora" name="horaD" required>
									<input type="text" placeholder="Minutos" name="minutosD" required>
								<br>
								<br>
								<br>
									<h4>Ingrese la fecha hasta</h4>
									<input type="text" placeholder="Año" name="anioH" required>
									<input type="text" placeholder="Mes" name="mesH" required>
									<input type="text" placeholder="Dia" name="diaH" required>
									<input type="text" placeholder="Hora" name="horaH" required>
									<input type="text" placeholder="Minutos" name="minutosH" required>
								<br>
								<br>
								<br>
									<div class="form-group">
										<h4>Seleccione Transporte</h4>
										<select class="" name="tipoTransporte" id="option3">
											<option value="1">Tren</option>
											<option value="2">Colectivo</option>
											<option value="3">Subte</option>
										</select>
									</div>
									<input type="submit" value="Realizar Consulta" name="consulta">
								</form>
							</div>
						</div>

						<!-- footer de la ventana-->
					</div>
				</div>
			</div>
			
			<div class="modal fade" id="ventana6">
				<div class="modal-dialog">
					<div class="modal-content">
						<!-- header de la ventana-->
						<div class="modal-header">
							<button title="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							<h3 class="modal-tittle">CONSULTAS COLECTIVO</h3>
						</div>
						<!-- body de la ventana-->
						<div class="modal-body">
							<div class="formulario container">
								<form action="/SistemaSubeV3/ConsultasColectivo">
								<h4>Ingrese la fecha desde</h4>
									<input type="text" placeholder="Año" name="anioD" required>
									<input type="text" placeholder="Mes" name="mesD" required>
									<input type="text" placeholder="Dia" name="diaD" required>
									<input type="text" placeholder="Hora" name="horaD" required>
									<input type="text" placeholder="Minutos" name="minutosD" required>
								<br>
								<br>
								<br>
								<h4>Ingrese la fecha hasta</h4>
									<input type="text" placeholder="Año" name="anioH" required>
									<input type="text" placeholder="Mes" name="mesH" required>
									<input type="text" placeholder="Dia" name="diaH" required>
									<input type="text" placeholder="Hora" name="horaH" required>
									<input type="text" placeholder="Minutos" name="minutosH" required>
								<br>
								<br>
								<br>
								<div class="form-group">
										<h4>Seleccione Linea</h4>
										<select class="" name="Linea" id="option2">
											<option value="0">Todas</option>
											<option value="160"><%= colectivoABM.traerColectivo(2).getLinea() %></option>
											<option value="60"><%= colectivoABM.traerColectivo(3).getLinea() %></option>
											<option value="318"><%= colectivoABM.traerColectivo(4).getLinea() %></option>
											<option value="514"><%= colectivoABM.traerColectivo(5).getLinea() %></option>
										</select>
									</div>
									<input type="submit" value="Realizar Consulta" name="consulta">
								</form>
							</div>
						</div>

						<!-- footer de la ventana-->
					</div>
				</div>
			</div>
			<div class="modal fade" id="ventana7">
				<div class="modal-dialog">
					<div class="modal-content">
						<!-- header de la ventana-->
						<div class="modal-header">
							<button title="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							<h3 class="modal-tittle">CONSULTAS TREN</h3>
						</div>
						<!-- body de la ventana-->
						<div class="modal-body">
							<div class="formulario container">
								<form action="/SistemaSubeV3/ConsultasTren">
								<h4>Ingrese la fecha desde</h4>
									<input type="text" placeholder="Año" name="anioD" required>
									<input type="text" placeholder="Mes" name="mesD" required>
									<input type="text" placeholder="Dia" name="diaD" required>
									<input type="text" placeholder="Hora" name="horaD" required>
									<input type="text" placeholder="Minutos" name="minutosD" required>
								<br>
								<br>
								<br>
								<h4>Ingrese la fecha hasta</h4>
									<input type="text" placeholder="Año" name="anioH" required>
									<input type="text" placeholder="Mes" name="mesH" required>
									<input type="text" placeholder="Dia" name="diaH" required>
									<input type="text" placeholder="Hora" name="horaH" required>
									<input type="text" placeholder="Minutos" name="minutosH" required>
								<br>
								<br>
								<br>
								<div class="form-group">
										<h4>Seleccione Linea</h4>
										<select class="" name="Linea" id="option3">
											<option value="1">Roca</option>
										</select>
									</div>
									<input type="submit" value="Realizar Consulta" name="consulta">
								</form>
							</div>
						</div>

						<!-- footer de la ventana-->
					</div>
				</div>
			</div>
			<div class="modal fade" id="ventana8">
				<div class="modal-dialog">
					<div class="modal-content">
						<!-- header de la ventana-->
						<div class="modal-header">
							<button title="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							<h3 class="modal-tittle">CONSULTAS SUBTE</h3>
						</div>
						<!-- body de la ventana-->
						<div class="modal-body">
							<div class="formulario container">
								<form action="/SistemaSubeV3/ConsultasSubte">
								<h4>Ingrese la fecha desde</h4>
									<input type="text" placeholder="Año" name="anioD" required>
									<input type="text" placeholder="Mes" name="mesD" required>
									<input type="text" placeholder="Dia" name="diaD" required>
									<input type="text" placeholder="Hora" name="horaD" required>
									<input type="text" placeholder="Minutos" name="minutosD" required>
								<br>
								<br>
								<br>
								<h4>Ingrese la fecha hasta</h4>
									<input type="text" placeholder="Año" name="anioH" required>
									<input type="text" placeholder="Mes" name="mesH" required>
									<input type="text" placeholder="Dia" name="diaH" required>
									<input type="text" placeholder="Hora" name="horaH" required>
									<input type="text" placeholder="Minutos" name="minutosH" required>
								<br>
								<br>
								<br>
								<div class="form-group">
										<h4>Seleccione Linea</h4>
										<select class="" name="Linea" id="option3">
											<option value="0">Todas</option>
											<option value="A"><%= subteABM.traerSubte(6).getLinea() %></option>
											<option value="B"><%= subteABM.traerSubte(7).getLinea() %></option>
											<option value="C"><%= subteABM.traerSubte(8).getLinea() %></option>
											<option value="D"><%= subteABM.traerSubte(9).getLinea() %></option>
											<option value="E"><%= subteABM.traerSubte(10).getLinea() %></option>
											<option value="H"><%= subteABM.traerSubte(11).getLinea() %></option>

										</select>
									</div>
									<input type="submit" value="Realizar Consulta" name="consulta">
								</form>
							</div>
						</div>

						<!-- footer de la ventana-->
					</div>
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
	<script src="js/validacionPaginaPrincipal1.js"></script>

</body>
</html>