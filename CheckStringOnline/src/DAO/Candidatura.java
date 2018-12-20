package DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Candidatura {
	String nome;
	String cognome;
	String email;
	String dataNascita;
	String titoloStudio;
	String numTelefono;
	String livelloEsperienza;
	String competenze;
	String ultimaEsperienza;

	public Candidatura() {

	}

	/**
	 * Ciao ragazzi e Grazie
	 * 
	 * 
	 * @param nome
	 * @param cognome
	 * @param dataNascita
	 * @param titoloStudio
	 * @param livelloEsperienza
	 * @param competenze
	 * @param ultimaEsperienza
	 */

	// push di ripristino
	public Candidatura(String nome, String cognome, String email, String dataNascita, String numTelefono,
			String titoloStudio, String livelloEsperienza, String competenze, String ultimaEsperienza) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.dataNascita = dataNascita;
		this.numTelefono = numTelefono;
		this.titoloStudio = titoloStudio;
		this.livelloEsperienza = livelloEsperienza;
		this.competenze = competenze;
		this.ultimaEsperienza = ultimaEsperienza;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getTitoloStudio() {
		return titoloStudio;
	}

	public void setTitoloStudio(String titoloStudio) {
		this.titoloStudio = titoloStudio;
	}

	public String getLivelloEsperienza() {
		return livelloEsperienza;
	}

	public void setLivelloEsperienza(String livelloEsperienza) {
		this.livelloEsperienza = livelloEsperienza;
	}

	public String getCompetenze() {
		return competenze;
	}

	public void setCompetenze(String competenze) {
		this.competenze = competenze;
	}

	public String getUltimaEsperienza() {
		return ultimaEsperienza;
	}

	public void setUltimaEsperienza(String ultimaEsperienza) {
		this.ultimaEsperienza = ultimaEsperienza;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumTelefono() {
		return numTelefono;
	}

	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}

//	public void StreamData(String s) throws IOException {
//		File file = new File("C:\\eclipse-workspace\\CheckStringOnline\\src\\DAO", "Candidature.txt");
//		Scanner sc = new Scanner(file);
//		String s1 = "";
//		while (sc.hasNextLine()) {
//			s1 = s1 + sc.nextLine() + "\n";
//		}
//		FileWriter fw = new FileWriter(file);
//		fw.append(s1 + "\n\n" + s);
//		sc.close();
//		fw.close();
//		// jklklkjljk
//	}

	public boolean insertCandidatura() throws ClassNotFoundException {

		String url = "jdbc:postgresql://localhost:5433/postgres";
		String user = "postgres";
		String password = "admin";
		Class.forName("org.postgresql.Driver");
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			Statement statement = connection.createStatement();
			ResultSet resultSet =  statement.executeQuery("INSERT into candidatura(nome,cognome,email,data_nascita,num_telefono,titolo_studio,livello_esperienza,ultima_esperienza) VALUES ('"+nome+"','"+cognome+"','"+email+"','"+dataNascita+"','"+numTelefono+"','"+titoloStudio+"','"+livelloEsperienza+"','"+ultimaEsperienza+"')");
			connection.close();
			resultSet.close();
			statement.close();
			return true;
		} catch (SQLException e) {
			System.out.println("Connection failure.");
			e.printStackTrace();
			return false;
		}
	}
	public ResultSet vediCandidature() throws ClassNotFoundException{
		String url = "jdbc:postgresql://localhost:5433/postgres";
		String user = "postgres";
		String password = "admin";
		Class.forName("org.postgresql.Driver");
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			Statement statement = connection.createStatement();
			ResultSet resultSet =  statement.executeQuery("SELECT * FROM candidatura WHERE stato='true'");
			connection.close();
			statement.close();
			resultSet.close();
			return resultSet;
			
		} catch (SQLException e) {
			System.out.println("Connection failure.");
			e.printStackTrace();
		}
		
		return null;
		
	}

}
