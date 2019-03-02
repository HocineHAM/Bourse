package fr.formation.bourse.imane;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Donnee extends HttpServlet {

	private static final long serialVersionUID = -4921766939953528663L;

	@Override
	// protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
	// ServletException, IOException {
	// TODO Auto-generated method stub
	// resp.getWriter().write("bionjour");;
	// }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		 int id;
	        double Depot;
	        String ChoixEntreprise;
	        String ChoixDate; 
	        double SommeInvestie;
	        double ChoixCritere;
	        double SommeFinale;
	        
	        Connection connect;
	        try {
	            Class.forName("com.mysql.jdbc.Driver").newInstance();

	            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
	            //PreparedStatement pstmt = (PreparedStatement)
	    
	            

	            PreparedStatement pstmt = connect.prepareStatement("INSERT INTO base (id, Depot,ChoixEntreprise,ChoixDate,SommeInvestie,ChoixCritere,SommeFinale) VALUES (?,?,?,?,?,?,?)");
	            System.out.println(request.getParameter("Numerodecompte"));
	            id = Integer.parseInt(request.getParameter("Numerodecompte"));
	            Depot = Integer.parseInt(request.getParameter("Depot"));
	            ChoixEntreprise = request.getParameter("ChoixEntreprise");
	            
	            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	            ChoixDate = request.getParameter("ChoixDate");
	            Date date = formatter.parse(ChoixDate);
	            
	            
	            
	            SommeInvestie = Integer.parseInt(request.getParameter("SommeInvestie"));
	            ChoixCritere = Integer.parseInt(request.getParameter("ChoixCritere"));
	            SommeFinale = Depot - SommeInvestie;//Integer.parseInt(request.getParameter("SommeFinale"));
	            
	            pstmt.setInt(1, id);
	            pstmt.setDouble(2, Depot);
	            pstmt.setString(3, ChoixEntreprise);
	            pstmt.setDate(4, new java.sql.Date(date.getTime()));
	            pstmt.setDouble(5, SommeInvestie);
	            pstmt.setDouble(6, ChoixCritere);
	            pstmt.setDouble(7, SommeFinale);
	            pstmt.executeUpdate();

	            request.setAttribute("theportefeuille", "\n Investisements "
	                    + "<br> id :" + id +", "
	                    + "<br>   Depot :" + Depot + ", "
	                    + "<br>   Choix de Entreprise=" + ChoixEntreprise + ","
	                    + "<br>   Somme investie="  + SommeInvestie +  ","
	                    + "<br>   Date d'investisement=" + ChoixDate + ", "
	                    + "<br>   Choix du Critere=" + ChoixCritere + ", "
	                    + "<br>   SommeFinale= "+(Depot-SommeInvestie)
	                    + "<br>   stock=" );
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (InstantiationException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (IllegalAccessException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (ParseException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } 
//	        response.sendRedirect(request.getContextPath() + "/PortefeuilleH.jsp");
	        
	        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Portefeuilles.jsp");
	        dispatcher.forward(request,response);
//	        RequestDispatcher rd = request.getRequestDispatcher("investisements");
//	        // servlet2 is the url-pattern of the second servlet
	//
//	        rd.forward(request, response);// method may be include or forward

	        // while (res.next()) {
	        // id = res.getInt(1);
	        // Depot = res.getDouble(2);
	        // ChoixEntreprise= res.getString(3);
	        // ChoixDate = res.getDouble(4);
	        // SommeInvestie= res.getDouble(5);
	        // ChoixCritere= res.getDouble(6);
	        // SommeFinale= res.getDouble(7);
	        // stock= res.getDouble(8);
	        //
	        //
	        // portefeuilles.add("Investisements [id=" + id +", Depot=" + Depot + ", Choix
	        // de l'entreprise=" + ChoixEntreprise + ", Date d'investisement=" + ",
	        // Investisement=" + SommeInvestie + ChoixDate + ", Choix du Critere=" +
	        // ChoixCritere
	        // + ", SommeFinale=" + SommeFinale + ", stock=" + stock + "]");
	        //
	        // }

	        // Depot = res.getDouble(2);
	        // ChoixEntreprise= res.getString(3);
	        // ChoixDate = res.getDouble(4);
	        // SommeInvestie= res.getDouble(5);
	        // ChoixCritere= res.getDouble(6);
	        // SommeFinale= res.getDouble(7);
	        // stock= res.getDouble(8);

	    }
	}
