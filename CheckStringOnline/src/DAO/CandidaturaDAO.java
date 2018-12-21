package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CandidaturaDAO {

	public static ArrayList<Candidatura> vediCandidature() throws ClassNotFoundException {
		String url = "jdbc:postgresql://localhost:5433/postgres";
		String user = "postgres";
		String password = "admin";
		Class.forName("org.postgresql.Driver");
		ArrayList<Candidatura> listaC = new ArrayList<Candidatura>();
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM candidatura WHERE stato='true'");
			while (rs.next()) {
				Candidatura c = new Candidatura(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
//				Candidatura c = new Candidatura(rs.getString("id_candidatura"), rs.getString("nome"), rs.getString("cognome"), rs.getString("email"), rs.getString("data_nascita"), rs.getString("num_telefono"), rs.getString("titolo_studio"), rs.getString("livello_esperienza"), rs.getString("ultima_esperienza"));
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

	public static List<Candidatura> vediNuoveCandidature() throws ClassNotFoundException {
		String url = "jdbc:postgresql://localhost:5433/postgres";
		String user = "postgres";
		String password = "admin";
		Class.forName("org.postgresql.Driver");
		List<Candidatura> listaC = new ArrayList<Candidatura>();
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM candidatura WHERE stato=false");
			while (rs.next()) {
				Candidatura c = new Candidatura(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
				// Candidatura c = new Candidatura(rs.getString("id_candidatura"),
				// rs.getString("nome"), rs.getString("cognome"), rs.getString("email"),
				// rs.getString("data_nascita"), rs.getString("num_telefono"),
				// rs.getString("titolo_studio"), rs.getString("livello_esperienza"),
				// rs.getString("ultima_esperienza"));
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
