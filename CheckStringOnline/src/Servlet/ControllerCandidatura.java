package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Candidatura;

/**
 * Servlet implementation class Controller
 */
@WebServlet(description = "Create new Servlet", urlPatterns = { "/candidaturaCompletata" })
public class ControllerCandidatura extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
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
		String cognome = request.getParameter("cognome");
		String dataNascita = request.getParameter("dataNascita");
		String titoloStudio = request.getParameter("titoloStudio");
		String livelloEsperienza = request.getParameter("livelloEsperienza");
		String competenze = request.getParameter("competenze");
		String ultimaEsperienza = request.getParameter("ultimaEsperienza");

		String s = "Nome: " + nome + "\nCognome: " + cognome + "\n" + "Data di Nascita: " + dataNascita + "\n"
				+ "Titolo di studio: " + titoloStudio + "\n" + "Livello di esperienza: " + livelloEsperienza + "\n"
				+ "Competenze tecniche: " + competenze + "\n" + "Ultima esperienza: " + ultimaEsperienza;

		Candidatura candidatura = new Candidatura(nome, cognome, dataNascita, titoloStudio, livelloEsperienza,
				competenze, ultimaEsperienza);

		candidatura.StreamData(s);

		request.setAttribute("candidatura", candidatura);
		RequestDispatcher view = request.getRequestDispatcher("candidaturaCompletata.jsp");
		view.forward(request, response);

	}

}
