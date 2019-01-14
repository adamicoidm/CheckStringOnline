package DAO;

public class Candidatura2Competenze {
	long id_candidatura;
	String nomeCompetenza;
	
	public long getId_candidatura() {
		return id_candidatura;
	}
	public void setId_candidatura(long id_candidatura) {
		this.id_candidatura = id_candidatura;
	}
	public String getNomeCompetenza() {
		return nomeCompetenza;
	}
	public void setNomeCompetenza(String competenze) {
		this.nomeCompetenza = competenze;
	}
	public Candidatura2Competenze(long id_candidatura, String competenze) {
		this.id_candidatura = id_candidatura;
		this.nomeCompetenza = competenze;
	}
	
	public Candidatura2Competenze(Object id_candidatura, String competenze) {
		Integer I = (Integer) id_candidatura;
		this.id_candidatura = (I.longValue());
		this.nomeCompetenza = competenze;
	}
	public Candidatura2Competenze() {
		// TODO Auto-generated constructor stub
	}
	
}
