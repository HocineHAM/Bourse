package fr.formation.bourse.hocine;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Connexion
 */
// @WebServlet("/connexion")
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PreparedStatement prstm;
		String login = request.getParameter("identifiant");
		String pwd = request.getParameter("motDePasse");

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
			String sql = "select * from utilisateurs where identifiant=? and motdepasse=?";
			prstm = connect.prepareStatement(sql);
			prstm.setString(1, login);
			prstm.setString(2, pwd);

			ResultSet rs = prstm.executeQuery();
			if (rs.next()) {
				System.out.println(rs.getString(1));
				request.getSession().setAttribute(login, pwd);

				RequestDispatcher rd = request.getRequestDispatcher("/manu.html");
				rd.forward(request, response);
			}
			else {
				
				 RequestDispatcher rd = request.getRequestDispatcher("/login.html");
				 rd.forward(request, response);
				

			}
			// boolean b =false;
			// while (rs.next()) {
			// System.out.println(rs.getString(5));
			// System.out.println(rs.getString(6));
			// response.sendRedirect("Acceuil.html");
			// System.out.println("--------------------");
			// b=true;
			// // RequestDispatcher rd = request.getRequestDispatcher("EspaceMembre");
			// // rd.forward(request, response);
			// response.sendRedirect("EspaceMembre.html");
			// }
			//
			// prstm.close();
			// if(!b)
			// response.sendRedirect("login.html");
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

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
