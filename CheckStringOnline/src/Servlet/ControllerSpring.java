package Servlet;

import javax.servlet.http.HttpServlet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import DAO.Candidatura;
/**
 * Servlet implementation class Controller
 */
@Controller
public class ControllerSpring extends HttpServlet {
	private static final long serialVersionUID = 1L;

	  @GetMapping(value = "/addCandidatura")
	   public String addCandidatura(@ModelAttribute("/addCandidatura")Candidatura candidatura, 
	   ModelMap model) {
	      model.addAttribute("nome", candidatura.getNome());
	      model.addAttribute("cognome", candidatura.getCognome());
	      model.addAttribute("dataNascita",candidatura.getDataNascita());
	      model.addAttribute("titoloStudio",candidatura.getTitoloStudio());
	      model.addAttribute("competenze",candidatura.getCompetenze());
	      model.addAttribute("livelloEsperienza",candidatura.getLivelloEsperienza());
		return "candidaturaCompletata";
	   }
	  
	  @GetMapping(value = "/")
	   public String home() {
		  
		return "Candidatura";
	   }
	  
//	  @GetMapping(value = "/home")
//	   public String home(@RequestParam("prova") String prova) {
//		  System.out.println("Siamo passati al metodo home: "+prova);
//		  
//		return "Candidatura";
//	   }

    public ControllerSpring() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    	
}
