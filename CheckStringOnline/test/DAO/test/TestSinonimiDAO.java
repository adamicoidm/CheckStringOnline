package DAO.test;

import java.util.ArrayList;

import DAO.SinonimiDAO;
import DAO.Sinonimo;

public class TestSinonimiDAO {

	public static void main(String[] args) throws ClassNotFoundException {

		int errors = 0;
		SinonimiDAO s = new SinonimiDAO();

		System.out.println("Instanziazione Funzionante!\n\n");

		String sinonimo = "HTML9";
		String competenza = "HTML";
		System.out.println("METODO: inserisciCSinonimo PARAMETRI: " + sinonimo + ", " + competenza + "\n");
		System.out.flush();
		s.inserisciSinonimo(competenza, sinonimo);
		if (s.getSinonimo(sinonimo) != null) {
			System.out.println("La parola inserita e': " + s.getSinonimo(sinonimo) + "\n\n");

		} else {
			System.err.println("Inserimento Errato");
			errors++;
		}

		System.out.println("METODO: vediSinonimi\n");
		ArrayList<Sinonimo> sinonimi = s.vediSinonimi();
		if (sinonimi == null) {
			System.err.println("Non è stato restituito un oggetto dal metodo");
			errors++;
		} else if (sinonimi.size() == 0) {
			System.err.println("L'ArrayList restituito è vuoto");
			errors++;
		} else {
			System.out.println("L'ArrayListContiene:");
			for (Sinonimo si : sinonimi) {
				System.out.println(si.toString());
			}
			System.out.println("\n");
		}

		System.out.println("METODO: rimuoviCompetenza PARAMETRI: " + sinonimo + "\n");
		s.rimuoviSinonimo(sinonimo);
		if (s.getSinonimo(sinonimo).length() == 0) {
			System.out.println("La parola " + sinonimo + " e' stata rimossa");
		} else {
			System.err.println("Rimozione Fallita");
			errors++;
		}

		System.out.println("\nESECUZIONE COMPLETATA\n" + "Errori riscontrati: " + errors);

	}

}
