package DAO;

import java.util.ArrayList;

public class PostgresCompetenzeDAO extends PostgresAbstractDAO implements CompetenzeDAO {

	@Override
	public void inserisciCompetenza(String nomeCompetenza) throws ClassNotFoundException {
		String query = "INSERT INTO public.competenza(nome_competenza, approvata)" + "	VALUES ('" + nomeCompetenza
				+ "', 'false');";
		this.voidQuery(query);
	}

	@Override
	public void rimuoviCompetenza(String nomeCompetenza) throws ClassNotFoundException {
		String query = "DELETE FROM public.competenza\r\n" + "	WHERE nome_competenza='" + nomeCompetenza + "';";
		this.voidQuery(query);
	}

	@Override
	public ArrayList<String> vediCompetenze() throws ClassNotFoundException {

		String query = "SELECT * FROM public.competenza";
		return this.ArrayListQuery(query);

	}

	@Override
	public String getCompetenza(String nomeCompetenza) throws ClassNotFoundException {

		String query = "SELECT * FROM public.competenza WHERE nome_competenza='" + nomeCompetenza + "';";
		return this.StringQuery(query);

	}

	private void voidQuery(String query) throws ClassNotFoundException {
		super.noReturnExecute(query);

	}

	private String StringQuery(String query) throws ClassNotFoundException {

		ArrayList<Object[]> risultato = super.resultSetExecute(query);
		if (risultato.size() != 0) {
			Object[] res = risultato.get(0);
			String s = (String) res[0];

			return s;
		}

		return null;
	}

	private ArrayList<String> ArrayListQuery(String query) throws ClassNotFoundException {

		ArrayList<Object[]> risultato = super.resultSetExecute(query);
		ArrayList<String> listaS = new ArrayList<String>();

		for (Object[] tupla : risultato) {

			String s = (String) tupla[0];
			listaS.add(s);
		}

		return listaS;

	}

}