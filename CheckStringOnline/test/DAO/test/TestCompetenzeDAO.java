package DAO.test;

import java.util.ArrayList;

import DAO.Competenza;
import DAO.PostgresCompetenzeDAO;

public class TestCompetenzeDAO {

	public static void main(String[] args) throws ClassNotFoundException {
		int errors = 0;
		PostgresCompetenzeDAO c = new PostgresCompetenzeDAO();

		System.out.println("Instanziazione Funzionante!\n\n");

		String competenza = "HTML10";
		System.out.println("METODO: inserisciCompetenza PARAMETRI: " + competenza + "\n");
		System.out.flush();
		c.inserisciCompetenza(competenza);
		if (c.getCompetenza(competenza) != null) {
			System.out.println("La parola inserita e': " + c.getCompetenza(competenza) + "\n\n");

		} else {
			System.err.println("Inserimento Errato");
			errors++;
		}

//		log4j

		System.out.println("METODO: vediCompetenze\n");
		ArrayList<Competenza> competenze = c.vediCompetenze();
		if (competenze == null) {
			System.err.println("Non è stato restituito un oggetto dal metodo");
			errors++;
		} else if (competenze.size() == 0) {
			System.err.println("L'ArrayList restituito è vuoto");
			errors++;
		} else {
			System.out.println("L'ArrayListContiene:");
			for (Competenza co : competenze) {
				System.out.println(co.toString());
			}
			System.out.println("\n");
		}

		System.out.println("METODO: rimuoviCompetenza PARAMETRI: " + competenza + "\n");
		c.rimuoviCompetenza(competenza);
		if (c.getCompetenza(competenza) == null) {
			System.out.println("La parola " + competenza + " e' stata rimossa");

		} else {
			System.err.println("Rimozione Fallita");
			errors++;
		}

		System.out.println("\nESECUZIONE COMPLETATA\n" + "Errori riscontrati: " + errors);

	}

}
