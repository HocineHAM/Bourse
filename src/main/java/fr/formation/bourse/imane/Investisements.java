package fr.formation.bourse.imane;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class Investisements extends HttpServlet {
	private static final long serialVersionUID = 1L;

	



		
	
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			
			Statement req;
            ResultSet res;
            int id;
            double Depot;
            String ChoixEntreprise;
            Date ChoixDate;
            double SommeInvestie;
            double ChoixCritere;
            double SommeFinale;
            double stock;
            
            
            ArrayList<String> portefeuille = new ArrayList<String>();
            
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();

                Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
                req = connect.createStatement();
                res = req.executeQuery("SELECT id, Depot, ChoiXEntreprise  ,ChoixDate ,SommeInvestie,ChoixCritere,SommeFinale, stock FROM base");

                while (res.next()) {
                    id = res.getInt(1);
                    Depot = res.getDouble(2);
                    ChoixEntreprise= res.getString(3);
                    ChoixDate = res.getDate(4);
                    SommeInvestie= res.getDouble(5);
                    ChoixCritere= res.getDouble(6);
                    SommeFinale= Depot-SommeInvestie;
                    stock= res.getDouble(8);
                    
                    
                    portefeuille.add("\n Investisements "
                            + "\n id :" + id +", "
                            + "\n   Depot :" + Depot + ", "
                            + "\n   Choix de Entreprise=" + ChoixEntreprise + ","
                            + "\n   Somme investie="  + SommeInvestie +  ","
                            + "\n   Date d'investisement=" + ChoixDate + ", "
                            + "\n   Choix du Critere=" + ChoixCritere + ", "
                            + "\n   SommeFinale=" + SommeFinale+ ", "
                            + "\n   stock=" + stock);
                
                }
                
            
                req.close();

            

            } catch (SQLException e) {
                // TODO Auto-generated catch block
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
            }
            
            request.setAttribute("theportefeuille", portefeuille);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Portefeuilles.jsp");
            dispatcher.forward(request,response);
//            ServletContext context = getServletContext();
//            RequestDispatcher dispatcher = context.getRequestDispatcher("/Portefeuilles.jsp");
//            dispatcher.forward(request, response);

        }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}