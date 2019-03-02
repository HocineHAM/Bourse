//package fr.formation.bourse.market;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class marche extends HttpServlet {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = -3779882394003588733L;
//
//	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<link rel=\"stylesheet\" href=\"style.css\" media=\"screen\" type=\"text/css\" />");
//		out.println("<title> LE MARCHE</title> ");
//		// out.println("<title> Titre !" + nom + "</title> ");
//		out.println("</head>");
//		out.println("<h1>CHOIX DU MARCHE</h1>");
//		out.println("<input type=\"submit\" value='CAC40' />");
//		out.println("<input type=\"submit\" value='Dow Jones' />");
//		out.println("<input type=\"submit\" value='Nasdaq' />");
//		out.println("<input type=\"submit\" value='Shanghai' />");
//		out.println("</form>");
//		out.println("</div>");
//		out.println("</body>");
//		out.println("</html>");
//	}
//	
//	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}
//}
