package DAO;

import java.util.ArrayList;

public class PostgresSinonimiDAO extends PostgresAbstractDAO implements SinonimiDAO {

	@Override
	public void inserisciSinonimo(String nomeCompetenza, String sinonimo) throws ClassNotFoundException {
		String query = "INSERT INTO public.sinonimi(corrispondenza, competenza_standard) " + 
				"	VALUES ('"+ sinonimo +"', '"+ nomeCompetenza + "');";
		this.voidQuery(query);
	}
	
	@Override
	public void rimuoviSinonimo(String sinonimo) throws ClassNotFoundException {
		String query = "DELETE FROM public.sinonimi\r\n" + 
				"	WHERE corrispondenza='"+ sinonimo +"';";
		this.voidQuery(query);
	}
	
	@Override
	public String getSinonimo(String sinonimo) throws ClassNotFoundException {
			
			String query = "SELECT corrispondenza FROM public.sinonimi WHERE corrispondenza='"+sinonimo+"';";
			return this.StringQuery(query);
			
		}
	
	@Override
	public ArrayList<Sinonimo> vediSinonimi() throws ClassNotFoundException {
			
			String query = "SELECT * FROM public.sinonimi";
			return this.ArrayListQuery(query);
			
		}
	
	private  String StringQuery(String query) throws ClassNotFoundException{
		
		
		ArrayList<Object[]> risultato = super.resultSetExecute(query);
		if(risultato.size() != 0) {
		Object[] res= risultato.get(0);
		String s = (String) res[0];
		
		return s;
		}

		return null;
	}
	
	
	private void voidQuery(String query) throws ClassNotFoundException {
		super.noReturnExecute(query);
		
	}
	
	private  ArrayList<Sinonimo> ArrayListQuery(String query) throws ClassNotFoundException{
			
		ArrayList<Object[]> risultato = super.resultSetExecute(query);
		ArrayList<Sinonimo> listaS = new ArrayList<Sinonimo>();
		
		for(Object[] tupla : risultato) {
		
			Sinonimo s = new Sinonimo(
					(String) tupla[0],
					(String) tupla[1]);
			listaS.add(s);
		}

		
		return listaS;
		
		}
	
}
