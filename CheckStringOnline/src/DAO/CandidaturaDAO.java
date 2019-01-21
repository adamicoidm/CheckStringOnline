package DAO;

import java.util.ArrayList;

public interface CandidaturaDAO {

	public abstract ArrayList<Candidatura> vediCandidature() throws ClassNotFoundException ;

	public abstract ArrayList<Candidatura> vediNuoveCandidature() throws ClassNotFoundException ;
	
	public abstract ArrayList<Candidatura> vediTutteCandidature() throws ClassNotFoundException ;
	
	public abstract ArrayList<Candidatura> resocontoCandidatura(long index) throws ClassNotFoundException;
	
	public abstract boolean inserisciCandidatura(Candidatura c) throws ClassNotFoundException ;

	public abstract ArrayList<Candidatura> getId_New_Candidatura(Candidatura c) throws ClassNotFoundException;
	
	public abstract  boolean cambiaStato(long id_candidatura,String stato)  throws ClassNotFoundException;
	
	public abstract ArrayList<Candidatura> cercaCandidaturaCompetenza(String competenza) throws ClassNotFoundException;

	public abstract ArrayList<Candidatura> vediTutteCandidatureOrderNome() throws ClassNotFoundException;
	
	public abstract ArrayList<Candidatura> vediTutteCandidatureOrderCognome() throws ClassNotFoundException;
	
	public abstract ArrayList<Candidatura> vediTutteCandidatureOrderTitoloStudio() throws ClassNotFoundException;

	public abstract ArrayList<Candidatura> vediTutteCandidatureOrderLivelloEsperienza() throws ClassNotFoundException;

	public abstract ArrayList<Candidatura> vediTutteCandidatureOrderStato() throws ClassNotFoundException;

	public abstract ArrayList<Candidatura> cercaCandidaturaTitoloStudio(String titolostudio) throws ClassNotFoundException;

	public abstract ArrayList<Candidatura> cercaCandidaturaStato(String stato) throws ClassNotFoundException;

	public abstract ArrayList<Candidatura> cercaCandidaturaLivelloEsperienza(String livelloesperienza) throws ClassNotFoundException;
}
