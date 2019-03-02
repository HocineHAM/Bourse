package fr.formation.bourse.hocine; 
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

	//@WebServlet("/inscription")
	public class Inscription extends HttpServlet{
		private static final long serialVersionUID =1L;
		
	
			public void doPost(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				//String nom = request.getParameter("nom");
				response.setContentType("text/html");
				
				PrintWriter out = response.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title> INSCRIPTION </title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h1> Formulaire </h1>");
			
				out.println("</html>");
				out.println("<form action=\"identification\">");
				out.println("Nom:<br>");
				out.println("<input type=\"text\" name=\"Nom\" value=\"\"><br>");
				out.println("Prenom:<br>");
				out.println("<input type=\"text\" name=\"Prénom\" value=\"\"><br>");
				out.println("Adresse mail:<br>");
				out.println("<input type=\"text\" name=\"Adresse mail\" value=\"\"><br>");
				out.println("Login:<br>");
				out.println("<input type=\"text\" name=\"login\" value=\"\"><br>");
				out.println("Password:<br>");
				out.println("<input type=\"password\" name=\"password\" value=\"\"><br><br>");
				
				
//				out.println("<form action=\"Connexion\" method=\"post\">");
//				out.println("<input type=\"submit\" value=\"connexion\">");
				
				out.println("<input type=\"submit\" value=\"Submit\">");
				out.println("</form>");


				out.println("</body>");
				out.println("</html>");
				
				
	}
			public void doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				doPost(request, response);
				
			}
	
	}


