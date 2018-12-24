package DAO;

import java.util.ArrayList;

public class TestCandidaturaDAO {

	public static void main(String[] args) throws ClassNotFoundException {
		CandidaturaDAO c = new CandidaturaDAO();
		
		System.out.println("Instanziazione Funzionante!\n\n");
		
		System.out.println("METODO: vediCandidature\n");
		ArrayList<Candidatura> candidature = c.vediCandidature();		
		if(candidature == null) {
			System.err.println("Non è stato restituito un oggetto dal metodo");
		}else if(candidature.size() ==0) {
			System.err.println("L'ArrayList restituito è vuoto");
		}else {		
			System.out.println("L'ArrayListContiene:");
			for (Candidatura ca : candidature) {
				System.out.println(ca.toString());
			}
			System.out.println("\n");
		}
		
		System.out.println("METODO: vediNuoveCandidature\n");
		candidature=null;
		candidature = c.vediNuoveCandidature();		
		if(candidature == null) {
			System.err.println("Non è stato restituito un oggetto dal metodo");
		}else if(candidature.size() ==0) {
			System.err.println("L'ArrayList restituito è vuoto");
		}else {		
			System.out.println("L'ArrayListContiene:");
			for (Candidatura ca : candidature) {
				System.out.println(ca.toString());
			}
			System.out.println("\n");
		}
		
		System.out.println("METODO: vediTutteCandidature\n");
		candidature=null;
		candidature = c.vediTutteCandidature();		
		if(candidature == null) {
			System.err.println("Non è stato restituito un oggetto dal metodo");
		}else if(candidature.size() ==0) {
			System.err.println("L'ArrayList restituito è vuoto");
		}else {		
			System.out.println("L'ArrayListContiene:");
			for (Candidatura ca : candidature) {
				System.out.println(ca.toString());
			}
			System.out.println("\n");
		}
		
		
		
		
	}

}
