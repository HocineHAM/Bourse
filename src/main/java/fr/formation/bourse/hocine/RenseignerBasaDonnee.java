package fr.formation.bourse.hocine;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RenseignerBasaDonnee
 */

public class RenseignerBasaDonnee extends HttpServlet {

	public static final String Newfile = "/WEB-INF/Inscription.jsp";
	public static final String nom = "nom";
	public static final String prenom = "prenom";
	public static final String identifiant = "nom";
	public static final String mdp = "motDePasse";
	public static final String civilite = "civilite";

	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PreparedStatement req;
//		ResultSet res;
//		int id;
//		int nb;
	    String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String identifiant = request.getParameter("identifiant");
		String motDePasse = request.getParameter("motDePasse");
		String mail = request.getParameter("mail");
		
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
			req = connect.prepareStatement("Insert into utilisateurs(nom, prenom,email,identifiant,motDePasse) VALUES (?,?,?,?,?)");
			req.setString(1, nom);
			req.setString(2, prenom);
			req.setString(3, mail);
			req.setString(4, identifiant);
			req.setString(5, motDePasse);
			req.executeUpdate();

			req.close();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		System.out.println("Bienvenue parmis nous");
		
		RequestDispatcher rd = request.getRequestDispatcher("/connexion");
		rd.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
