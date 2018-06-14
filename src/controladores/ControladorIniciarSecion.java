package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.HibernateException;
import datos.*;
import negocio.*;

public class ControladorIniciarSecion extends HttpServlet {
	protected void doGet(HttpServletRequest request , HttpServletResponse response )throws ServletException, IOException{
		procesarPeticion(request,response);
	}

	protected void doPost(HttpServletRequest request , HttpServletResponse response )throws ServletException, IOException{
		procesarPeticion( request , response );
	}
	
	protected void procesarPeticion(HttpServletRequest request , HttpServletResponse response)throws ServletException, IOException {
		response .setContentType( "text/html;charset=UTF-8" );
		
		try {
			int dni = Integer.parseInt ( request . getParameter ( "dni" ));
			String password= request.getParameter("pass");
			
			long dni2= (long) dni;
			UsuarioABM usuarioABM= new UsuarioABM();
			Usuario usuario = usuarioABM.accesoLogin(password,dni2);
			
			
			TarjetaABM tarjetaABM=new TarjetaABM();
			Tarjeta tarjeta = tarjetaABM.traerTarjeta3(usuario.getIdUsuario());
			
			MovimientoABM movimientoAbm = new MovimientoABM();
			List<Movimiento> movimientos = movimientoAbm.traerMovimientos(tarjeta.getIdTarjeta());
			
			response.setStatus(200);
			PrintWriter salida = response.getWriter();
			salida.println( "" );
			salida.println( "<!DOCTYPE 4.01 Transitional//EN\">" );
			salida.println( "<HTML>" );
			salida.println( "<HEAD>" );
			salida.println("function vermas() {");
			salida.println("var i = 0;");
			salida.println("var d = document.createElement(\"<table>\");");
			salida.println( "<TITLE>SUBE</TITLE>" );
			salida.println( "<meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">" );
			salida.println( "<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">" );
			salida.println( "<link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"imagenes/icono.ico\">" );
			salida.println( "<link rel=\"stylesheet\" type=\"text/css\" href=\"css/estilos.css\">" );
			salida.println( "</HEAD>" );
			salida.println( "<BODY>" );
			salida.println( "<header>" );
			salida.println( "<div class=\"logotipo\">" );
			salida.println( "<img src=\"imagenes/subeLogo.png\" align=\"left\" alt=\"sube imagen\" title=\"Sube\" width=\"10%\"/>" );
			salida.println( "</div>" );
			salida.println( "<div class=\"container\">" );
			salida.println( "</div>" );
			salida.println( "</header>" );
			salida.println("<div class=\"container\">");
			salida.println("<div class=\"left\">");
			salida.println( "<A href=\"/SistemaSubeV2/Consultas.html\">Consultas</A>");
			salida.println( "<A href=\"/SistemaSubeV2/AgregarMovimiento.html\">AgregarMovimiento</A>" );
			salida.println("</div>");
			salida.println("<div class=\"center\">");
			salida.println("<table id=\"movimientos\" width=\"70%\" cellpadding=\"8\" border=\"1\" bgcolor=\"#FFFEFD\">");
			salida.println("<tr valign=\"top\">");
			salida.println("<th>Fecha y Hora</th><th>Transporte</th><th>Linea</th><th>Detalle</th><th>Valor</th>");
			salida.println("</tr>");
			for(int i=0;i<movimientos.size();i++) {
				salida.println("<tr>");
				Movimiento movi = movimientos.get(i);
				salida.print("<td>"+Funciones.traerFechaCortaHora(movi.getFechaHora())+"</td>");
					salida.print("<td>Uso "+movi.getTransporte().getDescripcion()+"</td>");
					int tipo = (int) movi.getTransporte().getTipoTransporte();
					switch(tipo) {
					case 0:
						salida.print("<td></td>");
						salida.print("<td></td>");
						break;
					case 1:
						TrenABM trenAbm = new TrenABM();
						Tren tren = trenAbm.traerTren(movi.getTransporte().getIdTransporte());
						salida.print("<td>"+tren.getLineaTren().getNombreLinea()+"</td>");
						salida.print("<td></td>");
						break;
					case 2:
						ColectivoABM colectivoAbm = new ColectivoABM();
						Colectivo colectivo = colectivoAbm.traerColectivo(movi.getTransporte().getIdTransporte());
						salida.print("<td>"+colectivo.getEmpresa()+"</td>");
						salida.print("<td>"+colectivo.getInterno()+"</td>");
						break;
					case 3:
						SubteABM subteAbm = new SubteABM();
						Subte subte = subteAbm.traerSubte(movi.getTransporte().getIdTransporte());
						salida.print("<td>"+subte.getLinea()+"</td>");
						salida.print("<td></td>");
						break;
				}
				salida.println("<td>"+movi.getTarifa().getValorTarifa()+"</td>");
				salida.println("</tr>");				
			}
			salida.println("</table>");
			salida.println("<div style=\"text-align: center\">");
			salida.println("<input type=\"button\" name=\"Ver mas\" value=\"Ver Mas\" onclick=\"vermas()\">");
			salida.println("</div>");
			salida.println("</div>");
			salida.println("</div>");
			salida.println( "<A href=\"/SistemaSubeV2/Login.html\">Cerrar Sesion</A>" );
			salida.println( "<footer>" );
			salida.println( "<div vertical-align=\"bottom\"class=\"logotipo2\">" );
			salida.println( "<img src=\"imagenes/logoMinisterio.png\" align=\"left\" alt=\"\" title=\"\" width=\"15%\"/>" );
			salida.println( "</div>" );
			salida.println( "<div class=\"container\">" );
			salida.println( "</div>" );
			salida.println( "</footer>" );
			salida.println("<script>");
			salida.println("fucion vermas() {");
			salida.println("var table = document.getElementById(\"movimientos\");");
			Movimiento movi = movimientos.get(movimientos.size()-1);
			long id = movi.getIdMovimiento();
			movimientos=movimientoAbm.traerMasMovimientos(tarjeta.getNroTarjeta(), id);
			for(int i=0;i<movimientos.size();i++) {
				movi= movimientos.get(i);
				salida.println("var row = table.insertRow(-1);");
				salida.println("var cell1 = row.insertCell(0);");
				salida.println("var cell2 = row.insertCell(1);");
				salida.println("var cell3 = row.insertCell(2);");
				salida.println("var cell4 = row.insertCell(3);");
				salida.println("var cell5 = row.insertCell(4);");
				salida.println("cell1.innerHTML ="+Funciones.traerFechaCortaHora(movi.getFechaHora())+";");
				salida.println("cell2.innerHTML ="+movi.getTransporte().getDescripcion()+";");
				int tipo = (int) movi.getTransporte().getTipoTransporte();
				switch(tipo) {
				case 0:
					salida.println("cell3.innerHTML = ;");
					salida.println("cell4.innerHTML = ;");
					break;
				case 1:
					TrenABM trenAbm = new TrenABM();
					Tren tren = trenAbm.traerTren(movi.getTransporte().getIdTransporte());
					salida.print("cell3.innerHTML="+tren.getLineaTren().getNombreLinea()+";");
					salida.print("cell4.innerHTML= ;");
					break;
				case 2:
					ColectivoABM colectivoAbm = new ColectivoABM();
					Colectivo colectivo = colectivoAbm.traerColectivo(movi.getTransporte().getIdTransporte());
					salida.print("cell3.innerHTML ="+colectivo.getEmpresa()+";");
					salida.print("cell4.innerHTML ="+colectivo.getInterno()+";");
					break;
				case 3:
					SubteABM subteAbm = new SubteABM();
					Subte subte = subteAbm.traerSubte(movi.getTransporte().getIdTransporte());
					salida.print("cell3.innerHTML ="+subte.getLinea()+";");
					salida.print("cell4.innerHTML = ;");
					break;
				}
				salida.println("cell5.innerHTML ="+movi.getTarifa().getValorTarifa()+";");
			}
			salida.println("}");
			salida.println("</script>");
			salida.println( "<script src=\"js/jquery.js\">" );
			salida.println( "</script>" );
			salida.println( "<script src=\"js/main.js\">" );
			salida.println( "</script>" );
			salida.println( "<script src=\"js/bootstrap.min.js\"></script>" );
			salida.println( "</script>" );
			
			salida.println( "</BODY>" );
			salida.println( "</HTML>" );
		}
		catch (Exception e) {
			response.sendError(500, "El DNI o PASSWORD Ingresado no existe en la base de datos." );
		}
	
	}
}
