package DAO;

public class Competenza {
	String nomeCompetenza;
	String approvata;
	public String getNomeCompetenza() {
		return nomeCompetenza;
	}
	public void setNomeCompetenza(String nomeCompetenza) {
		this.nomeCompetenza = nomeCompetenza;
	}
	@Override
	public String toString() {
		return "Competenza [nomeCompetenza=" + nomeCompetenza + ", approvata=" + approvata + "]";
	}

	
}
