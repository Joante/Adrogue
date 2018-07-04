<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.util.List" %>
    <%@ page import = "datos.*" %>
  <%@ page import = "negocio.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% Usuario usuario=(Usuario)request.getAttribute( "usuario" ); %>
<% Tarjeta tarjeta=(Tarjeta)request.getAttribute( "tarjeta" ); %>
<% List<Movimiento> movimientos= (List) request.getAttribute( "movimientos" ); %>
<% EstacionTrenABM estacionABM = new EstacionTrenABM();%>
<% SeccionColectivoABM seccionColectivoABM = new SeccionColectivoABM();%>
<% ColectivoABM colectivoABM = new ColectivoABM();%>
<% SubteABM subteABM = new SubteABM();%>

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
				<h1>INFORMACION DE LA TARJETA</h1>

					<table id="idTabla" class="table table-bordered  table-condensed" >
						<tr class="">	
							<th>Propietario</th>
							<th>DNI</th>
							<th>Numero de Tarjeta</th>
							<th>Saldo</th>
						</tr>
						
						<tr>
							<td><%=usuario.getNombre()%> <%=usuario.getApellido()%></td>
							<td><%=usuario.getDni() %></td>
							<td><%=tarjeta.getNroTarjeta() %></td>
							<td><%=tarjeta.getSaldo()%></td>
						</tr>
					</table>
				
				
				
				<h2>MOVIMIENTOS TRENES</h2>
				<div class="table-responsive"> 
					<table id="idTabla" class="table table-bordered  table-condensed" >
						<tr class="">	
							<th>Fecha y Hora</th>
							<th>Transporte</th>
							<th>Linea</th>
							<th>Detalle</th>
							<th>Valor</th>
						</tr>
						<%for(Movimiento movi :movimientos) { %>
						<tr>
							
							<td><%= Funciones.traerFechaCortaHora(movi.getFechaHora())%></td>
							<td><%= movi.getTransporte().getDescripcion() %></td>
							<%int tipo = (int) movi.getTransporte().getTipoTransporte(); %>
							
							<%if(tipo ==0){%>
								<td>-------</td>
								<td>-------</td>
							<%} %>
							<%if(tipo ==1){%>
								<%
								LineaTrenABM lineaTrenABM = new LineaTrenABM();
								LineaTren linea =lineaTrenABM.traerLineaTren(1);
								%>
								
								<td><%=linea.getNombreLinea()%></td>
								<td>--------</td>
							<%} %>
							<%if(tipo ==2){%>
								<%
								ColectivoABM colectivoAbm = new ColectivoABM();
								Colectivo colectivo = colectivoAbm.traerColectivo(movi.getTransporte().getIdTransporte());%>
								
								<td><%=colectivo.getLinea()%></td>
								<td><%=colectivo.getEmpresa()%></td>
							<%} %>
							<%if(tipo ==3){%>
								<%
								SubteABM subteAbm = new SubteABM();
								Subte subte = subteAbm.traerSubte(movi.getTransporte().getIdTransporte());%>
								
								<td><%=subte.getLinea()%></td>
								<td>--------</td>
							<%} %>
							<%double valor= movi.getTarifa().getValorTarifa()*-1; %>
							<td><%=valor%></td>
						</tr>
						<%} %>
					</table>
					</div>

			<%if(usuario.isAdmin()){ %>
			<a href="/SistemaSubeV3/PaginaPrincipalAdmin.jsp" class="btn btn-primary btn-lg ">Volver</a>
			<%}else{ %>
			<a href="/SistemaSubeV3/PaginaPrincipal.jsp" class="btn btn-primary btn-lg ">Volver</a>
			<%}%>
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
]
</body>
</html>