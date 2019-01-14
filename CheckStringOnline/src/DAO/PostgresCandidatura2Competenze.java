package DAO;
import java.util.ArrayList;

import DAO.Candidatura2CompetenzeDAO;
import DAO.Competenza;

public class PostgresCandidatura2Competenze extends PostgresAbstractDAO implements Candidatura2CompetenzeDAO{

	@Override
	public boolean inserisciCandidatura2Competenze(long id_candidatura,String nomeCompetenza) throws ClassNotFoundException {
		String query="INSERT INTO public.candidatura2competenze(id_candidatura, competenze) VALUES ('"+id_candidatura+"', '"+nomeCompetenza+"')";
		return this.booleanQuery(query);
	}

	@Override
	public boolean rimuoviCandidatura2Competenze(long id_candidatura) throws ClassNotFoundException {
		String query="DELETE FROM public.candidatura2competenze WHERE id_candidatura='"+id_candidatura+"'";
		return this.booleanQuery(query);
		
	}

	@Override
	public boolean rimuoviCandidatura2Competenze(long id_candidatura, String nomeCompetenza) throws ClassNotFoundException {
		String query="DELETE FROM public.candidatura2competenze WHERE id_candidatura='"+id_candidatura+"' AND competenza=' "+nomeCompetenza+"'";
		return this.booleanQuery(query);
	}

	@Override
	public ArrayList<Candidatura2Competenze> vediCandidatura2Competenze() throws ClassNotFoundException {
		String query = "SELECT * FROM public.candidatura2competenze";
		return this.ArrayListQuery(query);
	}

	@Override
	public ArrayList<Candidatura2Competenze> vediCandidatura2Competenze(String nomeCompetenza) throws ClassNotFoundException {
		String query = "SELECT * FROM public.candidatura2competenze WHERE competenza='"+nomeCompetenza+"'";
		return this.ArrayListQuery(query);
	}

	@Override
	public ArrayList<Candidatura2Competenze> getCandidatura2Competenze(long id_candidatura) throws ClassNotFoundException {
		String query = "SELECT * FROM public.candidatura2competenze WHERE id_candidatura='"+id_candidatura+"'";
		return this.ArrayListQuery(query);
	}
	private  ArrayList<Candidatura2Competenze> ArrayListQuery(String query) throws ClassNotFoundException{
		
		ArrayList<Object[]> risultato = super.resultSetExecute(query);
		ArrayList<Candidatura2Competenze> listaC = new ArrayList<Candidatura2Competenze>();
		
		for(Object[] tupla : risultato) {
		
			Candidatura2Competenze c = new Candidatura2Competenze(
					tupla[0],
					(String) tupla[1].toString());
					listaC.add(c);
		}
		return listaC;
	
	}
	private boolean booleanQuery(String query) throws ClassNotFoundException {

		return super.noReturnExecute(query);
		
	}
	
}
