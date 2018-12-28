package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PostgreCandidaturaDAO extends PostgresAbstractDAO implements CandidaturaDAO{

	public PostgreCandidaturaDAO() {
		super();
	}
	public PostgreCandidaturaDAO(String url, String user, String password, String driver) {
		super(url, user, password, driver);
	}
	
	
	
	@Override
	public ArrayList<Candidatura> vediCandidature() throws ClassNotFoundException {
		String query = "SELECT * FROM candidatura WHERE stato='true'";
		return this.ArrayListQuery(query);
	}

	@Override
	public ArrayList<Candidatura> vediNuoveCandidature() throws ClassNotFoundException {		
		String query = "SELECT * FROM candidatura WHERE stato='false'";
		return this.ArrayListQuery(query);
	}
	
	@Override
	public ArrayList<Candidatura> vediTutteCandidature() throws ClassNotFoundException {		
		String query = "SELECT * FROM candidatura ";
		return this.ArrayListQuery(query);
	}

	@Override
	public boolean inserisciCandidatura(Candidatura c) throws ClassNotFoundException {

		String query = "INSERT into candidatura(nome,cognome,email,data_nascita,num_telefono,titolo_studio,livello_esperienza,ultima_esperienza) VALUES ('"+c.getNome()+"','"+c.getCognome()+"','"+c.getEmail()+"','"+c.getDataNascita()+"','"+c.getNumTelefono()+"','"+c.getTitoloStudio()+"','"+c.getLivelloEsperienza()+"','"+c.getUltimaEsperienza()+"')";
		return this.booleanQuery(query);

	}

//	public boolean rimuoviCandidatura(Candidatura c) throws ClassNotFoundException {
//		String query = "DELETE FROM public.candidatura\r\n" + 
//				"	WHERE id_candidatura=;";????
//		return this.booleanQuery(query);
//	}
	

	
	private boolean booleanQuery(String query) throws ClassNotFoundException {

		return super.noReturnExecute(query);
		
	}
	
	private  ArrayList<Candidatura> ArrayListQuery(String query) throws ClassNotFoundException{
		
		ArrayList<Object[]> risultato = super.resultSetExecute(query);
		ArrayList<Candidatura> listaC = new ArrayList<Candidatura>();
		
		for(Object[] tupla : risultato) {
		
			Candidatura c = new Candidatura(
					(String) tupla[0].toString(),
					(String) tupla[1],
					(String) tupla[2],
					(String) tupla[3],
					(String) tupla[4].toString(),
					(String) tupla[5],
					(String) tupla[6],
					(String) tupla[7],
					(String) tupla[8]);
			listaC.add(c);
		}

		
		return listaC;
	
	}
	
	
	

}
