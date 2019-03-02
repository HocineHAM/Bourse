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

public class Nasdaq extends HttpServlet {

	private static final long serialVersionUID = 5395222771235455382L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double indicenas;
		Date date;
		
		try {
			
			Statement req;
			ResultSet res;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
			
			req = connect.createStatement();
			res = req.executeQuery("SELECT Annee, nasdaq FROM boursenasdaq");
			ArrayList<String> maliste = new ArrayList<String>();
			while (res.next()) {
				date = res.getDate(1);
				indicenas = res.getDouble(2);
				maliste.add(date +" : " + indicenas);
			}
			request.setAttribute("nom", maliste);
			req.close();

			ServletContext context = getServletContext();
			RequestDispatcher dispatcher = context.getRequestDispatcher("/nasdaq.jsp");
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
