//package fr.formation.bourse.hocine;
//
//import java.io.IOException;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//
//public class Filtre implements Filter {
//
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//
//		if (request.getAttribute("utilisateur").equals("password")) {
//			/*
//			 * RequestDispatcher rd = request.getRequestDispatcher("/programme");
//			 * rd.forward(request, response);
//			 */
//			chain.doFilter(request, response);
//		} else {
//
//			RequestDispatcher rd = request.getRequestDispatcher("login.html");
//			rd.forward(request, response);
//		}
//	}
//
//	public void init(FilterConfig filterConfig) throws ServletException {
//		// TODO Auto-generated method stub ( on implement ce constructeur vide pour que
//		// le plug in marche)
//	}
//}
