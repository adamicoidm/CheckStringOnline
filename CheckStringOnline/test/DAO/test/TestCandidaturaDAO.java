package DAO.test;

import java.util.ArrayList;

import DAO.Candidatura;
import DAO.PostgreCandidaturaDAO;

public class TestCandidaturaDAO {

	public static void main(String[] args) throws ClassNotFoundException {
		int errors = 0;

		PostgreCandidaturaDAO c = new PostgreCandidaturaDAO();

		System.out.println("Instanziazione Funzionante!\n\n");
		
		Candidatura candidatura = new Candidatura(0, "nome", "cognome", "email@d", "11-11-11", "numTelefono",
				"titoloStudio", "livelloEsperienza", "competenze", false, "ultimaEsperienza");
		System.out.println("METODO: inserisciCandidatura PARAMETRI: " + candidatura.toString() + "\n");
		System.out.flush();
		c.inserisciCandidatura(candidatura);
		

		System.out.println("METODO: vediCandidature\n");
		ArrayList<Candidatura> candidature = c.vediCandidature();
		if (candidature == null) {
			System.err.println("Non è stato restituito un oggetto dal metodo");
			errors++;
		} else if (candidature.size() == 0) {
			System.err.println("L'ArrayList restituito è vuoto");
			errors++;
		} else {
			System.out.println("L'ArrayListContiene:");
			for (Candidatura ca : candidature) {
				System.out.println(ca.getNome());
			}
			System.out.println("\n");
		}

		System.out.println("METODO: vediNuoveCandidature\n");
		candidature = null;
		candidature = c.vediNuoveCandidature();
		if (candidature == null) {
			System.err.println("Non è stato restituito un oggetto dal metodo");
			errors++;
		} else if (candidature.size() == 0) {
			System.err.println("L'ArrayList restituito è vuoto");
			errors++;
		} else {
			System.out.println("L'ArrayListContiene:");
			for (Candidatura ca : candidature) {
				System.out.println(ca.getNome());
			}
			System.out.println("\n");
		}

		System.out.println("METODO: vediTutteCandidature\n");
		candidature = null;
		candidature = c.vediTutteCandidature();
		if (candidature == null) {
			System.err.println("Non è stato restituito un oggetto dal metodo");
			errors++;
		} else if (candidature.size() == 0) {
			System.err.println("L'ArrayList restituito è vuoto");
			errors++;
		} else {
			System.out.println("L'ArrayListContiene:");
			for (Candidatura ca : candidature) {
				System.out.println(ca.getNome());
			}
			System.out.println("\n");
		}

		System.out.println("\nESECUZIONE COMPLETATA\n" + "Errori riscontrati: " + errors);

	}

}
