package fr.formation.bourse.imane;
 
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Portefeuilles extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String nom = request.getParameter("nom");
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<br/></br>");
		out.println("<center>");
		out.println("<br/></br>");
		out.println("<head>");
		out.println("<title> Portefeuille</title>");
		out.println("</head>");
		out.println("<body bgcolor=#FFEFE5>" );
		out.println("<B><label style=\"font-size:30px; font-family:arial;\">Constitution du portefeuille</label> </B><br><br>");
		out.println("<br/></br>");

		out.println("<form action=\"donnee\" method=\"POST\">");
		
		out.println("<label style=\"font-size:20px; font-family:arial;\" required/>Numéro de compte:<br>" );
        out.println("<input type=\"number\" name=\"Numerodecompte\" value=\"\"required/><br><br>");
        out.println("<label style=\"font-size:20px; font-family:arial;\"required/>Dépot:<br>");
        out.println("<input type=\"number\" name=\"Depot\" value=\"\"required/><br><br>");
        out.println("<label style=\"font-size:20px; font-family:arial;\"required/>Choix entreprise:<br>");
        out.println("<select type=\"text\"name=\"ChoixEntreprise\" onchange=\"updated(this)\"required/>");
        out.println(" <option value=\"1\">------Sélectionner------</option>");
        out.println(" <option text=\"2\">CAC 40</option>");
        out.println("<option text=\"3\">DOW Jones</option>");
        out.println("<option text=\"4\">Nasdaq</option>");
        out.println("<option text=\"5\">Shangai</option>");
        out.println("</select>");
		
        out.println("<br/></br>");
        out.println("<label style=\"font-size:20px; font-family:arial;\" required/>Date d'investisement:<br>");
        out.println("<input type=\"date\" name=\"ChoixDate\" value=\"\" required/><br><br>");
        out.println("<label style=\"font-size:20px; font-family:arial;\"required/>Investisement:<br>");
        out.println("<input name=\"SommeInvestie\" onchange=\"updated(this)\">");
        
        
        out.println("<br/></br>");
        out.println("<label style=\"font-size:20px; font-family:arial;\"required/>Choix du critere:<br>");
        out.println("<select name=\"ChoixCritere\" onchange=\"updated(this)\">");
        out.println(" <option value=\"1\">------Sélectionner------</option>");
        out.println(" <option value=\"2\"> 1</option>");
        out.println("<option value=\"3\"> 2</option>");
        out.println("<option value=\"4\"> 3</option>");
        out.println("</select>");
        
        out.println("<br/></br>");
        out.println("<br/></br>");
        out.println("<br/></br>");
        out.println("<br><input type=\"submit\" value=\"Simulation\">");
        out.println("</form>");
        out.println("</body>");
        out.println("</center>");
        out.println("</html>");
      
	
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
