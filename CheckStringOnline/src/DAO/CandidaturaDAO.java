package DAO;

import java.util.ArrayList;

public interface CandidaturaDAO {

	public abstract ArrayList<Candidatura> vediCandidature() throws ClassNotFoundException ;

	public abstract ArrayList<Candidatura> vediNuoveCandidature() throws ClassNotFoundException ;
	
	public abstract ArrayList<Candidatura> vediTutteCandidature() throws ClassNotFoundException ;
	
	public abstract ArrayList<Candidatura> resocontoCandidatura(int index) throws ClassNotFoundException;
	
	public abstract boolean inserisciCandidatura(Candidatura c) throws ClassNotFoundException ;
}
