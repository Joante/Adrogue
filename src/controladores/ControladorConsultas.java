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

public class ControladorConsultas extends HttpServlet {
	protected void doGet(HttpServletRequest request , HttpServletResponse response )throws ServletException, IOException{
		procesarPeticion(request,response);
	}

	protected void doPost(HttpServletRequest request , HttpServletResponse response )throws ServletException, IOException{
		procesarPeticion( request , response );
	}
	
	protected void procesarPeticion(HttpServletRequest request , HttpServletResponse response)throws ServletException, IOException {
		response .setContentType( "text/html;charset=UTF-8" );

		try {
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
			salida.println("</div>");
			
			
			
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