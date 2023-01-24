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

import com.securiteweb1.securiteweb1.dao.CompteDao;
import com.securiteweb1.securiteweb1.dao.CompteDaoImpl;
import com.securiteweb1.securiteweb1.dao.DroitDao;
import com.securiteweb1.securiteweb1.dao.DroitDaoImpl;
import com.securiteweb1.securiteweb1.entities.Compte;
import com.securiteweb1.securiteweb1.entities.Droit;

/**
 * Servlet implementation class DroitServlet
 */
@WebServlet(value = "/Droit", name = "droit")
public class DroitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DroitDao droitdao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DroitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.droitdao = new DroitDaoImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("userConnect") == null) {
			response.sendRedirect("Login");
		} else {
			List<Droit> droits = droitdao.findAll();
			request.setAttribute("droits", droits);
			request.getRequestDispatcher("/WEB-INF/views/droits/list.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Droit droit = new Droit();
		droit.setName(request.getParameter("name"));
		droitdao.save(droit);
		List<Droit> droits = droitdao.findAll();
		request.setAttribute("droits", droits);
		response.sendRedirect("Droit");
	}

}
