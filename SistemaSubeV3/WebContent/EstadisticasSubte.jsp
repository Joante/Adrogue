<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.util.List" %>
    <%@ page import = "java.util.GregorianCalendar" %>
    <%@ page import = "java.util.ArrayList" %>
    <%@ page import = "datos.*" %>
    <%@ page import = "negocio.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta  http-equiv = "Content-Type" content = "text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="shortcut icon" type="image/x-icon" href="imagenes/icono.ico">
	<link rel="stylesheet" type="text/css" href="css/estilos.css">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script>
	<title>Estadisticas Subte</title>
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
				<h1>ESTADISTICAS GENERALES DE SUBTES</h1>
	<div>
	<canvas id="graficoMontoLinea" width="400" heigth="400"></canvas>
	</div>
	<script> 
	<% int[] cantidad = (int[]) request.getAttribute("Cantidad");%>
	<% double[] monto = (double[]) request.getAttribute("Monto");%>
	<% String nombres = (String) request.getAttribute("Nombres");%>
	var configMontoLinea = {
			type: 'bar',
			data: {
				labels: [<%=nombres%>] ,
				datasets: [{
					label: 'Monto Recaudado',
					data: [<%for(int i =0;i<monto.length;i++){%>
							<%=monto[i]%>,
							<%}%>],
					 backgroundColor: [
			                'white',
			                'red',
			                'blue',
			                'yellow',
			                'rgba(153, 102, 255, 0.2)',
			                'rgba(255, 159, 64, 0.2)'
			            ],
			            borderWidth: 1,
			            borderColor:'grey',
			            hooverBorderWidth: 3,
			            hooverBorderColor:'#000',
				           
					}],  
			        },
			    options: {
			    	 title: {
			             display: true,
			             text: 'Monto Recaudado por Linea (En Pesos).',
			             fontSize:25,
			             fontColor:'white'
			         },
					 legend:{
						   display:true,
						   },
			        scales: {
			            yAxes: [{
				            ticks: {
			                    beginAtZero:true,
			                    fontColor:'white'
			                }
			            }],
			            xAxes: [{
				            ticks: {
			                    fontColor:'white'
			                }
			            }]
			        }
			    }
			};
		var ctx = document.getElementById("graficoMontoLinea");
		ctx.style.backgroundColor = '#5caceb';
		new Chart (ctx,configMontoLinea);
	</script>	
	<div>
		<canvas id="graficoCantidadLinea" width="400" heigth="400"></canvas>
		</div>
	<script>
	var configCantidadLinea = {
			type: 'pie',
			data: {
				datasets: [{
					label: 'Cantidad de Viajes',
					data: [<%for(int i =0;i<cantidad.length;i++){%>
							<%=cantidad[i]%>,
							<%}%>],
					 backgroundColor: [
			                '#F7464A',
			                '#46BFBD',
			                '#FDB45C',
			                '#949FB1',
			                '#4D5360',
			                'rgba(255, 159, 64, 0.2)'
			            ], 
					}],
					labels: [<%=nombres%>] ,  
			        },
			    options: {
			    	 title: {
			             display: true,
			             text: 'Cantidad de Viajes por Linea.',
			             fontSize:25,
			             fontColor:'white'
			         },
					 legend:{
						   display:true,
						   },
			       }
			};
		var ctx = document.getElementById("graficoCantidadLinea");
		ctx.style.backgroundColor = '#5caceb';
		new Chart (ctx,configCantidadLinea);
	</script>
		<a href="/SistemaSubeV3/PaginaPrincipalAdmin.jsp" class="btn btn-primary btn-lg ">Volver</a>
</article>




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

</body>
</html>