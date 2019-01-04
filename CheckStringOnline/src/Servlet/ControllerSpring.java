package Servlet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import DAO.*;

/**
 * Servlet implementation class Controller
 */
@Controller
public class ControllerSpring extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//CONTROLLER SPRING
	
	
	public ControllerSpring() {
		super();
	}

	
	//HOME
	
	
	@GetMapping(value = "/")
	public String home() {

		return "Candidatura";
	}
	
	
	//CANDIDATURE
	
	
	@GetMapping(value = "/VediCandidature")
	public String vediCandidature(@ModelAttribute("/VediCandidature") ArrayList <Candidatura> candidatura,
			ModelMap model) throws ClassNotFoundException, SQLException {
		PostgreCandidaturaDAO c = new PostgreCandidaturaDAO();
		ArrayList<Candidatura> candidature = c.vediCandidature();
		model.addAttribute("ListaCandidature", candidature);
		return "VediCandidatureAccettate";
	}
	
	@GetMapping(value = "/VediNuoveCandidature")
	public String vediNuoveCandidature(@ModelAttribute("/VediNuoveCandidature") ArrayList <Candidatura> candidatura,
			ModelMap model) throws ClassNotFoundException, SQLException {
		PostgreCandidaturaDAO c = new PostgreCandidaturaDAO();
		List<Candidatura> candidature = c.vediNuoveCandidature();
		model.addAttribute("ListaCandidature", candidature);
		return "VediCandidature";
	}

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

	@GetMapping(value = "/accettaCandidatura")
	public String accettaCandidatura(@ModelAttribute("/acceptCandidatura") Candidatura candidatura, ModelMap model)
			throws ClassNotFoundException {
		PostgreCandidaturaDAO aC = new PostgreCandidaturaDAO();
		aC.accettaCandidatura(candidatura, 3);
		return "VediNuoveCandidature";
	}

	
	//COMPETENZE
	
	
	@GetMapping(value = "/InserisciCompetenza")
	public String inserisciCompetenza(@ModelAttribute("/InserisciCompetenza") ArrayList <Candidatura> candidatura,
			ModelMap model) throws ClassNotFoundException, SQLException {
		return "InserisciCompetenza";
	}

	@GetMapping(value = "/addCompetenza")
	public String addCompetenza(@ModelAttribute("/addCandidatura")ArrayList<String> competenze,PostgresCompetenzeDAO competenza, ModelMap model)
			throws ClassNotFoundException {
		competenza.inserisciCompetenza(competenza.getNomeCompetenza());
		return vediCompetenze(competenze,model);
	}

	@GetMapping(value = "/removeCompetenza")
	public String removeCompetenza(@ModelAttribute("/removeCompetenza") ArrayList<String> competenze, PostgresCompetenzeDAO competenza, ModelMap model)
			throws ClassNotFoundException {
		competenza.rimuoviCompetenza(competenza.getNomeCompetenza());
		
		return vediCompetenze(competenze, model);
	}

	@GetMapping(value = "/VediCompetenze")
	public String vediCompetenze(@ModelAttribute("/VediCompetenze") ArrayList<String> competenze, ModelMap model)
			throws ClassNotFoundException {
		PostgresCompetenzeDAO c = new PostgresCompetenzeDAO();
		List<PostgresCompetenzeDAO> competenze1 = c.vediCompetenze();
		model.addAttribute("ListaCompetenze", competenze1);
		return "VediCompetenze";
	}

	
	//LOGIN
	
	
	@GetMapping(value = "/LoginButtonCand")
	public String Login(@ModelAttribute("/LoginButtonCand") ModelMap model) throws ClassNotFoundException, SQLException {
		return "Login";
	}

	@GetMapping(value = "/Login")
	public String LoginButton(@ModelAttribute("/Login") Utente utente, ModelMap model) throws ClassNotFoundException, SQLException {
		model.addAttribute("user", utente.getUser());
		model.addAttribute("password", utente.getPassword());
		if ((utente.getUser().equals("Chiara")) && (utente.getPassword().equals("Titti"))) {
			return "PanelControl";
		} else {
			return "Login";
		}

	}
	
	//PANNELLO DI CONTROLLO
	
	
	@GetMapping(value = "/PanelControl")
	  public String vaiPanelControl(@ModelAttribute("/PanelControl") ModelMap model)
	      throws ClassNotFoundException, SQLException {
	    return "PanelControl";
	  }
	}
