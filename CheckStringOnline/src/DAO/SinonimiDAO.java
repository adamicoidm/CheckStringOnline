package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SinonimiDAO {
	
	public void inserisciSinonimo(String nomeCompetenza, String sinonimo) throws ClassNotFoundException {
		String query = "INSERT INTO public.sinonimi(corrispondenza, competenza_standard) " + 
				"	VALUES ('"+ sinonimo +"', '"+ nomeCompetenza + "');";
		this.voidQuery(query);
	}
	
	public void rimuoviSinonimo(String sinonimo) throws ClassNotFoundException {
		String query = "DELETE FROM public.sinonimi\r\n" + 
				"	WHERE corrispondenza='"+ sinonimo +"';";
		this.voidQuery(query);
	}
	
	public String getSinonimo(String sinonimo) throws ClassNotFoundException {
			
			String query = "SELECT corrispondenza FROM public.sinonimi WHERE corrispondenza='"+sinonimo+"';";
			return this.StringQuery(query);
			
		}
	
	public ArrayList<Sinonimo> vediSinonimi() throws ClassNotFoundException {
			
			String query = "SELECT * FROM public.sinonimi";
			return this.ArrayListQuery(query);
			
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
	
	private  ArrayList<Sinonimo> ArrayListQuery(String query) throws ClassNotFoundException{
			
			
			String url = "jdbc:postgresql://localhost:5433/postgres";
			String user = "postgres";
			String password = "admin";
			Class.forName("org.postgresql.Driver");
			ArrayList<Sinonimo> listaCompetenze = new ArrayList<Sinonimo>();
			try {
				Connection connection = DriverManager.getConnection(url, user, password);
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(query);
				while (rs.next()) {
					Sinonimo s = new Sinonimo(rs.getString(1), rs.getString(2));//				Candidatura c = new Candidatura(rs.getString("id_candidatura"), rs.getString("nome"), rs.getString("cognome"), rs.getString("email"), rs.getString("data_nascita"), rs.getString("num_telefono"), rs.getString("titolo_studio"), rs.getString("livello_esperienza"), rs.getString("ultima_esperienza"));
					listaCompetenze.add(s);
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
