package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class PostgresAbstractDAO {


	private String url ;
	private String user ;
	private String password ;
	private String driver ;

	public PostgresAbstractDAO(String url, String user, String password, String driver) {
		this.url = url;
		this.user = user;
		this.password = password;
		this.driver = driver;
	}

	public PostgresAbstractDAO() {
		
		url = "jdbc:postgresql://localhost:5433/postgres";
		user = "postgres";
		password = "admin";
		driver = "org.postgresql.Driver";
	}
	
	public boolean noReturnExecute(String query) throws ClassNotFoundException {
	
		Class.forName(this.driver);
		try {
			Connection connection = DriverManager.getConnection(this.url, this.user, this.password);
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
	
	public ArrayList<Object[]> resultSetExecute(String query) throws ClassNotFoundException {
		

		Class.forName(this.driver);
		ArrayList<Object[]> listaC = new ArrayList<Object[]>();
		try {
			Connection connection = DriverManager.getConnection(this.url, this.user, this.password);
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			ResultSetMetaData rsmt = rs.getMetaData();
			int columns = rsmt.getColumnCount();

			while (rs.next()) {
				Object[] tupla = new Object[columns];
				for(int i = 0 ; i<columns ; i++ ) {
					tupla[i]=rs.getObject(i+1);
				}				
				listaC.add(tupla);
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
	
	
	
	
	
//	Class.forName("org.postgresql.Driver");
}
