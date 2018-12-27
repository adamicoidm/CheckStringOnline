package DAO;

public class Sinonimo {

	private String corrispondenza;
	private String competenzaStandard;
	
	public Sinonimo(String corrispondenza, String competenzaStandard) {
		this.corrispondenza = corrispondenza;
		this.competenzaStandard = competenzaStandard;
	}

	public String getCorrispondenza() {
		return corrispondenza;
	}

	public void setCorrispondenza(String corrispondenza) {
		this.corrispondenza = corrispondenza;
	}

	public String getCompetenzaStandard() {
		return competenzaStandard;
	}

	public void setCompetenzaStandard(String competenzaStandard) {
		this.competenzaStandard = competenzaStandard;
	}
	
	@Override
	public String toString() {
		
		return corrispondenza + " " + competenzaStandard;
	}
	
	
	
	
}
