package DAO;

import java.util.ArrayList;

public interface SinonimiDAO {

	public void inserisciSinonimo(String nomeCompetenza, String sinonimo) throws ClassNotFoundException;

	public void rimuoviSinonimo(String sinonimo) throws ClassNotFoundException;

	public String getSinonimo(String sinonimo) throws ClassNotFoundException;

	public ArrayList<Sinonimo> vediSinonimi() throws ClassNotFoundException;

	boolean containsSinonimo(String sinonimo) throws ClassNotFoundException;
}
