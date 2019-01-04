package DAO;

public class Utente {
    String user;
	String password;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Utente(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}
	
//checkLogin	
//	public boolean checkLogin(String email,String Password) {
//		String query="SELECT email,password FROM Utente WHERE email='"+email+"' AND password='"+password+"';";
//		ResultSet rs;
//		if (rs!=null)
//			return true;
//		else 
//			return false;
//	}
	
	
//	public String getLabel() {
//		String query="Select Nome,Cognome FROM Utente WHERE email='"+this.email+"';";
//		ResultSet rs;
//		if(rs!=null)
//		return this.nome+" "+this.cognome;
//		else
//			return "Ospite";
//	}
}
