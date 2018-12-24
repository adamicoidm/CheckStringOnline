package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CompetenzeDAO {

	public void inserisciCompetenza(String nomeCompetenza) throws ClassNotFoundException {
		String query = "INSERT INTO public.competenza(nome_competenza, approvata)" + 
				"	VALUES ('"+ nomeCompetenza + "', 'false');";
		this.voidQuery(query);
	}
	
	public void rimuoviCompetenza(String nomeCompetenza) throws ClassNotFoundException {
		String query = "DELETE FROM public.competenza\r\n" + 
				"	WHERE nome_competenza='"+nomeCompetenza+"';";
		this.voidQuery(query);
	}
	
	public ArrayList<String> vediCompetenze() throws ClassNotFoundException {
		
		String query = "SELECT * FROM public.competenza";
		return this.ArrayListQuery(query);
		
	}
	
	public String getCompetenza(String nomeCompetenza) throws ClassNotFoundException {
		
		String query = "SELECT * FROM public.competenza WHERE nome_competenza='"+nomeCompetenza+"';";
		return this.StringQuery(query);
		
	}
	
	private void voidQuery(String query) throws ClassNotFoundException {
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

		} catch (SQLException e) {
			System.out.println("Connection failure.");
			e.printStackTrace();
		}

		
	}
	
	private  String StringQuery(String query) throws ClassNotFoundException{
		
		
		String url = "jdbc:postgresql://localhost:5433/postgres";
		String user = "postgres";
		String password = "admin";
		Class.forName("org.postgresql.Driver");
		String competenza = new String();
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				String c = new String(rs.getString(1));//				Candidatura c = new Candidatura(rs.getString("id_candidatura"), rs.getString("nome"), rs.getString("cognome"), rs.getString("email"), rs.getString("data_nascita"), rs.getString("num_telefono"), rs.getString("titolo_studio"), rs.getString("livello_esperienza"), rs.getString("ultima_esperienza"));
				competenza=c;
			}
			connection.close();
			statement.close();
			rs.close();

			return competenza;

		} catch (SQLException e) {
			System.out.println("Connection failure.");
			e.printStackTrace();
		}

		return null;
	}
	
	private  ArrayList<String> ArrayListQuery(String query) throws ClassNotFoundException{
		
		
		String url = "jdbc:postgresql://localhost:5433/postgres";
		String user = "postgres";
		String password = "admin";
		Class.forName("org.postgresql.Driver");
		ArrayList<String> listaCompetenze = new ArrayList<String>();
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				String c = new String(rs.getString(1));//				Candidatura c = new Candidatura(rs.getString("id_candidatura"), rs.getString("nome"), rs.getString("cognome"), rs.getString("email"), rs.getString("data_nascita"), rs.getString("num_telefono"), rs.getString("titolo_studio"), rs.getString("livello_esperienza"), rs.getString("ultima_esperienza"));
				listaCompetenze.add(c);
			}
			connection.close();
			statement.close();
			rs.close();

			return listaCompetenze;

		} catch (SQLException e) {
			System.out.println("Connection failure.");
			e.printStackTrace();
		}

		return null;
	}
	
	
	

}
	
	

