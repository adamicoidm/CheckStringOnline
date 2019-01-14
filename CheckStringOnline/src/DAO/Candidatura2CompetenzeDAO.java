package DAO;
import java.util.ArrayList;

public interface Candidatura2CompetenzeDAO {

	boolean inserisciCandidatura2Competenze(long id_candidatura,String nomeCompetenza) throws ClassNotFoundException;

	boolean rimuoviCandidatura2Competenze(long id_candidatura,String nomeCompetenza) throws ClassNotFoundException;

	ArrayList<Candidatura2Competenze> vediCandidatura2Competenze() throws ClassNotFoundException;

	ArrayList<Candidatura2Competenze> vediCandidatura2Competenze(String nomeCompetenza) throws ClassNotFoundException;

	ArrayList<Candidatura2Competenze> getCandidatura2Competenze(long id_candidatura) throws ClassNotFoundException;

	boolean rimuoviCandidatura2Competenze(long id_candidatura) throws ClassNotFoundException;

}
