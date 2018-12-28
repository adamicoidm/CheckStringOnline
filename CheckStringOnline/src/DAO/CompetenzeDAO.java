package DAO;

import java.util.ArrayList;

public interface CompetenzeDAO {

	void inserisciCompetenza(String nomeCompetenza) throws ClassNotFoundException;

	void rimuoviCompetenza(String nomeCompetenza) throws ClassNotFoundException;

	ArrayList<String> vediCompetenze() throws ClassNotFoundException;

	String getCompetenza(String nomeCompetenza) throws ClassNotFoundException;

}
