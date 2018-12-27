package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CandidaturaDAO {

	public ArrayList<Candidatura> vediCandidature() throws ClassNotFoundException {
		String query = "SELECT * FROM candidatura WHERE stato='true'";
		return this.ArrayListQuery(query);
	}

	public ArrayList<Candidatura> vediNuoveCandidature() throws ClassNotFoundException {		
		String query = "SELECT * FROM candidatura WHERE stato='false'";
		return this.ArrayListQuery(query);
	}
	
	public ArrayList<Candidatura> vediTutteCandidature() throws ClassNotFoundException {		
		String query = "SELECT * FROM candidatura ";
		return this.ArrayListQuery(query);
	}
	

//	public boolean rimuoviCandidatura(Candidatura c) throws ClassNotFoundException {
//		String query = "DELETE FROM public.candidatura\r\n" + 
//				"	WHERE id_candidatura=;";????
//		return this.booleanQuery(query);
//	}
	
	public boolean inserisciCandidatura(Candidatura c) throws ClassNotFoundException {

		String query = "INSERT into candidatura(nome,cognome,email,data_nascita,num_telefono,titolo_studio,livello_esperienza,ultima_esperienza) VALUES ('"+c.getNome()+"','"+c.getCognome()+"','"+c.getEmail()+"','"+c.getDataNascita()+"','"+c.getNumTelefono()+"','"+c.getTitoloStudio()+"','"+c.getLivelloEsperienza()+"','"+c.getUltimaEsperienza()+"')";
		return this.booleanQuery(query);

	}
	
	private boolean booleanQuery(String query) throws ClassNotFoundException {

		String url = "jdbc:postgresql://localhost:5433/postgres";
		String user = "postgres";
		String password = "admin";
		Class.forName("org.postgresql.Driver");
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			Statement statement = connection.createStatement();
			statement.execute(query);
			connection.close();
			statement.close();
			return true;
		} catch (SQLException e) {
			System.out.println("Connection failure.");
			e.printStackTrace();
			return false;
		}
		
	}
	
	private  ArrayList<Candidatura> ArrayListQuery(String query) throws ClassNotFoundException{
		
		
		String url = "jdbc:postgresql://localhost:5433/postgres";
		String user = "postgres";
		String password = "admin";
		Class.forName("org.postgresql.Driver");
		ArrayList<Candidatura> listaC = new ArrayList<Candidatura>();
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
//				Candidatura c = new Candidatura(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
//						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
				Candidatura c = new Candidatura(rs.getString("id_candidatura"), rs.getString("nome"), rs.getString("cognome"), rs.getString("email"), rs.getString("data_nascita"), rs.getString("num_telefono"), rs.getString("titolo_studio"), rs.getString("livello_esperienza"), rs.getString("ultima_esperienza"));
				listaC.add(c);
			}
			connection.close();
			statement.close();
			rs.close();

			return listaC;

		} catch (SQLException e) {
			System.out.println("Connection failure.");
			e.printStackTrace();
		}

		return null;
	}
	
	
	

}
