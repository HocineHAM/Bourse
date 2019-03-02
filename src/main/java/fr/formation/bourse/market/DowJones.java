package fr.formation.bourse.market;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DowJones extends HttpServlet {

	private static final long serialVersionUID = 2323746867973011457L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double indicedow;
		Date date;
		
		try {
			
			Statement req;
			ResultSet res;
			
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/root", "root", "root");
			
			req = connect.createStatement();
			res = req.executeQuery("SELECT ANNEE, DowJones FROM boursedowjones");
			ArrayList<String> maliste = new ArrayList<String>();
			while (res.next()) {
				date = res.getDate(1);
				indicedow = res.getDouble(2);
				maliste.add(date +" : " + indicedow);
			}
			request.setAttribute("nom", maliste);
			req.close();

			ServletContext context = getServletContext();
			RequestDispatcher dispatcher = context.getRequestDispatcher("/dowjones.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}