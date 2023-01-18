package com.securiteweb1.securiteweb1.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.securiteweb1.securiteweb1.dao.CompteDao;
import com.securiteweb1.securiteweb1.dao.CompteDaoImpl;
import com.securiteweb1.securiteweb1.dao.DroitDao;
import com.securiteweb1.securiteweb1.dao.DroitDaoImpl;
import com.securiteweb1.securiteweb1.dao.HibernateUtil;
import com.securiteweb1.securiteweb1.entities.Compte;
import com.securiteweb1.securiteweb1.entities.Droit;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(value = "/Login", name = "login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CompteDao comptedao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		comptedao = new CompteDaoImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Compte compte = new Compte();
		compte.setUsername(request.getParameter("login"));
		compte.setPassword(request.getParameter("password"));
		comptedao.save(compte);*/
		try {
			Compte compte1 = comptedao.logon(request.getParameter("login"),request.getParameter("password"));
			HttpSession session1 = request.getSession();
			session1.setAttribute("userConnect", compte1);
			response.sendRedirect("Compte");
		} catch (Exception e) {
			request.setAttribute("msg_error", "nom d'utilisateur ou mot de passe incorrect !");
			response.sendRedirect("Login");
		}
	}

}
