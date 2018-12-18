package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Utente;

/**
 * Servlet implementation class ControllerRegistrazione
 */
@WebServlet(description = "ControllerRegistrazione", urlPatterns = { "/Registrazione" })
public class ControllerRegistrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerRegistrazione() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nome = request.getParameter("nome");
		String cognome= request.getParameter("cognome");
		String nTel= request.getParameter("telefono");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String passRip = request.getParameter("password2");
		if (password == passRip) {
			Utente user = new Utente(email, password);
			//user.registrationDB();
		}
	}

}
