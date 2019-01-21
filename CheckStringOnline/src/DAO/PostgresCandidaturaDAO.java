package DAO;

import java.util.ArrayList;

public class PostgresCandidaturaDAO extends PostgresAbstractDAO implements CandidaturaDAO{

	public PostgresCandidaturaDAO() {
		super();
	}
	public PostgresCandidaturaDAO(String url, String user, String password, String driver) {
		super(url, user, password, driver);
	}
	
	
	
	@Override
	public ArrayList<Candidatura> vediCandidature() throws ClassNotFoundException {
		String query = "SELECT * FROM public.candidatura WHERE stato!='Nuova'";
		return this.ArrayListQuery(query);
	}
	@Override
	public ArrayList<Candidatura> getId_New_Candidatura(Candidatura c) throws ClassNotFoundException {
		String query = "SELECT * FROM public.candidatura WHERE nome='"+c.getNome()+"' AND cognome='"+c.getCognome()+"' AND email='"+c.getEmail()+"' AND data_nascita='"+c.getDataNascita()+"' AND num_telefono='"+c.getNumTelefono()+"' AND titolo_studio='"+c.getTitoloStudio()+"' AND livello_esperienza='"+c.getLivelloEsperienza()+"' AND ultima_esperienza='"+c.getUltimaEsperienza()+"'";
		return this.ArrayListQuery(query);
	}
	public ArrayList<Candidatura> resocontoCandidatura(long index) throws ClassNotFoundException {
		String query = "SELECT * FROM public.candidatura WHERE id_candidatura='"+index+"'";
		return this.ArrayListQuery(query);
	}
	@Override
	public ArrayList<Candidatura> vediNuoveCandidature() throws ClassNotFoundException {		
		String query = "SELECT * FROM candidatura WHERE stato='Nuova'";
		return this.ArrayListQuery(query);
	}
	
	@Override
	public ArrayList<Candidatura> vediTutteCandidature() throws ClassNotFoundException {		
		String query = "SELECT * FROM candidatura";
		return this.ArrayListQuery(query);
	}
	
	@Override
	public boolean inserisciCandidatura(Candidatura c) throws ClassNotFoundException {

		String query = "INSERT into candidatura(nome,cognome,email,data_nascita,num_telefono,titolo_studio,livello_esperienza,ultima_esperienza) VALUES ('"+c.getNome()+"','"+c.getCognome()+"','"+c.getEmail()+"','"+c.getDataNascita()+"','"+c.getNumTelefono()+"','"+c.getTitoloStudio()+"','"+c.getLivelloEsperienza()+"','"+c.getUltimaEsperienza()+"')";
		return this.booleanQuery(query);

	}
	@Override
	public boolean cambiaStato(long id_candidatura,String stato) throws ClassNotFoundException {

		String query = "UPDATE public.candidatura SET stato ='"+stato+"' WHERE id_candidatura="+id_candidatura;

		return this.booleanQuery(query);

	}
	@Override
	public ArrayList<Candidatura> cercaCandidaturaCompetenza(String competenza) throws ClassNotFoundException {
		if(competenza=="")
			return null;
		String query =creaQuery(competenza);
				
				return this.ArrayListQuery(query);
	}
public String creaQuery(String competenza) {
	String[] parts = competenza.split("-");
	String query="SELECT *" + 
			"	FROM public.candidatura" + 
			"	WHERE id_candidatura IN (SELECT id_candidatura from candidatura2competenze where competenze='"+parts[0].toUpperCase()+"'";
	if(parts.length>1) {
			for (int i = 1; i < parts.length; i++) {
				query += " AND id_candidatura in (SELECT id_candidatura from candidatura2competenze where competenze='" + parts[i].toUpperCase() + "'";
			}
	}
	for(int i=0;i<parts.length;i++) {
		query+=")";}
	query+=";";
	return query;
}
//	public boolean rimuoviCandidatura(Candidatura c) throws ClassNotFoundException {
//		String query = "DELETE FROM public.candidatura\r\n" + 
//				"	WHERE id_candidatura=;";????
//		return this.booleanQuery(query);
//	}
	

	
	private boolean booleanQuery(String query) throws ClassNotFoundException {

		return super.noReturnExecute(query);
		
	}
	
	private  ArrayList<Candidatura> ArrayListQuery(String query) throws ClassNotFoundException{
		
		ArrayList<Object[]> risultato = super.resultSetExecute(query);
		ArrayList<Candidatura> listaC = new ArrayList<Candidatura>();
		
		for(Object[] tupla : risultato) {
		
			Candidatura c = new Candidatura(
					
					(long) tupla[0],
					(String) tupla[1].toString(),
					(String) tupla[2],
					(String) tupla[3],
					(String) tupla[4].toString(),
					(String) tupla[5],
					(String) tupla[6],
					(String) tupla[7],
					(String) tupla[8],
					(String) tupla[9],
					(String) tupla[10]);
					listaC.add(c);
		}

		
		return listaC;
	
	}
	@Override
	public ArrayList<Candidatura> vediTutteCandidatureOrderNome() throws ClassNotFoundException {		
			String query = "SELECT * FROM candidatura WHERE stato!='Nuova' ORDER BY nome ASC";
			return this.ArrayListQuery(query);
		}
	@Override
	public ArrayList<Candidatura> vediTutteCandidatureOrderCognome() throws ClassNotFoundException {
		String query = "SELECT * FROM candidatura WHERE stato!='Nuova' ORDER BY cognome ASC";
		return this.ArrayListQuery(query);
	}
	@Override
	public ArrayList<Candidatura> vediTutteCandidatureOrderTitoloStudio() throws ClassNotFoundException {
		String query = "SELECT * FROM candidatura WHERE stato!='Nuova' ORDER BY titolo_studio ASC";
		return this.ArrayListQuery(query);
	}
	@Override
	public ArrayList<Candidatura> vediTutteCandidatureOrderLivelloEsperienza() throws ClassNotFoundException {
		String query = "SELECT * FROM candidatura WHERE stato!='Nuova' ORDER BY livello_esperienza DESC";
		return this.ArrayListQuery(query);
	}
	@Override
	public ArrayList<Candidatura> vediTutteCandidatureOrderStato() throws ClassNotFoundException {
		String query = "SELECT * FROM candidatura WHERE stato!='Nuova' ORDER BY stato DESC";
		return this.ArrayListQuery(query);
	}
	@Override
	public ArrayList<Candidatura> cercaCandidaturaTitoloStudio (String titolostudio) throws ClassNotFoundException {
		String query = "SELECT * FROM public.candidatura WHERE titolo_studio='"+titolostudio+"'";
		return this.ArrayListQuery(query);
	}
	@Override
	public ArrayList<Candidatura> cercaCandidaturaStato(String stato)throws ClassNotFoundException {
		String query = "SELECT * FROM public.candidatura WHERE stato='"+stato+"'";
		return this.ArrayListQuery(query);
	}
	@Override
	public ArrayList<Candidatura> cercaCandidaturaLivelloEsperienza(String livelloesperienza) throws ClassNotFoundException{
		String query = "SELECT * FROM public.candidatura WHERE livello_esperienza='"+livelloesperienza+"'";
		return this.ArrayListQuery(query);
	}
	


}
	
	

