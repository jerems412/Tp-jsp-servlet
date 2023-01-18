package com.securiteweb1.securiteweb1.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import com.securiteweb1.securiteweb1.dao.CompteDao;
import com.securiteweb1.securiteweb1.dao.CompteDaoImpl;
import com.securiteweb1.securiteweb1.dao.DroitDao;
import com.securiteweb1.securiteweb1.dao.DroitDaoImpl;
import com.securiteweb1.securiteweb1.dao.HibernateUtil;
import com.securiteweb1.securiteweb1.entities.Compte;
import com.securiteweb1.securiteweb1.entities.Droit;

/**
 * Servlet implementation class CompteServlet
 */
@WebServlet(value = "/Compte", name = "compte")
public class CompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private CompteDaoImpl comptedao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.comptedao = new CompteDaoImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("userConnect") == null) {
			response.sendRedirect("Login");
		} else {
			//List<Compte> comptes = comptedao.findAll();
			//request.setAttribute("comptes", comptes);
			request.getRequestDispatcher("/WEB-INF/views/comptes/list.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Compte compte = new Compte();
		compte.setUsername(request.getParameter("login"));
		compte.setPassword(request.getParameter("password"));
		comptedao.save(compte);
		List<Compte> comptes = comptedao.findAll();
		request.setAttribute("comptes", comptes);
		response.sendRedirect("Compte");
	}

}
