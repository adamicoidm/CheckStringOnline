package DAO;

public class Utente {
	String nome;
	String cognome;
	String email;
	String password;
	String numTel="";
	public Utente(String nome, String cognome, String email, String password, String numTel) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password =password;
		this.numTel = numTel;
	}

	public Utente(String email, String password) {
		this.email = email;
		this.password = password;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNumTel() {
		return numTel;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
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
