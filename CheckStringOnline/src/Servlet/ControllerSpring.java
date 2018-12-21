package Servlet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import DAO.Candidatura;
import DAO.PanelControlQuery;

/**
 * Servlet implementation class Controller
 */
@Controller
public class ControllerSpring extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@GetMapping(value = "/addCandidatura")
	public String addCandidatura(@ModelAttribute("/addCandidatura") Candidatura candidatura, ModelMap model)
			throws ClassNotFoundException {
		model.addAttribute("nome", candidatura.getNome());
		model.addAttribute("cognome", candidatura.getCognome());
		model.addAttribute("email", candidatura.getEmail());
		model.addAttribute("dataNascita", candidatura.getDataNascita());
		model.addAttribute("numTelefono", candidatura.getNumTelefono());
		model.addAttribute("titoloStudio", candidatura.getTitoloStudio());
		model.addAttribute("competenze", candidatura.getCompetenze());
		model.addAttribute("livelloEsperienza", candidatura.getLivelloEsperienza());
		model.addAttribute("ultimaEsperienza", candidatura.getUltimaEsperienza());
		candidatura.insertCandidatura();
		return "candidaturaCompletata";
	}

	@GetMapping(value = "/VediCandidature")
	public String vediCandidature(@ModelAttribute("/VediCandidature") ModelMap model) throws ClassNotFoundException, SQLException {

		ArrayList<Candidatura> candidature = PanelControlQuery.vediCandidature(); 

		model.addAttribute("ListaCandidature", candidature);
				
		return "VediCandidature";
	}
	@GetMapping(value = "/VediNuoveCandidature")
	public String vediNuoveCandidature(@ModelAttribute("/VediNuoveCandidature") ArrayList <Candidatura> candidatura,ModelMap model) throws ClassNotFoundException, SQLException {
		List<Candidatura> candidature = PanelControlQuery.vediNuoveCandidature();
		model.addAttribute("ListaCandidature", candidature);
		return "VediCandidature";
	}
	@GetMapping(value = "/PanelControl")
	public String vaiPanelControl(@ModelAttribute("/PanelControl") ModelMap model) throws ClassNotFoundException, SQLException {
	return "PanelControl";
	}
	@GetMapping(value = "/")
	public String home() {

		return "Candidatura";
	}

	public ControllerSpring() {
		super();
	}


}
