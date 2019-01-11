package DAO;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import algoritmi.CheckString;
import algoritmi.Equals;

public class StringaCompetenza {
	String stringaCompetenza;

	public String getstringaCompetenza() {
		return stringaCompetenza;
	}

	public void setstringaCompetenza(String stringaCompetenza) {
		this.stringaCompetenza = stringaCompetenza;
	}

	public StringaCompetenza(String stringaCompetenza) {
		this.stringaCompetenza = stringaCompetenza;
	}
	
	public ArrayList<Sinonimo> controllaCompetenze() throws ClassNotFoundException {
		String[] competenzeDaVerificare = stringaCompetenza.split(";");
		ArrayList<String[]> competenzeEcorrispondenze = new ArrayList<String[]>();

		ApplicationContext context = new ClassPathXmlApplicationContext("/algoritmi/CatenaDiResponsabilita.xml");

		CheckString algorithmChain = (Equals) context.getBean("equals");

		String s ="";
		
		PostgresSinonimiDAO p = new PostgresSinonimiDAO(); 
		
		ArrayList<Sinonimo> sin = new ArrayList<Sinonimo>();
		
		for (int i = 0; i < competenzeDaVerificare.length; i++) {
			String[] array = new String[2];
			array[0]= competenzeDaVerificare[i];
			competenzeEcorrispondenze.add(array);
			competenzeEcorrispondenze.get(i)[1] = algorithmChain.check(competenzeEcorrispondenze.get(i)[0]);
			if(!p.containsSinonimo(competenzeEcorrispondenze.get(i)[1])) {
				p.inserisciSinonimo(competenzeEcorrispondenze.get(i)[0],competenzeEcorrispondenze.get(i)[1]);
			}
			
//			s+=competenzeEcorrispondenze.get(i)[1] + "+";
			
		}
//		this.stringaCompetenza = s;
		
		for(int i = 0 ; i<competenzeEcorrispondenze.size(); i++) {
			
			Sinonimo si = new Sinonimo(competenzeEcorrispondenze.get(i)[0],competenzeEcorrispondenze.get(i)[1]);
			
			sin.add(si);
		}
		
		return sin;
		
		
		
		
		
		/**
		 * Split in Array[String]
		 * 
		 * for competenza in array
		 * 
		 * array[i]=check() nuoveCompetenze+= ", " + array[i]
		 * 
		 *
		 */

	}
}
